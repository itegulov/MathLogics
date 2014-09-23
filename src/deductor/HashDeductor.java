package deductor;

import com.sun.istack.internal.NotNull;
import expression.Entailment;
import expression.Expression;
import parser.ExpressionParser;
import parser.ParseException;
import proof.*;
import scanner.FastLineScanner;
import validator.HashValidator;

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
    public Proof deduct(final File f) throws FileNotFoundException, ParseException {
        FastLineScanner scanner = new FastLineScanner(f);

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final Statement[] assumptions = new Statement[assumptionStrings.length];
        for (int i = 0; i < assumptionStrings.length; i++) {
            assumptions[i] = new Statement(ExpressionParser.parse(assumptionStrings[i]), new Assumption(), i + 2);
        }
        Proof proof = new HashValidator().validate(scanner, assumptions);

        for (Statement assumption : assumptions) {
            Expression currentAssumption = assumption.getExp();
            Proof newProof = new Proof();
            for (Statement statement : proof.getStatements()) {
                Expression currentExp = statement.getExp();
                StatementType statementType = statement.getType();
                //TODO: good enough i think
                if (statement.equals(assumption)) {
                    final List<Statement> statements = newProof.getStatements();
                    newProof.addExpression(ExpressionParser.parse("a->a->a".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    newProof.addExpression(ExpressionParser.parse("(a->(a->a))->(a->((a->a)->a))->(a->a)".replaceAll("a", currentExp.toString())), Axiom.AxiomTwo);
                    ModusPonens modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    newProof.addExpression(ExpressionParser.parse("(a->((a->a)->a))->(a->a)".replaceAll("a", currentExp.toString())), modusPonens);
                    newProof.addExpression(ExpressionParser.parse("(a->((a->a)->a))".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    newProof.addExpression(ExpressionParser.parse("a->a".replaceAll("a", currentExp.toString())), modusPonens);
                } else if (statementType.getClass() == Axiom.class || allowanceContainsStatement(assumptions, statement)) {
                    newProof.addExpression(statement.getExp(), statementType);
                    newProof.addExpression(new Entailment(statement.getExp(), new Entailment(assumption.getExp(), statement.getExp())), Axiom.AxiomOne);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens)statementType).getFirst();
                    Expression expression = ExpressionParser.parse("(a->b)->((a->(b->c))->(a->c))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.toString())
                            .replaceAll("c", currentExp.toString()));
                    newProof.addExpression(expression, Axiom.AxiomTwo);
                    expression = ExpressionParser.parse("((a->(b->c))->(a->c))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.toString())
                            .replaceAll("c", currentExp.toString()));
                    ModusPonens modusPonens = newProof.findModusPonens(expression, null);
                    newProof.addExpression(expression, modusPonens);
                    expression = ExpressionParser.parse("a->c"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("c", currentExp.toString()));
                    modusPonens = newProof.findModusPonens(expression, null);
                    newProof.addExpression(expression, modusPonens);
                }
            }
            proof = newProof;
        }
        return proof;
    }
}
