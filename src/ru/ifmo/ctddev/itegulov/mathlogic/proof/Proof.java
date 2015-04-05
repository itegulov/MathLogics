package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

import java.util.List;
import java.util.Map;

/**
 * Interface for all type of proofs in math logic theories.
 *
 * @author Daniyar Itegulov
 */
public interface Proof<E extends Expression<E>> {
    /**
     * Adds statement to proof, consisting of expression
     * with specified {@link StatementType}.
     *
     * @param expression expression to add
     * @param type type of added statement
     */
    void addExpression(final E expression, final StatementType<E> type);

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
    boolean check(List<Statement<E>> assumptions);

    /**
     * Finds basis (statement type) for specified statement.
     *
     * @param statement statement, which basis to find
     * @param proofed map, with keys, containing string representation of
     * expressions, contained in appropriate values
     * @return Statement type, describing basis of specified
     * statement. {@link Error} if couldn't found any.
     */
    StatementType<E> findBasis(Statement<E> statement, Map<String, Statement<E>> proofed) throws InvalidProofException;

    /**
     * Deducts {@code statement} and writes it to {@code newProof}.
     *
     * @param statement statement to deductAll
     * @param newProof proof, where deducted statements are to be written
     * @param currentAssumption expression, which needs to removed from left-turnstile side
     * @param proofed statements, which are proofed and can be believed to be true
     * @throws InvalidProofException
     */
    void deduct(Statement<E> statement, Proof<E> newProof, final E currentAssumption, final List<Statement<E>> proofed) throws InvalidProofException;

    /**
     * Replaces specified {@link ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Gap} (as keys in {@code map}
     * with specified expressions (as values in {@code Map}).
     *
     * @param map contains what gaps are to be replaced with what expressions
     * @return proof with replaced gaps
     * @see Expression#replaceAll(Map)
     */
    Proof<E> replaceAll(Map<Integer, E> map);
}
