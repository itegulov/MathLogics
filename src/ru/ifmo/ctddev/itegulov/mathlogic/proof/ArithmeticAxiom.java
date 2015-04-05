package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

public enum ArithmeticAxiom implements StatementType<FormalArithmeticExpression> {
    ArithmeticAxiomOne("a=b->a'=b'", 1), ArithmeticAxiomTwo("a=b->a=c->b=c", 2), ArithmeticAxiomThree("a'=b'->a=b", 3), ArithmeticAxiomFour("!a'=0", 4),
    ArithmeticAxiomFive("a+b'=(a+b)'", 5), ArithmeticAxiomSix("a+0=a", 6), ArithmeticAxiomSeven("a*0=0", 7), ArithmeticAxiomEight("a*b'=a*b+a", 8);


    private Expression exp;
    private int number;

    ArithmeticAxiom(String s, int number) {
        FormalArithmeticParser expressionParser = FormalArithmeticParser.getInstance();
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
