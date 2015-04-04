package ru.ifmo.ctddev.itegulov.structure.predicatelogic;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.util.Map;

public final class PNot extends PUnaryOperator {
    //TODO: javadoc
    public PNot(FormalArithmeticExpression exp) {
        super(exp, "!");
    }

    @Override
    protected boolean operation(boolean a) {
        return !a;
    }
    
    @Override
    public String toJavaCode() {
        return "new Not(" + exp.toJavaCode() + ")";
    }

    @Override
    public FormalArithmeticExpression replaceAll(Map<Integer, FormalArithmeticExpression> replacement) {
        return new PNot(exp.replaceAll(replacement));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new ru.ifmo.ctddev.itegulov.structure.purelogic.Not((LogicExpression) exp.clone());
    }
}
