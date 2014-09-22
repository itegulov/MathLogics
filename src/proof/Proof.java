package proof;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import expression.BinaryOperator;
import expression.Expression;
import parser.ExpressionParser;
import parser.ParseException;
import scanner.FastLineScanner;
import threading.Control;

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

    public Proof(@NotNull List<Statement> statements) {
        this.statements = statements;
    }

    public Proof(@NotNull String proof) throws ParseException {
        String[] lines = proof.split("\n");
        statements = new ArrayList<>();
        for (String s: lines) {
            line++;
            if (s.matches("Доказательство(.*)")) {
                statements.add(new Statement(null, new Error(line), line));
            } else {
                String[] tokens = s.split(" ", 2);
                if (tokens[1].matches("\\(сх\\. акс\\.(.*)")) {
                    statements.add(new Statement(ExpressionParser.parse(tokens[0]), Axiom.values()[Integer.parseInt(tokens[1].substring(10, tokens[1].length() - 1)) - 1], line));
                } else {
                    if (tokens[1].matches("\\(M\\.P\\.(.*)")) {
                        String lineNumbers = tokens[1].substring(6, tokens[1].length() - 1);
                        String[] numbers = lineNumbers.split(", ");
                        int firstLine = Integer.parseInt(numbers[0]);
                        int secondLine = Integer.parseInt(numbers[1]);
                        statements.add(new Statement(ExpressionParser.parse(tokens[0]), new ModusPonens(statements.get(firstLine - 1), statements.get(secondLine - 1)), line));
                    } else {
                        throw new ParseException("Undefined type of statement");
                    }
                }
            }
        }
    }

    public Proof(@NotNull File file) throws ParseException, FileNotFoundException {
        FastLineScanner scanner = new FastLineScanner(file);
        statements = new ArrayList<>();
        while (scanner.hasMore()) {
            String s = scanner.next();
            line++;
            if (s.matches("Доказательство(.*)")) {
                statements.add(new Statement(null, new Error(line), line));
            } else {
                String[] tokens = s.split(" ", 2);
                if (tokens[1].matches("\\(сх\\. акс\\.(.*)")) {
                    statements.add(new Statement(ExpressionParser.parse(tokens[0]),
                            Axiom.values()[Integer.parseInt(tokens[1].substring(10, tokens[1].length() - 1)) - 1], line));
                } else {
                    if (tokens[1].matches("\\(M\\.P\\.(.*)")) {
                        String lineNumbers = tokens[1].substring(6, tokens[1].length() - 1);
                        String[] numbers = lineNumbers.split(", ");
                        int firstLine = Integer.parseInt(numbers[0]);
                        int secondLine = Integer.parseInt(numbers[1]);
                        statements.add(new Statement(ExpressionParser.parse(tokens[0]), new ModusPonens(statements.get(firstLine - 1),
                                statements.get(secondLine - 1)), line));
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

        return statements.equals(proof.statements);

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

    public String[] toStrings() {
        String[] answer = new String[statements.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = statements.get(i).toString();
        }
        return answer;
    }

    public void addExpression(@Nullable final Expression expression, @Nullable final StatementType type) {
        line++;
        Statement st = new Statement(expression, type, line);
        statements.add(st);
        if (expression == null) {
            return;
        }
        if (expression.isBinary()) {
            BinaryOperator bo = (BinaryOperator) expression;
            if (right.containsKey(bo.getRight())) {
                right.get(bo.getRight()).add(st);
            } else {
                right.put(bo.getRight(), new HashSet<Statement>());
                right.get(bo.getRight()).add(st);
            }
        }
        all.put(expression, st);
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

    public int getLine() {
        return line;
    }

    public ModusPonens findModusPonens(@NotNull Expression expression, @Nullable Control control) {
        if (rightExists(expression)) {
            Set<Statement> set = getRights(expression);
            for (Statement target : set) {
                BinaryOperator bo = (BinaryOperator) target.getExp();
                Expression left = bo.getLeft();
                if (control != null && control.flag) {
                    return null;
                }
                if (allExists(left)) {
                    if (control != null) {
                        control.flag = true;
                    }
                    Statement antecedent = getAll(left);
                    return new ModusPonens(antecedent, target);
                }
            }
        }
        return null;
    }

    public final List<Statement> getStatements() {
        return statements;
    }
}
