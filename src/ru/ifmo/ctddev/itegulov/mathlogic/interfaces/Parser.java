package ru.ifmo.ctddev.itegulov.mathlogic.interfaces;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

/**
 * Interface, providing way to parse some types of {@link Expression}.
 *
 * @param <E> type of expression to parse
 */
public interface Parser<E extends Expression> {
    /**
     * Parses expressions from {@code expression}.
     *
     * @param expression string, describing expression to parse
     * @return expression, parsed from {@code expression}
     * @throws ParseException if {@code expression} contains invalid
     * expression
     */
    E parse(final String expression) throws ParseException;
}
