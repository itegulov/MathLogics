package structure.logic;
import structure.Expression;

import java.util.Map;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Entailment(left, right);
    }

    @Override
    public Expression replaceAll(Map<Expression, Expression> replacement) {
        Entailment entailment = new Entailment(null, null);
        if (replacement.containsKey(left)) {
            entailment.left = replacement.get(left);
        } else {
            entailment.left = left.replaceAll(replacement);
        }

        if (replacement.containsKey(right)) {
            entailment.right = replacement.get(right);
        } else {
            entailment.right = right.replaceAll(replacement);
        }
        return entailment;
    }
}
