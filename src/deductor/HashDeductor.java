package deductor;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import expression.BinaryOperator;
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
    //All contains all expressions
    private Map<Expression, Statement> all;
    /**
     * All contains all expressions, suitable for next rule:
     * If expression has the next form: a -> b, then b
     * is contained in right map
     */
    private Map<Expression, Set<Statement>> right;
    //List of all statements
    private List<Statement> statements;
    //Current line number
    private int line;
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

    private void addExpression(@Nullable final Expression expression, @Nullable final StatementType type) {
        line++;
        Statement st = new Statement(expression, type, line);
        statements.add(st);
        if (expression == null) {
            return;
        }
        if (expression.isBinary()) {
            BinaryOperator bo = (BinaryOperator) expression;
            if (right.containsKey(bo.getRight())) {
                right.get(bo.getRight()).add(st);
            } else {
                right.put(bo.getRight(), new HashSet<Statement>());
                right.get(bo.getRight()).add(st);
            }
        }
        all.put(expression, st);
    }

    @Override
    public Proof deduct(final File f) throws FileNotFoundException, ParseException {
        statements = new ArrayList<>();
        right = new HashMap<>();
        all = new HashMap<>();
        FastLineScanner scanner = new FastLineScanner(f);

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("|-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final Statement[] assumptions = new Statement[assumptionStrings.length];
        for (int i = 0; i < assumptionStrings.length; i++) {
            assumptions[i] = new Statement(ExpressionParser.parse(assumptionStrings[i]), new Assumption(), i + 2);
        }
        Proof proof = new HashValidator().validate(f);
        for (Statement assumption : assumptions) {
            ArrayList<Statement> statements = new ArrayList<>();
            Expression currentAssumption = assumption.getExp();
            line = 0;
            for (Statement statement : proof.getStatements()) {
                Expression currentExp = statement.getExp();
                StatementType statementType = statement.getType();
                //What's going on :(
                //TODO: do something with it
                if (statement.equals(assumption)) {
                    addExpression(ExpressionParser.parse("a->a->a".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    addExpression(ExpressionParser.parse("(a->(a->a))->(a->((a->a)->a))->(a->a)".replaceAll("a", currentExp.toString())), Axiom.AxiomTwo);
                    ModusPonens modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    addExpression(ExpressionParser.parse("(a->((a->a)->a))->(a->a)".replaceAll("a", currentExp.toString())), modusPonens);
                    addExpression(ExpressionParser.parse("(a->((a->a)->a))".replaceAll("a", currentExp.toString())), Axiom.AxiomOne);
                    modusPonens = new ModusPonens(statements.get(statements.size() - 1), statements.get(statements.size() -2));
                    addExpression(ExpressionParser.parse("a->a".replaceAll("a", currentExp.toString())), modusPonens);
                } else if (statementType.getClass() == Axiom.class || allowanceContainsStatement(assumptions, statement)) {
                    addExpression(statement.getExp(), statementType);
                    addExpression(new Entailment(statement.getExp(), new Entailment(assumption.getExp(), statement.getExp())), Axiom.AxiomOne);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens)statementType).getFirst();
                    Expression exp = ExpressionParser.parse("(a->b)->((a->(b->c))->(a->c))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.toString())
                            .replaceAll("c", currentExp.toString()));
                    addExpression(exp, Axiom.AxiomTwo);
                    //TODO: convert to normal
                    exp = ExpressionParser.parse("((a->(b->c))->(a->c))"
                            .replaceAll("a", currentAssumption.toString())
                            .replaceAll("b", antecedent.toString())
                            .replaceAll("c", currentExp.toString()));
                    statements.add(new Statement(exp, Axiom.AxiomTwo, line));
                } else {

                }
            }
            //proof = new Proof(statements.toArray(new Statement[statements.size()]));
        }
        return null;
    }
}
