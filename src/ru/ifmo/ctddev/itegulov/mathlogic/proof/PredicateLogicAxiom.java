package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

import java.util.HashMap;

public enum PredicateLogicAxiom implements StatementType<FormalArithmeticExpression> {
    //TODO: javadoc
    AxiomOne("A->B->A",1), AxiomTwo("(A->B)->(A->B->C)->(A->C)", 2), AxiomThree("A->B->A&B", 3), AxiomFour("A&B->A", 4), AxiomFive("A&B->B", 5),
    AxiomSix("A->A|B", 6), AxiomSeven("B->A|B", 7), AxiomEight("(A->C)->(B->C)->(A|B->C)", 8), AxiomNine("(A->B)->(A->!B)->!A", 9), AxiomTen("!!A->A", 10);


    private FormalArithmeticExpression exp;
    private int number;

    PredicateLogicAxiom(String s, int number) {
        Parser<FormalArithmeticExpression> expressionParser = FormalArithmeticParser.getInstance();
        try {
            exp = expressionParser.parse(s);
            this.number = number;
        } catch (ParseException e) {
            throw new IllegalStateException("Logic axiom is invalid");
        }
    }

    public boolean matches(FormalArithmeticExpression other) {
        return exp.matches(other, new HashMap<>());
    }

    @Override
    public String toString() {
        return "сх. акс. " + number;
    }
}
