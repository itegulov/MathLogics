package expression;

import com.sun.istack.internal.NotNull;

import java.util.Map;

/**
 * Expression is the interface for all type of expressions met in the math logics.
 * Expressions can be evaluated, generate Java code, be converted to string,
 * matched with other expression.
 * @author  Daniar Itegulov
 * @since %I% %G%
 * @version 1.1
 */
public interface Expression {
    /**
     * Returns the result of evaluating the expression. Variable values must be
     * specified in {@link java.util.Map}. Throws {@link java.lang.IllegalArgumentException}
     * if some variables value hasn't been specified.
     * @param args      a Map, which specifies what values were given to variables
     * @return          result of evaluating the expression
    */
    public boolean evaluate(@NotNull Map<String, Boolean> args);

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
     * 1) If some operation (binary or unary) was met in this expression, then
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
     * Converts expression to human-read string. Priority is used to specify
     * priority of operation, which stands right above current expression
     * @param priority  priority of operation above
     * @return          human-read string interpretation of expression
     */
    public String toString(int priority);
}
