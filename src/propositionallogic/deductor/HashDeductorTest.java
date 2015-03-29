package propositionallogic.deductor;

import interfaces.Deductor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Assumption;
import proof.LogicalProof;
import proof.Proof;
import proof.Statement;
import structure.LogicExpression;
import structure.logic.Variable;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class HashDeductorTest {
    private File file;
    private Deductor<LogicExpression> deductor;

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
        pw.println("A|-A");
        pw.println("A");
        pw.close();
        Proof<LogicExpression> proof = new LogicalProof("A->(A->A) (сх. акс. 1)\n" +
                "(A->(A->A))->((A->((A->A)->A))->(A->A)) (сх. акс. 2)\n" +
                "(A->((A->A)->A))->(A->A) (M.P. 2, 1)\n" +
                "A->((A->A)->A) (сх. акс. 1)\n" +
                "A->A (M.P. 4, 3)");
        assertEquals(deductor.deduct(file, null), proof);
    }

    @Test
    public void testDeductSmall() throws Exception {
        Proof<LogicExpression> proof = new LogicalProof(new File("res/tests/deductor_small.out"));
        assertEquals(deductor.deduct(new File("res/tests/deductor_small.in"), null), proof);
    }

    @Test
    public void testDeductWithProofed() throws Exception {
        Statement<LogicExpression>[] statements = new Statement[]{new Statement(new Variable("A"), new Assumption(), 1)};
        Proof<LogicExpression> proof = new LogicalProof(new File("res/tests/deductor_assumption.out"));
        assertEquals(deductor.deduct(new File("res/tests/deductor_assumption.in"), statements), proof);
    }
}