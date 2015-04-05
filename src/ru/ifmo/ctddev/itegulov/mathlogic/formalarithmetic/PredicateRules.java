package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniyar Itegulov
 */
public final class PredicateRules {
    public static final Proof<FormalArithmeticExpression> FOR_ALL_RULE;
    public static final Proof<FormalArithmeticExpression> EXISTS_RULE;

    private static Map<Integer, FormalArithmeticExpression> map  = new HashMap<>();

    public static void addForAllProof(FormalArithmeticExpression alpha, FormalArithmeticExpression e,
                                      FormalArithmeticExpression e1, Term variable, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, alpha);
        map.put(2, e);
        map.put(3, e1);
        map.put(4, variable);
        proof.addProof(PredicateRules.FOR_ALL_RULE.replaceAll(map));
    }

    public static void addExistsProof(FormalArithmeticExpression alpha, FormalArithmeticExpression e,
                                      FormalArithmeticExpression e1, Term variable, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, alpha);
        map.put(2, e);
        map.put(3, e1);
        map.put(4, variable);
        proof.addProof(PredicateRules.EXISTS_RULE.replaceAll(map));
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/for_all_rule.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        FOR_ALL_RULE = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/exists_rule.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        EXISTS_RULE = proof;
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException {
        /*FormalArithmeticProof proof = new FormalArithmeticProof(null);
        ExistsRule.addExistsProof1(new PGap(1), new PGap(2), new PGap(3), new PGap(4), proof);
        ExistsRule.addExistsProof2(new PGap(1), new PGap(2), new PGap(3), new PGap(4), proof);
        ExistsRule.addExistsProof3(new PGap(1), new PGap(2), new PGap(3), new PGap(4), proof);
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        validator.validate(proof, null);
        PrintWriter pw = new PrintWriter(new File("exists_rule.proof"));
        pw.println(proof.toSimpleString());
        pw.close();*/
        System.out.println(EXISTS_RULE);
    }
}
