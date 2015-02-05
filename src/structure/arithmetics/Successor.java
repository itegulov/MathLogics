package structure.arithmetics;

import structure.logic.Variable;
import structure.predicate.Term;

import java.util.ArrayList;
import java.util.HashSet;
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
    public Set<String> getFreeVars() {
        HashSet<String> vars = new HashSet<>();
        for (Term t : arguments) {
            vars.addAll(t.getFreeVars());
        }
        return vars;
    }

    public Term getOperand() {
        return operand;
    }

    @Override
    public StringBuilder asString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(operand.asString()).append(")").append(name);
        return sb;
    }

}