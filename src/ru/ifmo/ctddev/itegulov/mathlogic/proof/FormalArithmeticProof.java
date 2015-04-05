package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import javafx.util.Pair;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.DenialReason;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.PredicateRules;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics.Successor;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics.Zero;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PAnd;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PBinaryOperator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PEntailment;

import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public class FormalArithmeticProof implements Proof<FormalArithmeticExpression> {
    //TODO: javadoc
    private final List<Statement<FormalArithmeticExpression>> statements;
    private final Map<FormalArithmeticExpression, Statement<FormalArithmeticExpression>> all = new HashMap<>();
    private final List<Statement<FormalArithmeticExpression>> assumptions;
    private final Map<FormalArithmeticExpression, Set<Statement<FormalArithmeticExpression>>> right = new HashMap<>();
    private int line = 0;

    public FormalArithmeticProof(final List<Statement<FormalArithmeticExpression>> assumptions) {
        this.assumptions = assumptions;
        statements = new ArrayList<>();
    }

    public String toSimpleString() {
        StringBuilder sb = new StringBuilder();

        for (Statement<FormalArithmeticExpression> s : statements) {
            sb.append(s.toSimpleString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void addExpression(final FormalArithmeticExpression expression, final StatementType<FormalArithmeticExpression> type) {
        addStatement(new Statement<>(expression, type, -1));
    }

    @Override
    public void addStatement(final Statement<FormalArithmeticExpression> st) {
        line++;
        st.setLine(line);
        statements.add(st);
        if (st.getExp() == null) {
            return;
        }
        if (st.getExp() instanceof PBinaryOperator) {
            PBinaryOperator bo = (PBinaryOperator) st.getExp();
            if (right.containsKey(bo.getRight())) {
                right.get(bo.getRight()).add(st);
            } else {
                right.put(bo.getRight(), new HashSet<>());
                right.get(bo.getRight()).add(st);
            }
        }
        if (!all.containsKey(st.getExp())) {
            all.put(st.getExp(), st);
        }
    }

    @Override
    public void addProof(final Proof<FormalArithmeticExpression> proof) {
        proof.getStatements().forEach(this::addStatement);
    }

    @Override
    public List<Statement<FormalArithmeticExpression>> getStatements() {
        return statements;
    }

    @Override
    public boolean check(final List<Statement<FormalArithmeticExpression>> assumptions) {
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            validator.validate(this, assumptions);
            return true;
        } catch (InvalidProofException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Statement s : statements) {
            sb.append(s.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public StatementType<FormalArithmeticExpression> findBasis(final Statement<FormalArithmeticExpression> statement,
                                   final Map<String, Statement<FormalArithmeticExpression>> proofed) throws InvalidProofException {
        final FormalArithmeticExpression expression = statement.getExp();
        int row = statement.getLine();
        /**
         * Modus Ponens checking
         */
        ModusPonens<FormalArithmeticExpression> proofModusPonens = findModusPonens(statement);
        if (proofModusPonens != null) {
            return proofModusPonens;
        }


        /**
         * Logic axiom checking
         */
        for (PredicateLogicAxiom axiom : PredicateLogicAxiom.values()) {
            if (axiom.matches(expression)) {
                return axiom;
            }
        }

        /**
         * Formal arithmetic axioms checking
         */
        for (ArithmeticAxiom arithmeticAxiom : ArithmeticAxiom.values()) {
            if (arithmeticAxiom.matches(expression)) {
                return arithmeticAxiom;
            }
        }

        /**
         * Assumption checking
         */
        if (assumptions != null) {
            for (Statement assumption : assumptions) {
                if (assumption.getExp().equals(expression)) {
                    return new Assumption<>();
                }
            }
        }

        /**
         * For all axiom checking
         */
        {
            boolean found = false;
            if (expression instanceof PEntailment && ((PEntailment) expression).getLeft() instanceof ForAll) {
                PEntailment PEntailment = (PEntailment) expression;
                ForAll forAll = (ForAll) PEntailment.getLeft();
                Term var = forAll.getVariable();
                try {
                    forAll.getExp().setQuantifiers(new HashSet<>());
                    PEntailment.getRight().setQuantifiers(new HashSet<>());
                    int freeCount = forAll.getExp().markFreeVariableOccurrences(var.getName());
                    Set<Pair<Term, Term>> replaced = PEntailment.getRight().getReplacedVariableOccurrences(forAll.getExp());
                    //trees are matching
                    boolean cond = true;
                    if (freeCount == 0) {
                        cond = false;
                        if (forAll.getExp().treeMatch(PEntailment.getRight())) {
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
                                    throw new InvalidProofException(DenialReason.ERROR_1.create(row, String.valueOf(term), ((ForAll) ((PEntailment) expression).getLeft()).getExp().toString(), var.getName()));
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
                return PredicateAxiom.AXIOM_FOR_ALL;
            }
        }

        /**
         * Exists axiom checking
         */
        {
            boolean found = false;
            if (expression instanceof PEntailment
                    && ((PEntailment) expression).getRight() instanceof Exists) {
                PEntailment PEntailment = (PEntailment) expression;
                Exists exists = (Exists) PEntailment.getRight();
                Term var = exists.getVariable();
                try {
                    exists.getExp().setQuantifiers(new HashSet<>());
                    PEntailment.getLeft().setQuantifiers(new HashSet<>());
                    int freeCount = exists.getExp().markFreeVariableOccurrences(var.getName());
                    Set<Pair<Term, Term>> replaced = PEntailment.getLeft().getReplacedVariableOccurrences(exists.getExp());
                    boolean cond = true;
                    if (freeCount == 0) {
                        cond = false;
                        if (exists.getExp().treeMatch(PEntailment.getLeft())) {
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
                                    throw new InvalidProofException(DenialReason.ERROR_1.create(row + 1, String.valueOf(term), ((Exists) ((PEntailment) expression).getRight()).getExp().toString(), var.getName()));
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
                return PredicateAxiom.AXIOM_EXISTS;
            }
        }

        /**
         * For all derivation rule
         */
        InvalidProofException e1 = null;
        if (expression instanceof PEntailment &&
                ((PEntailment) expression).getRight() instanceof ForAll) {
            PEntailment PEntailment = (PEntailment) expression;
            ForAll forAll = (ForAll) PEntailment.getRight();
            Statement state = proofed.get(new PEntailment(PEntailment.getLeft(), forAll.getExp()).toString());
            if (state != null) {
                Expression prev = state.getExp();
                Term var = forAll.getVariable();
                if (prev != null) {
                    Set<String> freeVars = new HashSet<>();
                    ((PEntailment) prev).getLeft().getFreeVars(freeVars);
                    if (freeVars.contains(var.getName())) {
                        e1 = new InvalidProofException(DenialReason.ERROR_2.create(row, var.getName(), PEntailment.getLeft().toString()));
                    } else {
                        return new ForAllDerivationRule(state);
                    }
                }
            }
        }

        /**
         * Exists derivation rule
         */
        InvalidProofException e2 = null;
        if (expression instanceof PEntailment &&
                ((PEntailment) expression).getLeft() instanceof Exists) {
            PEntailment PEntailment = (PEntailment) expression;
            Exists exists = (Exists) PEntailment.getLeft();
            Statement state = proofed.get(
                    new PEntailment(
                            exists.getExp(),
                            PEntailment.getRight()
                    ).toString());
            if (state != null) {
                Expression prev = state.getExp();
                Term var = exists.getVariable();
                if (prev != null) {
                    if (((PEntailment) prev).getRight().getFreeVars(new HashSet<>()).contains(var.getName())) {
                        e2 = new InvalidProofException(DenialReason.ERROR_2.create(row, var.getName(), PEntailment.getRight().toString()));
                    } else {
                        return new ExistsDerivationRule(state);
                    }
                }
            }
        }

        /**
         * Induction checking
         */
        {
            boolean found = false;
            if (expression instanceof PEntailment) {
                PEntailment PEntailment = (PEntailment) expression;
                Expression left = PEntailment.getLeft();
                if (left instanceof PAnd &&
                        ((PAnd) left).getRight() instanceof ForAll &&
                        ((ForAll) ((PAnd) left).getRight()).getExp() instanceof PEntailment) {
                    FormalArithmeticExpression result = PEntailment.getRight();
                    PAnd and = (PAnd) PEntailment.getLeft();
                    PEntailment then = (PEntailment) ((ForAll) and.getRight()).getExp();
                    FormalArithmeticExpression original = then.getLeft();
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
                return InductionRule.INDUCTION_RULE;
            }
        }

        if (e1 != null) {
            throw e1;
        } else if (e2 != null) {
            throw e2;
        }

        return new Error<>();
    }

    private boolean containsStatement(final List<Statement<FormalArithmeticExpression>> proofed,
                                      final Statement<FormalArithmeticExpression> statement) {
        if (proofed == null) {
            return false;
        }
        for (Statement<FormalArithmeticExpression> allow : proofed) {
            if (allow.equals(statement)) {
                return true;
            }
        }
        return false;
    }

    private Expression getHypoExp(Term variable, List<Statement<FormalArithmeticExpression>> assumptions) {
        for (Statement<FormalArithmeticExpression> assumption : assumptions) {
            if (assumption.getExp().getFreeVars(new HashSet<>()).contains(variable.getName())) {
                return assumption.getExp();
            }
        }
        throw new IllegalStateException("Couldn't find hypothesis");
    }

    @Override
    public void deduct(final Statement<FormalArithmeticExpression> statement,
                       final Proof<FormalArithmeticExpression> newProof,
                       final FormalArithmeticExpression currentAssumption,
                       final List<Statement<FormalArithmeticExpression>> proofed) throws InvalidProofException {
        Set<String> hyposVars = new HashSet<>();
        hyposVars.addAll(currentAssumption.getFreeVars(new HashSet<>()));
        FormalArithmeticExpression currentExp = statement.getExp();
        StatementType<FormalArithmeticExpression> statementType = statement.getType();
        if (statement.getExp().equals(currentAssumption)) {
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentExp, currentExp)), PredicateLogicAxiom.AxiomOne);
            newProof.addExpression(new PEntailment(
                    new PEntailment(
                            currentExp,
                            new PEntailment(currentExp, currentExp)
                    ),
                    new PEntailment(
                            new PEntailment(
                                    currentExp,
                                    new PEntailment(
                                            new PEntailment(currentExp, currentExp),
                                            currentExp
                                    )
                            ),
                            new PEntailment(currentExp, currentExp)
                    )
            ), PredicateLogicAxiom.AxiomTwo);
            newProof.addExpression(new PEntailment(
                    new PEntailment(
                            currentExp,
                            new PEntailment(
                                    new PEntailment(currentExp, currentExp),
                                    currentExp
                            )
                    ),
                    new PEntailment(currentExp, currentExp)
            ), null);
            newProof.addExpression(new PEntailment(
                    currentExp,
                    new PEntailment(
                            new PEntailment(currentExp, currentExp),
                            currentExp
                    )
            ), PredicateLogicAxiom.AxiomOne);
            newProof.addExpression(new PEntailment(currentExp, currentExp), null);
        } else if (statementType.getClass() == PredicateLogicAxiom.class
                || containsStatement(assumptions, statement)
                || containsStatement(proofed, statement)) {
            newProof.addExpression(currentExp, null);
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentAssumption, currentExp)), null);
            FormalArithmeticExpression expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else if (statementType.getClass() == ModusPonens.class) {
            Statement<FormalArithmeticExpression> antecedent = ((ModusPonens<FormalArithmeticExpression>) statementType).getFirst();
            FormalArithmeticExpression expression = new PEntailment(
                    new PEntailment(currentAssumption, antecedent.getExp()),
                    new PEntailment(
                            new PEntailment(
                                    currentAssumption,
                                    new PEntailment(
                                            antecedent.getExp(),
                                            currentExp
                                    )
                            ),
                            new PEntailment(
                                    currentAssumption,
                                    currentExp
                            )
                    )
            );
            newProof.addExpression(expression, null);
            expression = new PEntailment(
                    new PEntailment(
                            currentAssumption,
                            new PEntailment(
                                    antecedent.getExp(),
                                    currentExp
                            )
                    ),
                    new PEntailment(
                            currentAssumption,
                            currentExp
                    )
            );
            newProof.addExpression(expression, null);
            expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else if (statementType.getClass() == PredicateAxiom.class) {
            newProof.addExpression(currentExp, null);
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentAssumption, currentExp)), null);
            FormalArithmeticExpression expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else if (statementType.getClass() == ArithmeticAxiom.class) {
            newProof.addExpression(currentExp, null);
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentAssumption, currentExp)), null);
            FormalArithmeticExpression expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else if (statementType.getClass() == InductionRule.class) {
            newProof.addExpression(currentExp, null);
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentAssumption, currentExp)), null);
            FormalArithmeticExpression expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else {
            if (statementType.getClass() == ExistsDerivationRule.class) {
                if (currentExp instanceof PEntailment &&
                        ((PEntailment) currentExp).getLeft() instanceof Exists) {
                    PEntailment PEntailment = (PEntailment) currentExp;
                    Exists exists = (Exists) PEntailment.getLeft();
                    FormalArithmeticExpression prev = getAll(
                            new PEntailment(
                                    exists.getExp(),
                                    PEntailment.getRight()
                            )).getExp();
                    Term var = exists.getVariable();
                    boolean cond = (prev != null);
                    if (cond) {
                        cond = !((PEntailment) prev).getRight().getFreeVars(new HashSet<>()).contains(var.getName());
                        if (!cond) {
                            throw new InvalidProofException(
                                    DenialReason.ERROR_2.create(statement.getLine(), var.getName(), PEntailment.getRight().toString())
                            );
                        }
                        cond = !hyposVars.contains(var.getName());
                        if (!cond) {
                            throw new InvalidProofException(
                                    DenialReason.ERROR_3.create(statement.getLine(), "правило", var.getName(), getHypoExp(var, assumptions).toString())
                            );
                        }
                        PredicateRules.addExistsProof(currentAssumption, exists.getExp(), PEntailment.getRight(), var, newProof);
                    }
                } else {
                    throw new IllegalStateException("Illegal exists derivation rule");
                }
            } else if (statementType.getClass() == ForAllDerivationRule.class) {
                if (currentExp instanceof PEntailment &&
                        ((PEntailment) currentExp).getRight() instanceof ForAll) {
                    Expression prev = getAll(
                            new PEntailment(
                                    ((PEntailment) currentExp).getLeft(),
                                    ((ForAll) ((PEntailment) currentExp).getRight()).getExp()
                            )).getExp();
                    Term var = ((ForAll) ((PEntailment) currentExp).getRight()).getVariable();
                    boolean cond = (prev != null);
                    if (cond) {
                        cond = !((PEntailment) prev).getLeft().getFreeVars(new HashSet<>()).contains(var.getName());
                        if (!cond) {
                            throw new InvalidProofException(
                                    DenialReason.ERROR_2.create(statement.getLine(), var.getName(), ((PEntailment) currentExp).getLeft().toString())
                            );
                        }
                        cond = !hyposVars.contains(var.getName());
                        if (!cond) {
                            throw new InvalidProofException(
                                    DenialReason.ERROR_3.create(statement.getLine(), "правило", var.getName(), getHypoExp(var, assumptions).toString())
                            );
                        }
                        PredicateRules.addForAllProof(currentAssumption, ((PEntailment) currentExp).getLeft(), ((ForAll) ((PEntailment) currentExp).getRight()).getExp(), var, newProof);
                    }
                } else {
                    throw new IllegalStateException("Illegal for all derivation rule");
                }
            } else {
                throw new InvalidProofException(statement.getLine() + "");
            }
        }
    }

    @Override
    public Proof<FormalArithmeticExpression> replaceAll(final Map<Integer, FormalArithmeticExpression> map) {
        Proof<FormalArithmeticExpression> newProof = new FormalArithmeticProof(assumptions);
        for (Statement<FormalArithmeticExpression> statement : statements) {
            newProof.addStatement(new Statement<>(statement.getExp().replaceAll(map), statement.getType(), -1));
        }
        return newProof;
    }

    public boolean rightExists(FormalArithmeticExpression exp) {
        return right.containsKey(exp);
    }

    public Set<Statement<FormalArithmeticExpression>> getRights(FormalArithmeticExpression exp) {
        return right.get(exp);
    }

    public boolean allExists(FormalArithmeticExpression exp) {
        return all.containsKey(exp);
    }

    public Statement<FormalArithmeticExpression> getAll(FormalArithmeticExpression exp) {
        return all.get(exp);
    }

    public ModusPonens<FormalArithmeticExpression> findModusPonens(Statement<FormalArithmeticExpression> statement) {
        if (rightExists(statement.getExp())) {
            Set<Statement<FormalArithmeticExpression>> set = getRights(statement.getExp());
            for (Statement<FormalArithmeticExpression> target : set) {
                if (target.getLine() >= statement.getLine()) {
                    continue;
                }
                PBinaryOperator bo = (PBinaryOperator) target.getExp();
                FormalArithmeticExpression left = bo.getLeft();
                if (allExists(left)) {
                    Statement st = all.get(left);
                    if (st.getLine() >= statement.getLine()) {
                        continue;
                    }
                    Statement<FormalArithmeticExpression> antecedent = getAll(left);
                    return new ModusPonens<>(antecedent, target);
                }
            }
        }
        return null;
    }
}
