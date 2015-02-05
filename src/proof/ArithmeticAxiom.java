package proof;

import parser.ArithmeticParser;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import structure.Expression;

import java.util.HashMap;

public enum ArithmeticAxiom implements StatementType {
    ArithmeticAxiomOne("a=b->a'=b'", 1), ArithmeticAxiomTwo("a=b->a=c->b=c", 2), ArithmeticAxiomThree("a'=b'->a=b", 3), ArithmeticAxiomFour("!a'=0", 4),
    ArithmeticAxiomFive("a+b'=(a+b)'", 5), ArithmeticAxiomSix("a+0=0", 6), ArithmeticAxiomSeven("a*0=0", 7), ArithmeticAxiomEight("a*b'=a*b+a", 8);


    private Expression exp;
    private int number;

    ArithmeticAxiom(String s, int number) {
        ArithmeticParser expressionParser = new ArithmeticParser();
        try {
            exp = expressionParser.parse(s);
            this.number = number;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean matches(Expression other) {
        return exp.equals(other);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Сх. акс. ФА " + number;
    }
}
