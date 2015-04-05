package ru.ifmo.ctddev.itegulov.mathlogic.structure;
/**
 * Interface for generating random {@link Expression} with specified size of
 * terms.
 * @author Daniyar Itegulov
 * @since %I% %G%
 * @version 1.0
 */
public interface ExpressionRandomGenerator<E extends Expression<E>> {
    /**
     * Generates random {@link ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression} with specified size of
     * terms.
     * @param size      specifies count of terms in result structure.expression
     * @return          some random structure.expression with specified size of terms
     */
    E generate(int size);
}
