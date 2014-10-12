package deductor;

import com.sun.istack.internal.NotNull;
import expression.Entailment;
import expression.Expression;
import parser.ExpressionParser;
import parser.ParseException;
import parser.Parser;
import proof.*;
import scanner.FastLineScanner;
import validator.HashValidator;
import validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;

public final class HashDeductor implements Deductor {
    //TODO: javadoc
    //TODO: refactor

    private boolean allowanceContainsStatement(@NotNull final Statement[] allowance, @NotNull final Statement statement) {
        for (Statement allow : allowance) {
            if (allow.equals(statement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Proof deduct(@NotNull final File f) throws FileNotFoundException, ParseException {
        FastLineScanner scanner = new FastLineScanner(f);
        Parser<Expression> parser = new ExpressionParser();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final Statement[] assumptions = new Statement[assumptionStrings.length];
        for (int i = 0; i < assumptionStrings.length; i++) {
            assumptions[i] = new Statement(parser.parse(assumptionStrings[i]), new Assumption(), 0);
        }
        Validator validator = new HashValidator();
        Proof proof = validator.validate(scanner, assumptions);
        for (Statement assumption : assumptions) {
            Expression currentAssumption = assumption.getExp();
            Proof newProof = new Proof();
            for (Statement statement : proof.getStatements()) {
                Expression currentExp = statement.getExp();
                StatementType statementType = statement.getType();
                if (statement.getExp().equals(currentAssumption)) {
                    newProof.addExpression(parser.parse("(a)->(a)->(a)".replaceAll("a", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((a)->((a)->(a)))->((a)->(((a)->(a))->(a)))->((a)->(a))".replaceAll("a", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((a)->(((a)->(a))->a))->((a)->(a))".replaceAll("a", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((a)->(((a)->(a))->(a)))".replaceAll("a", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("(a)->(a)".replaceAll("a", currentExp.toString())), null);
                } else if (statementType.getClass() == Axiom.class || allowanceContainsStatement(assumptions, statement)) {
                    newProof.addExpression(statement.getExp(), null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens)statementType).getFirst();
                    Expression expression = parser.parse("((a)->(b))->(((a)->((b)->(c)))->((a)->(c)))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.getExp().toString())
                            .replaceAll("c", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(((a)->((b)->(c)))->((a)->(c)))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.getExp().toString())
                            .replaceAll("c", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(a)->(c)"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("c", currentExp.toString()));
                    newProof.addExpression(expression, null);
                }
            }
            proof = validator.validate(newProof, assumptions);
        }
        return proof;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("Illegal count of arguments");
        }
        File f = new File("test.in");
        Deductor d = new HashDeductor();
        try {
            Proof proof = d.deduct(f);
            System.out.println(proof);
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
