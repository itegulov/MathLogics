package expression;

import java.util.Map;

public abstract class UnaryOperator implements Expression {
    protected final Expression exp;
    protected final String operationName;
    protected final int operationPriority;

    public UnaryOperator(Expression exp, String operationName, int operationPriority) {
        this.exp = exp;
        this.operationName = operationName;
        this.operationPriority = operationPriority;
    }

    @Override
    public final boolean evaluate(Map<String, Boolean> args) {
        return operation(exp.evaluate(args));
    }

    protected abstract boolean operation(boolean a);

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        ExpressionType myType = ExpressionType.valueOf(getClass().getSimpleName());
        ExpressionType otherType = ExpressionType.valueOf(other.getClass().getSimpleName());
        if (myType == otherType) {
            UnaryOperator otherBo = (UnaryOperator) other;
            return exp.matches(otherBo.exp, map);
        }
        return false;
    }

    @Override
    public final String toString() {
        return operationName + exp.toString(operationPriority);
    }

    @Override
    public String toString(int priority) {
        return operationName + exp.toString(operationPriority);
    }

    @Override
    public int hashCode() {
        int result = exp.hashCode();
        result = 31 * result + operationName.hashCode();
        return result;
    }

    public Expression getExp() {
        return exp;
    }
}