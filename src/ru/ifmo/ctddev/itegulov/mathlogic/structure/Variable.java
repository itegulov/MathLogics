package ru.ifmo.ctddev.itegulov.mathlogic.structure;

/**
 * @author Daniyar Itegulov
 */
public interface Variable<E extends Expression> extends Expression<E> {
    String getName();
}
