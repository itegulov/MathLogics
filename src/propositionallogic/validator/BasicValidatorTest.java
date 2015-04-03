package propositionallogic.validator;

import exceptions.InvalidProofException;
import interfaces.Validator;
import org.junit.Assert;
import org.junit.Test;
import structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;

public class BasicValidatorTest {
    private Validator<LogicExpression> validator = new BasicValidator();

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

    @Test
    public void test6_correct6() throws Exception {
        testCorrect("correct6.in");
    }

    @Test
    public void test7_incorrect1() throws Exception {
        testIncorrect("incorrect1.in");
    }

    @Test
    public void test8_incorrect2() throws Exception {
        testIncorrect("incorrect2.in");
    }

    @Test
    public void test9_incorrect3() throws Exception {
        testIncorrect("incorrect3.in");
    }

    @Test
    public void test10_incorrect4() throws Exception {
        testIncorrect("incorrect4.in");
    }

    @Test
    public void test11_incorrect5() throws Exception {
        testIncorrect("incorrect5.in");
    }

    @Test
    public void test12_incorrect6() throws Exception {
        testIncorrect("incorrect6.in");
    }

    public void testCorrect(String testName) throws InvalidProofException {
        try {
            validator.validate(new File("res/tests/propositional_logic_validator/correct/" + testName));
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
        }
    }

    public void testIncorrect(String testName) throws InvalidProofException {
        try {
            validator.validate(new File("res/tests/propositional_logic_validator/incorrect/" + testName));
            Assert.assertTrue(false);
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
        } catch (InvalidProofException ignored) {

        }
    }
}