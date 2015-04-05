package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.BinaryOperator;

public final class ModusPonens<E extends Expression<E>> implements StatementType<E> {
    //TODO: javadoc
    private final Statement<E> first, second;

    public ModusPonens(Statement<E> first, Statement<E> second) {
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

    public Statement<E> getFirst() {
        return first;
    }

    public Statement<E> getSecond() {
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
