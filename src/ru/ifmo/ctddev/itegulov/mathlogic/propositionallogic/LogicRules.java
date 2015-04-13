package ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public final class LogicRules {
    private static final Proof<LogicExpression> CONTRAPOSITION_RULE_PROOF;
    private static final Proof<LogicExpression> TERTIUM_NON_DATUR_PROOF;

    private static Map<Integer, LogicExpression> map  = new HashMap<>();

    static {
        Proof<LogicExpression> proof;
        Validator<LogicExpression> hashValidator = LogicValidator.getInstance();
        try {
            proof = hashValidator.validate(new File("res/rules/contraposition_rule.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        CONTRAPOSITION_RULE_PROOF = proof;
    }

    static {
        Proof<LogicExpression> proof;
        Validator<LogicExpression> hashValidator = LogicValidator.getInstance();
        try {
            proof = hashValidator.validate(new File("res/rules/tertium_non_datur.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        TERTIUM_NON_DATUR_PROOF = proof;
    }

    public static void addTeruimNonDaturProof(LogicExpression e, Proof<LogicExpression> proof) {
        map.clear();
        map.put(1, e);
        proof.addProof(TERTIUM_NON_DATUR_PROOF.replaceAll(map));
    }

    public static void addContrapositionProof(LogicExpression first, LogicExpression second, Proof<LogicExpression> proof) {
        map.clear();
        map.put(1, first);
        map.put(2, second);
        proof.addProof(CONTRAPOSITION_RULE_PROOF.replaceAll(map));
    }
}