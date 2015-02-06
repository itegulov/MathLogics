package propositionallogic.deductor;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import structure.logic.Entailment;
import structure.Expression;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import proof.*;
import scanner.FastLineScanner;
import propositionallogic.validator.HashValidator;
import propositionallogic.validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;

public final class HashDeductor implements Deductor {
    //TODO: javadoc

    private boolean containsStatement(@NotNull final Statement[] proofed, @NotNull final Statement statement) {
        if (proofed == null) {
            return false;
        }
        for (Statement allow : proofed) {
            if (allow.equals(statement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Proof deduct(@NotNull final File f, @Nullable final Statement[] proofed) throws FileNotFoundException, ParseException {
        FastLineScanner scanner = new FastLineScanner(f);
        Parser<Expression> parser = new LogicParser();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final Statement[] assumptions = new Statement[assumptionStrings.length];
        for (int i = 0; i < assumptionStrings.length; i++) {
            assumptions[i] = new Statement(parser.parse(assumptionStrings[i]), new Assumption(), 0);
        }
        Validator validator = new HashValidator();
        Proof proof = validator.validate(scanner, assumptions);
        return deduct(proof, assumptions, proofed);
    }

    @Override
    public Proof deduct(@NotNull Proof proof, @NotNull final Statement[] assumptions, @Nullable final Statement[] proofed) throws ParseException {
        Validator validator = new HashValidator();
        Statement[] all;
        if (proofed != null) {
            all = new Statement[assumptions.length + proofed.length];
            System.arraycopy(assumptions, 0, all, 0, assumptions.length);
            System.arraycopy(proofed, 0, all, assumptions.length, proofed.length);
        } else {
            all = new Statement[assumptions.length];
            System.arraycopy(assumptions, 0, all, 0, assumptions.length);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        Parser<Expression> parser = new LogicParser();
        for (Statement assumption : assumptions) {
            Expression currentAssumption = assumption.getExp();
            Proof newProof = new Proof();
            for (Statement statement : proof.getStatements()) {
                Proof tempProof = validator.validate(newProof, all);
                if (!tempProof.check(proofed)) {
                    System.out.println("WUT");
                }
                Expression currentExp = statement.getExp();
                StatementType statementType = statement.getType();
                if (statement.getExp().equals(currentAssumption)) {
                    newProof.addExpression(parser.parse("(1)->(1)->(1)".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->((1)->(1)))->((1)->(((1)->(1))->(1)))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->(((1)->(1))->1))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->(((1)->(1))->(1)))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("(1)->(1)".replaceAll("1", currentExp.toString())), null);
                } else if (statementType.getClass() == Axiom.class
                        || containsStatement(assumptions, statement)
                        || containsStatement(proofed, statement)) {
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens) statementType).getFirst();
                    Expression expression = parser.parse("((1)->(2))->(((1)->((2)->(3)))->((1)->(3)))"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("2", antecedent.getExp().toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(((1)->((2)->(3)))->((1)->(3)))"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("2", antecedent.getExp().toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(1)->(3)"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                }
            }
            proof = validator.validate(newProof, all);
            proof.check(proofed);
        }
        return proof;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("Illegal count of arguments");
            return;
        }
        File f = new File("test.in");
        Deductor d = new HashDeductor();
        try {
            Proof proof = d.deduct(f, null);
            System.out.println(proof);
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
