package ru.ifmo.ctddev.itegulov.structure;

public abstract class AbstractLogicExpression implements LogicExpression {
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        asString(sb);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractLogicExpression
                && ((AbstractLogicExpression) obj).treeMatch(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
