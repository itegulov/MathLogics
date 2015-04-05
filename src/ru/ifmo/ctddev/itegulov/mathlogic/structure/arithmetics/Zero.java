package ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

public class Zero extends Term {

    public Zero() {
        super("0");
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(name);
    }
}
