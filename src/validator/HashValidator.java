package validator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import expression.*;
import parser.*;
import proof.*;
import proof.Error;
import scanner.FastLineScanner;
import threading.Control;

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
                //Couldn't parse an expression
                proof.addExpression(null, new Error());
                return proof;
            }
        }
        return validate(proof, assumptions);
    }

    @Override
    public Proof validate(final Proof proof, final Statement[] assumptions) {
        final Control control = new Control();
        for (final Statement statement : proof.getStatements()) {
            control.flag = false;
            if (statement.getType() == null) {
                final Expression expression = statement.getExp();
                //Thread for application Modus Ponens rule
                Runnable modusPonens = new Runnable() {
                    @Override
                    public void run() {
                        ModusPonens proofModusPonens = proof.findModusPonens(expression, control);
                        if (proofModusPonens != null) {
                            statement.setType(proofModusPonens);
                        }
                    }
                };

                //Thread for matching an axiom
                Runnable axiomMatch = new Runnable() {
                    @Override
                    public void run() {
                        for (Axiom axiom : Axiom.values()) {
                            synchronized (control) {
                                try {
                                    control.wait(0, 1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (control.flag) {
                                    return;
                                }

                                if (axiom.matches(expression)) {
                                    control.flag = true;
                                    statement.setType(axiom);
                                    return;
                                }
                                control.notifyAll();
                            }
                        }
                    }
                };

                //Thread for matching an assumption
                Runnable assumptionMatch = new Runnable() {
                    @Override
                    public void run() {
                        if (assumptions == null) {
                            return;
                        }
                        for (Statement assumption : assumptions) {
                            synchronized (control) {
                                try {
                                    control.wait(0, 1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (control.flag) {
                                    return;
                                }
                                if (assumption.getExp().equals(expression)) {
                                    control.flag = true;
                                    statement.setType(new Assumption());
                                    return;
                                }
                                control.notifyAll();
                            }
                        }
                    }
                };

                Thread first = new Thread(modusPonens, "Modus Ponens");
                Thread second = new Thread(axiomMatch, "Axiom matching");
                Thread third = new Thread(assumptionMatch, "Assumption matching");
                first.start();
                second.start();
                third.start();

                try {
                    first.join();
                    second.join();
                    third.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (control.flag) {
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