package structure;

import com.sun.istack.internal.NotNull;

import structure.logic.Variable;

import java.util.List;
import java.util.Map;

/**
 * Expression is the interface for all type of expressions met in the math logics.
 * Expressions can be evaluated, generate Java code, can be converted to string,
 * matched with other expressions.
 * @author  Daniyar Itegulov
 * @since %I% %G%
 * @version 1.2
 */
public interface Expression extends Cloneable {
    /**
     * Returns the result of evaluating the expression. Variable values must be
     * specified in {@link java.util.Map}. Throws {@link java.lang.IllegalArgumentException}
     * if some variables value hasn't been specified.
     * @param args      a Map, which specifies what values were given to variables
     * @return          result of evaluating the expression
    */
    boolean evaluate(@NotNull Map<String, Boolean> args);

    /**
     * Evaluate using known information (works only in particular cases, for example
     * after assigning all variables in expression some value through setCurrentValue
     * @return          result of evaluating the expression
     */
    boolean evaluate();

    /**
     * Checks if other expression and this expression represent expressions, which coincide
     * character by character in string representation
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression coincide with this
     */
    boolean match(@NotNull Expression other);

    /**
     * Checks if other expression and this expression represent expressions, which coincide
     * by nodes in expression-tree representation
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression coincide with this
     */
    boolean treeMatch(@NotNull Expression other);

    /**
     * Checks if other expression and this expression has same exactly the same type
     * @param other     expression, which needs, to be checked
     * @return          <code>true</code> if other expression's and this expression's types
     *                  coincide
     */
    boolean hasSameType(@NotNull Expression other);

    /**
     * Returns all variables names and some one node of all variable nodes, which have this name
     * @return map, consisting of variable names and appropriate variable nodes
     */
    Map<String, Variable> getVariables();

    /**
     * Generates Java code of the expression, which can be used for testing
     * or something else.
     * <p>
     * For example: <code>(new And(new Variable("a"), new Variable("b"))).toJavaCode()</code>
     * results to <code>"new And(new Variable("a"), new Variable("b"))"</code>
     * @return          interpretation of expression if Java code
     */
    public String toJavaCode();

    /**
     * Checks if this expression is binary
     * @return          <code>true</code> if this expression is binary and false otherwise
     */
    public boolean isBinary();

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
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map);

    /**
     * Converts expression to human-readable string
     * @return          human-readable string interpretation of expression
     */
    public StringBuilder asString();

    /**
     * Finds all nodes in expression tree, which contained in map and replaces them with
     * appropriate new expression
     * @param replacement   map, which contains what expression you need to replace and what
     *                      expression you want it is to be replaced with
     * @return
     */
    Expression replaceAll(Map<Integer, Expression> replacement);

    /**
     *
     * @param hypothesis
     * @return
     */
    List<Expression> getParticularProof(List<Expression> hypothesis);

    Object clone() throws CloneNotSupportedException;
}
