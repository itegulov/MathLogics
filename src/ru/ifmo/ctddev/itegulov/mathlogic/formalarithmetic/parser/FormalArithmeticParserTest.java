package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser;

import org.junit.Test;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics.*;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Predicate;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

import static org.junit.Assert.*;

public class FormalArithmeticParserTest {
    FormalArithmeticParser parser = FormalArithmeticParser.getInstance();

    @Test
    public void testEasy() throws Exception {
        Expression e = parser.parse("@xx=x");
        assertEquals(e, new ForAll(new Term("x"), new Equals(new Term("x"), new Term("x"))));

        e = parser.parse("@xx+0=x");
        assertEquals(e, new ForAll(new Term("x"), new Equals(new Plus(new Term("x"), new Zero()), new Term("x"))));

        e = parser.parse("@x?yx=y");
        assertEquals(e, new ForAll(
                            new Term("x"),
                            new Exists(
                                new Term("y"),
                                new Equals(new Term("x"), new Term("y"))
                            )
                        )
        );

        e = parser.parse("@xx*0=0");
        assertEquals(e, new ForAll(new Term("x"), new Equals(new Multiply(new Term("x"), new Zero()), new Zero())));

        e = parser.parse("x'=(x)'");
        assertEquals(e, new Equals(new Successor(new Term("x")), new Successor(new Term("x"))));
    }

    @Test
    public void testPredicates() throws Exception {
        Expression e = parser.parse("@xA(x, x)");
        assertEquals(e, new ForAll(new Term("x"), new Predicate("A", new Term("x"), new Term("x"))));

        e = parser.parse("@x@yA(x, y)");
        assertEquals(e, new ForAll(new Term("x"), new ForAll(new Term("y"), new Predicate("A", new Term("x"), new Term("y")))));

        e = parser.parse("@xA(x+x, x)");
        assertEquals(e, new ForAll(new Term("x"), new Predicate("A", new Plus(new Term("x"), new Term("x")), new Term("x"))));

        e = parser.parse("@xA(x+x, f(x, x))");
        assertEquals(e,
                new ForAll(
                    new Term("x"),
                    new Predicate("A",
                            new Plus(new Term("x"), new Term("x")),
                            new Term("f", new Term("x"), new Term("x"))
                    )
                )
        );
    }

    @Test
    public void testHard() throws Exception {
        Expression e = parser.parse("(x'+0=(x+0)')&@y(((x)'+y=(x+y)')->((x)'+(y)'=(x+(y)')'))->((x)'+y=(x+y)')");
        System.out.println(e);
    }
}