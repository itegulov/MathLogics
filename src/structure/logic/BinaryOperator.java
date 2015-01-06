package structure.logic;

import java.util.Map;

import structure.AbstractExpression;
import structure.Expression;

public abstract class BinaryOperator extends AbstractExpression {
    //TODO: javadoc
    protected Expression left, right;
    protected final String operationName;

    public BinaryOperator(Expression left, Expression right, String operationName) {
        this.left = left;
        this.right = right;
        this.operationName = operationName;
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
    public StringBuilder asString() {
        StringBuilder s1 = left.asString();
        StringBuilder s2 = right.asString();
        if (left instanceof BinaryOperator) {
            s1.insert(0, '(');
            s1.append(')');
        }
        if (right instanceof BinaryOperator) {
            s2.insert(0, '(');
            s2.append(')');
        }
        return s1.append(operationName).append(s2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperator binaryOperator = (BinaryOperator) o;
        return binaryOperator.left.equals(left) && binaryOperator.right.equals(right) && binaryOperator.operationName.equals(operationName);
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && ((BinaryOperator) other).left.treeMatch(left)
                && ((BinaryOperator) other).right.treeMatch(right);
    }

    @Override
    public Map<String, Variable> getVariables() {
        Map<String, Variable> variables = left.getVariables();
        variables.putAll(right.getVariables());
        return variables;
    }
}