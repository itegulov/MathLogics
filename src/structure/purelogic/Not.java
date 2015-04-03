package structure.purelogic;
import structure.LogicExpression;

import java.util.List;
import java.util.Map;

public final class Not extends UnaryOperator {
    //TODO: javadoc
    public Not(LogicExpression exp) {
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
        return new Not((LogicExpression) exp.clone());
    }

    @Override
    public LogicExpression replaceAll(Map<Integer, LogicExpression> replacement) {
        return new Not(exp.replaceAll(replacement));
    }

    @Override
    public boolean evaluate() {
        return !exp.evaluate();
    }

    @Override
    public List<LogicExpression> getParticularProof(List<LogicExpression> hypothesis) {
        List<LogicExpression> result = super.getParticularProof(hypothesis);
        LogicExpression a = exp;
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
