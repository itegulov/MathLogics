package parser;

import structure.Expression;
import structure.ExpressionRandomGenerator;
import structure.ExpressionRandomGeneratorPseudo;
import structure.LogicExpression;
import structure.purelogic.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LogicParserTest {
    ExpressionRandomGenerator generator;
    Parser<LogicExpression> expressionParser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        generator = new ExpressionRandomGeneratorPseudo();
        expressionParser = new LogicParser();
    }

    @org.junit.Test
    public void testEasyParse() throws Exception {

        Expression e = new And(new NVariable("A"), new NVariable("B"));
        assertEquals(e, expressionParser.parse("A&B"));
        assertEquals(e, expressionParser.parse("A& B"));
        assertEquals(e, expressionParser.parse("A &B"));
        assertEquals(e, expressionParser.parse("A & B"));
        assertEquals(e, expressionParser.parse("      A            &               B      "));
        e = new Or(new NVariable("A"), new NVariable("B"));
        assertEquals(e, expressionParser.parse("A|B"));
        assertEquals(e, expressionParser.parse("A| B"));
        assertEquals(e, expressionParser.parse("A |B"));
        assertEquals(e, expressionParser.parse("A | B"));
        assertEquals(e, expressionParser.parse("      A            |               B      "));
        e = new Entailment(new NVariable("A"), new NVariable("B"));
        assertEquals(e, expressionParser.parse("A->B"));
        assertEquals(e, expressionParser.parse("A-> B"));
        assertEquals(e, expressionParser.parse("A ->B"));
        assertEquals(e, expressionParser.parse("A -> B"));
        assertEquals(e, expressionParser.parse("      A            ->               B      "));
        e = new Not(new NVariable("A"));
        assertEquals(e, expressionParser.parse("!A"));
        assertEquals(e, expressionParser.parse("! A"));
        assertEquals(e, expressionParser.parse("             ! A"));
    }

    @Test
    public void testMiddleParse() throws Exception {
        Expression e = new Entailment(new Not(new Not(new Entailment(new Not(new NVariable("A")), new Not(new NVariable("B"))))), new Not(new NVariable("A")));
        assertEquals(e, expressionParser.parse("!!(!A->!B)->!A"));

        e = new Or(new Not(new NVariable("A")), new Not(new Entailment(new Not(new NVariable("A")), new And(new NVariable("B"), new NVariable("A")))));
        assertEquals(e, expressionParser.parse("!A|!(!A->B&A)"));

        e = new Or(new Entailment(new Not(new NVariable("Q")), new Not(new NVariable("S"))), new Or(new NVariable("S"), new Not(new NVariable("Q"))));
        assertEquals(e, expressionParser.parse("(!Q->!S)|(S|!Q)"));

        e = new Not(new Or(new Entailment(new NVariable("A"), new Not(new NVariable("B"))), new Entailment(new NVariable("B"), new Not(new NVariable("A")))));
        assertEquals(e, expressionParser.parse("!((A->!B)|(B->!A))"));
    }

    @Test
    public void testHardParse() throws Exception {
        Expression e = new Or(new Not(new Or(new NVariable("A"), new NVariable("B"))), new And(new And(new NVariable("A"), new Not(new Not(new NVariable("B")))),
                new Or(new NVariable("C"), new And(new NVariable("A"), new Entailment(new NVariable("B"), new And(new NVariable("A"), new NVariable("C")))))));
        assertEquals(e, expressionParser.parse("!(A|B)|((A&!!B)&(C|A&(B->A&C)))"));

        e = new Not(new Not(new Or(new And(new Or(new NVariable("A"), new Not(new NVariable("B"))), new Or(new NVariable("C"), new NVariable("D"))),
                new Or(new And(new And(new NVariable("A"), new NVariable("C")), new Not(new NVariable("D"))), new Not(new NVariable("B"))))));
        assertEquals(e, expressionParser.parse("!!(((A|!B)&(C|D))|(((A&C)&!D)|!B))"));

        e = new Not(new Entailment(new Or(new NVariable("A"), new Entailment(new Not(new Entailment(new NVariable("B"), new NVariable("A"))), new Or(new NVariable("C"),
                new Not(new NVariable("B"))))), new And(new Not(new Entailment(new NVariable("A"), new NVariable("C"))), new Not(new NVariable("B")))));
        assertEquals(e, expressionParser.parse("!((A|(!(B->A)->(C|!B)))->(!(A->C)&!B))"));

        e = new And(new And(new Entailment(new Entailment(new NVariable("C"), new NVariable("A")), new Not(new NVariable("B"))), new Entailment(new Not(new NVariable("C")),
                new And(new Or(new NVariable("B"), new NVariable("A")), new Not(new NVariable("A"))))), new Or(new NVariable("B"), new NVariable("C")));
        assertEquals(e, expressionParser.parse("((C->A)->!B)&(!C->(B|A)&!A)&(B|C)"));
    }

    @Test
    public void testNotException() throws Exception {
        expressionParser.parse("A");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAndRight() throws Exception {
        expressionParser.parse("A&");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAndLeft() throws Exception {
        expressionParser.parse("&B");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAnd() throws Exception {
        expressionParser.parse("&");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOrRight() throws Exception {
        expressionParser.parse("A|");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOrLeft() throws Exception {
        expressionParser.parse("|B");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOr() throws Exception {
        expressionParser.parse("|");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEntailRight() throws Exception {
        expressionParser.parse("A->");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEntailLeft() throws Exception {
        expressionParser.parse("->B");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEntail() throws Exception {
        expressionParser.parse("->");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseNot() throws Exception {
        expressionParser.parse("!");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseBracketLeft() throws Exception {
        expressionParser.parse("(A&B");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseBracketRight() throws Exception {
        expressionParser.parse("A&B)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseDoubleAnd() throws Exception {
        expressionParser.parse("A&&B)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseDoubleSign() throws Exception {
        expressionParser.parse("A&|B)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSign() throws Exception {
        expressionParser.parse("a#b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSignLeft() throws Exception {
        expressionParser.parse("#A&B");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSignRight() throws Exception {
        expressionParser.parse("A&B#");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalNearlyEntail() throws Exception {
        expressionParser.parse("A-<b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalAtSign() throws Exception {
        expressionParser.parse("@");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEmpty() throws Exception {
        expressionParser.parse("");
    }

    @Test
    public void testStressParse() throws Exception {
        final int TEST_COUNT = 10000;
        for (int i = 0; i < TEST_COUNT; i++) {
            Expression e = generator.generate(10);
            try {
                if (!e.equals(expressionParser.parse(e.toString()))) {
                    System.out.println(e);
                    System.out.println(e.toJavaCode());
                    System.out.println(expressionParser.parse(e.toString()).toJavaCode());
                }
            } catch (Exception exception) {
                System.out.println(e);
            }
            assertEquals(e, expressionParser.parse(e.toString()));
        }
    }
}