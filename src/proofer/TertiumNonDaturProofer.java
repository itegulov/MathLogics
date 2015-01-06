package proofer;

import parser.ExpressionParser;
import parser.ParseException;
import parser.Parser;
import proof.Assumption;
import proof.Proof;
import proof.Statement;
import rules.LogicRules;
import structure.Expression;
import structure.logic.Variable;
import validator.HashValidator;

import java.util.*;

public class TertiumNonDaturProofer implements Proofer {

    private Proof getProof(Expression toProve, List<Statement> hypothesis, int pos) {
        
    }

    @Override
    public Proof proof(String statement) throws ParseException {
        Parser<Expression> parser = new ExpressionParser();
        Expression expression = parser.parse(statement);
        Map<String, Variable> variables = expression.getVariables();
        Collection<Variable> variableValues = variables.values();
        int variablesCount = variables.size();
        for (int mask = 0; mask < (1 << variablesCount); mask++) {
            Map<String, Boolean> values = new HashMap<>();
            int count = 0;
            for (Variable var : variableValues) {
                if (((1 << count) & mask) != 0) {
                    values.put(var.getName(), true);
                } else {
                    values.put(var.getName(), false);
                }
                count++;
            }
            if (!expression.evaluate(values)) {
                StringBuilder sb = new StringBuilder("Выражение ложно при ");
                count = 0;
                for (Variable var : variableValues) {
                    if (((1 << count) & mask) != 0) {
                        sb.append(var.getName()).append("=И");
                    } else {
                        sb.append(var.getName()).append("=Л");
                    }
                    count++;
                    if (count != variablesCount) {
                        sb.append(",");
                    }
                }
                throw new IllegalStateException(sb.toString());
            }
        }
        Proof proof = new Proof();
        List<Statement> proofed = new ArrayList<>();
        List<Statement> hypothesis = new ArrayList<>();
        for (Variable var : variableValues) {
            Map<Expression, Expression> expressionMap = new HashMap<>();
            expressionMap.put(new Variable("a"), var);
            Proof newProof = LogicRules.TERTIUM_NON_DATUR_PROOF.replace(expressionMap);
            proof.addProof(newProof);
            proofed.add(newProof.getStatements().get(newProof.getStatements().size() - 1));
            hypothesis.add(new Statement(var, new Assumption(), -1));
        }
        proof.addProof(getProof(expression, hypothesis, 0));
        return proof;
    }

    public static void main(String[] args) {
        try {
            Proof proof = new TertiumNonDaturProofer().proof("a->a|b");
            proof = new HashValidator().validate(proof, null);
            System.out.println(proof);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
