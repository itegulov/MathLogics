package structure.logic;

import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.AbstractLogicExpression;
import structure.Expression;
import structure.LogicExpression;
import structure.predicate.Term;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class UnaryOperator extends AbstractLogicExpression {
    protected LogicExpression exp;
    protected final String operationName;

    public UnaryOperator(LogicExpression exp, String operationName) {
        this.exp = exp;
        this.operationName = operationName;
    }

    @Override
    public final boolean evaluate(Map<String, Boolean> args) {
        return operation(exp.evaluate(args));
    }

    protected abstract boolean operation(boolean a);

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        ExpressionType myType = ExpressionType.valueOf(getClass().getSimpleName());
        ExpressionType otherType = ExpressionType.valueOf(other.getClass().getSimpleName());
        if (myType == otherType) {
            UnaryOperator otherBo = (UnaryOperator) other;
            return exp.matches(otherBo.exp, map);
        }
        return false;
    }

    @Override
    public StringBuilder asString() {
        StringBuilder s = exp.asString();
        if (exp instanceof BinaryOperator) {
            s.insert(0, '(');
            s.append(')');
        }
        return s.insert(0, operationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryOperator unaryOperator = (UnaryOperator) o;
        return unaryOperator.exp.equals(exp) && unaryOperator.operationName.equals(operationName);
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && ((Not) other).exp.treeMatch(exp);
    }

    @Override
    public Map<String, Variable> getVariables() {
        return exp.getVariables();
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        return exp.getParticularProof(hypothesis);
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
        return exp.getReplacedVariableOccurrences(((UnaryOperator) originalExpr).exp);
    }
}