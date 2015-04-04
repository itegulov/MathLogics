package ru.ifmo.ctddev.itegulov.structure.predicatelogic;

import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.util.Map;

public final class PEntailment extends PBinaryOperator {
    //TODO: javadoc
    public PEntailment(FormalArithmeticExpression left, FormalArithmeticExpression right) {
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
    public FormalArithmeticExpression replaceAll(Map<Integer, FormalArithmeticExpression> replacement) {
        return new PEntailment(left.replaceAll(replacement), right.replaceAll(replacement));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new PEntailment(left, right);
    }
}
