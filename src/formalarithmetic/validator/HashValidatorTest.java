package formalarithmetic.validator;

import interfaces.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parser.ArithmeticParser;
import proof.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HashValidatorTest {
    private File file;
    private Validator validator;
    private ArithmeticParser parser = new ArithmeticParser();

    @Before
    public void setUp() throws Exception {
        file = new File("test.in");
        validator = new HashValidator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPropositional() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A->B->A");
        pw.println("(A->B)->(A->B->C)->(A->C)");
        pw.println("A->B->A&B");
        pw.println("A&B->A");
        pw.println("A&B->B");
        pw.println("A->A|B");
        pw.println("B->A|B");
        pw.println("(A->Q)->(B->Q)->(A|B->Q)");
        pw.println("(A->B)->(A->!B)->!A");
        pw.println("!!A->A");
        pw.close();

        Proof proof = new Proof("A->B->A (сх. акс. 1)\n" +
                "(A->B)->(A->B->C)->(A->C) (сх. акс. 2)\n" +
                "A->B->A&B (сх. акс. 3)\n" +
                "A&B->A (сх. акс. 4)\n" +
                "A&B->B (сх. акс. 5)\n" +
                "A->A|B (сх. акс. 6)\n" +
                "B->A|B (сх. акс. 7)\n" +
                "(A->Q)->(B->Q)->(A|B->Q) (сх. акс. 8)\n" +
                "(A->B)->(A->!B)->!A (сх. акс. 9)\n" +
                "!!A->A (сх. акс. 10)");

        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testPredicateAxioms() throws Exception {
        /**
         * TEST 1
         */

        PrintWriter pw = new PrintWriter(file);
        pw.println(
                "Q(a)->?aQ(a)\n" +
                "@aQ(a)->Q(a)\n" +
                "@x(@xP(x)&Q(x))->@xP(x)&Q(x)\n" +
                "@xP(x)->P(y)"
        );
        pw.close();

        Proof proof = validator.validate(file);

        List<Statement> statementList = new ArrayList<>();
        statementList.add(new Statement(parser.parse("Q(a)->?aQ(a)"), PredicateAxiom.AXIOM_EXISTS, 0));
        statementList.add(new Statement(parser.parse("@aQ(a)->Q(a)"), PredicateAxiom.AXIOM_FOR_ALL, 1));
        statementList.add(new Statement(parser.parse("@x(@xP(x)&Q(x))->@xP(x)&Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 2));
        statementList.add(new Statement(parser.parse("@xP(x)->P(y)"), PredicateAxiom.AXIOM_FOR_ALL, 3));
        assertEquals(proof.getStatements(), statementList);

        /**
         * TEST 2
         */

        pw = new PrintWriter(file);
        pw.println(
                "@x(Q(x))->Q(x)\n" +
                "@x(P(x)&Q(x))->P(x)&Q(x)\n" +
                "@x(@yP(y)&Q(x))->@yP(y)&Q(x)\n" +
                "@x((@yP(y))&Q(x))->(@yP(y))&Q(x)\n" +
                "@x((@xP(x))&Q(x))->(@xP(x))&Q(x)"
        );
        pw.close();

        proof = validator.validate(file);

        statementList = new ArrayList<>();
        statementList.add(new Statement(parser.parse("@x(Q(x))->Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 0));
        statementList.add(new Statement(parser.parse("@x(P(x)&Q(x))->P(x)&Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 1));
        statementList.add(new Statement(parser.parse("@x(@yP(y)&Q(x))->@yP(y)&Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 2));
        statementList.add(new Statement(parser.parse("@x((@yP(y))&Q(x))->(@yP(y))&Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 3));
        statementList.add(new Statement(parser.parse("@x((@xP(x))&Q(x))->(@xP(x))&Q(x)"), PredicateAxiom.AXIOM_FOR_ALL, 4));
        assertEquals(proof.getStatements(), statementList);
    }

    @Test
    public void testNewDerivationRules() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println(
                "Q(b)->P(a)->Q(b)\n" +
                "Q(b)->@a(P(a)->Q(b))"
        );
        pw.close();

        Proof proof = validator.validate(file);

        List<Statement> statementList = new ArrayList<>();
        statementList.add(new Statement(parser.parse("Q(b)->P(a)->Q(b)"), Axiom.AxiomOne, 0));
        statementList.add(new Statement(parser.parse("Q(b)->@a(P(a)->Q(b))"), new ForAllDerivationRule(statementList.get(0)), 1));
        assertEquals(proof.getStatements(), statementList);
    }

    @Test
    public void testInduction() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println(
                "(x'+0=(x+0)')&@y(((x)'+y=(x+y)')->((x)'+(y)'=(x+(y)')'))->((x)'+y=(x+y)')\n" +
                "P(0)&@x123 (P(x123) -> P(x123')) -> P(x123)"
        );
        pw.close();

        Proof proof = validator.validate(file);
        List<Statement> statementList = new ArrayList<>();
        statementList.add(new Statement(parser.parse("(x'+0=(x+0)')&@y(((x)'+y=(x+y)')->((x)'+(y)'=(x+(y)')'))->((x)'+y=(x+y)')"), InductionRule.INDUCTION_RULE, 0));
        statementList.add(new Statement(parser.parse("P(0)&@x123 (P(x123) -> P(x123')) -> P(x123)"), InductionRule.INDUCTION_RULE, 1));
        assertEquals(proof.getStatements(), statementList);
    }
}