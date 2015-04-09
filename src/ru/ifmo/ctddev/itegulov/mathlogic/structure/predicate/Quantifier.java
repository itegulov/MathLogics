package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.*;

import java.util.Map;
import java.util.Set;

public abstract class Quantifier extends AbstractFormalArithmeticExpression {
    protected Term variable;
    protected FormalArithmeticExpression exp;
    protected String quantifierName;

    public Quantifier(Term variable, FormalArithmeticExpression exp, String quantifierName) {
        this.variable = variable;
        this.exp = exp;
        this.quantifierName = quantifierName;
    }

    @Override
    public Set<String> getFreeVars(Set<String> set) {
        if (set.contains(variable.getName())) {
            exp.getFreeVars(set);
        } else {
            exp.getFreeVars(set);
            set.remove(variable.getName());
        }
        return set;
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(quantifierName);
        variable.asString(sb);
        sb.append('(');
        exp.asString(sb);
        sb.append(')');
    }

    @Override
    public void getVariables(Map<String, Variable<FormalArithmeticExpression>> map) {
        exp.getVariables(map);
    }

    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        boolean f = quantifiers.contains(variable.getName());
        quantifiers.add(variable.getName());
        exp.setQuantifiers(quantifiers);
        if (!f) {
            quantifiers.remove(variable.getName());
        }
    }

    @Override
    public boolean matches(FormalArithmeticExpression other, Map<String, FormalArithmeticExpression> map) {
        throw new IllegalStateException("cannot match expressions with quantifiers");
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        return exp.markFreeVariableOccurrences(variableName);
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        if (!(originalExpr.getClass() == getClass()) || !variable.getName().equals(((Quantifier) originalExpr).getVariable().getName())) {
            throw new TreeMismatchException(originalExpr, this);
        }
        return exp.getReplacedVariableOccurrences(((Quantifier) originalExpr).getExp());
    }

    public Term getVariable() {
        return variable;
    }

    public FormalArithmeticExpression getExp() {
        return exp;
    }
}
