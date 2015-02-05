package structure.predicate;

import com.sun.istack.internal.NotNull;
import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.AbstractExpression;
import structure.Expression;
import structure.logic.Variable;

import java.util.*;

public class Term extends AbstractExpression {
    public Set<String> quantifiers;
    public boolean isFree = false;
    public String name;
    protected Term[] arguments;

    public Term(String name) {
        this.name = name;
        arguments = new Term[0];
        quantifiers = new HashSet<>();
    }

    public Term(String name, Term... arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public Term(String name, ArrayList<Term> list) {
        this.name = name;
        this.arguments = list.toArray(new Term[list.size()]);
        quantifiers = new HashSet<>(3);
    }

    public String getName() {
        return name;
    }

    public Term[] getArguments() {
        return arguments;
    }

    public List<String> getTermNames() {
        List<String> result;
        if (arguments.length == 0) {
            result = new ArrayList<>();
        } else {
            result = arguments[0].getTermNames();
            for (int i = 1; i < arguments.length; i++) {
                result.addAll(arguments[i].getTermNames());
            }
        }
        result.add(name);
        return result;
    }

    public boolean matchTerm(Term t) {
        return (t.name.equals(name) && hasSameArgumentLength(t));
    }

    public boolean hasSameArgumentLength(Term t) {
        return t.arguments.length == arguments.length;
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
            Term otherTerm = (Term) other;
            if (name.equals(otherTerm.name) && arguments.length == otherTerm.arguments.length) {
                for (int i = 0; i < arguments.length; i++) {
                    if (!arguments[i].treeMatch(otherTerm.arguments[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Variable> getVariables() {
        throw new IllegalStateException("predicates don't contain variables");
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder("new Term(").append("\"").append(name).append("\"");
        for (Term argument : arguments) {
            sb.append(",").append(argument.toJavaCode());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map) {
        throw new IllegalStateException("predicates can't be matched");
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
        throw new IllegalStateException("predicates can't be replaced");
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        throw new IllegalStateException("can't proof predicates");
    }

    @Override
    public Set<String> getFreeVars() {
        HashSet<String> vars = new HashSet<>();
        for (Term t : arguments) {
            vars.addAll(t.getFreeVars());
        }
        if (!this.quantifiers.contains(this.name))
            vars.add(name);
        return vars;
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        int result = 0;
        for (Term t : arguments) {
            result += t.markFreeVariableOccurrences(variableName);
        }
        if (this.name.equals(variableName)) {
            boolean f = true;
            for (String s : quantifiers) {
                if (s.equals(variableName)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                isFree = true;
                result++;
            }
        }
        return result;
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        Set<Pair<Term, Term>> set = new HashSet<>();
        if (!(originalExpr instanceof Term)) {
            throw new TreeMismatchException(originalExpr, this);
        }
        Term term = (Term) originalExpr;
        if (term.isFree) {
            set.add(new Pair<>(term, this));
        }
        if (hasSameArgumentLength(term)) {
            for (int i = 0; i < arguments.length; i++) {
                Term t = arguments[i];
                set.addAll(t.getReplacedVariableOccurrences(term.arguments[i]));
            }
        }
        return set;
    }

    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        for (Term t : arguments) {
            t.setQuantifiers(quantifiers);
        }
        Set<String> set = new HashSet<>();
        for (String s : quantifiers) {
            set.add(s);
        }
        this.quantifiers = set;
    }
}
