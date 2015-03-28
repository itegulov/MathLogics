package interfaces;

import exceptions.InvalidProofException;
import proof.Proof;
import proof.Statement;
import scanner.FastLineScanner;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Interface, providing way to validate some {@link proof.Proof}.
 * It isn't bounded to some theory (propositional logic, formal
 * arithmetic or some other), so it's somehow general for all
 * math logic theories.
 *
 * @author Daniyar Itegulov
 */
public interface Validator {
    /**
     * Validates {@code file}, containing proof, consisting
     * of statements line by line. Creates formal {@link proof.Proof},
     * which match that one in the file.
     *
     * @param file file, containing proof
     * @return formal proof, obtained from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof validate(final File file) throws FileNotFoundException, InvalidProofException;

    /**
     * Validates {@code file}, containing proof, consisting
     * of statements line by line. Assumes, that {@code assumptions}
     * contains {@link proof.Statement}, that can be trusted to be true.
     * Creates formal {@link proof.Proof}, which match that one in the file
     * ({@code assumptions} can be used)
     *
     * @param file file, containing proof
     * @param assumptions array of statements, which can be believed to be true
     * @return formal proof, obtained from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof validate(final File file, final Statement[] assumptions) throws FileNotFoundException, InvalidProofException;

    /**
     * Validates left data from {@code in}, containing proof, consisting
     * of statements line by line. Assumes, that {@code assumptions}
     * contains {@link proof.Statement}, that can be trusted to be true.
     * Creates formal {@link proof.Proof}, which match that one in the file
     * ({@code assumptions} can be used)
     *
     * @param in fast line scanner, which contains proof data
     * @param assumptions array of statements, which can be believed to be true
     * @return formal proof, obtained from {@code file}
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof validate(final FastLineScanner in, final Statement[] assumptions) throws InvalidProofException;

    /**
     * Validates {@code proof}. If some {@link proof.Statement} from {@code proof} has
     * no type, than it tries to find it suitable basis. Assumes, that {@code assumptions}
     * contains {@link proof.Statement}, that can be trusted to be true.
     *
     * @param proof formal proof to be checked
     * @param assumptions array of statements, which can be believed to be true
     * @return proof, that consist of only validated statements
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof validate(final Proof proof, final Statement[] assumptions) throws InvalidProofException;
}
