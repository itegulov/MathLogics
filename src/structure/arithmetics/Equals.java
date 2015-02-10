package structure.arithmetics;

import structure.Expression;
import structure.predicate.Predicate;
import structure.predicate.Term;

import java.util.ArrayList;

public class Equals extends Predicate {
    private Expression left;
    private Expression right;

    public Equals(Term left, Term right) {
        super("=", left, right);
        this.left = left;
        this.right = right;
    }

    public Equals(ArrayList<Term> list) {
        super("=", list.get(0), list.get(1));
        left = arguments[0];
        right = arguments[1];
    }

    @Override
    public StringBuilder asString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(left.asString()).append(name).append(right.asString()).append(")");
        return sb;
    }
}
