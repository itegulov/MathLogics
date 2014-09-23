package proof;

import expression.*;
import parser.ExpressionParser;
import parser.ParseException;
import parser.Parser;

import java.util.HashMap;

public enum Axiom implements StatementType {
    //TODO: javadoc
    AxiomOne("a->b->a",1), AxiomTwo("(a->b)->(a->b->c)->(a->c)", 2), AxiomThree("a->b->a&b", 3), AxiomFour("a&b->a", 4), AxiomFive("a&b->b", 5),
    AxiomSix("a->a|b", 6), AxiomSeven("b->a|b", 7), AxiomEight("(a->c)->(b->c)->(a|b->c)", 8), AxiomNine("(a->b)->(a->!b)->!a", 9), AxiomTen("!!a->a", 10);


    private Expression exp;
    private int number;

    Axiom(String s, int number) {
        Parser<Expression> expressionParser = new ExpressionParser();
        try {
            exp = expressionParser.parse(s);
            this.number = number;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean matches(Expression other) {
        return exp.matches(other, new HashMap<String, Expression>());
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "сх. акс. " + number;
    }
}
