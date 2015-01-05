package proof;

import structure.logic.BinaryOperator;

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
        ModusPonens modusPonens = (ModusPonens) o;
        BinaryOperator binaryOperator = (BinaryOperator) modusPonens.second.getExp();
        BinaryOperator myBinaryOperator = (BinaryOperator) second.getExp();
        return binaryOperator.getRight().equals(myBinaryOperator.getRight());
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
