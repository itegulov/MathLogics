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
import java.util.*;

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
                    final List<Statement> statements = newProof.getStatements();
                    newProof.addExpression(parser.parse("(a)->(a)->(a)".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    newProof.addExpression(parser.parse("((a)->((a)->(a)))->((a)->(((a)->(a))->(a)))->((a)->(a))".replaceAll("a", currentExp.toString())), Axiom.AxiomTwo);
                    ModusPonens modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    newProof.addExpression(parser.parse("((a)->(((a)->(a))->a))->((a)->(a))".replaceAll("a", currentExp.toString())), modusPonens);
                    newProof.addExpression(parser.parse("((a)->(((a)->(a))->(a)))".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    newProof.addExpression(parser.parse("(a)->(a)".replaceAll("a", currentExp.toString())), modusPonens);
                } else if (statementType.getClass() == Axiom.class || allowanceContainsStatement(assumptions, statement)) {
                    newProof.addExpression(statement.getExp(), statementType);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), Axiom.AxiomOne);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    ModusPonens modusPonens = newProof.findModusPonens(expression, null);
                    newProof.addExpression(expression, modusPonens);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens)statementType).getFirst();
                    Expression expression = parser.parse("((a)->(b))->(((a)->((b)->(c)))->((a)->(c)))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.getExp().toString())
                            .replaceAll("c", currentExp.toString()));
                    newProof.addExpression(expression, Axiom.AxiomTwo);
                    expression = parser.parse("(((a)->((b)->(c)))->((a)->(c)))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.getExp().toString())
                            .replaceAll("c", currentExp.toString()));
                    ModusPonens modusPonens = newProof.findModusPonens(expression, null);
                    newProof.addExpression(expression, modusPonens);
                    expression = parser.parse("(a)->(c)"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("c", currentExp.toString()));
                    modusPonens = newProof.findModusPonens(expression, null);
                    if (modusPonens == null) {
                        System.out.println("Bad");
                        modusPonens = newProof.findModusPonens(expression, null);
                    }
                    newProof.addExpression(expression, modusPonens);
                }
            }
            proof = newProof;
        }
        return proof;
    }
}
