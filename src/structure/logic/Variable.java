package structure.logic;

import java.util.HashMap;
import java.util.Map;

import structure.AbstractExpression;
import structure.Expression;

public final class Variable extends AbstractExpression {
    private String name;

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
    public boolean isBinary() {
        return false;
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
    public Expression replaceAll(Map<Expression, Expression> replacement) {
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
}
