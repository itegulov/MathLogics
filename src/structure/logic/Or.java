package structure.logic;
import structure.Expression;

import java.util.Map;

public final class Or extends BinaryOperator {
    //TODO: javadoc
    public Or(Expression left, Expression right) {
        super(left, right, "|");
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a | b;
    }

    @Override
    public String toJavaCode() {
        return "new Or(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Or(left, right);
    }

    @Override
    public Expression replaceAll(Map<Expression, Expression> replacement) {
        Or or = new Or(null, null);
        if (replacement.containsKey(left)) {
            or.left = replacement.get(left);
        } else {
            or.left = left.replaceAll(replacement);
        }

        if (replacement.containsKey(right)) {
            or.right = replacement.get(right);
        } else {
            or.right = right.replaceAll(replacement);
        }
        return or;
    }
}
