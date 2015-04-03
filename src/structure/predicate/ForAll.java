package structure.predicate;

import structure.Expression;
import structure.FormalArithmeticExpression;

import java.util.Map;

public final class ForAll extends Quantifier {
    public ForAll(Term variable, FormalArithmeticExpression exp) {
        super(variable, exp, "@");
    }

    @Override
    public boolean treeMatch(Expression other) {
        return hasSameType(other)
                && variable.treeMatch(((ForAll) other).variable)
                && exp.treeMatch(((ForAll) other).exp);
    }

    @Override
    public String toJavaCode() {
        return "new ForAll(" + variable.toJavaCode() + "," + exp.toJavaCode() + ")";
    }

    @Override
    public FormalArithmeticExpression replaceAll(final Map<Integer, FormalArithmeticExpression> replacement) {
        return new ForAll((Term) variable.replaceAll(replacement), exp.replaceAll(replacement));
    }
}
