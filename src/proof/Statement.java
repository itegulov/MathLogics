package proof;

import expression.Expression;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (exp != null) {
            if (!exp.equals(statement.exp)) {
                return false;
            }
        } else {
            if (statement.exp != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = exp != null ? exp.hashCode() : 0;
        result = 31 * result + type.hashCode();
        result = 31 * result + line;
        return result;
    }

    @Override
    public String toString() {
        if (exp == null) {
            return type.toString();
        }
        return exp.toString() + " (" + type.toString() + ")";
    }
}
