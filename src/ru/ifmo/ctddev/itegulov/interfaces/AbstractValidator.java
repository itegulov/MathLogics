package ru.ifmo.ctddev.itegulov.interfaces;

import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.proof.Error;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.proof.StatementType;
import ru.ifmo.ctddev.itegulov.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.structure.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Daniyar Itegulov
 */
public abstract class AbstractValidator<E extends Expression<E>> implements Validator<E> {

    abstract protected Parser<E> getParser();

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
                StatementType statementType = proof.findBasis(statement, proofed);

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
