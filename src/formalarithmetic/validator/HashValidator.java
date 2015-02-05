package formalarithmetic.validator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import exceptions.DenialReason;
import exceptions.InvalidProofException;
import exceptions.TreeMismatchException;
import javafx.util.Pair;
import parser.ArithmeticParser;
import parser.ParseException;
import proof.*;
import proof.Error;
import scanner.FastLineScanner;
import structure.Expression;
import structure.logic.Entailment;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashValidator implements Validator {

    @Override
    public Proof validate(@NotNull final File f) throws FileNotFoundException, InvalidProofException {
        return validate(f, null);
    }

    @Override
    public Proof validate(@NotNull final File f, @Nullable final Statement[] assumptions) throws FileNotFoundException, InvalidProofException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof validate(@NotNull final FastLineScanner in, @Nullable final Statement[] assumptions) throws InvalidProofException {
        final Proof proof = new Proof();
        final ArithmeticParser expressionParser = new ArithmeticParser();
        while (in.hasMore()) {
            final String s;
            s = in.next();
            try {
                final Expression expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                //Couldn't parse an structure.expressionession
                proof.addExpression(null, new proof.Error());
                return proof;
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof validate(Proof proof, Statement[] assumptions) throws InvalidProofException {
        int row = 0;
        for (Statement statement : proof.getStatements()) {
            row++;
            if (statement.getType() == null) {
                final Expression expression = statement.getExp();
                boolean found = false;
                ModusPonens proofModusPonens = proof.findModusPonens(statement);
                if (proofModusPonens != null) {
                    statement.setType(proofModusPonens);
                    found = true;
                }

                if (!found) {
                    for (Axiom axiom : Axiom.values()) {
                        if (axiom.matches(expression)) {
                            statement.setType(axiom);
                            found = true;
                            break;
                        }
                    }
                }

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

                if (!found) {
                    if (expression instanceof Entailment
                            && ((Entailment) expression).getRight() instanceof Exists) {
                        Entailment entailment = (Entailment) expression;
                        Exists exists = (Exists) entailment.getRight();
                        Term var = exists.getVariable();
                        try {
                            exists.getExp().setQuantifiers(new HashSet<>());
                            entailment.getRight().setQuantifiers(new HashSet<>());
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

                if (found) {
                    continue;
                }

                //Couldn't match an axiom, match an assumption or apply Modus Ponens rule
                statement.setType(new Error());
            }
        }
        return proof;
    }
}
