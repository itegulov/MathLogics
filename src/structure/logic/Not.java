package structure.logic;
import structure.Expression;

public final class Not extends UnaryOperator {
    //TODO: javadoc
    public Not(Expression exp) {
        super(exp, "!");
    }

    @Override
    protected boolean operation(boolean a) {
        return !a;
    }
    
    @Override
    public String toJavaCode() {
        return "new Not(" + exp.toJavaCode() + ")";
    }
}
