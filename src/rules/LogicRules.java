package rules;

import exceptions.InvalidProofException;
import interfaces.Validator;
import proof.Proof;
import propositionallogic.validator.BasicValidator;
import structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;

public final class LogicRules {
    public static final Proof<LogicExpression> CONTRAPOSITION_RULE_PROOF;

    static {
        Proof<LogicExpression> proof;
        Validator<LogicExpression> hashValidator = BasicValidator.getInstance();
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

    public static final Proof<LogicExpression> TERTIUM_NON_DATUR_PROOF;

    static {
        Proof<LogicExpression> proof;
        Validator<LogicExpression> hashValidator = BasicValidator.getInstance();
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
}