package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

public final class Assumption<E extends Expression<E>> implements StatementType<E> {
    //TODO: javadoc
    //TODO: realize assumption

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass());
    }

    @Override
    public int hashCode() {
        return 42; //Any arbitrary constant is good
    }

    @Override
    public String toString() {
        return "Допущение";
    }
}
