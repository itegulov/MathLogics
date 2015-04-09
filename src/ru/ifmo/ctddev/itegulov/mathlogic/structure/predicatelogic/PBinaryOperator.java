package ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.*;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

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
    public boolean matches(FormalArithmeticExpression other, Map<String, FormalArithmeticExpression> map) {
        if (getClass() == other.getClass()) {
            PBinaryOperator otherBo = (PBinaryOperator) other;
            return left.matches(otherBo.left, map) && right.matches(otherBo.right, map);
        }
        return false;
    }

    @Override
    public void asString(StringBuilder sb) {
        if (left instanceof PBinaryOperator) {
            sb.append('(');
            left.asString(sb);
            sb.append(')');
        } else {
            left.asString(sb);
        }
        sb.append(operationName);
        if (right instanceof PBinaryOperator) {
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
        return other.getClass() == getClass()
                && ((PBinaryOperator) other).left.treeMatch(left)
                && ((PBinaryOperator) other).right.treeMatch(right);
    }

    @Override
    public void getVariables(Map<String, Variable<FormalArithmeticExpression>> map) {
        right.getVariables(map);
    }

    @Override
    public void setQuantifiers(Set<String> quantifiers) {
        left.setQuantifiers(quantifiers);
        right.setQuantifiers(quantifiers);
    }

    @Override
    public Set<String> getFreeVars(Set<String> set) {
        left.getFreeVars(set);
        right.getFreeVars(set);
        return set;
    }

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        int result = left.markFreeVariableOccurrences(variableName);
        result += right.markFreeVariableOccurrences(variableName);
        return result;
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        if (!(originalExpr.getClass() == getClass())) {
            throw new TreeMismatchException(originalExpr, this);
        }
        Set<Pair<Term, Term>> set = left.getReplacedVariableOccurrences(((PBinaryOperator) originalExpr).left);
        set.addAll(right.getReplacedVariableOccurrences(((PBinaryOperator) originalExpr).right));
        return set;
    }
}