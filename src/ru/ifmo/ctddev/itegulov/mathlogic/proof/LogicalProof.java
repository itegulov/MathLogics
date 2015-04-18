package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.BinaryOperator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Entailment;

import java.util.*;

public final class LogicalProof implements Proof<LogicExpression> {
    //TODO: javadoc
    private final List<Statement<LogicExpression>> statements;
    private List<Statement<LogicExpression>> assumptions;
    private final Map<LogicExpression, Statement<LogicExpression>> all = new HashMap<>();
    private final Map<LogicExpression, Set<Statement<LogicExpression>>> right = new HashMap<>();
    private int line = 0;

    public LogicalProof(final List<Statement<LogicExpression>> assumptions) {
        this.assumptions = assumptions;
        statements = new ArrayList<>();
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
    public void addExpression(final LogicExpression expression, final StatementType<LogicExpression> type) {
        addStatement(new Statement<>(expression, type, -1));
    }

    @Override
    public void addExpression(final LogicExpression expression) {
        addExpression(expression, null);
    }

    @Override
    public void addStatement(final Statement<LogicExpression> st) {
        line++;
        st.setLine(line);
        statements.add(st);
        if (st.getExp() == null) {
            return;
        }
        if (st.getExp() instanceof BinaryOperator) {
            BinaryOperator bo = (BinaryOperator) st.getExp();
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

    public boolean rightExists(LogicExpression exp) {
        return right.containsKey(exp);
    }

    public Set<Statement<LogicExpression>> getRights(LogicExpression exp) {
        return right.get(exp);
    }

    public boolean allExists(LogicExpression exp) {
        return all.containsKey(exp);
    }

    public Statement<LogicExpression> getAll(LogicExpression exp) {
        return all.get(exp);
    }

    public ModusPonens<LogicExpression> findModusPonens(Statement<LogicExpression> statement) {
        if (rightExists(statement.getExp())) {
            Set<Statement<LogicExpression>> set = getRights(statement.getExp());
            for (Statement<LogicExpression> target : set) {
                if (target.getLine() >= statement.getLine()) {
                    continue;
                }
                BinaryOperator bo = (BinaryOperator) target.getExp();
                LogicExpression left = bo.getLeft();
                if (allExists(left)) {
                    Statement st = all.get(left);
                    if (st.getLine() >= statement.getLine()) {
                        continue;
                    }
                    Statement<LogicExpression> antecedent = getAll(left);
                    return new ModusPonens<>(antecedent, target);
                }
            }
        }
        return null;
    }

    @Override
    public void addProof(Proof<LogicExpression> proof) {
        proof.getStatements().forEach(this::addStatement);
    }

    @Override
    public Proof<LogicExpression> replaceAll(Map<Integer, LogicExpression> map) {
        Proof<LogicExpression> newProof = new LogicalProof(assumptions);
        for (Statement<LogicExpression> statement : statements) {
            newProof.addStatement(new Statement<>(statement.getExp().replaceAll(map), statement.getType(), -1));
        }
        return newProof;
    }

    @Override
    public List<Statement<LogicExpression>> getAssumptions() {
        return assumptions;
    }

    @Override
    public void setAssumptions(List<Statement<LogicExpression>> assumptions) {
        this.assumptions = assumptions;
    }

    @Override
    public String asSimpleString() {

        StringBuilder sb = new StringBuilder();

        for (Statement<LogicExpression> s : statements) {
            sb.append(s.toSimpleString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public List<Statement<LogicExpression>> getStatements() {
        return statements;
    }

    @Override
    public boolean check(List<Statement<LogicExpression>> assumptions) {
        Validator<LogicExpression> validator = LogicValidator.getInstance();
        try {
            validator.validate(this, assumptions);
            return true;
        } catch (InvalidProofException  e) {
            return false;
        }
    }

    @Override
    public StatementType<LogicExpression> findBasis(final Statement<LogicExpression> statement, Map<String, Statement<LogicExpression>> map) {
        ModusPonens<LogicExpression> proofModusPonens = findModusPonens(statement);
        if (proofModusPonens != null) {
            return proofModusPonens;
        }

        for (LogicAxiom axiom : LogicAxiom.values()) {
            if (axiom.matches(statement.getExp())) {
                return axiom;
            }
        }

        if (assumptions != null) {
            for (Statement assumption : assumptions) {
                if (assumption.getExp().equals(statement.getExp())) {
                    return new Assumption<>();
                }
            }
        }

        return new Error<>();
    }

    private boolean containsStatement(final List<Statement<LogicExpression>> proofed, final Statement statement) {
        if (proofed == null) {
            return false;
        }
        for (Statement allow : proofed) {
            if (allow.equals(statement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deduct(final Statement<LogicExpression> statement,
                       final Proof<LogicExpression> newProof,
                       final LogicExpression currentAssumption,
                       final List<Statement<LogicExpression>> proofed) throws InvalidProofException {
        try {
            Parser<LogicExpression> parser = LogicParser.getInstance();
            LogicExpression currentExp = statement.getExp();
            StatementType statementType = statement.getType();
            if (statement.getExp().equals(currentAssumption)) {
                newProof.addExpression(parser.parse("(1)->(1)->(1)".replace("1", currentExp.toString())));
                newProof.addExpression(parser.parse("((1)->((1)->(1)))->((1)->(((1)->(1))->(1)))->((1)->(1))".replace("1", currentExp.toString())));
                newProof.addExpression(parser.parse("((1)->(((1)->(1))->1))->((1)->(1))".replace("1", currentExp.toString())));
                newProof.addExpression(parser.parse("((1)->(((1)->(1))->(1)))".replace("1", currentExp.toString())));
                newProof.addExpression(parser.parse("(1)->(1)".replace("1", currentExp.toString())));
            } else if (statementType.getClass() == LogicAxiom.class || containsStatement(assumptions, statement) || containsStatement(proofed, statement)) {
                newProof.addExpression(currentExp);
                newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)));
                LogicExpression expression = new Entailment(currentAssumption, currentExp);
                newProof.addExpression(expression);
            } else if (statementType.getClass() == ModusPonens.class) {
                Statement antecedent = ((ModusPonens) statementType).getFirst();
                LogicExpression expression = parser.parse("((1)->(2))->(((1)->((2)->(3)))->((1)->(3)))".replace("1", currentAssumption.toString()).replace("2", antecedent.getExp().toString()).replace("3", currentExp.toString()));
                newProof.addExpression(expression);
                expression = parser.parse("(((1)->((2)->(3)))->((1)->(3)))".replace("1", currentAssumption.toString()).replace("2", antecedent.getExp().toString()).replace("3", currentExp.toString()));
                newProof.addExpression(expression);
                expression = parser.parse("(1)->(3)".replace("1", currentAssumption.toString()).replace("3", currentExp.toString()));
                newProof.addExpression(expression);
            }
        } catch (ParseException e) {
            throw new IllegalStateException("Const expression is invalid");
        }
    }
}
