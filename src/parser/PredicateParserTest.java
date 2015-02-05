package parser;

import org.junit.Before;
import org.junit.Test;
import structure.Expression;
import structure.ExpressionRandomGenerator;
import structure.ExpressionRandomGeneratorPseudo;
import structure.logic.*;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Predicate;

import static org.junit.Assert.*;

public class PredicateParserTest {
    ExpressionRandomGenerator generator;
    Parser<Expression> expressionParser;

    @Before
    public void setUp() throws Exception {
        generator = new ExpressionRandomGeneratorPseudo();
        expressionParser = new PredicateParser();
    }

    @Test
    public void testEasyParse() throws Exception {
        Expression exp = new ForAll(new Variable("a"), new Predicate("B"));
        assertEquals(exp, expressionParser.parse("@aB"));
        assertEquals(exp, expressionParser.parse("@a               B"));
        assertEquals(exp, expressionParser.parse("@             aB"));
        assertEquals(exp, expressionParser.parse("@              a            B       "));
        assertEquals(exp, expressionParser.parse("                  @                     a        B                "));

        exp = new Exists(new Variable("a"), new Predicate("B"));
        assertEquals(exp, expressionParser.parse("?aB"));
        assertEquals(exp, expressionParser.parse("?a               B"));
        assertEquals(exp, expressionParser.parse("?             aB"));
        assertEquals(exp, expressionParser.parse("?              a            B       "));
        assertEquals(exp, expressionParser.parse("                  ?                     a        B                "));

        Expression e = new And(new Variable("A"), new Variable("B"));
        assertEquals(e, expressionParser.parse("A&B"));
        assertEquals(e, expressionParser.parse("A& B"));
        assertEquals(e, expressionParser.parse("A &B"));
        assertEquals(e, expressionParser.parse("A & B"));
        assertEquals(e, expressionParser.parse("      A            &               B      "));

        e = new Or(new Variable("A"), new Variable("B"));
        assertEquals(e, expressionParser.parse("A|B"));
        assertEquals(e, expressionParser.parse("A| B"));
        assertEquals(e, expressionParser.parse("A |B"));
        assertEquals(e, expressionParser.parse("A | B"));
        assertEquals(e, expressionParser.parse("      A            |               B      "));

        e = new Entailment(new Variable("A"), new Variable("B"));
        assertEquals(e, expressionParser.parse("A->B"));
        assertEquals(e, expressionParser.parse("A-> B"));
        assertEquals(e, expressionParser.parse("A ->B"));
        assertEquals(e, expressionParser.parse("A -> B"));
        assertEquals(e, expressionParser.parse("      A            ->               B      "));

        e = new Not(new Variable("A"));
        assertEquals(e, expressionParser.parse("!A"));
        assertEquals(e, expressionParser.parse("! A"));
        assertEquals(e, expressionParser.parse("             ! A"));
    }

    @Test
    public void testSimpleParse() throws Exception {
        Expression e = new ForAll(new Variable("a"), new Entailment(new Variable("B"), new Variable("A")));
        assertEquals(e, expressionParser.parse("@a(B->A)"));

        e = new ForAll(new Variable("a"), new Or(new Variable("B"), new Variable("A")));
        assertEquals(e, expressionParser.parse("@a(B|A)"));

        e = new ForAll(new Variable("a"), new And(new Variable("B"), new Variable("A")));
        assertEquals(e, expressionParser.parse("@a(B&A)"));

        e = new Entailment(new ForAll(new Variable("a0"), new Variable("A")), new Variable("B"));
        assertEquals(e, expressionParser.parse("@a0A->B"));
    }
}