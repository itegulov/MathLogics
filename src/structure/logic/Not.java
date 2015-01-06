package structure.logic;
import structure.Expression;

import java.util.Map;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Not((Expression) exp.clone());
    }

    @Override
    public Expression replaceAll(Map<Expression, Expression> replacement) {
        if (replacement.containsKey(exp)) {
            return new Not(replacement.get(exp));
        }
        return new Not(exp.replaceAll(replacement));
    }
}
