package ru.ifmo.ctddev.itegulov.mathlogic.kripke;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.NVariable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniyar Itegulov
 */
public class World {

    private Set<Variable<LogicExpression>> variables = new HashSet<>();

    public void forceVariable(Variable<LogicExpression> variable) {
        variables.add(variable);
    }

    public boolean isForced(Variable<LogicExpression> variable) {
        return variables.contains(variable);
    }

    public boolean isLesserSubset(World other) {
        return other.variables.containsAll(variables) && !other.variables.equals(variables);
    }

    public Set<Variable<LogicExpression>> getVariables() {
        return variables;
    }

    @Override
    public String toString() {
        return "World{" +
                "variables=" + variables +
                '}';
    }
}
