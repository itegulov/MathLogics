package ru.ifmo.ctddev.itegulov.mathlogic.proof;

public final class Error implements StatementType {
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
