package structure.predicate;

import com.sun.istack.internal.NotNull;
import exceptions.TreeMismatchException;
import javafx.util.Pair;
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
    public Set<String> getFreeVars() {
        Set<String> vars = exp.getFreeVars();
        vars.remove(variable.getName());
        return vars;
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
    public void setQuantifiers(Set<String> quantifiers) {
        boolean f = quantifiers.contains(variable.getName());
        quantifiers.add(variable.getName());
        exp.setQuantifiers(quantifiers);
        if (!f) {
            quantifiers.remove(variable.getName());
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

    @Override
    public int markFreeVariableOccurrences(String variableName) {
        return exp.markFreeVariableOccurrences(variableName);
    }

    @Override
    public Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException {
        if (!hasSameType(originalExpr) || !variable.getName().equals(((Quantifier) originalExpr).getVariable().getName())) {
            throw new TreeMismatchException(originalExpr, this);
        }
        return exp.getReplacedVariableOccurrences(((Quantifier) originalExpr).getExp());
    }

    public Term getVariable() {
        return variable;
    }

    public Expression getExp() {
        return exp;
    }
}
