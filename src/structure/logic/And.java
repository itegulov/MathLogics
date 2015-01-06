package structure.logic;

import structure.Expression;

import java.util.Map;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new And(left, right);
    }

    @Override
    public Expression replaceAll(Map<Expression, Expression> replacement) {
        And and = new And(null, null);
        if (replacement.containsKey(left)) {
            and.left = replacement.get(left);
        } else {
            and.left = left.replaceAll(replacement);
        }

        if (replacement.containsKey(right)) {
            and.right = replacement.get(right);
        } else {
            and.right = right.replaceAll(replacement);
        }
        return and;
    }
}
