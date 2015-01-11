package proof;

import structure.Expression;

import java.util.Map;

public final class Statement {
    //TODO: javadoc
    private Expression exp;
    private StatementType type;
    private int line;

    public Statement(Expression exp, StatementType type, int line) {
        this.exp = exp;
        this.type = type;
        this.line = line;
    }

    public Expression getExp() {
        return exp;
    }

    public StatementType getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public void setType(StatementType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (exp != null) {
            return exp.equals(statement.exp);
        } else {
            return statement.exp == null;
        }
    }

    @Override
    public int hashCode() {
        return exp != null ? exp.hashCode() : 23498;
    }

    @Override
    public String toString() {
        if (exp == null) {
            return type.toString();
        }
        return "(" + line + ") " + exp.toString() + " (" + type.toString() + ")";
    }

    public String asSimpleString() {
        return exp.toString() + " (" + type.toString() + ")";
    }

    public Statement replaceAll(Map<Integer, Expression> replacement) {
        return new Statement(exp.replaceAll(replacement), type, line);
    }

    public void setLine(int line) {
        this.line = line;
    }
}
