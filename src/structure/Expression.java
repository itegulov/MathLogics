package structure;

import java.util.Map;

/**
 * Interface for all type of expressions, met in the math logic theories.
 * It provides easy way to work with them.
 *
 * @author  Daniyar Itegulov
 */
public interface Expression<E extends Expression> extends Cloneable {
    /**
     * Checks if other expression and this expression represent expressions, which coincide
     * character by character in string representation
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression coincide with this
     */
    boolean match(Expression other);

    /**
     * Checks if other expression and this expression represent expressions, which coincide
     * by nodes in expression-tree representation
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression coincide with this
     */
    boolean treeMatch(Expression other);

    /**
     * Checks if other expression and this expression has same exactly the same type
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression's and this expression's types
     *                  coincide
     */
    boolean hasSameType(Expression other);

    /**
     * Writes all variables names and some one node of all variable nodes, which have this name
     * to given {@code Map}.
     * @param map map, that will consist of variable names and appropriate variable nodes
     */
    void getVariables(Map<String, Variable<E>> map);

    /**
     * Generates Java code of the expression, which can be used for testing
     * or something else.
     * <p>
     * For example: <code>(new And(new Variable("a"), new Variable("b"))).toJavaCode()</code>
     * results to <code>"new And(new Variable("a"), new Variable("b"))"</code>
     * @return          interpretation of expression if Java code
     */
    String toJavaCode();

    /**
     * Checks if other expression suits this expression. Following rules are used:
     * 1) If some operation (binary or unary) was met in this structure.expression, then
     * the same type of expression must be met in other expression.
     * 2) If variable was met in this expression, then any expression can be
     * met in other expression.
     * 3) For any two identical variables in this expression, identical expression must
     * be met in other expression.
     * @param other     expression, which must be suitable for this expression
     * @param map       map, which specifies which expression collerates with variable
     * @return          <code>true</code> if other expression matches all rules
     */
    boolean matches(Expression other, Map<String, Expression> map);

    /**
     * Finds all gaps in expression tree, which are contained in map, and replaces them
     * with appropriate expression
     *
     * @param replacement   map, which contains what gaps you need to replace and what
     *                      expression you want it is to be replaced with
     * @return              expression, with replaced nodes
     */
    E replaceAll(Map<Integer, E> replacement);

    /**
     * Converts expression to human-readable string. Writes result to {@code sb}
     * @param sb string builder, that will contain result
     */
    void asString(StringBuilder sb);

    Object clone() throws CloneNotSupportedException;
}
