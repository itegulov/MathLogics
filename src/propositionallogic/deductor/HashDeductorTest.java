package propositionallogic.deductor;

import exceptions.InvalidProofException;
import interfaces.Deductor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import proof.Proof;
import structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class HashDeductorTest {
    private Deductor<LogicExpression> deductor;

    @Before
    public void setUp() throws Exception {
        deductor = HashDeductor.getInstance();
    }

    @Test
    public void test1_correct1() throws Exception {
        testCorrect("correct1.in");
    }

    @Test
    public void test2_correct2() throws Exception {
        testCorrect("correct2.in");
    }

    @Test
    public void test3_correct3() throws Exception {
        testCorrect("correct3.in");
    }

    @Test
    public void test4_correct4() throws Exception {
        testCorrect("correct4.in");
    }

    @Test
    public void test5_correct5() throws Exception {
        testCorrect("correct5.in");
    }

    public void testCorrect(String testName) throws InvalidProofException {
        try {
            Proof<LogicExpression> proof = deductor.deductAll(new File("res/tests/propositional_logic_deductor/correct/" + testName), null);
            assertTrue(proof.check(null));
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
        }
    }

    public void testIncorrect(String testName) throws InvalidProofException {
        try {
            deductor.deductAll(new File("res/tests/propositional_logic_deductor/incorrect/" + testName), null);
            Assert.assertTrue(false);
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
        } catch (InvalidProofException ignored) {

        }
    }
}