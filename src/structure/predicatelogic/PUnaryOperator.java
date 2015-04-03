package structure.predicatelogic;

import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.AbstractFormalArithmeticExpression;
import structure.Expression;
import structure.FormalArithmeticExpression;
import structure.Variable;
import structure.predicate.Term;

import java.util.Map;
import java.util.Set;

public abstract class PUnaryOperator extends AbstractFormalArithmeticExpression {
    protected FormalArithmeticExpression exp;
    protected final String operationName;

    public PUnaryOperator(FormalArithmeticExpression exp, String operationName) {
        this.exp = exp;
        this.operationName = operationName;
    }

    protected abstract boolean operation(boolean a);

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        if (getClass() == other.getClass()) {
            PUnaryOperator otherBo = (PUnaryOperator) other;
            return exp.matches(otherBo.exp, map);
        }
        return false;
    }

    @Override
    public StringBuilder asString() {
        StringBuilder s = exp.asString();
        if (exp instanceof PBinaryOperator) {
            s.insert(0, '(');
            s.append(')');
        }
        return s.insert(0, operationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PUnaryOperator unaryOperator = (PUnaryOperator) o;
        return unaryOperator.exp.equals(exp) && unaryOperator.operationName.equals(operationName);
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && ((PNot) other).exp.treeMatch(exp);
    }

    @Override
    public Map<String, Variable<FormalArithmeticExpression>> getVariables() {
        return exp.getVariables();
    }


    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        exp.setQuantifiers(quantifiers);
    }

    @Override
    public Set<String> getFreeVars() {
        return exp.getFreeVars();
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        return exp.markFreeVariableOccurrences(variableName);
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        if (!hasSameType(originalExpr)) {
            throw new TreeMismatchException(originalExpr, this);
        }
        return exp.getReplacedVariableOccurrences(((PUnaryOperator) originalExpr).exp);
    }
}