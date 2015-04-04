package ru.ifmo.ctddev.itegulov.formalarithmetic.validator;

import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class BasicValidatorTest {
    private File file;
    private Validator<FormalArithmeticExpression> validator;

    @Before
    public void setUp() throws Exception {
        file = new File("test.in");
        validator = BasicValidator.getInstance();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPropositional() throws Exception {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
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
    }

    @Test
    public void testPredicateAxioms() throws Exception {
        /**
         * TEST 1
         */

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        pw.println(
                "Q(a)->?aQ(a)\n" +
                "@aQ(a)->Q(a)\n" +
                "@x(@xP(x)&Q(x))->@xP(x)&Q(x)\n" +
                "@xP(x)->P(y)"
        );
        pw.close();

        validator.validate(file);

        /**
         * TEST 2
         */

        pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        pw.println(
                "@x(Q(x))->Q(x)\n" +
                "@x(P(x)&Q(x))->P(x)&Q(x)\n" +
                "@x(@yP(y)&Q(x))->@yP(y)&Q(x)\n" +
                "@x((@yP(y))&Q(x))->(@yP(y))&Q(x)\n" +
                "@x((@xP(x))&Q(x))->(@xP(x))&Q(x)"
        );
        pw.close();

        validator.validate(file);
    }

    @Test
    public void testNewDerivationRules() throws Exception {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        pw.println("Q(b)->P(a)->Q(b)\n" + "Q(b)->@a(P(a)->Q(b))");
        pw.close();

        validator.validate(file);
    }

    @Test
    public void testInduction() throws Exception {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        pw.println(
                "(x'+0=(x+0)')&@y(((x)'+y=(x+y)')->((x)'+(y)'=(x+(y)')'))->((x)'+y=(x+y)')\n" +
                "P(0)&@x123 (P(x123) -> P(x123')) -> P(x123)"
        );
        pw.close();

        validator.validate(file);
    }
}