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

    private Control control;

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
    public Proof validate(final FastLineScanner in, final Statement[] assumptions) {
        control = new Control();
        final Proof proof = new Proof();
        while (in.hasMore()) {
            control.flag = false;
            final String s;
            s = in.next();
            try {
                final Expression expression = ExpressionParser.parse(s);
                //Thread for application Modus Ponens rule
                Runnable modusPonens = new Runnable() {
                    @Override
                    public void run() {
                        ModusPonens proofModusPonens = proof.findModusPonens(expression, control);
                        if (proofModusPonens != null) {
                            proof.addExpression(expression, proofModusPonens);
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
                                    proof.addExpression(expression, axiom);
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
                                    proof.addExpression(expression, new Assumption());
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
                proof.addExpression(null, new Error(proof.getLine() + 1));
                return proof;
            } catch (ParseException e) {
                //Couldn't parse an expression
                proof.addExpression(null, new Error(proof.getLine() + 1));
                return proof;
            }
        }
        return proof;
    }
}