package ru.ifmo.ctddev.itegulov.propositionallogic.proofer;

import ru.ifmo.ctddev.itegulov.exceptions.FalseExpressionException;
import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.interfaces.Proofer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class TertiumNonDaturProoferTest {
    private Proofer<LogicExpression> proofer;

    @Before
    public void setUp() throws Exception {
        proofer = TertiumNonDaturProofer.getInstance();
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

    @Test
    public void test6_correct6() throws Exception {
        testCorrect("correct6.in");
    }

    @Test
    public void test7_correct7() throws Exception {
        testCorrect("correct7.in");
    }

    @Test
    public void test8_correct8() throws Exception {
        testCorrect("correct8.in");
    }

    @Test
    public void test9_correct9() throws Exception {
        testCorrect("correct9.in");
    }

    @Test
    public void test10_axioms() throws Exception {
        testCorrect("correct_axioms.in");
    }

    @Test
    public void test11_incorrect1() throws Exception {
        testIncorrect("incorrect1.in");
    }

    public void testCorrect(String testName) throws InvalidProofException {
        Scanner scanner;
        try {
            scanner = new Scanner(new InputStreamReader(
                    new FileInputStream(new File("res/tests/propositional_logic_proofer/correct/" + testName)),
                    StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
            throw new IllegalStateException();
        }
        while (scanner.hasNext()) {
            try {
                Proof<LogicExpression> proof = proofer.proof(scanner.next());
                assertTrue(proof.check(null));
            } catch (ParseException e) {
                System.err.println("Test file contains invalid expression");
                throw new IllegalStateException();
            } catch (FalseExpressionException e) {
                assertTrue(false);
            }
        }
    }

    public void testIncorrect(String testName) throws InvalidProofException {
        Scanner scanner;
        try {
            scanner = new Scanner(new InputStreamReader(
                    new FileInputStream(new File("res/tests/propositional_logic_proofer/incorrect/" + testName)),
                    StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            System.err.println("Test file wasn't found");
            throw new IllegalStateException();
        }
        while (scanner.hasNext()) {
            try {
                proofer.proof(scanner.next());
                Assert.assertTrue(false);
            } catch (ParseException e) {
                System.err.println("Test file contains invalid expression");
            } catch (FalseExpressionException ignored) {

            }
        }
    }
}