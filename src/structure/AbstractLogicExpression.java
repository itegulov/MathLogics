package structure;

public abstract class AbstractLogicExpression implements LogicExpression {
    @Override
    public boolean match(Expression other) {
        return this.toString().equals(other.toString());
    }

    @Override
    public boolean hasSameType(Expression other) {
        return getClass().getSimpleName().equals(other.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        asString(sb);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractLogicExpression
                && ((AbstractLogicExpression) obj).treeMatch(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
