package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

public final class Error<E extends Expression<E>> implements StatementType<E> {
    //TODO: javadoc

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass());
    }

    @Override
    public int hashCode() {
        return 23874;
    }

    @Override
    public String toString() {
        return "Не доказано";
    }
}
