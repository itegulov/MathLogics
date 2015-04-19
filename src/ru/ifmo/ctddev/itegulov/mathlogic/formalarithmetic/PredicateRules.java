package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor.FormalArithmeticDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Assumption;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Quantifier;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Daniyar Itegulov
 */
public final class PredicateRules {
    private static final Proof<FormalArithmeticExpression> FOR_ALL_RULE;
    private static final Proof<FormalArithmeticExpression> EXISTS_RULE;
    private static final Proof<FormalArithmeticExpression> CONTRAPOSITION_RULE_PROOF;
    private static final Proof<FormalArithmeticExpression> TERTIUM_NON_DATUR_PROOF;
    private static final Proof<FormalArithmeticExpression> IDENTITY_PROOF;
    private static final Proof<FormalArithmeticExpression> NOT_NOT_PROOF;
    private static final Proof<FormalArithmeticExpression> MAP_FOR_ALL_PROOF;
    private static final Proof<FormalArithmeticExpression> MAP_EXISTS_PROOF;
    private static final Proof<FormalArithmeticExpression> DE_MORGAN_AND_PROOF;
    private static final Proof<FormalArithmeticExpression> NOT_AND_PROOF;
    private static final Proof<FormalArithmeticExpression> NOT_AND_SYM_PROOF;
    private static final Proof<FormalArithmeticExpression> OR_TO_NOT_NOT_PROOF;
    private static final Proof<FormalArithmeticExpression> NOT_A_THEN_B_PROOF;
    private static final Proof<FormalArithmeticExpression> IN_MORGAN_AND_PROOF;
    private static final Proof<FormalArithmeticExpression> DE_MORGAN_OR_PROOF;

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

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/identity.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        IDENTITY_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/not_not.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        NOT_NOT_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/map_forall.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        MAP_FOR_ALL_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/map_exists.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        MAP_EXISTS_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/de_morgan_and.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        DE_MORGAN_AND_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/not_and.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        NOT_AND_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/not_and_sym.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        NOT_AND_SYM_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/or_to_not_not.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        OR_TO_NOT_NOT_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        PGap a = new PGap(1);
        PGap b = new PGap(2);
        assumptions.add(new Statement<>(new PEntailment(new POr(a, b),
                new POr(new PNot(new PNot(a)), new PNot(new PNot(b)))), null, -1));
        assumptions.add(new Statement<>(new PEntailment(new POr(new PNot(new PNot(a)), new PNot(new PNot(b))),
                new PNot(new PAnd(new PNot(a), new PNot(b)))), null, -1));
        try {
            proof = validator.validate(new File("res/rules/not_a_then_b.proof"), assumptions);
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        NOT_A_THEN_B_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        PGap a = new PGap(1);
        PGap b = new PGap(2);
        assumptions.add(new Statement<>(new PEntailment(new POr(a, b), new PEntailment(new PNot(a), b)), null, -1));
        try {
            proof = validator.validate(new File("res/rules/in_morgan_and.proof"), assumptions);
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        IN_MORGAN_AND_PROOF = proof;
    }

    static {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        try {
            proof = validator.validate(new File("res/rules/de_morgan_or.proof"));
        } catch (FileNotFoundException e) {
            System.err.println("Const proof wasn't found");
            throw new IllegalStateException();
        } catch (InvalidProofException e) {
            System.err.println("Const proof is invalid");
            throw new IllegalStateException();
        }
        DE_MORGAN_OR_PROOF = proof;
    }

    public static void addDeMorganOrProof(FormalArithmeticExpression a,
                                           FormalArithmeticExpression b,
                                           Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(DE_MORGAN_OR_PROOF.replaceAll(map));
    }

    public static void addInMorganAndProof(FormalArithmeticExpression a,
                                           FormalArithmeticExpression b,
                                           Proof<FormalArithmeticExpression> proof) {
        addNotAThenBProof(a, b, proof);
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(IN_MORGAN_AND_PROOF.replaceAll(map));
    }

    public static void addNotAThenBProof(FormalArithmeticExpression a,
                                         FormalArithmeticExpression b,
                                         Proof<FormalArithmeticExpression> proof) {
        addOrToNotNotProof(a, b, proof);
        addInMorganOrProof(new PNot(a), new PNot(b), proof);
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(NOT_A_THEN_B_PROOF.replaceAll(map));
    }

    public static void addOrToNotNotProof(FormalArithmeticExpression a,
                                          FormalArithmeticExpression b,
                                          Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(OR_TO_NOT_NOT_PROOF.replaceAll(map));
    }

    public static void addInMorganOrProof(FormalArithmeticExpression a,
                                          FormalArithmeticExpression b,
                                          Proof<FormalArithmeticExpression> proof) {
        addNotAndProof(a, b, proof);
        addNotAndSymProof(b, a, proof);
        FormalArithmeticExpression notA = new PNot(a);
        FormalArithmeticExpression notB = new PNot(b);
        FormalArithmeticExpression temp1 = new PEntailment(notA, new PNot(new PAnd(a, b)));
        FormalArithmeticExpression temp2 = new PEntailment(notB, new PNot(new PAnd(a, b)));
        proof.addExpression(new PEntailment(temp1, new PEntailment(temp2,
                new PEntailment(new POr(notA, notB), new PNot(new PAnd(a, b))))));
        proof.addExpression(new PEntailment(temp2,
                new PEntailment(new POr(notA, notB), new PNot(new PAnd(a, b)))));
        proof.addExpression(new PEntailment(new POr(notA, notB), new PNot(new PAnd(a, b))));
    }

    public static void addNotAndProof(FormalArithmeticExpression a,
                                      FormalArithmeticExpression b,
                                      Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(NOT_AND_PROOF.replaceAll(map));
    }

    public static void addNotAndSymProof(FormalArithmeticExpression a,
                                      FormalArithmeticExpression b,
                                      Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(NOT_AND_SYM_PROOF.replaceAll(map));
    }

    public static void addDeMorganAndProof(FormalArithmeticExpression a,
                                           FormalArithmeticExpression b,
                                           Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, a);
        map.put(2, b);
        proof.addProof(DE_MORGAN_AND_PROOF.replaceAll(map));
    }

