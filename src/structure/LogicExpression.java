package structure;

import java.util.List;
import java.util.Map;

/**
 * @author Daniyar Itegulov
 */
public interface LogicExpression extends FormalArithmeticExpression {
    /**
     * Returns the result of evaluating the expression. Variable values must be
     * specified in {@link java.util.Map}. Throws {@link java.lang.IllegalArgumentException}
     * if some variables value hasn't been specified.
     * @param args      a Map, which specifies what values were given to variables
     * @return          result of evaluating the expression
     */
    boolean evaluate(Map<String, Boolean> args);

    /**
     * Evaluate using known information (works only in particular cases, for example
     * after assigning all variables in expression some value through setCurrentValue
     * @return          result of evaluating the expression
     */
    boolean evaluate();

    /**
     * Finds all nodes in expression tree, which contained in map and replaces them with
     * appropriate new expression
     *
     * @param replacement   map, which contains what expression you need to replace and what
     *                      expression you want it is to be replaced with
     * @return              expression, with replaced nodes
     */
    @Override
    Expression replaceAll(Map<Integer, Expression> replacement);

    /**
     * Proofs this expression in assumption with hypothesis
     * @param hypothesis    assumption list
     * @return              list of expression which contains proof of this expression
     */
    List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis);
}
