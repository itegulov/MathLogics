package ru.ifmo.ctddev.itegulov.mathlogic.kripke;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.scanner.FastLineScanner;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * @author Daniyar Itegulov
 */
public class KripkeBuilderTest {

    private KripkeBuilder kripkeBuilder = KripkeBuilder.getInstance();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public Model test(String filename) throws FileNotFoundException, ParseException, ExpressionIsTrueException {
        LogicParser parser = LogicParser.getInstance();
        FastLineScanner fastLineScanner = new FastLineScanner(
                new File(filename));
        return kripkeBuilder.findModel(parser.parse(fastLineScanner.next()));
    }

    @Test
    public void testFalse1() throws Exception {
        System.out.println(test("res/tests/kripke_builder/false/false1.in"));
    }

    @Test
    public void testFalse2() throws Exception {
        System.out.println(test("res/tests/kripke_builder/false/false2.in"));
    }

    @Test
    public void testFalse3() throws Exception {
        System.out.println(test("res/tests/kripke_builder/false/false3.in"));
    }

    @Test
    public void testFalse4() throws Exception {
        System.out.println(test("res/tests/kripke_builder/false/false4.in"));
    }

    @Test
    public void testFalse5() throws Exception {
        System.out.println(test("res/tests/kripke_builder/false/false5.in"));
    }

    @Test
    public void testTrue1() throws Exception {
        exception.expect(ExpressionIsTrueException.class);
        System.out.println(test("res/tests/kripke_builder/true/true1.in"));
    }

    @Test
    public void testTrue2() throws Exception {
        exception.expect(ExpressionIsTrueException.class);
        System.out.println(test("res/tests/kripke_builder/true/true2.in"));
    }

}