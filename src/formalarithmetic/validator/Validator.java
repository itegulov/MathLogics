package formalarithmetic.validator;

import exceptions.InvalidProofException;
import proof.Proof;
import proof.Statement;
import scanner.FastLineScanner;

import java.io.File;
import java.io.FileNotFoundException;

public interface Validator {
    /**
     * Validates proof in formal arithmetic. It marks errors, but believes, that they are true
     * @param f             file containing proof
     * @return              validated proof in formal arithmetic
     */
    Proof validate(final File f) throws FileNotFoundException, InvalidProofException;
    Proof validate(final File f, final Statement[] assumptions) throws FileNotFoundException, InvalidProofException;
    Proof validate(final FastLineScanner in, final Statement[] assumptions) throws InvalidProofException;
    Proof validate(final Proof proof, final Statement[] assumptions) throws InvalidProofException;
}
