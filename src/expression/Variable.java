package expression;

import java.util.Map;

public final class Variable implements Expression {
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
    public boolean equals(Object obj) {
        return obj instanceof Variable && ((Variable) obj).name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String toString(int priority) {
        return name;
    }

    @Override
    public String toJavaCode() {
        return "new Variable(\"" + name + "\")";
    }

    @Override
    public final int hashCode() {
        return name.hashCode();
    }
}
