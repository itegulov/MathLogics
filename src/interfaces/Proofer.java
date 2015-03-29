package interfaces;

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
public interface Proofer<E extends Expression> {
    /**
     * Generates {@link LogicalProof}, that proofs {@code statement} without any
     * assumptions.
     *
     * @param statement string, describing expression to proof
     * @return generated proof
     * @throws ParseException if {@code statement} is invalid expression
     */
    Proof<E> proof(String statement) throws ParseException;
}
