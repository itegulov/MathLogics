package formalarithmetic.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Proof;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class HashValidatorTest {
    private File file;
    private Validator validator;

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
    public void testValidate() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println(
                "Q(a)->?aQ(a)\n" +
                "@aQ(a)->Q(a)\n" +
                "@x(@xP(x)&Q(x))->@xP(x)&Q(x)\n" +
                "@xP(x)->P(y)"
        );
        pw.close();

        System.out.println(validator.validate(file));
    }

    @Test
    public void testMedium() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println(
                "@x(Q(x))->Q(x)\n" +
                "@x(P(x)&Q(x))->P(x)&Q(x)\n" +
                "@x(@yP(y)&Q(x))->@yP(y)&Q(x)\n" +
                "@x((@yP(y))&Q(x))->(@yP(y))&Q(x)\n" +
                "@x((@xP(x))&Q(x))->(@xP(x))&Q(x)"
        );
        pw.close();
        System.out.println(validator.validate(file));
    }
}