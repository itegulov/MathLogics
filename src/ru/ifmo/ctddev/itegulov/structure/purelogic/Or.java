package ru.ifmo.ctddev.itegulov.structure.purelogic;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.util.List;
import java.util.Map;

public final class Or extends BinaryOperator {
    //TODO: javadoc
    public Or(LogicExpression left, LogicExpression right) {
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
    public LogicExpression replaceAll(Map<Integer, LogicExpression> replacement) {
        return new Or(left.replaceAll(replacement), right.replaceAll(replacement));
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() | right.evaluate();
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        List<LogicExpression> result = super.getParticularProof(hypothesis);
        boolean l = left.evaluate();
        boolean r = right.evaluate();
        LogicExpression a = left;
        LogicExpression b = right;
        if (l & r) {
            result.add(new Entailment(a, new Or(a, b)));
            result.add(a);
            result.add(new Or(a, b));
        } else if (!l & r) {
            result.add(new Entailment(b, new Or(a, b)));
            result.add(b);
            result.add(new Or(a, b));
        } else if (l) {
            result.add(new Entailment(a, new Or(a, b)));
            result.add(a);
            result.add(new Or(a, b));
        } else {
            result.add(new Entailment(a, new Entailment(a, a)));
            result.add(new Entailment(new Entailment(a, new Entailment(a, a)), new Entailment(new Entailment(a, new Entailment(new Entailment(a, a), a)), new Entailment(a, a))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(a, a), a)), new Entailment(a, a)));
            result.add(new Entailment(a, new Entailment(new Entailment(a, a), a)));
            result.add(new Entailment(a, a));
            result.add(new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))), new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))))));
            result.add(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)));
            result.add(new Entailment(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)), new Entailment(a, new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)))));
            result.add(new Entailment(a, new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a))));
            result.add(new Entailment(new Entailment(a, a), new Entailment(new Entailment(a, new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a))), new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)))));
            result.add(new Entailment(new Entailment(a, new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a))), new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a))));
            result.add(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)));
            result.add(new Entailment(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), a)), new Entailment(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b)))))), new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), a), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b)))))), new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(new And(new Not(a), new Not(b)), new Not(a)));
            result.add(new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), new Not(a)))));
            result.add(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), new Not(a))));
            result.add(new Entailment(new Entailment(a, new Entailment(new And(new Not(a), new Not(b)), new Not(a))), new Entailment(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))), new Entailment(a, new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(new Entailment(a, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(a)), new Not(new And(new Not(a), new Not(b))))), new Entailment(a, new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(a, new Not(new And(new Not(a), new Not(b)))));
            result.add(new Entailment(b, new Entailment(b, b)));
            result.add(new Entailment(new Entailment(b, new Entailment(b, b)), new Entailment(new Entailment(b, new Entailment(new Entailment(b, b), b)), new Entailment(b, b))));
            result.add(new Entailment(new Entailment(b, new Entailment(new Entailment(b, b), b)), new Entailment(b, b)));
            result.add(new Entailment(b, new Entailment(new Entailment(b, b), b)));
            result.add(new Entailment(b, b));
            result.add(new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))), new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))))));
            result.add(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)));
            result.add(new Entailment(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)), new Entailment(b, new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)))));
            result.add(new Entailment(b, new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b))));
            result.add(new Entailment(new Entailment(b, b), new Entailment(new Entailment(b, new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b))), new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)))));
            result.add(new Entailment(new Entailment(b, new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b))), new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b))));
            result.add(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)));
            result.add(new Entailment(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), b)), new Entailment(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b)))))), new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))))));
            result.add(new Entailment(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), b), new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b)))))), new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(new And(new Not(a), new Not(b)), new Not(b)));
            result.add(new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), new Not(b)))));
            result.add(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), new Not(b))));
            result.add(new Entailment(new Entailment(b, new Entailment(new And(new Not(a), new Not(b)), new Not(b))), new Entailment(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))), new Entailment(b, new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(new Entailment(b, new Entailment(new Entailment(new And(new Not(a), new Not(b)), new Not(b)), new Not(new And(new Not(a), new Not(b))))), new Entailment(b, new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(b, new Not(new And(new Not(a), new Not(b)))));
            result.add(new Entailment(new Entailment(a, new Not(new And(new Not(a), new Not(b)))), new Entailment(new Entailment(b, new Not(new And(new Not(a), new Not(b)))), new Entailment(new Or(a, b), new Not(new And(new Not(a), new Not(b)))))));
            result.add(new Entailment(new Entailment(b, new Not(new And(new Not(a), new Not(b)))), new Entailment(new Or(a, b), new Not(new And(new Not(a), new Not(b))))));
            result.add(new Entailment(new Or(a, b), new Not(new And(new Not(a), new Not(b)))));
            result.add(new Entailment(new Not(a), new Entailment(new Not(b), new And(new Not(a), new Not(b)))));
            result.add(new Entailment(new Not(b), new And(new Not(a), new Not(b))));
            result.add(new And(new Not(a), new Not(b)));
            result.add(new Entailment(new And(new Not(a), new Not(b)), new Entailment(new Or(a, b), new And(new Not(a), new Not(b)))));
            result.add(new Entailment(new Or(a, b), new And(new Not(a), new Not(b))));
            result.add(new Entailment(new Entailment(new Or(a, b), new And(new Not(a), new Not(b))), new Entailment(new Entailment(new Or(a, b), new Not(new And(new Not(a), new Not(b)))), new Not(new Or(a, b)))));
            result.add(new Entailment(new Entailment(new Or(a, b), new Not(new And(new Not(a), new Not(b)))), new Not(new Or(a, b))));
            result.add(new Not(new Or(a, b)));
        }
        return result;
    }
}
