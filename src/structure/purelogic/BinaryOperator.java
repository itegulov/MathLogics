package structure.purelogic;

import structure.AbstractLogicExpression;
import structure.Expression;
import structure.LogicExpression;
import structure.Variable;

import java.util.List;
import java.util.Map;

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
        return  operation(left.evaluate(args), right.evaluate(args));
    }

    protected abstract boolean operation(boolean a, boolean b);

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        if (getClass() == other.getClass()) {
            BinaryOperator otherBo = (BinaryOperator) other;
            return left.matches(otherBo.left, map) && right.matches(otherBo.right, map);
        }
        return false;
    }

    @Override
    public void asString(StringBuilder sb) {
        if (left instanceof BinaryOperator) {
            sb.append('(');
            left.asString(sb);
            sb.append(')');
        } else {
            left.asString(sb);
        }
        if (right instanceof BinaryOperator) {
            sb.append('(');
            right.asString(sb);
            sb.append(')');
        } else {
            right.asString(sb);
        }
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
    public void getVariables(Map<String, Variable<LogicExpression>> map) {
        left.getVariables(map);
        right.getVariables(map);
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        List<LogicExpression> result = left.getParticularProof(hypothesis);
        result.addAll(right.getParticularProof(hypothesis));
        return result;
    }

    /*

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

    */
}