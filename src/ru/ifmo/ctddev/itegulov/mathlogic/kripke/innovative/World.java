package ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Daniyar Itegulov
 */
public class World implements Cloneable {

    private final Set<Variable<LogicExpression>> forcedVariables;
    private Map<LogicExpression, Boolean> result = new HashMap<>();
    private List<World> children = new ArrayList<>();

    public World(Collection<Variable<LogicExpression>> forcedVariables) {
        this.forcedVariables = new HashSet<>(forcedVariables);
    }

    public void addChild(World child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "World{" +
                "variables=" + forcedVariables +
                '}';
    }

    public void toStringQuick(StringBuilder sb, int depth) {
        for (int i = 0; i < 2 * depth; i++) {
            sb.append(' ');
        }
        sb.append('*').append(' ');
        boolean flag = false;
        for (Variable variable : forcedVariables) {
            if (flag) sb.append(", ");
            sb.append(variable);
            flag = true;
        }
        sb.append('\n');
        for (World w : children) {
            w.toStringQuick(sb, depth + 1);
        }
    }

    public boolean check(LogicExpression expression) {
        if (result.containsKey(expression)) {
            return result.get(expression);
        }
        if (expression instanceof And) {
            And and = (And) expression;
            boolean r = check(and.getLeft()) && check(and.getRight());
            result.put(expression, r);
            return r;
        } else if (expression instanceof Or) {
            Or or = (Or) expression;
            boolean r = check(or.getLeft()) || check(or.getRight());
            result.put(expression, r);
            return r;
        } else if (expression instanceof Entailment) {
            Entailment entailment = (Entailment) expression;

            Queue<World> worlds = new ArrayDeque<>();
            worlds.add(this);
            while (!worlds.isEmpty()) {
                World w = worlds.poll();
                if (w.check(entailment.getLeft()) && !w.check(entailment.getRight())) {
                    result.put(expression, false);
                    return false;
                }
                worlds.addAll(w.children.stream().collect(Collectors.toList()));
            }
            result.put(expression, true);
            return true;
        } else if (expression instanceof Not) {
            Not not = (Not) expression;

            Queue<World> worlds = new ArrayDeque<>();
            worlds.add(this);
            while (!worlds.isEmpty()) {
                World w = worlds.poll();
                if (w.check(not.getExp())) {
                    result.put(expression, false);
                    return false;
                }
                worlds.addAll(w.children.stream().collect(Collectors.toList()));
            }
            result.put(expression, true);
            return true;
        } else if (expression instanceof NVariable) {
            NVariable variable = (NVariable) expression;
            boolean r = forcedVariables.contains(variable);
            result.put(expression, r);
            return r;
        } else {
            throw new IllegalStateException("There is no more type of expressions");
        }
    }

    public World clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Can't happen");
        }
        World thisWorld = new World(forcedVariables);
        for (World child: children) {
            thisWorld.addChild(child.clone());
        }
        return thisWorld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (!forcedVariables.equals(world.forcedVariables)) return false;
        return children.equals(world.children);

    }

    @Override
    public int hashCode() {
        int result = forcedVariables.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }

    public List<World> allWorlds() {
        List<World> worlds = new ArrayList<>();
        worlds.add(this);
        for (World child: worlds) {
            worlds.addAll(child.allWorlds());
        }
        return worlds;
    }

    public void forceRecursive(Variable<LogicExpression> variable) {
        forcedVariables.add(variable);
        for (World child: children) {
            child.forceRecursive(variable);
        }
    }
}
