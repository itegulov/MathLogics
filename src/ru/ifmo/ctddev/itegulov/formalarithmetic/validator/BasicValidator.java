package ru.ifmo.ctddev.itegulov.formalarithmetic.validator;

import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.proof.Error;
import ru.ifmo.ctddev.itegulov.proof.*;
import ru.ifmo.ctddev.itegulov.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicValidator implements Validator<FormalArithmeticExpression> {
    //TODO: javadoc
    private static BasicValidator ourInstance = new BasicValidator();

    //No instances for you
    private BasicValidator() {
    }

    public static BasicValidator getInstance() {
        return ourInstance;
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(final File f) throws FileNotFoundException, InvalidProofException {
        return validate(f, null);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(final File f,
                                                      final List<Statement<FormalArithmeticExpression>> assumptions)
            throws FileNotFoundException, InvalidProofException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(final FastLineScanner in,
                                                      final List<Statement<FormalArithmeticExpression>> assumptions)
            throws InvalidProofException {
        final Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        final Parser<FormalArithmeticExpression> expressionParser = FormalArithmeticParser.getInstance();
        int line = 0;
        while (in.hasMore()) {
            line++;
            final String s;
            s = in.next();
            try {
                final FormalArithmeticExpression expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                throw new InvalidProofException("Вывод некорректен начиная с формулы " + line);
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof<FormalArithmeticExpression> validate(Proof<FormalArithmeticExpression> proof,
                                                      List<Statement<FormalArithmeticExpression>> assumptions)
            throws InvalidProofException {
        Map<String, Statement<FormalArithmeticExpression>> proofed = new HashMap<>();
        int row = 0;
        for (Statement<FormalArithmeticExpression> statement : proof.getStatements()) {
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
