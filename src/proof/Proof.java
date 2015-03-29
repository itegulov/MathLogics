package proof;

import structure.Expression;

import java.util.List;

/**
 * Interface for all type of proofs in math logic theories.
 *
 * @author Daniyar Itegulov
 */
public interface Proof<E extends Expression> {
    /**
     * Adds statement to proof, consisting of expression
     * with specified {@link StatementType}.
     *
     * @param expression expression to add
     * @param type type of added statement
     */
    void addExpression(final E expression, final StatementType type);

    /**
     * Adds specified statement to proof.
     *
     * @param st statement to add
     */
    void addStatement(final Statement<E> st);

    /**
     * Adds all statement of specified proof to this proof.
     * All new statements need to be appended to the end.
     *
     * @param proof proof, which needs to be appended
     */
    void addProof(Proof<E> proof);

    /**
     * Retrieves all statements from this proof.
     *
     * @return list of statements in the order, specified
     * by this proof
     */
    List<Statement<E>> getStatements();

    /**
     * Checks if this proof is valid, assuming that {@code assumptions}
     * can be believed to be true.
     *
     * @param assumptions array of statements, which can be believed to be true
     * @return {@code true} if every statement in this proof has legal basis,
     * {@code false} otherwise
     */
    boolean check(Statement<E>[] assumptions);

    /**
     * Finds basis (statement type) for specified statement.
     *
     * @param statement statement, which basis to find
     * @return Statement type, describing basis of specified
     * statement. {@link Error} if couldn't found any.
     */
    StatementType findBasis(Statement<E> statement);
}
