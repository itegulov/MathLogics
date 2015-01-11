package deductor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Assumption;
import proof.Proof;
import proof.Statement;
import structure.logic.Variable;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class HashDeductorTest {
    private File file;
    private Deductor deductor;

    @Before
    public void setUp() throws Exception {
        file = new File("test.in");
        deductor = new HashDeductor();
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testDeductSimple() throws Exception {
        PrintWriter pw = new PrintWriter(file);
        pw.println("a|-a");
        pw.println("a");
        pw.close();
        Proof proof = new Proof("a->(a->a) (сх. акс. 1)\n" +
                "(a->(a->a))->((a->((a->a)->a))->(a->a)) (сх. акс. 2)\n" +
                "(a->((a->a)->a))->(a->a) (M.P. 2, 1)\n" +
                "a->((a->a)->a) (сх. акс. 1)\n" +
                "a->a (M.P. 4, 3)");
        assertEquals(deductor.deduct(file, null), proof);
    }

    @Test
    public void testDeductSmall() throws Exception {
        Proof proof = new Proof(new File("res/tests/deductor_small.out"));
        assertEquals(deductor.deduct(new File("res/tests/deductor_small.in"), null), proof);
    }

    @Test
    public void testDeductWithProofed() throws Exception {
        Statement[] statements = {new Statement(new Variable("a"), new Assumption(), 1)};
        Proof proof = deductor.deduct(new File("res/tests/deductor_assumption.proof"), statements);
    }
}