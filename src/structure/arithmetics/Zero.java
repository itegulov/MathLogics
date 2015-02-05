package structure.arithmetics;

import structure.predicate.Term;

public class Zero extends Term {

    public Zero() {
        super("0");
    }

    @Override
    public StringBuilder asString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb;
    }
}
