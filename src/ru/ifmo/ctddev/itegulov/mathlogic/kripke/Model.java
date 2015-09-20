package ru.ifmo.ctddev.itegulov.mathlogic.kripke;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniyar Itegulov
 */
public class Model {

    private List<Model> children = new ArrayList<>();
    private World world;
    private boolean active = true;
    private int subtree = 0;

    public Model(World world) {
        this.world = world;
    }

    public void addChild(World world) {
        children.add(new Model(world));
    }

    private boolean checkEntailment(Entailment entailment) {
        if (check(entailment.getLeft()) && !check(entailment.getRight())) {
            return false;
        }
        for (Model child: children) {
            if (child.isActive() && !child.checkEntailment(entailment)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(LogicExpression expression) {
        if (!active) {
            return true;
        }

        if (expression instanceof And) {
            And and = (And) expression;
            return check(and.getLeft()) && check(and.getRight());
        } else if (expression instanceof Or) {
            Or or = (Or) expression;
            return check(or.getLeft()) || check(or.getRight());
        } else if (expression instanceof Entailment) {
            Entailment entailment = (Entailment) expression;
            return checkEntailment(entailment);
        } else if (expression instanceof Not) {
            Not not = (Not) expression;
            if (check(not.getExp())) {
                return false;
            }
            for (Model child: children) {
                if (child.isActive() && child.check(not.getExp())) {
                    return false;
                }
            }
            return true;
        } else if (expression instanceof NVariable) {
            NVariable variable = (NVariable) expression;
            return world.isForced(variable);
        } else {
            throw new IllegalStateException("There is no more type of expressions");
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public World getWorld() {
        return world;
    }

    public List<Model> getChildren() {
        return children;
    }

    public int getSubtree() {
        return subtree;
    }

    public void setSubtree(int subtree) {
        this.subtree = subtree;
    }

    private void toString(StringBuilder sb, int shift) {
        for (int i = 0; i < shift; ++i) {
            sb.append(" ");
        }
        sb.append("* ");
        for (Variable<LogicExpression> variable: world.getVariables()) {
            sb.append(variable).append(" ");
        }
        sb.append("\n");
        children.stream().filter(child -> child.active).forEach(child -> child.toString(sb, shift + 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, 0);
        return sb.toString();
    }
}
