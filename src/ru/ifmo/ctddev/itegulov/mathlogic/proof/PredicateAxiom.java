package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

public enum PredicateAxiom implements StatementType<FormalArithmeticExpression> {
    AXIOM_FOR_ALL("Сх. акс. всеобщности"), AXIOM_EXISTS("Сх. акс. существования");

    private String text;

    PredicateAxiom(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
