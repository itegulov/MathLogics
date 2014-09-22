package expression;

public final class Entailment extends BinaryOperator {
    //TODO: javadoc
    public Entailment(Expression left, Expression right) {
        super(left, right, "->", 1);
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return !a | b;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entailment) {
            Entailment entailment = (Entailment) obj;
            return entailment.left.equals(left) && entailment.right.equals(right);
        }
        return false;
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
    public String toJavaCode() {
        return "new Entailment(" + left.toJavaCode() + ", " + right.toJavaCode() + ")";
    }
}
