package expression;

/**
 * Interface for generating random {@link Expression} with specified size of
 * terms.
 * @author Daniyar Itegulov
 * @since %I% %G%
 * @version 1.0
 */
public interface ExpressionRandomGenerator {
    /**
     * Generates random {@link expression.Expression} with specified size of
     * terms.
     * @param size      specifies count of terms in result expression
     * @return          some random expression with specified size of terms
     */
    Expression generate(int size);
}
