package structure.logic;
import structure.Expression;

public final class Entailment extends BinaryOperator {
    //TODO: javadoc
    public Entailment(Expression left, Expression right) {
        super(left, right, "->");
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return !a | b;
    }

    @Override
    public String toJavaCode() {
        return "new Entailment(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }
}
