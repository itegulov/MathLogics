package ru.ifmo.ctddev.itegulov.structure;

import java.util.Map;

/**
 * Interface for all type of expressions, met in the math logic theories.
 * It provides general interface to work with all types of expression.
 * More information about expressions you can find in any math logic book.
 *
 * @param <E> real type of expression
 * @author  Daniyar Itegulov
 * @see LogicExpression
 * @see FormalArithmeticExpression
 */
public interface Expression<E extends Expression> extends Cloneable {
    /**
     * Checks if other expression and this expression represent absolutely the same
     * expressions.
     *
     * @param other expression, which needs to be checked on coincidence
     * @return {@code true} if other expression coincides with this, {@code false}
     * otherwise
     */
    default boolean match(Expression other) {
        return this.toString().equals(other.toString());
    }

    /**
     * Checks if other expression and this expression coincide by nodes in
     * expression-tree representation.
     *
     * @param other expression, which needs to be checked on coincidence
     * @return {@code true} if other expression coincide with this, {@code false}
     * otherwise
     */
    boolean treeMatch(Expression other);

    /**
     * Writes all variables names and some one node of all variable nodes, which have this name
     * to given {@code Map}.
     *
     * @param map map, that will consist of variable names and appropriate variable nodes
     */
    void getVariables(Map<String, Variable<E>> map);

    /**
     * Checks if other expression suits this expression. Following rules are used:
     * 1) If some type of operation was met in this expression, then
     * exactly the same type of operation must be met in other expression. And it's
     * operand must match recursively too.
     * 2) If variable was met in this expression, then any expression can be
     * met in other expression.
     * 3) For any two identical variables was met in this expression, identical
     * expressions must be met in other expression.
     *
     * @param other expression, which must match for this expression
     * @param map Map, which specifies which expression collerates with variable.
     *            You need to provide empty {@code HashMap} here.
     * @return {@code true} if other expression matches all rules, {@code false}
     * otherwise
     */
    boolean matches(E other, Map<String, E> map);

    /**
     * Generates Java code of the expression, which can be used to create absolutely the same
     * expression.
     * <p>
     * For example: {@code (new And(new Variable("a"), new Variable("b"))).toJavaCode()}
     * results to {@code "new And(new Variable("a"), new Variable("b"))"}.
     *
     * @return string interpretation of expression in Java code
     */
    String toJavaCode();

    /**
     * Finds all gaps in expression tree, which are contained in map, and replaces them
     * with appropriate expression.
     *
     * @param replacement  map, which contains what gaps you need to replace as keys
     *                     and what expression you want it is to be replaced with as value
     * @return expression, with replaced nodes
     */
    E replaceAll(Map<Integer, E> replacement);

    /**
     * Converts expression to human-readable string. Writes result to {@code sb}.
     *
     * @param sb string builder, that will contain result
     */
    void asString(StringBuilder sb);

    Object clone() throws CloneNotSupportedException;
}
