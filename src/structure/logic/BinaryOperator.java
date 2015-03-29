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

public abstract class BinaryOperator extends AbstractLogicExpression {
    //TODO: javadoc
    protected LogicExpression left, right;
    protected final String operationName;

    public BinaryOperator(LogicExpression left, LogicExpression right, String operationName) {
        this.left = left;
        this.right = right;
        this.operationName = operationName;
    }

    @Override
    public final boolean evaluate(Map<String, Boolean> args) {
        return operation(left.evaluate(args), right.evaluate(args));
    }

    protected abstract boolean operation(boolean a, boolean b);

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        ExpressionType myType = ExpressionType.valueOf(getClass().getSimpleName());
        ExpressionType otherType = ExpressionType.valueOf(other.getClass().getSimpleName());
        if (myType == otherType) {
            BinaryOperator otherBo = (BinaryOperator) other;
            return left.matches(otherBo.left, map) && right.matches(otherBo.right, map);
        }
        return false;
    }

    @Override
    public StringBuilder asString() {
        StringBuilder s1 = left.asString();
        StringBuilder s2 = right.asString();
        if (left instanceof BinaryOperator) {
            s1.insert(0, '(');
            s1.append(')');
        }
        if (right instanceof BinaryOperator) {
            s2.insert(0, '(');
            s2.append(')');
        }
        return s1.append(operationName).append(s2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperator binaryOperator = (BinaryOperator) o;
        return binaryOperator.left.equals(left) && binaryOperator.right.equals(right) && binaryOperator.operationName.equals(operationName);
    }

    public LogicExpression getLeft() {
        return left;
    }

    public LogicExpression getRight() {
        return right;
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && ((BinaryOperator) other).left.treeMatch(left)
                && ((BinaryOperator) other).right.treeMatch(right);
    }

    @Override
    public Map<String, Variable> getVariables() {
        Map<String, Variable> variables = left.getVariables();
        variables.putAll(right.getVariables());
        return variables;
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        List<LogicExpression> result = left.getParticularProof(hypothesis);
        result.addAll(right.getParticularProof(hypothesis));
        return result;
    }

    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        left.setQuantifiers(quantifiers);
        right.setQuantifiers(quantifiers);
    }

    @Override
    public Set<String> getFreeVars() {
        Set<String> h = left.getFreeVars();
        h.addAll(right.getFreeVars());
        return h;
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        int result = left.markFreeVariableOccurrences(variableName);
        result += right.markFreeVariableOccurrences(variableName);
        return result;
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        if (!hasSameType(originalExpr)) {
            throw new TreeMismatchException(originalExpr, this);
        }
        Set<Pair<Term, Term>> set = left.getReplacedVariableOccurrences(((BinaryOperator) originalExpr).left);
        set.addAll(right.getReplacedVariableOccurrences(((BinaryOperator) originalExpr).right));
        return set;
    }
}