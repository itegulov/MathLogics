package formalarithmetic.deductor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Assumption;
import proof.Proof;
import proof.Statement;
import structure.logic.Entailment;
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
    public void testDeduct1() throws Exception {
        //System.out.println(deductor.deduct(new File("res/tests/fa_deductor_correct1.in"), null));
    }

    @Test
    public void testDeduct2() throws Exception {
        System.out.println(deductor.deduct(new File("res/tests/fa_deductor_correct8.in"), null));
    }
}