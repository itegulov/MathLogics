package ru.ifmo.ctddev.itegulov.structure.arithmetics;

import ru.ifmo.ctddev.itegulov.structure.Expression;
import ru.ifmo.ctddev.itegulov.structure.predicate.Term;

import java.util.ArrayList;

public class Plus extends Term {
    private Expression left;
    private Expression right;

    public Plus(Term left, Term right) {
        super("+", left, right);
        this.left = left;
        this.right = right;
    }

    public Plus(ArrayList<Term> list) {
        super("+", list.get(0), list.get(1));
        this.left = arguments[0];
        this.right = arguments[1];
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append('(');
        left.asString(sb);
        sb.append(name);
        right.asString(sb);
        sb.append(')');
    }
}
