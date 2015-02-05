package structure.predicate;

import com.sun.istack.internal.NotNull;
import structure.AbstractExpression;
import structure.Expression;
import structure.logic.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Quantifier extends AbstractExpression {
    protected Term variable;
    protected Expression exp;
    protected String quantifierName;

    public Quantifier(Term variable, Expression exp, String quantifierName) {
        this.variable = variable;
        this.exp = exp;
        this.quantifierName = quantifierName;
    }

    @Override
    public Set<Variable> getFreeVariables() {
        Set<Variable> variables = exp.getFreeVariables();
        variables.remove(variable);
        return variables;
    }

    @Override
    public boolean evaluate() {
        throw new IllegalStateException("cannot evaluate expressions with quantifiers");
    }

    @Override
    public boolean evaluate(@NotNull Map<String, Boolean> args) {
        throw new IllegalStateException("cannot evaluate expressions with quantifiers");
    }

    @Override
    public StringBuilder asString() {
        return new StringBuilder(quantifierName).append(variable.toString()).append("(").append(exp.toString()).append(")");
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        throw new IllegalStateException("cannot proof expressions with quantifiers");
    }

    @Override
    public Map<String, Variable> getVariables() {
        return exp.getVariables();
    }

    @Override
    public void getQuantifiers(Set<Variable> quantifiers) {
        boolean contained = quantifiers.contains(variable);
        //quantifiers.add(variable);
        exp.getQuantifiers(quantifiers);
        if (!contained) {
            quantifiers.remove(variable);
        }
    }

    @Override
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map) {
        throw new IllegalStateException("cannot match expressions with quantifiers");
    }

    @Override
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        throw new IllegalStateException("cannot replace expressions with quantifiers");
    }
}
