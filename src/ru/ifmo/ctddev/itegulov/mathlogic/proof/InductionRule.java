package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

public enum InductionRule implements StatementType<FormalArithmeticExpression> {
    INDUCTION_RULE;

    @Override
    public String toString() {
        return "Сх. акс. индукции";
    }
}
