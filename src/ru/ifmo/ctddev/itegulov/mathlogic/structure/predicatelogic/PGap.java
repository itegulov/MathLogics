package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic;

import com.sun.istack.internal.NotNull;
import javafx.util.Pair;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

import java.util.Map;
import java.util.Set;

public final class PGap extends Term implements Variable<FormalArithmeticExpression> {
    private int num;

    public PGap(int num) {
        super(Integer.toString(num));
        this.num = num;
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        return true;
    }

    @Override
    public void getVariables(final Map<String, Variable<FormalArithmeticExpression>> map) {
        throw new IllegalStateException("cannot perform this operation on gap");
    }

    @Override
    public boolean matches(final FormalArithmeticExpression other, final Map<String, FormalArithmeticExpression> map) {
        throw new IllegalStateException("cannot perform this operation on gap");
    }

    @Override
    public String toJavaCode() {
        return "new Gap(" + num + ")";
    }

    @Override
    public FormalArithmeticExpression replaceAll(final Map<Integer, FormalArithmeticExpression> replacement) {
        if (replacement.containsKey(num)) {
            return replacement.get(num);
        }
        try {
            return (FormalArithmeticExpression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(Integer.toString(num));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new PGap(num);
    }

    @Override
    public Set<String> getFreeVars(final Set<String> set) {
        return set;
    }

    @Override
    public void setQuantifiers(final Set<String> quantifiers) {
        throw new IllegalStateException("cannot perform this operation on gap");
    }

    @Override
    public int markFreeVariableOccurrences(final String variableName) {
        throw new IllegalStateException("cannot perform this operation on gap");
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(final Expression originalExpr) throws TreeMismatchException {
        throw new IllegalStateException("cannot perform this operation on gap");
    }

    @Override
    public String getName() {
        return toString();
    }
}
