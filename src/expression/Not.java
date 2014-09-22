package expression;

public final class Not extends UnaryOperator {
    //TODO: javadoc
    public Not(Expression exp) {
        super(exp, "!", 4);
    }

    @Override
    protected boolean operation(boolean a) {
        return !a;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Not && ((Not) obj).exp.equals(exp);
    }

    @Override
    public String toJavaCode() {
        return "new Not(" + exp.toJavaCode() + ")";
    }
}
