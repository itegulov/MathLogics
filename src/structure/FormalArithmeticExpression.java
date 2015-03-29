package structure;

import exceptions.TreeMismatchException;
import javafx.util.Pair;
import structure.predicate.Term;

import java.util.Set;

/**
 * @author Daniyar Itegulov
 */
public interface FormalArithmeticExpression extends Expression {

    /**
     * Gets set of free variables in expression
     * @return          set consisting of free variable names
     */
    Set<String> getFreeVars();

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

    Set<Pair<Term, Term>> getReplacedVariableOccurrences(Expression originalExpr) throws TreeMismatchException;
}
