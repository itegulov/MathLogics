package structure.purelogic;

import com.sun.istack.internal.NotNull;
import structure.AbstractLogicExpression;
import structure.Expression;
import structure.LogicExpression;
import structure.Variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Gap extends AbstractLogicExpression {
    private int num;

    public Gap(int num) {
        this.num = num;
    }

    @Override
    public boolean evaluate(@NotNull Map<String, Boolean> args) {
        throw new IllegalStateException("cannot evaluate expression, where gaps are left");
    }

    @Override
    public boolean evaluate() {
        throw new IllegalStateException("cannot evaluate expression, where gaps are left");
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        return true;
    }

    @Override
    public Map<String, Variable<LogicExpression>> getVariables() {
        return new HashMap<>();
    }

    @Override
    public String toJavaCode() {
        return "new Gap(" + num + ")";
    }

    @Override
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map) {
        return true;
    }

    @Override
    public StringBuilder asString() {
        return new StringBuilder(Integer.toString(num));
    }

    @Override
    public LogicExpression replaceAll(Map<Integer, LogicExpression> replacement) {
        if (replacement.containsKey(num)) {
            return replacement.get(num);
        }
        try {
            return (LogicExpression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        throw new IllegalStateException("cannot get particular proofs on expressions with gaps");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Gap(num);
    }
}
