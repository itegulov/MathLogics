package structure.predicatelogic;

import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.*;
import structure.predicate.Term;

import java.util.*;

public final class PVariable extends AbstractFormalArithmeticExpression implements Variable<FormalArithmeticExpression> {
    private String name;

    public PVariable(String name) {
        this.name = name;
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other) && (name != null && ((PVariable) other).name.equals(name));
    }

    @Override
    public Map<String, Variable<FormalArithmeticExpression>> getVariables() {
        Map<String, Variable<FormalArithmeticExpression>> map = new HashMap<>();
        map.put(name, this);
        return map;
    }

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
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
    public StringBuilder asString() {
        return new StringBuilder(name);
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
    public Set<String> getFreeVars() {
        return new HashSet<>();
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
