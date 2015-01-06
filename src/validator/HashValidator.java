package validator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import structure.AbstractExpression;
import structure.Expression;
import structure.logic.*;
import parser.*;
import proof.*;
import proof.Error;
import scanner.FastLineScanner;

import java.io.File;
import java.io.FileNotFoundException;

public final class HashValidator implements Validator {
    //TODO: javadoc

    @Override
    public Proof validate(@NotNull final File f) throws FileNotFoundException {
        return validate(f, null);
    }

    @Override
    public Proof validate(@NotNull final File f, @Nullable final Statement[] assumptions) throws FileNotFoundException {
        final FastLineScanner in = new FastLineScanner(f);
        return validate(in, assumptions);
    }

    @Override
    public Proof validate(@NotNull final FastLineScanner in, @Nullable final Statement[] assumptions) {
        final Proof proof = new Proof();
        final Parser<Expression> expressionParser = new ExpressionParser();
        while (in.hasMore()) {
            final String s;
            s = in.next();
            try {
                final Expression expression = expressionParser.parse(s);
                proof.addExpression(expression, null);
            } catch (ParseException e) {
                //Couldn't parse an structure.expression
                proof.addExpression(null, new Error());
                return proof;
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof validate(final Proof proof, final Statement[] assumptions) {
        for (final Statement statement : proof.getStatements()) {
            if (statement.getType() == null) {
                final Expression expression = statement.getExp();
                boolean found = false;
                ModusPonens proofModusPonens = proof.findModusPonens(statement);
                if (proofModusPonens != null) {
                    statement.setType(proofModusPonens);
                    found = true;
                }
                if (!found) {
                    for (Axiom axiom : Axiom.values()) {
                        if (axiom.matches(expression)) {
                            statement.setType(axiom);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
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

                if (found) {
                    continue;
                }

                //Couldn't match an axiom, match an assumption or apply Modus Ponens rule
                statement.setType(new Error());
            }
        }
        return proof;
    }

    public static void main(String[] args) {
        File f = new File("test2.in");
        Validator v = new HashValidator();
        Statement[] assumptions = {new Statement(new Variable("P"), new Assumption(), 0)};
        try {
            Proof p = v.validate(f, assumptions);
            System.out.println(p);
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
    }
}