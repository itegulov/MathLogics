package ru.ifmo.ctddev.itegulov.mathlogic.proof;

public enum InductionRule implements StatementType {
    INDUCTION_RULE;

    @Override
    public String toString() {
        return "Сх. акс. индукции";
    }
}
