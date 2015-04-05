package ru.ifmo.ctddev.itegulov.mathlogic.proof;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

import java.util.Map;

/**
 * Class, representing one unit (statement) in {@link Proof}.
 * <p>
 * Provides several methods for getting {@link Expression},
 * contained in this statement, line on which this statement is
 * stationed and what {@link StatementType} of statement is it.
 *
 * @param <E> type of expressions, which statement contains
 */
public final class Statement<E extends Expression<E>> {
    private E exp;
    private StatementType<E> type;
    private int line;

    /**
     * Constructor, which instantiate a statement, containing
     * {@code exp} as it's expression, {@code type} as it's type
     * and {@code line} as line, on which it's stationed.
     *
     * @param exp expression, contained in this statement
     * @param type statement type of new statement
     * @param line number of line
     */
    public Statement(E exp, StatementType<E> type, int line) {
        this.exp = exp;
        this.type = type;
        this.line = line;
    }

    /**
     * @return expression, contained in this statement
     */
    public E getExp() {
        return exp;
    }

    /**
     * @return statement type of this statement
     */
    public StatementType<E> getType() {
        return type;
    }

    /**
     * @return number of line, on which statement is stationed
     */
    public int getLine() {
        return line;
    }

    /**
     * Sets this statement's type to specified.
     *
     * @param type new statement type for this
     *             statement
     */
    public void setType(StatementType<E> type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (exp != null) {
            return exp.equals(statement.exp);
        } else {
            return statement.exp == null;
        }
    }

    @Override
    public int hashCode() {
        return exp != null ? exp.hashCode() : 23498;
    }

    @Override
    public String toString() {
        if (exp == null) {
            return type.toString();
        }
        return "(" + line + ") " + exp.toString() + " (" + type.toString() + ")";
    }

    public String toSimpleString() {
        return exp.toString();
    }

    /**
     * Finds all {@link ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.Gap}
     * in expression tree of contained expression, which are contained in map, and
     * replaces them with appropriate expression.
     *
     * @param replacement map, which contains what gaps you need to replace as keys
     *                    and what expression you want it is to be replaced with as value
     * @return new statement, representing almost the same expression, but with replaced
     * gaps
     * @see Expression#replaceAll(Map)
     */
    public Statement<E> replaceAll(Map<Integer, E> replacement) {
        return new Statement<>(exp.replaceAll(replacement), type, line);
    }

    public void setLine(int line) {
        this.line = line;
    }
}
