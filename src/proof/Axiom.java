package proof;

import structure.Expression;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import structure.LogicExpression;

import java.util.HashMap;

public enum Axiom implements StatementType<LogicExpression> {
    //TODO: javadoc
    AxiomOne("A->B->A",1), AxiomTwo("(A->B)->(A->B->C)->(A->C)", 2), AxiomThree("A->B->A&B", 3), AxiomFour("A&B->A", 4), AxiomFive("A&B->B", 5),
    AxiomSix("A->A|B", 6), AxiomSeven("B->A|B", 7), AxiomEight("(A->C)->(B->C)->(A|B->C)", 8), AxiomNine("(A->B)->(A->!B)->!A", 9), AxiomTen("!!A->A", 10);


    private Expression exp;
    private int number;

    Axiom(String s, int number) {
        Parser<LogicExpression> expressionParser = new LogicParser();
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

    @Override
    public String toString() {
        return "сх. акс. " + number;
    }
}
