package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

import java.util.Map;

public final class Exists extends Quantifier {
    public Exists(Term variable, FormalArithmeticExpression exp) {
        super(variable, exp, "?");
    }

    @Override
    public boolean treeMatch(Expression other) {
        return other.getClass() == getClass()
                && variable.treeMatch(((Exists) other).variable)
                && exp.treeMatch(((Exists) other).exp);
    }

    @Override
    public String toJavaCode() {
        return "new Exists(" + variable.toJavaCode() + "," + exp.toJavaCode() + ")";
    }

    @Override
    public FormalArithmeticExpression replaceAll(final Map<Integer, FormalArithmeticExpression> replacement) {
        return new Exists((Term) variable.replaceAll(replacement), exp.replaceAll(replacement));
    }
}
