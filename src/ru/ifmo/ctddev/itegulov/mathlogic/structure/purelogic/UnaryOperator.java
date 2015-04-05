package ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.AbstractLogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;

import java.util.List;
import java.util.Map;

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
    public boolean matches(LogicExpression other, Map<String, LogicExpression> map) {
        if (getClass() == other.getClass()) {
            UnaryOperator otherBo = (UnaryOperator) other;
            return exp.matches(otherBo.exp, map);
        }
        return false;
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(operationName);
        if (exp instanceof BinaryOperator) {
            sb.append('(');
            exp.asString(sb);
            sb.append(')');
        } else {
            exp.asString(sb);
        }
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
        return other.getClass() == getClass()
                && ((Not) other).exp.treeMatch(exp);
    }

    @Override
    public void getVariables(Map<String, Variable<LogicExpression>> map) {
        exp.getVariables(map);
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        return exp.getParticularProof(hypothesis);
    }
}