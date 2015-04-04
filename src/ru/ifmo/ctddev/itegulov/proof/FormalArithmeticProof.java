package ru.ifmo.ctddev.itegulov.proof;

import ru.ifmo.ctddev.itegulov.exceptions.DenialReason;
import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import javafx.util.Pair;
import ru.ifmo.ctddev.itegulov.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.rules.ExistsRule;
import ru.ifmo.ctddev.itegulov.rules.ForAllRule;
import ru.ifmo.ctddev.itegulov.structure.Expression;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.structure.arithmetics.Successor;
import ru.ifmo.ctddev.itegulov.structure.arithmetics.Zero;
import ru.ifmo.ctddev.itegulov.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.structure.predicatelogic.PAnd;
import ru.ifmo.ctddev.itegulov.structure.predicatelogic.PBinaryOperator;
import ru.ifmo.ctddev.itegulov.structure.predicatelogic.PEntailment;

import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public class FormalArithmeticProof implements Proof<FormalArithmeticExpression> {
    //TODO: javadoc
    //All statements in proof
    private final List<Statement<FormalArithmeticExpression>> statements;
    //All contains all expressions
    private final Map<FormalArithmeticExpression, Statement<FormalArithmeticExpression>> all = new HashMap<>();
    private final List<Statement<FormalArithmeticExpression>> assumptions;
    /**
     * All contains all expressions, suitable for next rule:
     * If expression has the next form: a -> b, then b
     * is contained in right map
     */
    private final Map<FormalArithmeticExpression, Set<Statement<FormalArithmeticExpression>>> right = new HashMap<>();
    //Current line number
    private int line = 0;

    public FormalArithmeticProof(final List<Statement<FormalArithmeticExpression>> assumptions) {
        this.assumptions = assumptions;
        statements = new ArrayList<>();
    }

    public FormalArithmeticProof(String proof, final List<Statement<FormalArithmeticExpression>> assumptions) throws ParseException {
        this.assumptions = assumptions;
        Parser<FormalArithmeticExpression> expressionParser = FormalArithmeticParser.getInstance();
        String[] lines = proof.split("\n");
        statements = new ArrayList<>();
        for (String s: lines) {
            line++;
            String[] tokens = s.split(" ", 2);
            if (tokens[1].matches("\\(сх\\. акс\\.(.*)")) {
                statements.add(new Statement<>(expressionParser.parse(tokens[0]), LogicAxiom.values()[Integer.parseInt(tokens[1].substring(10, tokens[1].length() - 1)) - 1], line));
            } else {
                if (tokens[1].matches("\\(M\\.P\\.(.*)")) {
                    String lineNumbers = tokens[1].substring(6, tokens[1].length() - 1);
                    String[] numbers = lineNumbers.split(", ");
                    int firstLine = Integer.parseInt(numbers[0]);
                    int secondLine = Integer.parseInt(numbers[1]);
                    statements.add(new Statement<>(expressionParser.parse(tokens[0]), new ModusPonens(statements.get(firstLine - 1), statements.get(secondLine - 1)), line));
                } else {
                    if (tokens[1].matches("\\(Не доказано\\)")) {
                        statements.add(new Statement<>(expressionParser.parse(tokens[0]),
                                new Error(), line));
                    } else if (tokens[1].matches("\\(Допущение\\)")) {
                        statements.add(new Statement<>(expressionParser.parse(tokens[0]),
                                new Assumption(), line));
                    } else {
                        throw new ParseException("Undefined type of statement");
                    }
                }
            }
        }
    }

    @Override
    public void addExpression(final FormalArithmeticExpression expression, final StatementType type) {
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
    public StatementType findBasis(final Statement<FormalArithmeticExpression> statement,
                                   final Map<String, Statement<FormalArithmeticExpression>> proofed) throws InvalidProofException {
        final FormalArithmeticExpression expression = statement.getExp();
        int row = statement.getLine();
        /**
         * Modus Ponens checking
         */
        ModusPonens proofModusPonens = findModusPonens(statement);
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
                    return new Assumption();
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

        return new Error();
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
        return null;
    }

    @Override
    public void deduct(final Statement<FormalArithmeticExpression> statement,
                       final Proof<FormalArithmeticExpression> newProof,
                       final FormalArithmeticExpression currentAssumption,
                       final List<Statement<FormalArithmeticExpression>> proofed) throws InvalidProofException {
        Set<String> hyposVars = new HashSet<>();
        hyposVars.addAll(currentAssumption.getFreeVars(new HashSet<>()));
        FormalArithmeticExpression currentExp = statement.getExp();
        StatementType statementType = statement.getType();
        if (statement.getExp().equals(currentAssumption)) {
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentExp, currentExp)), LogicAxiom.AxiomOne);
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
            ), LogicAxiom.AxiomTwo);
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
            ), LogicAxiom.AxiomOne);
            newProof.addExpression(new PEntailment(currentExp, currentExp), null);
        } else if (statementType.getClass() == PredicateLogicAxiom.class
                || containsStatement(assumptions, statement)
                || containsStatement(proofed, statement)) {
            newProof.addExpression(currentExp, null);
            newProof.addExpression(new PEntailment(currentExp, new PEntailment(currentAssumption, currentExp)), null);
            FormalArithmeticExpression expression = new PEntailment(currentAssumption, currentExp);
            newProof.addExpression(expression, null);
        } else if (statementType.getClass() == ModusPonens.class) {
            Statement<FormalArithmeticExpression> antecedent = ((ModusPonens) statementType).getFirst();
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
            Expression expr = statement.getExp();
            Term var;
            PEntailment PEntailment = (PEntailment) expr;
            if (PEntailment.getRight() instanceof Exists) {
                var = ((Exists) PEntailment.getRight()).getVariable();
            } else if (PEntailment.getLeft() instanceof ForAll) {
                var = ((ForAll) PEntailment.getLeft()).getVariable();
            } else {
                throw new IllegalStateException("Illegal predicate axiom");
            }
                    /*
                    if (hyposVars.contains(var.getName())) {
                        throw new InvalidProofException(
                            DenialReason.ERROR_3.create(statement.getLine(), "схема аксиом", var.getName(), getHypoExp(var, assumptions).toString())
                        );
                    }
                    */
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
                        ExistsRule.addExistsProof1(currentAssumption, exists.getExp(), PEntailment.getRight(), var, newProof);
                        ExistsRule.addExistsProof2(currentAssumption,
                                exists.getExp(),
                                PEntailment.getRight(), var, newProof);
                        ExistsRule.addExistsProof3(currentAssumption,
                                exists.getExp(),
                                PEntailment.getRight(), var, newProof);
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
                        ForAllRule.addForAllProof(currentAssumption, ((PEntailment) currentExp).getLeft(), ((ForAll) ((PEntailment) currentExp).getRight()).getExp(), var, newProof);
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
        return null;
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
