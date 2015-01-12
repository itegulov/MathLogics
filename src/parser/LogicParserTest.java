package parser;

import structure.Expression;
import structure.logic.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LogicParserTest {
    ExpressionRandomGenerator generator;
    Parser<Expression> expressionParser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        generator = new ExpressionRandomGeneratorPseudo();
        expressionParser = new LogicParser();
    }

    @org.junit.Test
    public void testEasyParse() throws Exception {

        Expression e = new And(new Variable("a"), new Variable("b"));
        assertEquals(e, expressionParser.parse("a&b"));
        assertEquals(e, expressionParser.parse("a& b"));
        assertEquals(e, expressionParser.parse("a &b"));
        assertEquals(e, expressionParser.parse("a & b"));
        assertEquals(e, expressionParser.parse("      a            &               b      "));
        e = new Or(new Variable("a"), new Variable("b"));
        assertEquals(e, expressionParser.parse("a|b"));
        assertEquals(e, expressionParser.parse("a| b"));
        assertEquals(e, expressionParser.parse("a |b"));
        assertEquals(e, expressionParser.parse("a | b"));
        assertEquals(e, expressionParser.parse("      a            |               b      "));
        e = new Entailment(new Variable("a"), new Variable("b"));
        assertEquals(e, expressionParser.parse("a->b"));
        assertEquals(e, expressionParser.parse("a-> b"));
        assertEquals(e, expressionParser.parse("a ->b"));
        assertEquals(e, expressionParser.parse("a -> b"));
        assertEquals(e, expressionParser.parse("      a            ->               b      "));
        e = new Not(new Variable("a"));
        assertEquals(e, expressionParser.parse("!a"));
        assertEquals(e, expressionParser.parse("! a"));
        assertEquals(e, expressionParser.parse("             ! a"));
    }

    @Test
    public void testVariableName() throws Exception {
        Expression e = new Variable("akjrhgeiurghksjrhgksejrhg");
        assertEquals(e, expressionParser.parse("akjrhgeiurghksjrhgksejrhg"));
    }

    @Test
    public void testMiddleParse() throws Exception {
        Expression e = new Entailment(new Not(new Not(new Entailment(new Not(new Variable("a")), new Not(new Variable("b"))))), new Not(new Variable("a")));
        assertEquals(e, expressionParser.parse("!!(!a->!b)->!a"));

        e = new Or(new Not(new Variable("a")), new Not(new Entailment(new Not(new Variable("b")), new And(new Variable("b"), new Variable("a")))));
        assertEquals(e, expressionParser.parse("!a|!(!b->b&a)"));

        e = new Or(new Entailment(new Not(new Variable("q")), new Not(new Variable("s"))), new Or(new Variable("s"), new Not(new Variable("q"))));
        assertEquals(e, expressionParser.parse("(!q->!s)|(s|!q)"));

        e = new Not(new Or(new Entailment(new Variable("a"), new Not(new Variable("b"))), new Entailment(new Variable("b"), new Not(new Variable("a")))));
        assertEquals(e, expressionParser.parse("!((a->!b)|(b->!a))"));
    }

    @Test
    public void testHardParse() throws Exception {
        Expression e = new Or(new Not(new Or(new Variable("a"), new Variable("b"))), new And(new And(new Variable("a"), new Not(new Not(new Variable("b")))),
                new Or(new Variable("c"), new And(new Variable("a"), new Entailment(new Variable("b"), new And(new Variable("a"), new Variable("c")))))));
        assertEquals(e, expressionParser.parse("!(a|b)|((a&!!b)&(c|a&(b->a&c)))"));

        e = new Not(new Not(new Or(new And(new Or(new Variable("a"), new Not(new Variable("b"))), new Or(new Variable("c"), new Variable("d"))),
                new Or(new And(new And(new Variable("a"), new Variable("c")), new Not(new Variable("d"))), new Not(new Variable("b"))))));
        assertEquals(e, expressionParser.parse("!!(((a|!b)&(c|d))|(((a&c)&!d)|!b))"));

        e = new Not(new Entailment(new Or(new Variable("a"), new Entailment(new Not(new Entailment(new Variable("b"), new Variable("a"))), new Or(new Variable("c"),
                new Not(new Variable("b"))))), new And(new Not(new Entailment(new Variable("a"), new Variable("c"))), new Not(new Variable("b")))));
        assertEquals(e, expressionParser.parse("!((a|(!(b->a)->(c|!b)))->(!(a->c)&!b))"));

        e = new And(new And(new Entailment(new Entailment(new Variable("c"), new Variable("a")), new Not(new Variable("b"))), new Entailment(new Not(new Variable("c")),
                new And(new Or(new Variable("b"), new Variable("a")), new Not(new Variable("a"))))), new Or(new Variable("b"), new Variable("c")));
        assertEquals(e, expressionParser.parse("((c->a)->!b)&(!c->(b|a)&!a)&(b|c)"));
    }

    @Test
    public void testNotException() throws Exception {
        expressionParser.parse("a");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAndRight() throws Exception {
        expressionParser.parse("a&");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAndLeft() throws Exception {
        expressionParser.parse("&b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseAnd() throws Exception {
        expressionParser.parse("&");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOrRight() throws Exception {
        expressionParser.parse("a|");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOrLeft() throws Exception {
        expressionParser.parse("|b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseOr() throws Exception {
        expressionParser.parse("|");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEntailRight() throws Exception {
        expressionParser.parse("a->");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseEntailLeft() throws Exception {
        expressionParser.parse("->b");
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
        expressionParser.parse("(a&b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseBracketRight() throws Exception {
        expressionParser.parse("a&b)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseDoubleAnd() throws Exception {
        expressionParser.parse("a&&b)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseDoubleSign() throws Exception {
        expressionParser.parse("a&|b)");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSign() throws Exception {
        expressionParser.parse("a#b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSignLeft() throws Exception {
        expressionParser.parse("#a&b");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalSignRight() throws Exception {
        expressionParser.parse("a&b#");
    }

    @Test(expected = ParseException.class)
    public void testExceptionParseIllegalNearlyEntail() throws Exception {
        expressionParser.parse("a-<b");
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
            if (!e.equals(expressionParser.parse(e.toString()))) {
                System.out.println(e);
                System.out.println(e.toJavaCode());
                System.out.println(expressionParser.parse(e.toString()).toJavaCode());
            }
            assertEquals(e, expressionParser.parse(e.toString()));
        }
    }
}