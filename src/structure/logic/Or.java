package structure.logic;
import structure.Expression;

public final class Or extends BinaryOperator {
    //TODO: javadoc
    public Or(Expression left, Expression right) {
        super(left, right, "|");
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a | b;
    }

    @Override
    public String toJavaCode() {
        return "new Or(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }
}
