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

public abstract class PBinaryOperator extends AbstractFormalArithmeticExpression {
    //TODO: javadoc
    protected FormalArithmeticExpression left, right;
    protected final String operationName;

    public PBinaryOperator(FormalArithmeticExpression left, FormalArithmeticExpression right, String operationName) {
        this.left = left;
        this.right = right;
        this.operationName = operationName;
    }

    protected abstract boolean operation(boolean a, boolean b);

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
        if (getClass() == other.getClass()) {
            PBinaryOperator otherBo = (PBinaryOperator) other;
            return left.matches(otherBo.left, map) && right.matches(otherBo.right, map);
        }
        return false;
    }

    @Override
    public StringBuilder asString() {
        StringBuilder s1 = left.asString();
        StringBuilder s2 = right.asString();
        if (left instanceof PBinaryOperator) {
            s1.insert(0, '(');
            s1.append(')');
        }
        if (right instanceof PBinaryOperator) {
            s2.insert(0, '(');
            s2.append(')');
        }
        return s1.append(operationName).append(s2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PBinaryOperator binaryOperator = (PBinaryOperator) o;
        return binaryOperator.left.equals(left) && binaryOperator.right.equals(right) && binaryOperator.operationName.equals(operationName);
    }

    public FormalArithmeticExpression getLeft() {
        return left;
    }

    public FormalArithmeticExpression getRight() {
        return right;
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && ((PBinaryOperator) other).left.treeMatch(left)
                && ((PBinaryOperator) other).right.treeMatch(right);
    }

    @Override
    public Map<String, Variable<FormalArithmeticExpression>> getVariables() {
        Map<String, Variable<FormalArithmeticExpression>> variables = left.getVariables();
        variables.putAll(right.getVariables());
        return variables;
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
        Set<Pair<Term, Term>> set = left.getReplacedVariableOccurrences(((PBinaryOperator) originalExpr).left);
        set.addAll(right.getReplacedVariableOccurrences(((PBinaryOperator) originalExpr).right));
        return set;
    }
}