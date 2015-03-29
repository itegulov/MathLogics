package structure.predicate;

import structure.Expression;
import structure.FormalArithmeticExpression;

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
}
