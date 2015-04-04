package ru.ifmo.ctddev.itegulov.propositionallogic.validator;

import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.proof.Error;
import ru.ifmo.ctddev.itegulov.proof.*;
import ru.ifmo.ctddev.itegulov.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Basic implementation of {@link Validator} for {@link LogicExpression}.
 * Works using provided @{link Proof} method {@link ru.ifmo.ctddev.itegulov.proof.Proof#findBasis(Statement, Map)}.
 */
public final class BasicValidator implements Validator<LogicExpression> {
    private static BasicValidator ourInstance = new BasicValidator();

    //No instances for you
    private BasicValidator() {
    }

    public static BasicValidator getInstance() {
        return ourInstance;
    }

    @Override
    public Proof<LogicExpression> validate(final File f) throws FileNotFoundException, InvalidProofException {
        return validate(f, null);
    }

    @Override
    public Proof<LogicExpression> validate(final File f,
                                           final List<Statement<LogicExpression>> assumptions)
            throws FileNotFoundException, InvalidProofException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof<LogicExpression> validate(final FastLineScanner in,
                                           final List<Statement<LogicExpression>> assumptions) throws InvalidProofException {
        final LogicalProof proof = new LogicalProof(assumptions);
        final Parser<LogicExpression> expressionParser = LogicParser.getInstance();
        while (in.hasMore()) {
            final String s;
            s = in.next();
            try {
                final LogicExpression expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                //Couldn't parse a structure.expression
                proof.addExpression(null, new Error());
                return proof;
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof<LogicExpression> validate(final Proof<LogicExpression> proof, final List<Statement<LogicExpression>> assumptions) throws InvalidProofException {
        for (final Statement<LogicExpression> statement : proof.getStatements()) {
            if (statement.getType() == null) {
                StatementType statementType = proof.findBasis(statement, null);
                statement.setType(statementType);
                if (statementType instanceof Error) {
                    //Couldn't match an axiom, match an assumption or apply Modus Ponens rule
                    throw new InvalidProofException("Вывод некорректен начиная с формулы №" + statement.getLine());
                }
            }
        }
        return proof;
    }
}