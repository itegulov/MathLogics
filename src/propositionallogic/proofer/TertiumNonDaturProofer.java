package propositionallogic.proofer;

import exceptions.InvalidProofException;
import interfaces.Deductor;
import interfaces.Proofer;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import proof.Assumption;
import proof.Proof;
import proof.Statement;
import propositionallogic.deductor.HashDeductor;
import propositionallogic.validator.HashValidator;
import rules.LogicRules;
import structure.Expression;
import structure.logic.Entailment;
import structure.logic.Not;
import structure.logic.Or;
import structure.logic.Variable;

import java.util.*;

public final class TertiumNonDaturProofer implements Proofer {
    private Deductor deductor = new HashDeductor();
    private Parser<Expression> parser = new LogicParser();
    private Statement[] proofed;

    private Proof getProof(Expression toProve, List<Statement> hypothesis, int pos) throws ParseException {
        Proof proof = new Proof();
        Statement var = new Statement(hypothesis.get(pos).getExp(), new Assumption(), -1);
        Statement notVar = new Statement(new Not(hypothesis.get(pos).getExp()), new Assumption(), -1);

        Proof proof1;
        Proof proof2;

        Statement[] all = new Statement[proofed.length + pos];
        for (int i = 0; i < pos; i++) {
            all[i] = hypothesis.get(i);
        }
        System.arraycopy(proofed, 0, all, pos, proofed.length);

        if (pos == hypothesis.size() - 1) {
            proof1 = new Proof();
            for (Statement st : proofed) {
                proof1.addStatement(st);
            }
            List<Expression> hypothesisExp = new ArrayList<>();
            for (Statement st : hypothesis) {
                hypothesisExp.add(st.getExp());
            }
            List<Expression> list = toProve.getParticularProof(hypothesisExp);
            for (Expression expression : list) {
                proof1.addExpression(expression, null);
            }
            try {
                proof1 = deductor.deduct(proof1, new Statement[]{hypothesis.get(pos)}, all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
            hypothesis.set(pos, notVar);
            proof2 = new Proof();
            for (Statement st : proofed) {
                proof2.addStatement(st);
            }
            hypothesisExp = new ArrayList<>();
            for (Statement st : hypothesis) {
                hypothesisExp.add(st.getExp());
            }
            list = toProve.getParticularProof(hypothesisExp);
            for (Expression expression : list) {
                proof2.addExpression(expression, null);
            }
            try {
                proof2 = deductor.deduct(proof2, new Statement[]{hypothesis.get(pos)}, all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
        } else {
            proof1 = getProof(toProve, hypothesis, pos + 1);
            proof1 = new HashValidator().validate(proof1, proofed);
            try {
                proof1 = deductor.deduct(proof1, new Statement[]{hypothesis.get(pos)}, all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
            hypothesis.set(pos, notVar);
            proof2 = getProof(toProve, hypothesis, pos + 1);
            try {
                proof2 = deductor.deduct(proof2, new Statement[]{hypothesis.get(pos)}, all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
        }
        proof.addProof(proof1);
        proof.addProof(proof2);
        hypothesis.set(pos, var);
        proof.addExpression(parser.parse("(1->3)->(2->3)->(1|2->3)"
                .replaceAll("1", var.getExp().toString())
                .replaceAll("2", notVar.getExp().toString())
                .replaceAll("3", toProve.toString())), null);
        proof.addExpression(new Entailment(new Entailment(notVar.getExp(), toProve), new Entailment(new Or(var.getExp(), notVar.getExp()), toProve)), null);
        proof.addExpression(new Entailment(new Or(var.getExp(), notVar.getExp()), toProve), null);
        proof.addExpression(toProve, null);
        return proof;
    }

    @Override
    public Proof proof(String statement) throws ParseException {
        Parser<Expression> parser = new LogicParser();
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
        List<Statement> proofedList = new ArrayList<>();
        List<Statement> hypothesis = new ArrayList<>();
        for (Variable var : variableValues) {
            Map<Integer, Expression> expressionMap = new HashMap<>();
            expressionMap.put(1, var);
            Proof newProof = LogicRules.TERTIUM_NON_DATUR_PROOF.replace(expressionMap);
            proof.addProof(newProof);
            proofedList.add(newProof.getStatements().get(newProof.getStatements().size() - 1));
            hypothesis.add(new Statement(var, new Assumption(), -1));
        }
        proofed = proofedList.toArray(new Statement[proofedList.size()]);
        proof.addProof(getProof(expression, hypothesis, 0));
        return proof;
    }

    public static void main(String[] args) {
        try {
            Proof proof = new TertiumNonDaturProofer().proof("!!(!!P->P)");
            proof = new HashValidator().validate(proof, null);
            System.out.println(proof);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
