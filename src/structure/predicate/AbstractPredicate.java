package structure.predicate;

import structure.AbstractExpression;
import structure.logic.Variable;

import java.util.Set;

public abstract class AbstractPredicate extends AbstractExpression {
    public abstract Set<Variable> getFreeVars();
    public abstract void setQuantifiers(Set<Variable> variables);
}
