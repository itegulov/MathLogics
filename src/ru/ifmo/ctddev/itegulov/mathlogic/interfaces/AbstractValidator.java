package ru.ifmo.ctddev.itegulov.mathlogic.interfaces;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Error;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.StatementType;
import ru.ifmo.ctddev.itegulov.mathlogic.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides basic implementation for {@link Validator}. Uses
 * {@link Proof#findBasis(Statement, Map)} to do all the work.
 *
 * @author Daniyar Itegulov
 */
public abstract class AbstractValidator<E extends Expression<E>> implements Validator<E> {

    /**
     * Get any correct parser, that can parse expressions
     * with type {@code E}.
     *
     * @return parser, that can correctly parse {@code E}
     * type expressions
     */
    abstract protected Parser<E> getParser();

    /**
     * Get any correct proof with specified assumptions, that represent
     * expressions of type {@code E}.
     *
     * @param assumptions list of {@link Statement}, which represent
     *                    assumptions in proof
     * @return proof, containing specified assumptions
     */
    abstract protected Proof<E> createProof(List<Statement<E>> assumptions);

    @Override
    public Proof<E> validate(final File f) throws FileNotFoundException, InvalidProofException {
        return validate(f, null);
    }

    @Override
    public Proof<E> validate(final File f, final List<Statement<E>> assumptions)
            throws FileNotFoundException, InvalidProofException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof<E> validate(final FastLineScanner in, final List<Statement<E>> assumptions) throws InvalidProofException {
        final Proof<E> proof = createProof(assumptions);
        final Parser<E> expressionParser = getParser();
        int line = 0;
        while (in.hasMore()) {
            line++;
            final String s;
            s = in.next();
            try {
                final E expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                throw new InvalidProofException("Вывод некорректен начиная с формулы " + line);
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof<E> validate(final Proof<E> proof, final List<Statement<E>> assumptions) throws InvalidProofException {
        Map<String, Statement<E>> proofed = new HashMap<>();
        int row = 0;
        for (Statement<E> statement : proof.getStatements()) {
            row++;
            if (statement.getType() == null) {
                StatementType<E> statementType = proof.findBasis(statement, proofed);

                if (!(statementType instanceof Error)) {
                    statement.setType(statementType);
                    proofed.put(statement.getExp().toString(), statement);
                } else {
                    statement.setType(statementType);
                    throw new InvalidProofException("Вывод некорректен начиная с формулы номер " + row);
                }
            } else {
                proofed.put(statement.getExp().toString(), statement);
            }
        }
        return proof;
    }
}
