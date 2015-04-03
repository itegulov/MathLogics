package interfaces;

import exceptions.FalseExpressionException;
import parser.ParseException;
import proof.LogicalProof;
import proof.Proof;
import structure.Expression;

/**
 * Interface, providing way to proof some {@link structure.Expression}.
 * It isn't bounded to some theory (propositional logic, formal
 * arithmetic or some other), so it's somehow general for all
 * math logic theories. But there must be constructive proof
 * of theory's completeness.
 *
 * @author Daniyar Itegulov
 */
public interface Proofer<E extends Expression<E>> {
    /**
     * Generates {@link LogicalProof}, that proofs {@code statement} without any
     * assumptions.
     *
     * @param statement string, describing expression to proof
     * @return generated proof
     * @throws ParseException if {@code statement} is invalid expression
     * @throws FalseExpressionException if {@code statement} is false expression and
     * can't be proofed
     */
    Proof<E> proof(String statement) throws ParseException, FalseExpressionException;
}
