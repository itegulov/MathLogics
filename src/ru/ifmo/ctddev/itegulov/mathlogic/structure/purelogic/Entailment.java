package ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;

import java.util.List;
import java.util.Map;

public final class Entailment extends BinaryOperator {
    //TODO: javadoc
    public Entailment(LogicExpression left, LogicExpression right) {
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
    public LogicExpression replaceAll(Map<Integer, LogicExpression> replacement) {
        return new Entailment(left.replaceAll(replacement), right.replaceAll(replacement));
    }

    @Override
    public boolean evaluate() {
        return !(left.evaluate() && !right.evaluate());
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        List<LogicExpression> result = super.getParticularProof(hypothesis);
        boolean l = left.evaluate();
        boolean r = right.evaluate();
        LogicExpression a = left;
        LogicExpression b = right;
        if (l & r) {
            result.add(new Entailment(b, new Entailment(a, b)));
            result.add(b);
            result.add(new Entailment(a, b));
        } else if (!l & r) {
            result.add(new Entailment(b, new Entailment(a, b)));
            result.add(b);
            result.add(new Entailment(a, b));
        } else if (l) {
            result.add(new Entailment(new Entailment(a, b), new Entailment(new Entailment(a, b), new Entailment(a, b))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Entailment(new Entailment(a, b), new Entailment(a, b))), new Entailment(new Entailment(new Entailment(a, b), new Entailment(new Entailment(new Entailment(a, b), new Entailment(a, b)), new Entailment(a, b))), new Entailment(new Entailment(a, b), new Entailment(a, b)))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Entailment(new Entailment(new Entailment(a, b), new Entailment(a, b)), new Entailment(a, b))), new Entailment(new Entailment(a, b), new Entailment(a, b))));
            result.add(new Entailment(new Entailment(a, b), new Entailment(new Entailment(new Entailment(a, b), new Entailment(a, b)), new Entailment(a, b))));
            result.add(new Entailment(new Entailment(a, b), new Entailment(a, b)));
            result.add(a);
            result.add(new Entailment(a, new Entailment(new Entailment(a, b), a)));
            result.add(new Entailment(new Entailment(a, b), a));
            result.add(new Entailment(new Entailment(new Entailment(a, b), a), new Entailment(new Entailment(new Entailment(a, b), new Entailment(a, b)), new Entailment(new Entailment(a, b), b))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Entailment(a, b)), new Entailment(new Entailment(a, b), b)));
            result.add(new Entailment(new Entailment(a, b), b));
            result.add(new Entailment(b, new Or(new Not(a), b)));
            result.add(new Entailment(new Entailment(b, new Or(new Not(a), b)), new Entailment(new Entailment(a, b), new Entailment(b, new Or(new Not(a), b)))));
            result.add(new Entailment(new Entailment(a, b), new Entailment(b, new Or(new Not(a), b))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), b), new Entailment(new Entailment(new Entailment(a, b), new Entailment(b, new Or(new Not(a), b))), new Entailment(new Entailment(a, b), new Or(new Not(a), b)))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Entailment(b, new Or(new Not(a), b))), new Entailment(new Entailment(a, b), new Or(new Not(a), b))));
            result.add(new Entailment(new Entailment(a, b), new Or(new Not(a), b)));

            result.addAll(new Not(new Not(a)).getParticularProof(hypothesis));
            result.addAll(new Or(new Not(a), b).getParticularProof(hypothesis));

            result.add(new Entailment(new Not(new Or(new Not(a), b)), new Entailment(new Entailment(a, b), new Not(new Or(new Not(a), b)))));
            result.add(new Entailment(new Entailment(a, b), new Not(new Or(new Not(a), b))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Or(new Not(a), b)), new Entailment(new Entailment(new Entailment(a, b), new Not(new Or(new Not(a), b))), new Not(new Entailment(a, b)))));
            result.add(new Entailment(new Entailment(new Entailment(a, b), new Not(new Or(new Not(a), b))), new Not(new Entailment(a, b))));
            result.add(new Not(new Entailment(a, b)));
        } else {
            result.add(new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))));
            result.add(new Entailment(new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))), new Entailment(a, new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))))));
            result.add(new Entailment(a, new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b))))));
            result.add(new Entailment(new Not(a), new Entailment(new Not(b), new Not(a))));
            result.add(new Entailment(new Entailment(new Not(a), new Entailment(new Not(b), new Not(a))), new Entailment(a, new Entailment(new Not(a), new Entailment(new Not(b), new Not(a))))));
            result.add(new Entailment(a, new Entailment(new Not(a), new Entailment(new Not(b), new Not(a)))));
            result.add(new Entailment(a, new Entailment(new Not(b), a)));
            result.add(new Entailment(new Entailment(a, new Entailment(new Not(b), a)), new Entailment(a, new Entailment(a, new Entailment(new Not(b), a)))));
            result.add(new Entailment(a, new Entailment(a, new Entailment(new Not(b), a))));
            result.add(new Entailment(a, new Entailment(a, a)));
            result.add(new Entailment(new Entailment(a, new Entailment(a, a)), new Entailment(new Entailment(a, new Entailment(new Entailment(a, a), a)), new Entailment(a, a))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(a, a), a)), new Entailment(a, a)));
            result.add(new Entailment(a, new Entailment(new Entailment(a, a), a)));
            result.add(new Entailment(a, a));
            result.add(new Not(a));
            result.add(new Entailment(new Not(a), new Entailment(a, new Not(a))));
            result.add(new Entailment(a, new Not(a)));
            result.add(new Entailment(new Entailment(a, a), new Entailment(new Entailment(a, new Entailment(a, new Entailment(new Not(b), a))), new Entailment(a, new Entailment(new Not(b), a)))));
            result.add(new Entailment(new Entailment(a, new Entailment(a, new Entailment(new Not(b), a))), new Entailment(a, new Entailment(new Not(b), a))));
            result.add(new Entailment(a, new Entailment(new Not(b), a)));
            result.add(new Entailment(new Entailment(a, new Not(a)), new Entailment(new Entailment(a, new Entailment(new Not(a), new Entailment(new Not(b), new Not(a)))), new Entailment(a, new Entailment(new Not(b), new Not(a))))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Not(a), new Entailment(new Not(b), new Not(a)))), new Entailment(a, new Entailment(new Not(b), new Not(a)))));
            result.add(new Entailment(a, new Entailment(new Not(b), new Not(a))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Not(b), a)), new Entailment(new Entailment(a, new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b))))), new Entailment(a, new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(new Not(b), a), new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b))))), new Entailment(a, new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b))))));
            result.add(new Entailment(a, new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Not(b), new Not(a))), new Entailment(new Entailment(a, new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))), new Entailment(a, new Not(new Not(b))))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(new Not(b), new Not(a)), new Not(new Not(b)))), new Entailment(a, new Not(new Not(b)))));
            result.add(new Entailment(a, new Not(new Not(b))));
            result.add(new Entailment(new Not(new Not(b)), b));
            result.add(new Entailment(new Entailment(new Not(new Not(b)), b), new Entailment(a, new Entailment(new Not(new Not(b)), b))));
            result.add(new Entailment(a, new Entailment(new Not(new Not(b)), b)));
            result.add(new Entailment(new Entailment(a, new Not(new Not(b))), new Entailment(new Entailment(a, new Entailment(new Not(new Not(b)), b)), new Entailment(a, b))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Not(new Not(b)), b)), new Entailment(a, b)));
            result.add(new Entailment(a, b));
        }
        return result;
    }
}
