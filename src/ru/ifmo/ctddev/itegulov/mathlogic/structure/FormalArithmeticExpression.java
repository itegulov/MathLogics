package ru.ifmo.ctddev.itegulov.mathlogic.structure;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.TreeMismatchException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;

import java.util.Map;
import java.util.Set;

/**
 * @author Daniyar Itegulov
 */
public interface FormalArithmeticExpression extends Expression<FormalArithmeticExpression> {

    /**
     * Gets set of free variables in expression
     * @param set set, that will consist of free variable names
     */
    Set<String> getFreeVars(Set<String> set);

    /**
     * Travels through expression tree and writes all quantifiers to set
     * @param quantifiers   set, in which quantifiers will be written
     */
    void setQuantifiers(Set<String> quantifiers);

    /**
     * Gets count variables free occurrences count
     * @param variableName  name of the variable to check
     * @return              count of free occurrences
     */
    int markFreeVariableOccurrences(String variableName);

    /**
     * Finds all gaps in expression tree, which are contained in map, and replaces them
     * with appropriate expression
     *
     * @param replacement   map, which contains what gaps you need to replace and what
     *                      expression you want it is to be replaced with
     * @return              expression, with replaced nodes
     */
    FormalArithmeticExpression replaceAll(Map<Integer, FormalArithmeticExpression> replacement);

    Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException;
}
