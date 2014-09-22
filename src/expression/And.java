package expression;

public final class And extends BinaryOperator {
    //TODO: javadoc
    public And(Expression left, Expression right) {
        super(left, right, "&", 3);
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a & b;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof And) {
            And and = (And) obj;
            return and.left.equals(left) && and.right.equals(right);
        }
        return false;
    }

    @Override
    public String toJavaCode() {
        return "new And(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }
}
