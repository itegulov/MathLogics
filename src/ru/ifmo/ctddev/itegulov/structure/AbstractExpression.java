package ru.ifmo.ctddev.itegulov.structure;

/**
 * @author Daniyar Itegulov
 */
public abstract class AbstractExpression<E extends Expression> implements Expression<E> {
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
        return obj instanceof Expression
                && ((Expression) obj).treeMatch(this);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