    public static void addMapForAllProof(Term x, FormalArithmeticExpression p, FormalArithmeticExpression q, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, x);
        map.put(2, p);
        map.put(3, q);
        proof.addProof(MAP_FOR_ALL_PROOF.replaceAll(map));
    }

    public static void addMapExistsProof(Term x, FormalArithmeticExpression p, FormalArithmeticExpression q, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, x);
        map.put(2, p);
        map.put(3, q);
        proof.addProof(MAP_EXISTS_PROOF.replaceAll(map));
    }

    public static void addIdentityProof(FormalArithmeticExpression e, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, e);
        proof.addProof(IDENTITY_PROOF.replaceAll(map));
    }

    public static void addNotNotProof(FormalArithmeticExpression e, Proof<FormalArithmeticExpression> proof) {
        map.clear();
        map.put(1, e);
        proof.addProof(NOT_NOT_PROOF.replaceAll(map));
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

    public static Quantifier liftQuantifier(FormalArithmeticExpression e, Proof<FormalArithmeticExpression> proof) {
        if (e instanceof PNot) {
            PNot pNot = (PNot) e;
            return liftQuantifier(pNot, proof);
        } else if (e instanceof PAnd) {

        } else if (e instanceof POr) {

        } else if (e instanceof PEntailment) {

        }
        return null;
    }

    public static Quantifier liftQuantifier(PNot pNot, Proof<FormalArithmeticExpression> proof) {
        if (pNot.getExp() instanceof Exists) {
            Exists exists = (Exists) pNot.getExp();
            FormalArithmeticExpression p = exists.getExp();
            Term x = exists.getVariable();
            proof.addExpression(new PEntailment(p, new Exists(x, p)));
            addContrapositionProof(p, new Exists(x, p), proof);
            proof.addExpression(new PEntailment(new PNot(new Exists(x, p)), new PNot(p)));
            proof.addExpression(new PEntailment(new PNot(new Exists(x, p)), new ForAll(x, new PNot(p))));
            proof.addExpression(new ForAll(x, new PNot(p)));
            return new ForAll(x, new PNot(p));
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
            return existsNot;
        } else if (pNot.getExp() instanceof PNot) {
            PNot pNot1 = (PNot) pNot.getExp();
            if (pNot1.getExp() instanceof Exists) {
                Exists exists = (Exists) pNot1.getExp();
                FormalArithmeticExpression p = exists.getExp();
                Term x = exists.getVariable();
                proof.addExpression(new PEntailment(pNot, exists));
                proof.addExpression(exists);
                addNotNotProof(p, proof);
                FormalArithmeticExpression e = new PEntailment(p, new PNot(new PNot(p)));
                proof.addExpression(new PEntailment(e, new PEntailment(exists, e)));
                proof.addExpression(new PEntailment(exists, e));
                proof.addExpression(new PEntailment(exists, new ForAll(x, e)));
                proof.addExpression(new ForAll(x, e));
                addMapExistsProof(x, p, new PNot(new PNot(p)), proof);
                proof.addExpression(new PEntailment(new Exists(x, p), new Exists(x, new PNot(new PNot(p)))));
                proof.addExpression(new Exists(x, new PNot(new PNot(p))));
                return new Exists(x, new PNot(new PNot(p)));
            } else if (pNot1.getExp() instanceof ForAll) {
                ForAll forAll = (ForAll) pNot1.getExp();
                Term x = forAll.getVariable();
                FormalArithmeticExpression e = forAll.getExp();
                proof.addExpression(new PEntailment(pNot, forAll));
                proof.addExpression(forAll);
                addNotNotProof(e, proof);
                FormalArithmeticExpression p = new PEntailment(e, new PNot(new PNot(e)));
                proof.addExpression(new PEntailment(p, new PEntailment(forAll, p)));
                proof.addExpression(new PEntailment(forAll, p));
                proof.addExpression(new PEntailment(forAll, new ForAll(x, p)));
                proof.addExpression(new ForAll(x, p));
                addMapForAllProof(x, e, new PNot(new PNot(e)), proof);
                proof.addExpression(new PEntailment(new ForAll(x, e), new ForAll(x, new PNot(new PNot(e)))));
                proof.addExpression(new ForAll(x, new PNot(new PNot(e))));
                return new ForAll(x, new PNot(new PNot(e)));
            } else {
                FormalArithmeticExpression e = pNot1.getExp();
                proof.addExpression(new PEntailment(new PNot(new PNot(e)), e));
                proof.addExpression(e);
                Quantifier result = liftQuantifier(e, proof);
                Term x = result.getVariable();
                FormalArithmeticExpression p = result.getExp();
                addNotNotProof(p, proof);
                FormalArithmeticExpression temp = new PEntailment(p, new PNot(new PNot(p)));
                proof.addExpression(new PEntailment(temp, new PEntailment(result, temp)));
                proof.addExpression(new PEntailment(result, temp));
                proof.addExpression(new PEntailment(result, new ForAll(x, temp)));
                proof.addExpression(new ForAll(x, temp));
                if (result instanceof ForAll) {
                    addMapForAllProof(x, p, new PNot(new PNot(p)), proof);
                    proof.addExpression(new PEntailment(result, new ForAll(x, new PNot(new PNot(p)))));
                    proof.addExpression(new ForAll(x, new PNot(new PNot(p))));
                    return new ForAll(x, new PNot(new PNot(p)));
                } else if (result instanceof Exists) {
                    addMapExistsProof(x, p, new PNot(new PNot(p)), proof);
                    proof.addExpression(new PEntailment(result, new Exists(x, new PNot(new PNot(p)))));
                    proof.addExpression(new Exists(x, new PNot(new PNot(p))));
                    return new Exists(x, new PNot(new PNot(p)));
                } else {
                    throw new IllegalStateException("Unknown type of quantifier");
                }
            }
        } else if (pNot.getExp() instanceof PAnd) {
            PAnd pAnd = (PAnd) pNot.getExp();
            FormalArithmeticExpression l = pAnd.getLeft();
            FormalArithmeticExpression r = pAnd.getRight();
            addDeMorganAndProof(l, r, proof);
            proof.addExpression(new POr(new PNot(l), new PNot(r)));
            Quantifier result = liftQuantifier(new POr(new PNot(l), new PNot(r)), proof);
            Term x = result.getVariable();
            l = ((PNot) ((POr) result.getExp()).getLeft()).getExp();
            r = ((PNot) ((POr) result.getExp()).getRight()).getExp();
            addInMorganOrProof(l, r, proof);
            FormalArithmeticExpression temp = new PEntailment(new POr(new PNot(l), new PNot(r)),
                    new PNot(new PAnd(l, r)));
            proof.addExpression(new PEntailment(temp, new PEntailment(result, temp)));
            proof.addExpression(new PEntailment(result, temp));
            proof.addExpression(new PEntailment(result, new ForAll(x, temp)));
            proof.addExpression(new ForAll(x, temp));
            if (result instanceof Exists) {
                addMapExistsProof(x, new POr(new PNot(l), new PNot(r)), new PNot(new PAnd(l, r)), proof);
                proof.addExpression(new PEntailment(result, new Exists(x, new PNot(new PAnd(l, r)))));
                proof.addExpression(new Exists(x, new PNot(new PAnd(l, r))));
                return new Exists(x, new PNot(new PAnd(l, r)));
            } else if (result instanceof ForAll) {
                addMapForAllProof(x, new POr(new PNot(l), new PNot(r)), new PNot(new PAnd(l, r)), proof);
                proof.addExpression(new PEntailment(result, new Exists(x, new PNot(new PAnd(l, r)))));
                proof.addExpression(new Exists(x, new PNot(new PAnd(l, r))));
                return new Exists(x, new PNot(new PAnd(l, r)));
            } else {
                throw new IllegalStateException("Unknown type of quantifier");
            }
        } else if (pNot.getExp() instanceof POr) {
            POr pAnd = (POr) pNot.getExp();
            FormalArithmeticExpression l = pAnd.getLeft();
            FormalArithmeticExpression r = pAnd.getRight();
            addDeMorganOrProof(l, r, proof);
            proof.addExpression(new PNot(new POr(l, r)));
            proof.addExpression(new PAnd(new PNot(l), new PNot(r)));
            Quantifier result = liftQuantifier(new PAnd(new PNot(l), new PNot(r)), proof);
            Term x = result.getVariable();
            l = ((PNot) ((PAnd) result.getExp()).getLeft()).getExp();
            r = ((PNot) ((PAnd) result.getExp()).getRight()).getExp();
            addInMorganAndProof(l, r, proof);
            PEntailment temp = new PEntailment(new PAnd(new PNot(l), new PNot(r)),
                    new PNot(new POr(l, r)));
            proof.addExpression(new PEntailment(temp, new PEntailment(result, temp)));
            proof.addExpression(new PEntailment(result, temp));
            proof.addExpression(new PEntailment(result, new ForAll(x, temp)));
            proof.addExpression(new ForAll(x, temp));
            if (result instanceof Exists) {
                addMapExistsProof(x, temp.getLeft(), temp.getRight(), proof);
                proof.addExpression(new PEntailment(result, new Exists(x, new PNot(new POr(l, r)))));
                proof.addExpression(new Exists(x, new PNot(new POr(l, r))));
                return new Exists(x, new PNot(new POr(l, r)));
            } else if (result instanceof ForAll) {
                addMapForAllProof(x, temp.getLeft(), temp.getRight(), proof);
                proof.addExpression(new PEntailment(result, new ForAll(x, new PNot(new POr(l, r)))));
                proof.addExpression(new ForAll(x, new PNot(new POr(l, r))));
                return new ForAll(x, new PNot(new POr(l, r)));
            } else {
                throw new IllegalStateException("Unknown type of quantifier");
            }
        } else if (pNot.getExp() instanceof PEntailment) {
            //TODO: implement
        }
        throw new IllegalStateException("Unknown type of expression: " + pNot.getExp());
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException {
        Proof<FormalArithmeticExpression> proof;
        Validator<FormalArithmeticExpression> validator = FormalArithmeticValidator.getInstance();
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        PVariable a = new PVariable("A");
        PVariable b = new PVariable("B");
        assumptions.add(new Statement<>(new PNot(new POr(a, b)), null, -1));
        proof = validator.validate(new File("res/rules/de_morgan_or.proof"), assumptions);
        proof = FormalArithmeticDeductor.getInstance().deductLast(proof, assumptions, null);
        System.out.println(proof.asSimpleString());
    }
}
