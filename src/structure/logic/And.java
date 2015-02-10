package structure.logic;

import structure.Expression;

import java.util.List;
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
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        return new And(left.replaceAll(replacement), right.replaceAll(replacement));
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() & right.evaluate();
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        List<Expression> result = super.getParticularProof(hypothesis);

        boolean l = left.evaluate();
        boolean r = right.evaluate();
        Expression a = left;
        Expression b = right;
        if (l & r) {
            result.add(new Entailment(a, new Entailment(b, new And(a, b))));
            result.add(a);
            result.add(b);
            result.add(new Entailment(b, new And(a, b)));
            result.add(new And(a, b));
        } else if (!l & r) {
            result.add(new Entailment(new Entailment(new And(a, b), a), new Entailment(new Entailment(new And(a, b), new Not(a)), new Not(new And(a, b)))));
            result.add(new Entailment(new And(a, b), a));
            result.add(new Entailment(new Entailment(new And(a, b), new Not(a)), new Not(new And(a, b))));
            result.add(new Entailment(new Not(a), new Entailment(new And(a, b), new Not(a))));
            result.add(new Not(a));
            result.add(new Entailment(new And(a, b), new Not(a)));
            result.add(new Not(new And(a, b)));
        } else if (l) {
            result.add(new Entailment(new Entailment(new And(a, b), b), new Entailment(new Entailment(new And(a, b), new Not(b)), new Not(new And(a, b)))));
            result.add(new Entailment(new And(a, b), b));
            result.add(new Entailment(new Entailment(new And(a, b), new Not(b)), new Not(new And(a, b))));
            result.add(new Entailment(new Not(b), new Entailment(new And(a, b), new Not(b))));
            result.add(new Not(b));
            result.add(new Entailment(new And(a, b), new Not(b)));
            result.add(new Not(new And(a, b)));
        } else {
            result.add(new Entailment(new Entailment(new And(a, b), a), new Entailment(new Entailment(new And(a, b), new Not(a)), new Not(new And(a, b)))));
            result.add(new Entailment(new And(a, b), a));
            result.add(new Entailment(new Entailment(new And(a, b), new Not(a)), new Not(new And(a, b))));
            result.add(new Entailment(new Not(a), new Entailment(new And(a, b), new Not(a))));
            result.add(new Not(a));
            result.add(new Entailment(new And(a, b), new Not(a)));
            result.add(new Not(new And(a, b)));
        }
        return result;
    }
}
