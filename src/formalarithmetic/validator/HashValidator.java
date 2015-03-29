package formalarithmetic.validator;

import exceptions.DenialReason;
import exceptions.InvalidProofException;
import exceptions.TreeMismatchException;
import interfaces.Validator;
import javafx.util.Pair;
import parser.ArithmeticParser;
import parser.ParseException;
import parser.Parser;
import proof.*;
import proof.Error;
import scanner.FastLineScanner;
import structure.Expression;
import structure.FormalArithmeticExpression;
import structure.arithmetics.Successor;
import structure.arithmetics.Zero;
import structure.logic.And;
import structure.logic.Entailment;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashValidator implements Validator<FormalArithmeticExpression> {

    @Override
    public Proof<FormalArithmeticExpression> validate(final File f) throws FileNotFoundException, InvalidProofException {
        return validate(f, null);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(final File f, final Statement<FormalArithmeticExpression>[] assumptions) throws FileNotFoundException, InvalidProofException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(final FastLineScanner in, final Statement<FormalArithmeticExpression>[] assumptions) throws InvalidProofException {
        final Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof();
        final Parser<FormalArithmeticExpression> expressionParser = new ArithmeticParser();
        int line = 0;
        while (in.hasMore()) {
            line++;
            final String s;
            s = in.next();
            try {
                final FormalArithmeticExpression expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                throw new InvalidProofException("Вывод некорректен начиная с формулы " + line);
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(Proof<FormalArithmeticExpression> proof, Statement<FormalArithmeticExpression>[] assumptions) throws InvalidProofException {
        Map<String, Statement> proofed = new HashMap<>();
        int row = 0;
        for (Statement statement : proof.getStatements()) {
            row++;
            if (statement.getType() == null) {
                final Expression expression = statement.getExp();
                boolean found = false;
                /**
                 * Modus Ponens checking
                 */
                ModusPonens proofModusPonens = proof.findModusPonens(statement);
                if (proofModusPonens != null) {
                    statement.setType(proofModusPonens);
                    found = true;
                }


                /**
                 * Logic axiom checking
                 */
                if (!found) {
                    for (Axiom axiom : Axiom.values()) {
                        if (axiom.matches(expression)) {
                            statement.setType(axiom);
                            found = true;
                            break;
                        }
                    }
                }

                /**
                 * Formal arithmetic axioms checking
                 */
                for (ArithmeticAxiom arithmeticAxiom : ArithmeticAxiom.values()) {
                    if (arithmeticAxiom.matches(expression)) {
                        statement.setType(arithmeticAxiom);
                        found = true;
                        break;
                    }
                }

                /**
                 * Assumption checking
                 */
                if (!found) {
                    if (assumptions != null) {
                        for (Statement assumption : assumptions) {
                            if (assumption.getExp().equals(expression)) {
                                statement.setType(new Assumption());
                                found = true;
                                break;
                            }
                        }
                    }
                }

                /**
                 * For all axiom checking
                 */
                if (!found) {
                    if (expression instanceof Entailment
                            && ((Entailment) expression).getLeft() instanceof ForAll) {
                        Entailment entailment = (Entailment) expression;
                        ForAll forAll = (ForAll) entailment.getLeft();
                        Term var = forAll.getVariable();
                        try {
                            forAll.getExp().setQuantifiers(new HashSet<>());
                            entailment.getRight().setQuantifiers(new HashSet<>());
                            int freeCount = forAll.getExp().markFreeVariableOccurrences(var.getName());
                            Set<Pair<Term, Term>> replaced = entailment.getRight().getReplacedVariableOccurrences(forAll.getExp());
                            //trees are matching
                            boolean cond = true;
                            if (freeCount == 0) {
                                cond = false;
                                if (forAll.getExp().treeMatch(entailment.getRight())) {
                                    //Trees must be just equal
                                    found = true;
                                }
                            }
                            Term term = null;
                            if (cond) {
                                for (Pair<Term, Term> pair : replaced) {
                                    if (term == null) {
                                        term = pair.getValue();
                                    } else {
                                        if (!(term.matchTerm(pair.getValue()))) {
                                            cond = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            /**
                             * We found all replaces and checked, that they are the same one.
                             * Now we must check, that none of them didn't ruin free entrance
                             */
                            if (term == null) {
                                cond = false;
                            }
                            if (cond) {
                                for (Pair<Term, Term> pair : replaced) {
                                    Term t = pair.getValue();
                                    List<String> names = t.getTermNames();
                                    for (String s : names) {
                                        if (t.quantifiers.contains(s)) {
                                            throw new InvalidProofException(DenialReason.ERROR_1.create(row, String.valueOf(term), ((ForAll) ((Entailment) expression).getLeft()).getExp().toString(), var.getName()));
                                        }
                                    }
                                }
                            }
                            if (cond) {
                                found = true;
                            }
                        } catch (TreeMismatchException ignore) {
                            //trees are not equal
                        }
                    }

                    if (found) {
                        statement.setType(PredicateAxiom.AXIOM_FOR_ALL);
                    }
                }

                /**
                 * Exists axiom checking
                 */
                if (!found) {
                    if (expression instanceof Entailment
                            && ((Entailment) expression).getRight() instanceof Exists) {
                        Entailment entailment = (Entailment) expression;
                        Exists exists = (Exists) entailment.getRight();
                        Term var = exists.getVariable();
                        try {
                            exists.getExp().setQuantifiers(new HashSet<>());
                            entailment.getLeft().setQuantifiers(new HashSet<>());
                            int freeCount = exists.getExp().markFreeVariableOccurrences(var.getName());
                            Set<Pair<Term, Term>> replaced = entailment.getLeft().getReplacedVariableOccurrences(exists.getExp());
                            boolean cond = true;
                            if (freeCount == 0) {
                                cond = false;
                                if (exists.getExp().treeMatch(entailment.getLeft())) {
                                    found = true;
                                }
                            }
                            Term term = null;
                            if (cond) {
                                for (Pair<Term, Term> pair : replaced) {
                                    if (term == null) {
                                        term = pair.getValue();
                                    } else {
                                        if (!(term.matchTerm(pair.getValue()))) {
                                            cond = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            /**
                             * We found all replaces and checked, that they are the same one.
                             * Now we must check, that none of them didn't ruin free entrance
                             */
                            if (term == null) cond = false;
                            if (cond) {
                                for (Pair<Term, Term> pair : replaced) {
                                    Term t = pair.getValue();
                                    List<String> names = t.getTermNames();
                                    for (String s : names) {
                                        if (t.quantifiers.contains(s)) {
                                            throw new InvalidProofException(DenialReason.ERROR_1.create(row + 1, String.valueOf(term), ((Exists) ((Entailment) expression).getRight()).getExp().toString(), var.getName()));
                                        }
                                    }
                                }
                            }
                            if (cond) {
                                found = true;
                            }
                        } catch (TreeMismatchException e) {
                            //trees are not equal
                        }
                    }

                    if (found) {
                        statement.setType(PredicateAxiom.AXIOM_EXISTS);
                    }
                }

                /**
                 * For all derivation rule
                 */
                InvalidProofException e1 = null;
                if (!found) {
                    if (expression instanceof Entailment &&
                            ((Entailment) expression).getRight() instanceof ForAll) {
                        Entailment entailment = (Entailment) expression;
                        ForAll forAll = (ForAll) entailment.getRight();
                        Statement state = proofed.get(
                                new Entailment(
                                        entailment.getLeft(),
                                        forAll.getExp()
                                ).toString());
                        if (state != null) {
                            Expression prev = state.getExp();
                            Term var = forAll.getVariable();
                            if (prev != null) {
                                Set<String> freeVars = ((Entailment) prev).getLeft().getFreeVars();
                                if (freeVars.contains(var.getName())) {
                                    e1 = new InvalidProofException(DenialReason.ERROR_2.create(row, var.getName(), entailment.getLeft().toString()));
                                } else {
                                    found = true;
                                    statement.setType(new ForAllDerivationRule(state));
                                }
                            }
                        }
                    }
                }

                /**
                 * Exists derivation rule
                 */
                InvalidProofException e2 = null;
                if (!found) {
                    if (expression instanceof Entailment &&
                            ((Entailment) expression).getLeft() instanceof Exists) {
                        Entailment entailment = (Entailment) expression;
                        Exists exists = (Exists) entailment.getLeft();
                        Statement state = proofed.get(
                                new Entailment(
                                        exists.getExp(),
                                        entailment.getRight()
                                ).toString());
                        if (state != null) {
                            Expression prev = state.getExp();
                            Term var = exists.getVariable();
                            if (prev != null) {
                                if (((Entailment) prev).getRight().getFreeVars().contains(var.getName())) {
                                    e2 = new InvalidProofException(DenialReason.ERROR_2.create(row, var.getName(), entailment.getRight().toString()));
                                } else {
                                    found = true;
                                    statement.setType(new ExistsDerivationRule(state));
                                }
                            }
                        }
                    }
                }

                /**
                 * Induction checking
                 */
                if (!found) {
                    if (expression instanceof Entailment) {
                        Entailment entailment = (Entailment) expression;
                        Expression left = entailment.getLeft();
                        if (left instanceof And &&
                                ((And) left).getRight() instanceof ForAll &&
                                ((ForAll) ((And) left).getRight()).getExp() instanceof Entailment) {
                            Expression result = entailment.getRight();
                            And and = (And) entailment.getLeft();
                            Entailment then = (Entailment) ((ForAll) and.getRight()).getExp();
                            Expression original = then.getLeft();
                            Term var = ((ForAll) and.getRight()).getVariable();
                            original.setQuantifiers(new HashSet<>());
                            and.getLeft().setQuantifiers(new HashSet<>());
                            int freeCount = original.markFreeVariableOccurrences(var.getName());
                            try {
                                Set<Pair<Term, Term>> replaced = and.getLeft().getReplacedVariableOccurrences(original);
                                boolean cond = true;
                                if (freeCount == 0) {
                                    //Didn't do anything actually: trees must be just equivalent
                                    cond = false;
                                    if (and.getLeft().treeMatch(original)) {
                                        found = true;
                                    }
                                }

                                //Check that all replaced terms are the same
                                Term term = null;
                                if (cond) {
                                    for (Pair<Term, Term> pair : replaced) {
                                        if (term == null) {
                                            term = pair.getValue();
                                        } else {
                                            if (!(term.matchTerm(pair.getValue()))) {
                                                cond = false;
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (cond && (term == null || !term.match(new Zero()))) {
                                    cond = false;
                                }
                                if (cond && !original.treeMatch(result)) {
                                    cond = false;
                                }
                                then.getRight().setQuantifiers(new HashSet<>());
                                replaced = then.getRight().getReplacedVariableOccurrences(original);
                                if (freeCount == 0) {
                                    //Didn't do anything actually and trees are equivalent
                                    cond = false;
                                    found = true;
                                }
                                //Check that all replaced terms are the same
                                term = null;
                                if (cond) {
                                    for (Pair<Term, Term> pair : replaced) {
                                        if (term == null) {
                                            term = pair.getValue();
                                        } else {
                                            if (!(term.matchTerm(pair.getValue()))) {
                                                cond = false;
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (cond && (term == null || !term.match(new Successor(var)))) {
                                    cond = false;
                                }
                                if (cond) {
                                    found = true;
                                }
                            } catch (TreeMismatchException ignored) {
                                //Trees are not equal
                            }
                        }
                    }

                    if (found) {
                        statement.setType(InductionRule.INDUCTION_RULE);
                    }
                }


                if (found) {
                    proofed.put(expression.toString(), statement);
                    continue;
                } else {
                    if (e1 != null) {
                        throw e1;
                    } else if (e2 != null) {
                        throw e2;
                    }
                }

                //Couldn't match an axiom, match an assumption or apply Modus Ponens rule
                statement.setType(new Error());

                throw new InvalidProofException("Вывод некорректен начиная с формулы номер " + row);
            } else {
                proofed.put(statement.getExp().toString(), statement);
            }
        }
        return proof;
    }
}
