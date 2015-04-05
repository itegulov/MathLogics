package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

import java.util.Map;

public final class POr extends PBinaryOperator {
    //TODO: javadoc
    public POr(FormalArithmeticExpression left, FormalArithmeticExpression right) {
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
    public FormalArithmeticExpression replaceAll(Map<Integer, FormalArithmeticExpression> replacement) {
        return new POr(left.replaceAll(replacement), right.replaceAll(replacement));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new POr(left, right);
    }
}
