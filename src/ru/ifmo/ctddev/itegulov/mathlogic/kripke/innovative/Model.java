package ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;

import java.util.List;

public class Model {
    private World rootWorld;

    public Model(World rootWorld) {
        this.rootWorld = rootWorld;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        rootWorld.toStringQuick(sb, 0);
        return sb.toString();
    }

    public boolean check(LogicExpression expression) {
        return rootWorld.check(expression);
    }

    public World getRootWorld() {
        return rootWorld;
    }

    public List<World> allWorlds() {
        return rootWorld.allWorlds();
    }

    public void forceRecursive(Variable<LogicExpression> variable) {
        rootWorld.forceRecursive(variable);
    }

    public Model clone() {
        return new Model(rootWorld.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        return rootWorld.equals(model.rootWorld);
    }

    @Override
    public int hashCode() {
        return rootWorld.hashCode();
    }
}