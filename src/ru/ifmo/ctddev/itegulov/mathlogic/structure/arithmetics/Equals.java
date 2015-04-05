package ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Predicate;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

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
    public void asString(StringBuilder sb) {
        sb.append('(');
        left.asString(sb);
        sb.append('=');
        right.asString(sb);
        sb.append(')');
    }
}
