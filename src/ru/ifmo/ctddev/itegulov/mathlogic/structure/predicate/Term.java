package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate;

import com.sun.istack.internal.NotNull;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.*;

import java.util.*;

public class Term extends AbstractFormalArithmeticExpression {
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
        quantifiers = new HashSet<>();
    }

    public Term(String name, ArrayList<Term> list) {
        this.name = name;
        this.arguments = list.toArray(new Term[list.size()]);
        quantifiers = new HashSet<>(3);
    }

    public String getName() {
        return name;
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
    public boolean treeMatch(@NotNull Expression other) {
        if (other.getClass() == getClass()) {
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
    public void getVariables(Map<String, Variable<FormalArithmeticExpression>> map) {
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
    public boolean matches(FormalArithmeticExpression other, Map<String, FormalArithmeticExpression> map) {
        throw new IllegalStateException("predicates can't be matched");
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
    public Set<String> getFreeVars(Set<String> set) {
        for (Term t : arguments) {
            t.getFreeVars(set);
        }
        if (!this.quantifiers.contains(this.name)) {
            set.add(name);
        }
        return set;
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
    public FormalArithmeticExpression replaceAll(final Map<Integer, FormalArithmeticExpression> replacement) {
        Term[] newTerms = new Term[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            newTerms[i] = (Term) arguments[i].replaceAll(replacement);
        }
        return new Term(name, newTerms);
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
