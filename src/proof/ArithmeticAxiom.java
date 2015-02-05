package proof;

import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import structure.Expression;

import java.util.HashMap;

public enum ArithmeticAxiom {
    ArithmeticAxiomOne("a=b->a'=b'",1), ArithmeticAxiomTwo("a=b->a=c->b=c", 2), ArithmeticAxiomThree("a'=b'->a=b", 3), ArithmeticAxiomFour("!a'=0", 4),
    ArithmeticAxiomFive("a+b'=(a+b)'", 5), ArithmeticAxiomSix("a+0=0", 6), ArithmeticAxiomSeven("a*0=0", 7), ArithmeticAxiomEight("a*b'=a*b+a", 8);


    private Expression exp;
    private int number;

    ArithmeticAxiom(String s, int number) {
        Parser<Expression> expressionParser = new LogicParser();
        try {
            exp = expressionParser.parse(s);
            this.number = number;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean matches(Expression other) {
        return exp.matches(other, new HashMap<>());
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "сх. акс. " + number;
    }
}
