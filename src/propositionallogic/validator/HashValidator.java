package propositionallogic.validator;

import interfaces.Validator;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import proof.*;
import proof.Error;
import scanner.FastLineScanner;
import structure.Expression;
import structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;

public final class HashValidator implements Validator<LogicExpression> {
    //TODO: javadoc

    @Override
    public Proof<LogicExpression> validate(final File f) throws FileNotFoundException {
        return validate(f, null);
    }

    @Override
    public Proof<LogicExpression> validate(final File f, final Statement<LogicExpression>[] assumptions) throws FileNotFoundException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof<LogicExpression> validate(final FastLineScanner in, final Statement<LogicExpression>[] assumptions) {
        final LogicalProof proof = new LogicalProof();
        final Parser<LogicExpression> expressionParser = new LogicParser();
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
    public Proof<LogicExpression> validate(final Proof<LogicExpression> proof, final Statement<LogicExpression>[] assumptions) {
        for (final Statement<LogicExpression> statement : proof.getStatements()) {
            if (statement.getType() == null) {
                final Expression expression = statement.getExp();
                boolean found = false;
                StatementType statementType = proof.findBasis(statement);
                if (!(statementType instanceof Error)) {
                    statement.setType(statementType);
                } else {
                    if (assumptions != null) {
                        for (Statement assumption : assumptions) {
                            if (assumption.getExp().equals(expression)) {
                                statement.setType(new Assumption());
                                found = true;
                                break;
                            }
                        }
                    }
                }
                if (!found) {
                    //Couldn't match an axiom, match an assumption or apply Modus Ponens rule
                    statement.setType(new Error());
                }
            }
        }
        return proof;
    }
}