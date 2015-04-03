package structure.arithmetics;

import structure.predicate.Term;

import java.util.ArrayList;
import java.util.Set;

public class Successor extends Term {

    private Term operand;

    public Successor(Term operand) {
        super("'", operand);
        this.operand = arguments[0];
    }

    public Successor(ArrayList<Term> list) {
        super("'", list.get(0));
        this.operand = arguments[0];
    }

    @Override
    public Set<String> getFreeVars(Set<String> set) {
        for (Term t : arguments) {
            t.getFreeVars(set);
        }
        return set;
    }

    public Term getOperand() {
        return operand;
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append('(');
        operand.asString(sb);
        sb.append(')');
        sb.append('\'');
    }

}