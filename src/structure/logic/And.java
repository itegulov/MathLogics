package structure.logic;

import structure.Expression;

public final class And extends BinaryOperator {
    //TODO: javadoc
    public And(Expression left, Expression right) {
        super(left, right, "&");
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a & b;
    }

    @Override
    public String toJavaCode() {
        return "new And(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }
}
