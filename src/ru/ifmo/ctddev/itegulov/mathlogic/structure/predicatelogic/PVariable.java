package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.*;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

import java.util.*;

public final class PVariable extends AbstractFormalArithmeticExpression implements Variable<FormalArithmeticExpression> {
    private String name;

    public PVariable(String name) {
        this.name = name;
    }

    @Override
    public boolean treeMatch(Expression other) {
        return other.getClass() == getClass() && (name != null && ((PVariable) other).name.equals(name));
    }

    @Override
    public void getVariables(Map<String, Variable<FormalArithmeticExpression>> map) {
        map.put(name, this);
    }

    @Override
    public boolean matches(FormalArithmeticExpression other, Map<String, FormalArithmeticExpression> map) {
        if (map.containsKey(name)) {
            return other.equals(map.get(name));
        }
        map.put(name, other);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVariable variable = (PVariable) o;
        return variable.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(name);
    }

    @Override
    public String toJavaCode() {
        return "new Variable(\"" + name + "\")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new PVariable(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FormalArithmeticExpression replaceAll(final Map<Integer, FormalArithmeticExpression> replacement) {
        try {
            return (FormalArithmeticExpression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<String> getFreeVars(Set<String> set) {
        return set;
    }

    @Override
    public void setQuantifiers(final Set<String> quantifiers) {
        //Do nothing heh
    }

    @Override
    public int markFreeVariableOccurrences(final String variableName) {
        return 0;
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(final Expression originalExpr) throws TreeMismatchException {
        return new HashSet<>();
    }
}
