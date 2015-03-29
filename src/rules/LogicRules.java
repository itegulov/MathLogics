package rules;

import proof.LogicalProof;
import propositionallogic.validator.HashValidator;

import java.io.File;
import java.io.FileNotFoundException;

public final class LogicRules {
    public static final LogicalProof CONTRAPOSITION_RULE_PROOF;

    static {
        LogicalProof proof;
        HashValidator hashValidator = new HashValidator();
        try {
            proof = hashValidator.validate(new File("res/rules/contraposition_rule.proof"));
        } catch (FileNotFoundException e) {
            proof = null;
            e.printStackTrace();
        }
        CONTRAPOSITION_RULE_PROOF = proof;
    }

    public static final LogicalProof TERTIUM_NON_DATUR_PROOF;

    static {
        LogicalProof proof;
        HashValidator hashValidator = new HashValidator();
        try {
            proof = hashValidator.validate(new File("res/rules/tertium_non_datur.proof"));
        } catch (FileNotFoundException e) {
            proof = null;
            e.printStackTrace();
        }
        TERTIUM_NON_DATUR_PROOF = proof;
    }

    public static void main(String[] args) {
        System.out.println(TERTIUM_NON_DATUR_PROOF.asSimpleString());
    }
}