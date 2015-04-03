package formalarithmetic.validator;

import exceptions.InvalidProofException;
import interfaces.Validator;
import parser.ArithmeticParser;
import parser.ParseException;
import parser.Parser;
import proof.Error;
import proof.*;
import scanner.FastLineScanner;
import structure.FormalArithmeticExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashValidator implements Validator<FormalArithmeticExpression> {
    //TODO: javadoc
    private static HashValidator ourInstance = new HashValidator();

    //No instances for you
    private HashValidator() {
    }

    public static HashValidator getInstance() {
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
        final Parser<FormalArithmeticExpression> expressionParser = ArithmeticParser.getInstance();
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
