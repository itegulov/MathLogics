package structure.predicate;

import com.sun.istack.internal.NotNull;
import structure.Expression;
import structure.logic.Variable;

public final class ForAll extends Quantifier {
    public ForAll(Term variable, Expression exp) {
        super(variable, exp, "@");
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        return hasSameType(other)
                && variable.treeMatch(((ForAll) other).variable)
                && exp.treeMatch(((ForAll) other).exp);
    }

    @Override
    public String toJavaCode() {
        return "new ForAll(" + variable.toJavaCode() + "," + exp.toJavaCode() + ")";
    }
}
