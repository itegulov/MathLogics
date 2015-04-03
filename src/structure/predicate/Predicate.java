package structure.predicate;

import com.sun.istack.internal.NotNull;
import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.AbstractFormalArithmeticExpression;
import structure.Expression;
import structure.FormalArithmeticExpression;
import structure.Variable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Predicate extends AbstractFormalArithmeticExpression {
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
        this.arguments = arguments.clone();
    }

    @Override
    public boolean treeMatch(Expression other) {
        if (other.getClass() == getClass()) {
            Predicate predicate = (Predicate) other;
            if (name.equals(predicate.name) && arguments.length == predicate.arguments.length) {
                for (int i = 0; i < arguments.length; i++) {
                    if (!arguments[i].treeMatch(predicate.arguments[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void getVariables(Map<String, Variable<FormalArithmeticExpression>> map) {
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
    public boolean match(Expression other) {
        return other.getClass() == getClass()
                && ((Predicate) other).getName().equals(name)
                && ((Predicate) other).arguments.length == arguments.length;
    }

    @Override
    public boolean matches(FormalArithmeticExpression other, Map<String, FormalArithmeticExpression> map) {
        throw new IllegalStateException("cannot match predicate");
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(name);
        if (arguments.length != 0) {
            sb.append('(');
            for (int i = 0; i < arguments.length; i++) {
                arguments[i].asString(sb);
                if (i != arguments.length - 1) {
                    sb.append(',');
                }
            }
            sb.append(')');
        }
    }

    @Override
    public FormalArithmeticExpression replaceAll(Map<Integer, FormalArithmeticExpression> replacement) {
        Predicate predicate = new Predicate(this.name);
        Term[] args = new Term[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            args[i] = (Term) arguments[i].replaceAll(replacement);
        }
        predicate.setArguments(args);
        return predicate;
    }

    @Override
    public Set<String> getFreeVars(Set<String> set) {
        for (Term t : arguments) {
            t.getFreeVars(set);
        }
        return set;
    }

    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        for (Term t : arguments) {
            t.setQuantifiers(quantifiers);
        }
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        int result = 0;
        for (Term t : arguments) {
            result += t.markFreeVariableOccurrences(variableName);
        }
        return result;
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        Set<Pair<Term, Term>> set = new HashSet<>();
        if (!match(originalExpr)) {
            throw new TreeMismatchException(originalExpr, this);
        }
        for (int i = 0; i < arguments.length; i++) {
            Term t = arguments[i];
            set.addAll(t.getReplacedVariableOccurrences(((Predicate) originalExpr).arguments[i]));
        }
        return set;
    }

    public String getName() {
        return name;
    }
}
