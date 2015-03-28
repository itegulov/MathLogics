package propositionallogic.proofer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proof.Proof;

import static org.junit.Assert.assertTrue;

public class TertiumNonDaturProoferTest {
    private Proofer proofer;

    @Before
    public void setUp() throws Exception {
        proofer = new TertiumNonDaturProofer();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSimpleProof() throws Exception {
        Proof proof = proofer.proof("A->A");
        assertTrue(proof.check(null));
    }

    @Test
    public void testAxiomProof() throws Exception {
        Proof proof = proofer.proof("A->A|B");
        assertTrue(proof.check(null));

        proof = proofer.proof("A&B->A");
        assertTrue(proof.check(null));

        proof = proofer.proof("A->B->A");
        assertTrue(proof.check(null));
    }

    @Test
    public void testMediumProof() throws Exception {
        Proof proof = proofer.proof("!(A&B)->!B|!A");
        assertTrue(proof.check(null));
    }

    @Test
    public void testHardProof() throws Exception {
        Proof proof = proofer.proof("(A->B->C)->(B&A->C)");
        assertTrue(proof.check(null));


        proof = proofer.proof("(A->B)->(!B->!A)");
        assertTrue(proof.check(null));
    }
}