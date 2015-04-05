package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

public class ExistsDerivationRule implements StatementType<FormalArithmeticExpression> {
    private final Statement previous;

    public ExistsDerivationRule(Statement previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExistsDerivationRule)) return false;

        ExistsDerivationRule that = (ExistsDerivationRule) o;

        return previous.equals(that.previous);

    }

    @Override
    public int hashCode() {
        return previous.hashCode();
    }

    @Override
    public String toString() {
        return "Правило вывода для существования из " + previous.getLine();
    }
}
