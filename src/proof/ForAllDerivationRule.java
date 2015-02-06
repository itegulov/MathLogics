package proof;

import structure.logic.BinaryOperator;

public class ForAllDerivationRule implements StatementType {
    private final Statement previous;

    public ForAllDerivationRule(Statement previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForAllDerivationRule)) return false;

        ForAllDerivationRule that = (ForAllDerivationRule) o;

        return previous.equals(that.previous);

    }

    @Override
    public int hashCode() {
        return previous.hashCode();
    }

    @Override
    public String toString() {
        return "Правило вывода для всеобщности из " + previous.getLine();
    }
}