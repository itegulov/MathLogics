package interfaces;

import exceptions.InvalidProofException;
import proof.LogicalProof;
import proof.Proof;
import proof.Statement;
import structure.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface, providing way to deductAll some {@link LogicalProof}.
 * It isn't bounded to some theory (propositional logic, formal
 * arithmetic or some other), so it's somehow general for all
 * math logic theories. But deduction theorem must be proofed
 * in this theory obviously.
 *
 * @author Daniyar Itegulov
 */
public interface Deductor<E extends Expression<E>> {
    /**
     * Deducts {@code file}, containing proof, consisting
     * of statements line by line. Assumes, that {@code proofed}
     * contains {@link proof.Statement}, that can be trusted to be true.
     * <p>
     * First line in {@code file} must be in this form:
     * <p>
     * A,B,...,C|-D
     * <p>
     * Which means, that D can be proofed if A,B,...,C are trusted to be
     * true. Creates formal {@link LogicalProof}, which lifts all assumptions:
     * <p>
     * |-A->B->...->C->D
     *
     * @param file file, containing proof
     * @param proofed array of statements, which can be trusted to be true
     * @return formal proof, deducted from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws InvalidProofException if proof, provided in {@code file} is
     * invalid
     */
    Proof<E> deductAll(final File file,
                       final List<Statement<E>> proofed) throws FileNotFoundException, InvalidProofException;

    /**
     * Deducts {@code proof} with left-turnstile elements {@code assumptions}.
     * Assumes, that {@code proofed} contains {@link proof.Statement}, that
     * can be trusted to be true.
     *
     * @param proof file, containing proof
     * @param assumptions array of statements, that describe left-turnstile statements
     * @param proofed array of statements, which can be trusted to be true
     * @return formal proof, deducted from {@code file}
     * @throws InvalidProofException
     * @see #deductAll(File, List)
     */
    Proof<E> deductAll(final Proof<E> proof,
                       final List<Statement<E>> assumptions,
                       final List<Statement<E>> proofed) throws InvalidProofException;

    /**
     * Deducts {@code proof} with left-turnstile elements {@code assumptions}.
     * Lifts only last assumption in contrast of {@link #deductAll(Proof, List, List)}.
     * Assumes, that {@code proofed} contains {@link proof.Statement}, that can
     * be trusted to be true.
     *
     * @param proof file, containing proof
     * @param assumptions array of statements, that describe left-turnstile statements
     * @param proofed array of statements, which can be trusted to be true
     * @return formal proof, deducted from {@code file}
     * @throws InvalidProofException
     */
    Proof<E> deductLast(final Proof<E> proof,
                        final List<Statement<E>> assumptions,
                        final List<Statement<E>> proofed) throws InvalidProofException;
}
