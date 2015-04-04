package ru.ifmo.ctddev.itegulov.structure.purelogic;

import ru.ifmo.ctddev.itegulov.structure.AbstractLogicExpression;
import ru.ifmo.ctddev.itegulov.structure.Expression;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.structure.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NVariable extends AbstractLogicExpression implements Variable<LogicExpression> {
    private String name;
    private Boolean currentValue;

    public NVariable(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(Map<String, Boolean> args) {
        if (!args.containsKey(name)) {
            throw new IllegalArgumentException("No such variable");
        }
        return args.get(name);
    }

    @Override
    public boolean treeMatch(Expression other) {
        return other.getClass() == getClass() && (name != null && ((NVariable) other).name.equals(name));
    }

    @Override
    public void getVariables(Map<String, Variable<LogicExpression>> map) {
        map.put(name, this);
    }

    @Override
    public boolean matches(LogicExpression other, Map<String, LogicExpression> map) {
        if (map.containsKey(name)) {
            return other.equals(map.get(name));
        }
        map.put(name, other);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NVariable variable = (NVariable) o;
        return variable.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public void asString(StringBuilder sb) {
        sb.append(name);
    }

    @Override
    public List<LogicExpression> getParticularProof(final List<LogicExpression> hypothesis) {
        boolean f = false;
        List<LogicExpression> list = new ArrayList<>();
        if (hypothesis.contains(this)) {
            currentValue = true;
            if (!list.contains(this)) list.add(this);
            f = true;
        }
        if (!f && hypothesis.contains(new Not(this))) {
            currentValue = false;
            if (!list.contains(new Not(this))) list.add(new Not(this));
            f = true;
        }
        if (!f) {
            throw new IllegalArgumentException("no such variable in hypothesis: " + name);
        }
        return list;
    }

    @Override
    public String toJavaCode() {
        return "new Variable(\"" + name + "\")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new NVariable(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean evaluate() {
        if (currentValue == null) {
            throw new IllegalStateException("variable doesn't have a value: " + name);
        }
        return currentValue;
    }

    @Override
    public LogicExpression replaceAll(final Map<Integer, LogicExpression> replacement) {
        try {
            return (LogicExpression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
