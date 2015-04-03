package structure.arithmetics;

import structure.predicate.Term;

public class Zero extends Term {

    public Zero() {
        super("0");
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(name);
    }
}
