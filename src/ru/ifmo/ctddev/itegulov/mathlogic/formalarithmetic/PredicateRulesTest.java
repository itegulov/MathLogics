package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic;

import org.junit.Test;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Assumption;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniyar Itegulov
 */
public class PredicateRulesTest {

    @Test
    public void test1_liftNotExists() throws Exception {
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new PVariable("A"), new Assumption<>(), -1));
        assumptions.add(new Statement<>(new PNot(new PVariable("A")), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new PEntailment(new PVariable("A"), new PEntailment(new PVariable("B"), new PVariable("A"))), null);
        proof.addExpression(new PVariable("A"), null);
        proof.addExpression(new PEntailment(new PVariable("B"), new PVariable("A")), null);
        proof.addExpression(new PEntailment(new Exists(new Term("x"), new PVariable("B")), new PVariable("A")), null);
        PredicateRules.addContrapositionProof(new Exists(new Term("x"), new PVariable("B")), new PVariable("A"), proof);
        proof.addExpression(new PEntailment(new PNot(new PVariable("A")), new PNot(new Exists(new Term("x"), new PVariable("B")))), null);
        proof.addExpression(new PNot(new PVariable("A")), null);
        proof.addExpression(new PNot(new Exists(new Term("x"), new PVariable("B"))), null);
        PredicateRules.liftQuantifier(new PNot(new Exists(new Term("x"), new PVariable("B"))), proof);
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test2_liftNotForAll() throws Exception {
        PVariable a = new PVariable("A");
        Term x = new Term("x");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new PNot(new ForAll(x, a)), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new PNot(new ForAll(x, a)));
        PredicateRules.liftQuantifier(new PNot(new ForAll(x, a)), proof);
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test3_liftNotNotExists() throws Exception {
        PVariable a = new PVariable("A");
        Term x = new Term("x");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new PNot(new PNot(new Exists(x, a))), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new PNot(new PNot(new Exists(x, a))));
        PredicateRules.liftQuantifier(new PNot(new PNot(new Exists(x, a))), proof);
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test4_mapForAll() throws Exception {
        PVariable p = new PVariable("P");
        Term x = new Term("x");
        PVariable q = new PVariable("Q");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new ForAll(x, new PEntailment(p, q)), null, -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new ForAll(x, new PEntailment(p, q)));
        PredicateRules.addMapForAllProof(x, p, q, proof);
        proof.addExpression(new PEntailment(new ForAll(x, p), new ForAll(x, q)));
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test5_mapExists() throws Exception {
        PVariable p = new PVariable("P");
        Term x = new Term("x");
        PVariable q = new PVariable("Q");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new ForAll(x, new PEntailment(p, q)), null, -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new ForAll(x, new PEntailment(p, q)));
        PredicateRules.addMapExistsProof(x, p, q, proof);
        proof.addExpression(new PEntailment(new Exists(x, p), new Exists(x, q)));
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test6_liftNotNotForAll() throws Exception {
        PVariable a = new PVariable("A");
        Term x = new Term("x");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new PNot(new PNot(new ForAll(x, a))), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        proof.addExpression(new PNot(new PNot(new ForAll(x, a))));
        PredicateRules.liftQuantifier(new PNot(new PNot(new ForAll(x, a))), proof);
        FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions());
    }

    @Test
    public void test7_inMorganOr() throws Exception {
        PVariable a = new PVariable("A");
        PVariable b = new PVariable("B");
        List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>();
        assumptions.add(new Statement<>(new POr(new PNot(a), new PNot(b)), new Assumption<>(), -1));
        Proof<FormalArithmeticExpression> proof = new FormalArithmeticProof(assumptions);
        PredicateRules.addInMorganOrProof(a, b, proof);
        proof.addExpression(new POr(new PNot(a), new PNot(b)));
        proof.addExpression(new PNot(new PAnd(a, b)));
        System.out.println(FormalArithmeticValidator.getInstance().validate(proof, proof.getAssumptions()));
    }
}