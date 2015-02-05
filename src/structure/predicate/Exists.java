package structure.predicate;

import com.sun.istack.internal.NotNull;
import structure.Expression;
import structure.logic.Variable;

public final class Exists extends Quantifier {
    public Exists(Term variable, Expression exp) {
        super(variable, exp, "?");
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        return hasSameType(other)
                && variable.treeMatch(((Exists) other).variable)
                && exp.treeMatch(((Exists) other).exp);
    }

    @Override
    public String toJavaCode() {
        return "new Exists(" + variable.toJavaCode() + "," + exp.toJavaCode() + ")";
    }
}
