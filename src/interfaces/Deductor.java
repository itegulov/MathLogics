package interfaces;

import exceptions.InvalidProofException;
import parser.ParseException;
import proof.Proof;
import proof.Statement;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Interface, providing way to deduct some {@link proof.Proof}.
 * It isn't bounded to some theory (propositional logic, formal
 * arithmetic or some other), so it's somehow general for all
 * math logic theories. But deduction theorem must be proofed
 * in this theory obviously.
 *
 * @author Daniyar Itegulov
 */
public interface Deductor {
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
     * true. Creates formal {@link proof.Proof}, which lifts all assumptions:
     * <p>
     * |-A->B->...->C->D
     *
     * @param file file, containing proof
     * @param proofed array of statements, which can be trusted to be true
     * @return formal proof, deducted from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws ParseException if some of turnstile {@link structure.Expression}
     * couldn't be parsed
     * @throws InvalidProofException if proof, provided in {@code file} is
     * invalid
     */
    Proof deduct(final File file, final Statement[] proofed) throws FileNotFoundException, ParseException, InvalidProofException;

    /**
     * Deducts {@code proof} with left-turnstile elements {@code assumptions}.
     * Assumes, that {@code proofed} contains {@link proof.Statement}, that
     * can be trusted to be true.
     *
     * @param proof file, containing proof
     * @param assumptions array of statements, that describe left-turnstile statements
     * @param proofed array of statements, which can be trusted to be true
     * @return formal proof, deducted from {@code file}
     * @throws ParseException
     * @throws InvalidProofException
     * @see #deduct(File, Statement[])
     */
    Proof deduct(final Proof proof, final Statement[] assumptions, final Statement[] proofed) throws ParseException, InvalidProofException;
}