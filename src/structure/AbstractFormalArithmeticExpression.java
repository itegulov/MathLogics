package structure;

/**
 * @author Daniyar Itegulov
 */
public abstract class AbstractFormalArithmeticExpression implements FormalArithmeticExpression {
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
        return obj instanceof FormalArithmeticExpression
                && ((FormalArithmeticExpression) obj).treeMatch(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
