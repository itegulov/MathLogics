package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor.FormalArithmeticDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Assumption;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PEntailment;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PNot;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PVariable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public final class PredicateRules {
    public static final Proof<FormalArithmeticExpression> FOR_ALL_RULE;
    public static final Proof<FormalArithmeticExpression> EXISTS_RULE;
    private static final Proof<FormalArithmeticExpression> CONTRAPOSITION_RULE_PROOF;
    private static final Proof<FormalArithmeticExpression> TERTIUM_NON_DATUR_PROOF;

    private static Map<Integer, FormalArithmeticExpression> map  = new HashMap<>();

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/contraposition_rule.proof"));
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
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> hashValidator = FormalArithmeticValidator.getInstance();
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

    public static void addTetruimNonDaturProof(FormalArithmeticExpression e, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, e);
        proof.addProof(TERTIUM_NON_DATUR_PROOF.replaceAll(map));
    }

    public static void addContrapositionProof(FormalArithmeticExpression first,
                                              FormalArithmeticExpression second,
                                              Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, first);
        map.put(2, second);
        Proof<FormalArithmeticExpression> temp = CONTRAPOSITION_RULE_PROOF.replaceAll(map);
        for (Statement<FormalArithmeticExpression> statement : temp.getStatements()) {
            statement.setType(null);
        }
        proof.addProof(temp);
    }

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

    public static void liftQuantifier(PNot pNot, Proof<FormalArithmeticExpression> proof) {
        if (pNot.getExp() instanceof Exists) {
            Exists exists = (Exists) pNot.getExp();
            FormalArithmeticExpression p = exists.getExp();
            Term x = exists.getVariable();
            proof.addExpression(new PEntailment(p, new Exists(x, p)));
            addContrapositionProof(p, new Exists(x, p), proof);
            proof.addExpression(new PEntailment(new PNot(new Exists(x, p)), new PNot(p)));
            proof.addExpression(new PEntailment(new PNot(new Exists(x, p)), new ForAll(x, new PNot(p))));
            proof.addExpression(new ForAll(x, new PNot(p)));
        } else if (pNot.getExp() instanceof ForAll) {
            ForAll forAll = (ForAll) pNot.getExp();
            FormalArithmeticExpression p = forAll.getExp();
            FormalArithmeticExpression notP = new PNot(p);
            Term x = forAll.getVariable();
            Exists existsNot = new Exists(x, notP);
            Proof<FormalArithmeticExpression> generatedProof = new FormalArithmeticProof(new Statement<>(
                    new PNot(forAll), new Assumption<>(), -1
            ));
            Proof<FormalArithmeticExpression> newProof = new FormalArithmeticProof(new Statement<>(
                    new PNot(existsNot), new Assumption<>(), -1
            ));
            newProof.addExpression(new PEntailment(notP, existsNot));
            addContrapositionProof(notP, existsNot, newProof);
            newProof.addExpression(new PEntailment(new PNot(existsNot), new PNot(notP)));
            newProof.addExpression(new PNot(existsNot));
            newProof.addExpression(new PNot(notP));
            newProof.addExpression(new PEntailment(new PNot(notP), p));
            newProof.addExpression(p);
            try {
                newProof = FormalArithmeticDeductor.getInstance().deductAll(newProof, newProof.getAssumptions(), null);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Constant proof is invalid");
            }
            generatedProof.addProof(newProof);
            generatedProof.addExpression(new PEntailment(new PNot(existsNot), forAll));
            addContrapositionProof(new PNot(existsNot), forAll, generatedProof);
            generatedProof.addExpression(new PEntailment(new PNot(forAll), new PNot(new PNot(existsNot))));
            generatedProof.addExpression(new PNot(forAll));
            generatedProof.addExpression(new PNot(new PNot(existsNot)));
            generatedProof.addExpression(new PEntailment(new PNot(new PNot(existsNot)), existsNot));
            generatedProof.addExpression(existsNot);
            try {
                generatedProof = FormalArithmeticDeductor.getInstance().deductAll(generatedProof, generatedProof.getAssumptions(), null);
            } catch (InvalidProofException e) {
                throw new IllegalStateException("Constant proof is invalid");
            }
            proof.addProof(generatedProof);
            proof.addExpression(existsNot);
        } else {
            throw new IllegalStateException();
        }
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

    public static void main(String[] args) throws InvalidProofException {
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new PVariable("A"), new Assumption<>(), -1));
        assumptions.add(new Statement<>(new PNot(new PVariable("A")), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new PEntailment(new PVariable("A"), new PEntailment(new PVariable("B"), new PVariable("A"))), null);
        proof.addExpression(new PVariable("A"), null);
        proof.addExpression(new PEntailment(new PVariable("B"), new PVariable("A")), null);
        proof.addExpression(new PEntailment(new Exists(new Term("x"), new PVariable("B")), new PVariable("A")), null);
        addContrapositionProof(new Exists(new Term("x"), new PVariable("B")), new PVariable("A"), proof);
        proof.addExpression(new PEntailment(new PNot(new PVariable("A")), new PNot(new Exists(new Term("x"), new PVariable("B")))), null);
        proof.addExpression(new PNot(new PVariable("A")), null);
        proof.addExpression(new PNot(new Exists(new Term("x"), new PVariable("B"))), null);
        liftQuantifier(new PNot(new Exists(new Term("x"), new PVariable("B"))), proof);
        proof = FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
        System.out.println(proof);
    }
}
