package interfaces;

import exceptions.InvalidProofException;
import proof.LogicalProof;
import proof.Proof;
import proof.Statement;
import scanner.FastLineScanner;
import structure.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface, providing way to validate some {@link LogicalProof}.
 * It isn't bounded to some theory (propositional logic, formal
 * arithmetic or some other), so it's somehow general for all
 * math logic theories.
 *
 * @author Daniyar Itegulov
 */
public interface Validator<E extends Expression<E>> {
    /**
     * Validates {@code file}, containing proof, consisting
     * of statements line by line. Creates formal {@link LogicalProof},
     * which match that one in the file.
     *
     * @param file file, containing proof
     * @return formal proof, obtained from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof<E> validate(final File file) throws FileNotFoundException, InvalidProofException;

    /**
     * Validates {@code file}, containing proof, consisting
     * of statements line by line. Assumes, that {@code assumptions}
     * contains {@link proof.Statement}, that can be trusted to be true.
     * Creates formal {@link LogicalProof}, which match that one in the file
     * ({@code assumptions} can be used)
     *
     * @param file file, containing proof
     * @param assumptions array of statements, which can be believed to be true
     * @return formal proof, obtained from {@code file}
     * @throws FileNotFoundException if {@code file} wasn't found
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof<E> validate(final File file, final List<Statement<E>> assumptions) throws FileNotFoundException, InvalidProofException;

    /**
     * Validates left data from {@code in}, containing proof, consisting
     * of statements line by line. Assumes, that {@code assumptions}
     * contains {@link proof.Statement}, that can be trusted to be true.
     * Creates formal {@link LogicalProof}, which match that one in the file
     * ({@code assumptions} can be used)
     *
     * @param in fast line scanner, which contains proof data
     * @param assumptions array of statements, which can be believed to be true
     * @return formal proof, obtained from {@code file}
     * @throws InvalidProofException if {@code proof} contains invalid
     * proof: at least one statement has no suitable basis
     */
    Proof<E> validate(final FastLineScanner in, final List<Statement<E>> assumptions) throws InvalidProofException;

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
    Proof<E> validate(final Proof<E> proof, final List<Statement<E>> assumptions) throws InvalidProofException;
}
