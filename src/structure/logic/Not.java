package structure.logic;
import structure.Expression;

import java.util.List;
import java.util.Map;

public final class Not extends UnaryOperator {
    //TODO: javadoc
    public Not(Expression exp) {
        super(exp, "!");
    }

    @Override
    protected boolean operation(boolean a) {
        return !a;
    }
    
    @Override
    public String toJavaCode() {
        return "new Not(" + exp.toJavaCode() + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Not((Expression) exp.clone());
    }

    @Override
    public Expression replaceAll(Map<Integer, Expression> replacement) {
        return new Not(exp.replaceAll(replacement));
    }

    @Override
    public boolean evaluate() {
        return !exp.evaluate();
    }

    @Override
    public List<Expression> getParticularProof(List<Expression> hypothesis) {
        List<Expression> result = super.getParticularProof(hypothesis);
        Expression a = exp;
        if (a.evaluate()) {
            result.add(new Entailment(new Entailment(new Not(a), a), new Entailment(new Entailment(new Not(a), new Not(a)), new Not(new Not(a)))));
            result.add(new Entailment(a, new Entailment(new Not(a), a)));
            result.add(a);
            result.add(new Entailment(new Not(a), a));
            result.add(new Entailment(new Entailment(new Not(a), new Not(a)), new Not(new Not(a))));
            result.add(new Entailment(new Not(a), new Entailment(new Not(a), new Not(a))));
            result.add(new Entailment(new Entailment(new Not(a), new Entailment(new Not(a), new Not(a))), new Entailment(new Entailment(new Not(a), new Entailment(new Entailment(new Not(a), new Not(a)), new Not(a))), new Entailment(new Not(a), new Not(a)))));
            result.add(new Entailment(new Entailment(new Not(a), new Entailment(new Entailment(new Not(a), new Not(a)), new Not(a))), new Entailment(new Not(a), new Not(a))));
            result.add(new Entailment(new Not(a), new Entailment(new Entailment(new Not(a), new Not(a)), new Not(a))));
            result.add(new Entailment(new Not(a), new Not(a)));
            result.add(new Not(new Not(a)));
        } else {
            result.add(new Not(a));
        }
        return result;
    }
}
