package structure.predicate;

import com.sun.istack.internal.NotNull;
import structure.AbstractExpression;
import structure.Expression;
import structure.logic.Variable;

import java.util.List;
import java.util.Map;

public class Term extends AbstractExpression {
    private String name;
    private Term[] arguments;

    public Term(String name) {
        this.name = name;
        arguments = new Term[0];
    }

    public Term(String name, Term... arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public Term[] getArguments() {
        return arguments;
    }

    @Override
    public boolean evaluate(@NotNull Map<String, Boolean> args) {
        throw new IllegalStateException("cannot evaluate predicates");
    }

    @Override
    public boolean evaluate() {
        throw new IllegalStateException("cannot evaluate predicates");
    }

    @Override
    public boolean treeMatch(@NotNull Expression other) {
        if (hasSameType(other)) {
            Term otherTerm = (Term) other;
            if (name.equals(otherTerm.name) && arguments.length == otherTerm.arguments.length) {
                for (int i = 0; i < arguments.length; i++) {
                    if (!arguments[i].treeMatch(otherTerm.arguments[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Variable> getVariables() {
        throw new IllegalStateException("predicates don't contain variables");
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder("new Term(").append("\"").append(name).append("\"");
        for (Term argument : arguments) {
            sb.append(",").append(argument.toJavaCode());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean matches(@NotNull Expression other, @NotNull Map<String, Expression> map) {
        throw new IllegalStateException("predicates can't be matched");
    }

    @Override
    public StringBuilder asString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (arguments.length != 0) {
            sb.append("(");
            for (int i = 0; i < arguments.length; i++) {
                sb.append(arguments[i].asString()).append(i == arguments.length - 1 ? "" : ",");
            }
            sb.append(")");
        }
        return sb;
    }

    @Override
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        throw new IllegalStateException("predicates can't be replaced");
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        throw new IllegalStateException("can't proof predicates");
    }
}
