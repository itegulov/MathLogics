package ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative;

import ru.ifmo.ctddev.itegulov.mathlogic.kripke.ExpressionIsTrueException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.PVariable;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.purelogic.*;

import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public class InnovativeKripkeBuilder {

    private List<Variable<LogicExpression>> additionalVars(LogicExpression expression, List<LogicExpression> mustBeTrue) {
        Map<String, Variable<LogicExpression>> map = new HashMap<>();
        expression.getVariables(map);
        List<Variable<LogicExpression>> variables = new ArrayList<>(map.values());

        Set<Variable<LogicExpression>> additionalVariables = new HashSet<>();
        for (LogicExpression exp: mustBeTrue) {
            Map<String, Variable<LogicExpression>> m = new HashMap<>();
            exp.getVariables(m);
            additionalVariables.addAll(m.values());
        }
        variables.forEach(additionalVariables::remove);
        return new ArrayList<>(additionalVariables);
    }

    public Model build(LogicExpression expression, List<LogicExpression> mustBeTrue) {
        Map<String, Variable<LogicExpression>> map = new HashMap<>();
        expression.getVariables(map);
        List<Variable<LogicExpression>> variables = new ArrayList<>(map.values());

        if (variables.size() <= 1) {
            try {
                return new KripkeBuilder(expression).build(mustBeTrue);
            } catch (ExpressionIsTrueException e) {
                return null;
            }
        }

        if (expression instanceof Or) {
            Or or = (Or) expression;
            Model left = build(or.getLeft(), mustBeTrue);
            Model right = build(or.getRight(), mustBeTrue);
            if (left == null || right == null) {
                return null;
            }
            List<Variable<LogicExpression>> additionalVariables = additionalVars(expression, mustBeTrue);

            World rootWorld = new World(Collections.emptyList());
            rootWorld.addChild(left.getRootWorld());
            rootWorld.addChild(right.getRootWorld());

            maskLoop: for (int mask = 0; mask < (1 << additionalVariables.size()); mask++) {
                World newRootWorld = rootWorld.clone();
                for (int i = 0; i < additionalVariables.size(); i++) {
                    if ((mask & (1 << i)) != 0) {
                        newRootWorld.forceRecursive(additionalVariables.get(i));
                    }
                }
                if (newRootWorld.check(expression)) {
                    continue;
                }
                for (LogicExpression exp: mustBeTrue) {
                    if (!newRootWorld.check(exp)) {
                        continue maskLoop;
                    }
                }
                return new Model(newRootWorld);
            }
        } else if (expression instanceof And) {
            And and = (And) expression;
            Model left = build(and.getLeft(), mustBeTrue);
            Model right = build(and.getRight(), mustBeTrue);
            if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            } else {
                return null;
            }
        } else if (expression instanceof Entailment) {
            Entailment entailment = (Entailment) expression;
            List<LogicExpression> newMustBeTrue = new ArrayList<>(mustBeTrue);
            newMustBeTrue.add(entailment.getLeft());
            return build(entailment.getRight(), newMustBeTrue);
        } else if (expression instanceof Not) {
            Not not = (Not) expression;
            List<LogicExpression> newMustBeTrue = new ArrayList<>(mustBeTrue);
            newMustBeTrue.add(not.getExp());
            return build(new Or(new NVariable("∫"), new Not(new NVariable("∫"))), newMustBeTrue);
        } else if (expression instanceof NVariable) {
            return new Model(new World(Collections.emptySet()));
        } else {
            throw new IllegalStateException("Unknown type of LogicExpression");
        }
        return null;
    }
}
