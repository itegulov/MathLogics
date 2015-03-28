package structure;

public abstract class AbstractExpression implements Expression {
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
        return asString().toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractExpression
                && ((AbstractExpression) obj).treeMatch(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
