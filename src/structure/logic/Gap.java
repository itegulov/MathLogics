package structure.logic;

import com.sun.istack.internal.NotNull;
import structure.AbstractExpression;
import structure.Expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gap extends AbstractExpression {
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
    public Map<String, Variable> getVariables() {
        return new HashMap<>();
    }

    @Override
    public String toJavaCode() {
        return "new Gap(" + num + ")";
    }

    @Override
    public boolean isBinary() {
        return false;
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
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        if (replacement.containsKey(num)) {
            return replacement.get(num);
        }
        try {
            return (Expression) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        throw new IllegalStateException("cannot get particular proofs on expressions with gaps");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Gap(num);
    }
}
