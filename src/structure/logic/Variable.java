package structure.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structure.AbstractExpression;
import structure.Expression;

public final class Variable extends AbstractExpression {
    private String name;
    private Boolean currentValue;

    public Variable(String name) {
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
        return hasSameType(other) && (name != null && ((Variable) other).name.equals(name));
    }

    @Override
    public Map<String, Variable> getVariables() {
        Map<String, Variable> map = new HashMap<>();
        map.put(name, this);
        return map;
    }

    @Override
    public boolean matches(Expression other, Map<String, Expression> map) {
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
        Variable variable = (Variable) o;
        return variable.name.equals(name);
    }

    @Override
    public StringBuilder asString() {
        return new StringBuilder(name);
    }

    @Override
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        try {
            return (Expression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toJavaCode() {
        return "new Variable(\"" + name + "\")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Variable(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        boolean f = false;
        List<Expression> list = new ArrayList<>();
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
    public boolean evaluate() {
        if (currentValue == null) {
            throw new IllegalStateException("variable doesn't have a value: " + name);
        }
        return currentValue;
    }
}
