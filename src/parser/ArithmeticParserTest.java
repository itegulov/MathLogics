package parser;

import org.junit.Test;
import structure.Expression;
import structure.arithmetics.Equals;
import structure.arithmetics.Multiply;
import structure.arithmetics.Plus;
import structure.arithmetics.Zero;
import structure.logic.Variable;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Predicate;
import structure.predicate.Term;

import static org.junit.Assert.*;

public class ArithmeticParserTest {
    ArithmeticParser parser = new ArithmeticParser();

    @Test
    public void testEasy() throws Exception {
        Expression e = parser.parse("@xx=x");
        assertEquals(e, new ForAll(new Variable("x"), new Equals(new Variable("x"), new Variable("x"))));

        e = parser.parse("@xx+0=x");
        assertEquals(e, new ForAll(new Variable("x"), new Equals(new Plus(new Variable("x"), new Zero()), new Variable("x"))));

        e = parser.parse("@x?yx=y");
        assertEquals(e, new ForAll(
                            new Variable("x"),
                            new Exists(
                                new Variable("y"),
                                new Equals(new Variable("x"), new Variable("y"))
                            )
                        )
        );

        e = parser.parse("@xx*0=0");
        assertEquals(e, new ForAll(new Variable("x"), new Equals(new Multiply(new Variable("x"), new Zero()), new Zero())));
    }

    @Test
    public void testPredicates() throws Exception {
        Expression e = parser.parse("@xA(x, x)");
        assertEquals(e, new ForAll(new Variable("x"), new Predicate("A", new Variable("x"), new Variable("x"))));

        e = parser.parse("@x@yA(x, y)");
        assertEquals(e, new ForAll(new Variable("x"), new ForAll(new Variable("y"), new Predicate("A", new Variable("x"), new Variable("y")))));

        e = parser.parse("@xA(x+x, x)");
        assertEquals(e, new ForAll(new Variable("x"), new Predicate("A", new Plus(new Variable("x"), new Variable("x")), new Variable("x"))));

        e = parser.parse("@xA(x+x, f(x, x))");
        assertEquals(e,
                new ForAll(
                    new Variable("x"),
                    new Predicate("A",
                            new Plus(new Variable("x"), new Variable("x")),
                            new Term("f", new Variable("x"), new Variable("x"))
                    )
                )
        );
    }
}