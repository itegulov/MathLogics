package proof;

import exceptions.InvalidProofException;
import functional.SupplierThatThrows;
import interfaces.Validator;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import propositionallogic.validator.BasicValidator;
import scanner.FastLineScanner;
import structure.LogicExpression;
import structure.purelogic.BinaryOperator;
import structure.purelogic.Entailment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class LogicalProof implements Proof<LogicExpression> {
    //TODO: javadoc
    //All statements in proof
    private final List<Statement<LogicExpression>> statements;
    private final List<Statement<LogicExpression>> assumptions;
    //All contains all expressions
    private final Map<LogicExpression, Statement<LogicExpression>> all = new HashMap<>();
    /**
     * All contains all expressions, suitable for next rule:
     * If expression has the next form: a -> b, then b
     * is contained in right map
     */
    private final Map<LogicExpression, Set<Statement<LogicExpression>>> right = new HashMap<>();
    //Current line number
    private int line = 0;

    public LogicalProof(final List<Statement<LogicExpression>> assumptions) {
        this.assumptions = assumptions;
        statements = new ArrayList<>();
    }

    public LogicalProof(String proof, final List<Statement<LogicExpression>> assumptions) throws ParseException {
        this.assumptions = assumptions;
        Parser<LogicExpression> expressionParser = LogicParser.getInstance();
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

    public LogicalProof(File file, final List<Statement<LogicExpression>> assumptions) throws ParseException, FileNotFoundException {
        this(((SupplierThatThrows<String, FileNotFoundException>) () -> {
            FastLineScanner scanner = null;
            scanner = new FastLineScanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasMore()) {
                sb.append(scanner.next()).append("\n");
            }
            return sb.toString();
        }).get(), assumptions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicalProof)) return false;

        LogicalProof proof = (LogicalProof) o;
        Validator<LogicExpression> validator = BasicValidator.getInstance();
        //TODO: do something with it!
        Proof<LogicExpression> otherValidated;
        Proof<LogicExpression> myValidated;
        try {
            otherValidated = validator.validate(proof, null);
        } catch (InvalidProofException e1) {
            try {
                validator.validate(this ,null);
            } catch (InvalidProofException e2) {
                return true;
            }
            return false;
        }
        try {
            myValidated = validator.validate(this, null);
        } catch (InvalidProofException e) {
            return false;
        }
        int errorCount = 0;
        for (int i = 0; i < myValidated.getStatements().size(); i++) {
            if (myValidated.getStatements().get(i).getType().getClass() == Error.class) {
                errorCount++;
            }
        }

        for (int i = 0; i < otherValidated.getStatements().size(); i++) {
            if (otherValidated.getStatements().get(i).getType().getClass() == Error.class) {
                errorCount--;
            }
        }

        return errorCount == 0 && myValidated.getStatements().get(myValidated.getStatements().size() - 1).equals(
                otherValidated.getStatements().get(otherValidated.getStatements().size() - 1));
    }

    @Override
    public int hashCode() {
        return statements.hashCode();
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
    public void addExpression(final LogicExpression expression, final StatementType type) {
        addStatement(new Statement<>(expression, type, -1));
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

    public Statement getAll(LogicExpression exp) {
        return all.get(exp);
    }

    public ModusPonens findModusPonens(Statement<LogicExpression> statement) {
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
                    Statement antecedent = getAll(left);
                    return new ModusPonens(antecedent, target);
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
    public List<Statement<LogicExpression>> getStatements() {
        return statements;
    }

    @Override
    public boolean check(List<Statement<LogicExpression>> assumptions) {
        Validator<LogicExpression> validator = BasicValidator.getInstance();
        try {
            validator.validate(this, assumptions);
            return true;
        } catch (InvalidProofException  e) {
            return false;
        }
    }

    @Override
    public StatementType findBasis(final Statement<LogicExpression> statement, Map<String, Statement<LogicExpression>> map) {
        ModusPonens proofModusPonens = findModusPonens(statement);
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
                    return new Assumption();
                }
            }
        }

        return new Error();
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
                newProof.addExpression(parser.parse("(1)->(1)->(1)".replaceAll("1", currentExp.toString())), null);
                newProof.addExpression(parser.parse("((1)->((1)->(1)))->((1)->(((1)->(1))->(1)))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                newProof.addExpression(parser.parse("((1)->(((1)->(1))->1))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                newProof.addExpression(parser.parse("((1)->(((1)->(1))->(1)))".replaceAll("1", currentExp.toString())), null);
                newProof.addExpression(parser.parse("(1)->(1)".replaceAll("1", currentExp.toString())), null);
            } else if (statementType.getClass() == LogicAxiom.class || containsStatement(assumptions, statement) || containsStatement(proofed, statement)) {
                newProof.addExpression(currentExp, null);
                newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                LogicExpression expression = new Entailment(currentAssumption, currentExp);
                newProof.addExpression(expression, null);
            } else if (statementType.getClass() == ModusPonens.class) {
                Statement antecedent = ((ModusPonens) statementType).getFirst();
                LogicExpression expression = parser.parse("((1)->(2))->(((1)->((2)->(3)))->((1)->(3)))".replaceAll("1", currentAssumption.toString()).replaceAll("2", antecedent.getExp().toString()).replaceAll("3", currentExp.toString()));
                newProof.addExpression(expression, null);
                expression = parser.parse("(((1)->((2)->(3)))->((1)->(3)))".replaceAll("1", currentAssumption.toString()).replaceAll("2", antecedent.getExp().toString()).replaceAll("3", currentExp.toString()));
                newProof.addExpression(expression, null);
                expression = parser.parse("(1)->(3)".replaceAll("1", currentAssumption.toString()).replaceAll("3", currentExp.toString()));
                newProof.addExpression(expression, null);
            }
        } catch (ParseException e) {
            throw new IllegalStateException("Const expression is invalid");
        }
    }
}
