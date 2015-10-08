package ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Daniyar Itegulov
 */
public class World {

    private Set<Variable<LogicExpression>> forcedVariables = new HashSet<>();
    private List<World> children = new ArrayList<>();

    public World(int mask, List<Variable<LogicExpression>> variables) {
        for (int i = 0; i < variables.size(); i++) {
            if ((mask & (1 << i)) != 0) {
                forcedVariables.add(variables.get(i));
            }
        }
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
        if (expression instanceof And) {
            And and = (And) expression;
            return check(and.getLeft()) && check(and.getRight());
        } else if (expression instanceof Or) {
            Or or = (Or) expression;
            return check(or.getLeft()) || check(or.getRight());
        } else if (expression instanceof Entailment) {
            Entailment entailment = (Entailment) expression;

            Queue<World> worlds = new ArrayDeque<>();
            worlds.add(this);
            while (!worlds.isEmpty()) {
                World w = worlds.poll();
                if (w.check(entailment.getLeft()) && !w.check(entailment.getRight())) {
                    return false;
                }
                worlds.addAll(w.children.stream().collect(Collectors.toList()));
            }
            return true;
        } else if (expression instanceof Not) {
            Not not = (Not) expression;

            Queue<World> worlds = new ArrayDeque<>();
            worlds.add(this);
            while (!worlds.isEmpty()) {
                World w = worlds.poll();
                if (w.check(not.getExp())) {
                    return false;
                }
                worlds.addAll(w.children.stream().collect(Collectors.toList()));
            }
            return true;
        } else if (expression instanceof NVariable) {
            NVariable variable = (NVariable) expression;
            return forcedVariables.contains(variable);
        } else {
            throw new IllegalStateException("There is no more type of expressions");
        }
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
}
