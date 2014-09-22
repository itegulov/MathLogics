package expression;

import java.util.Map;

public abstract class BinaryOperator implements Expression {
    //TODO: javadoc
    protected final Expression left, right;
    protected final String operationName;
    protected final int operationPriority;

    public BinaryOperator(Expression left, Expression right, String operationName, int operationPriority) {
        this.left = left;
        this.right = right;
        this.operationName = operationName;
        this.operationPriority = operationPriority;
    }

    @Override
    public final boolean evaluate(Map<String, Boolean> args) {
        return operation(left.evaluate(args), right.evaluate(args));
    }

    protected abstract boolean operation(boolean a, boolean b);

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        ExpressionType myType = ExpressionType.valueOf(getClass().getSimpleName());
        ExpressionType otherType = ExpressionType.valueOf(other.getClass().getSimpleName());
        if (myType == otherType) {
            BinaryOperator otherBo = (BinaryOperator) other;
            return left.matches(otherBo.left, map) && right.matches(otherBo.right, map);
        }
        return false;
    }

    @Override
    public final String toString() {
        return left.toString(operationPriority) + operationName + right.toString(operationPriority);
    }

    @Override
    public String toString(int priority) {
        if (operationPriority > priority) {
            return left.toString(operationPriority) + operationName + right.toString(operationPriority);
        } else {
            return "(" + left.toString(operationPriority) + operationName + right.toString(operationPriority) + ")";
        }
    }

    @Override
    public int hashCode() {
        int result = left.hashCode();
        result = 31 * result + right.hashCode();
        result = 31 * result + operationName.hashCode();
        return result;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}