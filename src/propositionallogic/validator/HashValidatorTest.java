package propositionallogic.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Proof;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

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
    public void testAxioms() throws Exception {
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
    public void testVerifySimple() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A&B&C->A&B");
        pw.println("A&B&C->C");
        pw.println("A|B->A|B|C");
        pw.println("C->A|B|C");
        pw.println("A->B->A");
        pw.println("(A->B)->(A->B->C)->(A->C)");
        pw.println("A&B->A");
        pw.println("A&B->B");
        pw.println("A->B->A&B");
        pw.println("A->A|B");
        pw.println("B->A|B");
        pw.println("(A->Q)->(B->Q)->(A|B->Q)");
        pw.println("(A->B)->(A->!B)->!A");
        pw.println("!!A->A");
        pw.println("((A&!A)->A)->((A&!A)->!A)->!(A&!A)");
        pw.println("(A->B)->(A->B->C)->(A->C)");
        pw.close();
        Proof proof = new Proof("(A&B)&C->A&B (сх. акс. 4)\n" +
                "(A&B)&C->C (сх. акс. 5)\n" +
                "A|B->(A|B)|C (сх. акс. 6)\n" +
                "C->(A|B)|C (сх. акс. 7)\n" +
                "A->(B->A) (сх. акс. 1)\n" +
                "(A->B)->((A->(B->C))->(A->C)) (сх. акс. 2)\n" +
                "A&B->A (сх. акс. 4)\n" +
                "A&B->B (сх. акс. 5)\n" +
                "A->(B->A&B) (сх. акс. 3)\n" +
                "A->A|B (сх. акс. 6)\n" +
                "B->A|B (сх. акс. 7)\n" +
                "(A->Q)->((B->Q)->(A|B->Q)) (сх. акс. 8)\n" +
                "(A->B)->((A->!B)->!A) (сх. акс. 9)\n" +
                "!!A->A (сх. акс. 10)\n" +
                "(A&!A->A)->((A&!A->!A)->!(A&!A)) (сх. акс. 9)\n" +
                "(A->B)->((A->(B->C))->(A->C)) (сх. акс. 2)\n");
        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testVerify() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A->A->A");
        pw.println("(A->(A->A))->(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))");
        pw.println("A->A");
        pw.close();
        Proof proof = new Proof("A->A->A (сх. акс. 1)\n" +
                "(A->(A->A))->(A->((A->A)->A))->(A->A) (сх. акс. 2)\n" +
                "(A->((A->A)->A))->(A->A) (M.P. 1, 2)\n" +
                "(A->((A->A)->A)) (сх. акс. 1)\n" +
                "A->A (M.P. 4, 3)\n");
        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testVerifyBad() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A->A->A");
        pw.println("B->A");
        pw.close();
        Proof proof = new Proof("A->A->A (сх. акс. 1)\n" +
                "B->A (Не доказано)\n");
        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testVerifyDifficult() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A->A->A");
        pw.println("(A->A)->(A->((A->A)->A))->(A->A)");
        pw.println("(A->(A->A))->(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))");
        pw.println("A->A");
        pw.close();
        Proof proof = new Proof("A->A->A (сх. акс. 1)\n" +
                "(A->A)->(A->((A->A)->A))->(A->A) (сх. акс. 1)\n" +
                "(A->(A->A))->(A->((A->A)->A))->(A->A) (сх. акс. 2)\n" +
                "(A->((A->A)->A))->(A->A) (M.P. 1, 3)\n" +
                "(A->((A->A)->A)) (сх. акс. 1)\n" +
                "A->A (M.P. 5, 4)\n");
        assertEquals(validator.validate(file), proof);

        pw = new PrintWriter(file);
        pw.println("A->A->A");
        pw.println("(A->(A->A))->(A->((A->A)->A))->(A->A)");
        pw.println("(A->A)->(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))->(A->A)");
        pw.println("(A->((A->A)->A))");
        pw.println("A->A");
        pw.close();
        proof = new Proof("A->A->A (сх. акс. 1)\n" +
                "(A->(A->A))->(A->((A->A)->A))->(A->A) (сх. акс. 2)\n" +
                "(A->A)->(A->((A->A)->A))->(A->A) (сх. акс. 1)\n" +
                "(A->((A->A)->A))->(A->A) (M.P. 1, 2)\n" +
                "(A->((A->A)->A)) (сх. акс. 1)\n" +
                "A->A (M.P. 5, 4)\n");
        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testMore() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("A&B->A");
        pw.println("A->A|B");
        pw.println("(A->A|B)->(A&B)->A->A|B");
        pw.println("A&B->A->A|B");
        pw.println("(A&B->A)->((A&B->(A->A|B))->(A&B->A|B))");
        pw.println("(A&B->(A->A|B))->(A&B->A|B)");
        pw.println("A&B->A|B");
        pw.close();
        Proof proof = new Proof("A&B->A (сх. акс. 4)\n" +
                "A->A|B (сх. акс. 6)\n" +
                "(A->A|B)->(A&B)->A->A|B (сх. акс. 1)\n" +
                "A&B->A->A|B (M.P. 2, 3)\n" +
                "(A&B->A)->((A&B->(A->A|B))->(A&B->A|B)) (сх. акс. 2)\n" +
                "(A&B->(A->A|B))->(A&B->A|B) (M.P. 1, 5)\n" +
                "A&B->A|B (M.P. 4, 6)\n");
        assertEquals(validator.validate(file), proof);
    }

    @Test
    public void testMaxTest() throws Exception {
        Proof answer = validator.validate(new File("res/tests/maxtest.in"));
        Proof goodAnswer = new Proof(new File("res/tests/maxtest.out"));
        assertEquals(answer, goodAnswer);
    }
}