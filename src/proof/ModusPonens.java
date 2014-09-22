package proof;

import expression.BinaryOperator;

public final class ModusPonens implements StatementType {
    //TODO: javadoc
    private final Statement first, second;

    public ModusPonens(Statement first, Statement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryOperator bo = (BinaryOperator) second.getExp();
        return first.getExp().equals(bo.getLeft());
    }

    public Statement getFirst() {
        return first;
    }

    public Statement getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "M.P. " + first.getLine() + ", " + second.getLine();
    }
}
