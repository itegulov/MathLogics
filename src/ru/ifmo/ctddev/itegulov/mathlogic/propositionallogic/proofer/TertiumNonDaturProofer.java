package ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.proofer;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.FalseExpressionException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Deductor;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Proofer;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Assumption;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.LogicalProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.deductor.LogicDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.LogicRules;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Entailment;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Not;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Or;

import java.util.*;

public final class TertiumNonDaturProofer implements Proofer<LogicExpression> {
    private static TertiumNonDaturProofer ourInstance = new TertiumNonDaturProofer();

    //No instances for you
    private TertiumNonDaturProofer() {
    }

    public static TertiumNonDaturProofer getInstance() {
        return ourInstance;
    }

    private Deductor<LogicExpression> deductor = LogicDeductor.getInstance();
    private Parser<LogicExpression> parser = LogicParser.getInstance();
    private List<Statement<LogicExpression>> proofed;

    private <E> List<E> combineLists(List... lists) {
        List<E> list = new ArrayList<>();
        for (List l : lists) {
            list.addAll(l);
        }
        return list;
    }

    private Proof<LogicExpression> getProof(LogicExpression toProve, List<Statement<LogicExpression>> hypothesis, int pos) throws ParseException {
        LogicalProof proof = new LogicalProof(null);
        Statement<LogicExpression> var = new Statement<>(hypothesis.get(pos).getExp(), new Assumption(), -1);
        Statement<LogicExpression> notVar = new Statement<>(new Not(hypothesis.get(pos).getExp()), new Assumption(), -1);

        Proof<LogicExpression> proof1;
        Proof<LogicExpression> proof2;

        List<Statement<LogicExpression>> all = new ArrayList<>(proofed.size() + pos);
        for (int i = 0; i < pos; i++) {
            all.add(hypothesis.get(i));
        }
        all.addAll(proofed);

        if (pos == hypothesis.size() - 1) {
            proof1 = new LogicalProof(combineLists(Collections.singletonList(hypothesis.get(pos)), all));
            for (Statement<LogicExpression> st : proofed) {
                proof1.addStatement(st);
            }
            List<LogicExpression> hypothesisExp = new ArrayList<>();
            for (Statement<LogicExpression> st : hypothesis) {
                hypothesisExp.add(st.getExp());
            }
            List<LogicExpression> list = toProve.getParticularProof(hypothesisExp);
            for (LogicExpression expression : list) {
                proof1.addExpression(expression, null);
            }
            try {
                proof1 = deductor.deductAll(proof1, Collections.singletonList(hypothesis.get(pos)), all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
            hypothesis.set(pos, notVar);
            proof2 = new LogicalProof(combineLists(Collections.singletonList(hypothesis.get(pos)), all));
            for (Statement<LogicExpression> st : proofed) {
                proof2.addStatement(st);
            }
            hypothesisExp = new ArrayList<>();
            for (Statement<LogicExpression> st : hypothesis) {
                hypothesisExp.add(st.getExp());
            }
            list = toProve.getParticularProof(hypothesisExp);
            for (LogicExpression expression : list) {
                proof2.addExpression(expression, null);
            }
            try {
                proof2 = deductor.deductAll(proof2, Collections.singletonList(hypothesis.get(pos)), all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
        } else {
            proof1 = getProof(toProve, hypothesis, pos + 1);
            try {
                proof1 = LogicValidator.getInstance().validate(proof1, proofed);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
            try {
                proof1 = deductor.deductAll(proof1, Collections.singletonList(hypothesis.get(pos)), all);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Generated proof is invalid");
            }
            hypothesis.set(pos, notVar);
            proof2 = getProof(toProve, hypothesis, pos + 1);
            try {
                proof2 = deductor.deductAll(proof2, Collections.singletonList(hypothesis.get(pos)), all);
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
    public Proof<LogicExpression> proof(String statement) throws ParseException, FalseExpressionException {
        Parser<LogicExpression> parser = LogicParser.getInstance();
        LogicExpression expression = parser.parse(statement);
        Map<String, Variable<LogicExpression>> variables = new HashMap<>();
        expression.getVariables(variables);
        Collection<Variable<LogicExpression>> variableValues = variables.values();
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
                throw new FalseExpressionException(sb.toString());
            }
        }
        Proof<LogicExpression> proof = new LogicalProof(null);
        List<Statement<LogicExpression>> proofedList = new ArrayList<>();
        List<Statement<LogicExpression>> hypothesis = new ArrayList<>();
        for (Variable<LogicExpression> var : variableValues) {
            Map<Integer, LogicExpression> expressionMap = new HashMap<>();
            expressionMap.put(1, (LogicExpression) var);
            Proof<LogicExpression> newProof = LogicRules.TERTIUM_NON_DATUR_PROOF.replaceAll(expressionMap);
            proof.addProof(newProof);
            proofedList.add(newProof.getStatements().get(newProof.getStatements().size() - 1));
            hypothesis.add(new Statement<>((LogicExpression) var, new Assumption(), -1));
        }
        proofed = proofedList;
        proof.addProof(getProof(expression, hypothesis, 0));
        return proof;
    }
}
