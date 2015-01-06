package proof;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import parser.ExpressionParser;
import structure.logic.BinaryOperator;
import structure.Expression;
import parser.ParseException;
import parser.Parser;
import scanner.FastLineScanner;
import validator.HashValidator;
import validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class Proof {
    //TODO: javadoc
    //All statements in proof
    private final List<Statement> statements;
    //All contains all expressions
    private final Map<Expression, Statement> all = new HashMap<>();
    /**
     * All contains all expressions, suitable for next rule:
     * If expression has the next form: a -> b, then b
     * is contained in right map
     */
    private final Map<Expression, Set<Statement>> right = new HashMap<>();
    //Current line number
    private int line = 0;

    public Proof() {
        statements = new ArrayList<>();
    }

    public Proof(@NotNull String proof) throws ParseException {
        Parser<Expression> expressionParser = new ExpressionParser();
        String[] lines = proof.split("\n");
        statements = new ArrayList<>();
        for (String s: lines) {
            line++;
            String[] tokens = s.split(" ", 2);
            if (tokens[1].matches("\\(сх\\. акс\\.(.*)")) {
                statements.add(new Statement(expressionParser.parse(tokens[0]), Axiom.values()[Integer.parseInt(tokens[1].substring(10, tokens[1].length() - 1)) - 1], line));
            } else {
                if (tokens[1].matches("\\(M\\.P\\.(.*)")) {
                    String lineNumbers = tokens[1].substring(6, tokens[1].length() - 1);
                    String[] numbers = lineNumbers.split(", ");
                    int firstLine = Integer.parseInt(numbers[0]);
                    int secondLine = Integer.parseInt(numbers[1]);
                    statements.add(new Statement(expressionParser.parse(tokens[0]), new ModusPonens(statements.get(firstLine - 1), statements.get(secondLine - 1)), line));
                } else {
                    if (tokens[1].matches("\\(Не доказано\\)")) {
                        statements.add(new Statement(expressionParser.parse(tokens[0]),
                                new Error(), line));
                    } else {
                        throw new ParseException("Undefined type of statement");
                    }
                }
            }
        }
    }

    public Proof(@NotNull File file) throws ParseException, FileNotFoundException {
        Parser<Expression> expressionParser = new ExpressionParser();
        FastLineScanner scanner = new FastLineScanner(file);
        statements = new ArrayList<>();
        while (scanner.hasMore()) {
            String s = scanner.next();
            line++;
            String[] tokens = s.split(" ", 2);
            if (tokens[1].matches("\\(сх\\. акс\\.(.*)")) {
                statements.add(new Statement(expressionParser.parse(tokens[0]),
                        Axiom.values()[Integer.parseInt(tokens[1].substring(10, tokens[1].length() - 1)) - 1], line));
            } else {
                if (tokens[1].matches("\\(M\\.P\\.(.*)")) {
                    String lineNumbers = tokens[1].substring(6, tokens[1].length() - 1);
                    String[] numbers = lineNumbers.split(", ");
                    int firstLine = Integer.parseInt(numbers[0]);
                    int secondLine = Integer.parseInt(numbers[1]);
                    statements.add(new Statement(expressionParser.parse(tokens[0]), new ModusPonens(statements.get(firstLine - 1),
                            statements.get(secondLine - 1)), line));
                } else {
                    if (tokens[1].matches("\\(Не доказано\\)")) {
                        statements.add(new Statement(expressionParser.parse(tokens[0]),
                                new Error(), line));
                    } else {
                        throw new ParseException("Undefined type of statement");
                    }
                }
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proof)) return false;

        Proof proof = (Proof) o;
        Validator validator = new HashValidator();
        Proof otherValidated = validator.validate(proof, null);
        Proof myValidated = validator.validate(this, null);
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

    public String asSimpleString() {
        StringBuilder sb = new StringBuilder();

        for (Statement s : statements) {
            sb.append(s.asSimpleString()).append("\n");
        }

        return sb.toString();
    }

    public void addExpression(@Nullable final Expression expression, @Nullable final StatementType type) {
        addStatement(new Statement(expression, type, line + 1));
    }

    public void addStatement(@NotNull final Statement st) {
        line++;
        st.setLine(line);
        statements.add(st);
        if (st.getExp() == null) {
            return;
        }
        if (st.getExp().isBinary()) {
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

    public boolean rightExists(@NotNull Expression exp) {
        return right.containsKey(exp);
    }

    public Set<Statement> getRights(@NotNull Expression exp) {
        return right.get(exp);
    }

    public boolean allExists(@NotNull Expression exp) {
        return all.containsKey(exp);
    }

    public Statement getAll(@NotNull Expression exp) {
        return all.get(exp);
    }

    public ModusPonens findModusPonens(@NotNull Statement statement) {
        if (rightExists(statement.getExp())) {
            Set<Statement> set = getRights(statement.getExp());
            for (Statement target : set) {
                if (target.getLine() >= statement.getLine()) {
                    continue;
                }
                BinaryOperator bo = (BinaryOperator) target.getExp();
                Expression left = bo.getLeft();
                if (allExists(left)) {
                    Statement antecedent = getAll(left);
                    return new ModusPonens(antecedent, target);
                }
            }
        }
        return null;
    }

    public void addProof(Proof proof) {
        proof.getStatements().forEach(this::addStatement);
    }

    public Proof replace(Map<Expression, Expression> map) {
        Proof newProof = new Proof();
        for (Statement statement : statements) {
            newProof.addStatement(new Statement(statement.getExp().replaceAll(map), statement.getType(), -1));
        }
        return newProof;
    }

    public final List<Statement> getStatements() {
        return statements;
    }

    public int getLine() {
        return line;
    }
}
