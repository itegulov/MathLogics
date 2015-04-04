package ru.ifmo.ctddev.itegulov.proof;

public enum InductionRule implements StatementType {
    INDUCTION_RULE;

    @Override
    public String toString() {
        return "Сх. акс. индукции";
    }
}
