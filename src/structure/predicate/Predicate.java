package structure.predicate;

import com.sun.istack.internal.NotNull;
import structure.AbstractExpression;
import structure.Expression;
import structure.logic.Variable;

import java.util.*;

public class Predicate extends AbstractExpression {
    protected String name;
    protected Term[] arguments;

    public Predicate(String name) {
        this.name = name;
        this.arguments = new Term[0];
    }

    public Predicate(String name, Term... arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public Predicate(String name, ArrayList<Term> list) {
        this.arguments = list.toArray(new Term[list.size()]);
        this.name = name;
    }

    public void setArguments(Term[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate(@NotNull Map<String, Boolean> args) {
        throw new IllegalStateException("cannot evaluate predicates");
    }

    @Override
    public boolean evaluate() {
        throw new IllegalStateException("cannot evaluate predicates");
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        if (hasSameType(other)) {
            Predicate predicate = (Predicate) other;
            if (name.equals(predicate.name) && arguments.length == predicate.arguments.length) {
                boolean f = false;
                for (int i = 0; i < arguments.length; i++) {
                    if (!arguments[i].treeMatch(predicate.arguments[i])) {
                        f = true;
                        break;
                    }
                }
                if (!f) return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Variable> getVariables() {
        throw new IllegalStateException("cannot get variables in predicates");
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder("new Predicate(").append("\"").append(name).append("\"");
        for (Term argument : arguments) {
            sb.append(",").append(argument.toJavaCode());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map) {
        throw new IllegalStateException("cannot match predicate");
    }

    @Override
    public StringBuilder asString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (arguments.length != 0) {
            sb.append("(");
            for (int i = 0; i < arguments.length; i++) {
                sb.append(arguments[i].asString()).append(i == arguments.length - 1 ? "" : ",");
            }
            sb.append(")");
        }
        return sb;
    }

    @Override
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        Predicate predicate = new Predicate(this.name);
        Term[] args = new Term[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            args[i] = (Term) arguments[i].replaceAll(replacement);
        }
        predicate.setArguments(args);
        return predicate;
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        throw new IllegalStateException("cannot proof predicate");
    }

    @Override
    public Set<Variable> getFreeVariables() {
        Set<Variable> set = new HashSet<>();
        for (Term t : arguments) {
            set.addAll(t.getFreeVariables());
        }
        return set;
    }

    @Override
    public void getQuantifiers(Set<Variable> quantifiers) {
        for (Term t : arguments) {
            t.getQuantifiers(quantifiers);
        }
    }
}
