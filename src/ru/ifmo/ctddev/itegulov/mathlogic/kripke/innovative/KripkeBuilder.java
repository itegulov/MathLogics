package ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative;

import ru.ifmo.ctddev.itegulov.mathlogic.kripke.ExpressionIsTrueException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;

import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public class KripkeBuilder {

    private List<Variable<LogicExpression>> variables;
    private Set<Variable<LogicExpression>>[] variableMasks;
    private LogicExpression expression;
    private Map<State, List<Model>> cache = new HashMap<>();

    public KripkeBuilder(LogicExpression expression) {
        Map<String, Variable<LogicExpression>> map = new HashMap<>();
        expression.getVariables(map);
        variables = new ArrayList<>(map.values());
        this.expression = expression;
        this.variableMasks = new Set[1 << variables.size()];
        for (int mask = 0; mask < (1 << variables.size()); mask++) {
            variableMasks[mask] = new HashSet<>();
            for (int i = 0; i < variables.size(); i++) {
                if ((mask & (1 << i)) != 0) {
                    variableMasks[mask].add(variables.get(i));
                }
            }
        }
    }


    public Model build(List<LogicExpression> mustBeTrue) throws ExpressionIsTrueException {
        int n = variables.size();
        if (n != 1) {
            throw new IllegalStateException("It can't be true");
        }
        Set<Variable<LogicExpression>> additionalVariables = new HashSet<>();
        for (LogicExpression exp: mustBeTrue) {
            Map<String, Variable<LogicExpression>> map = new HashMap<>();
            exp.getVariables(map);
            additionalVariables.addAll(map.values());
        }
        variables.forEach(additionalVariables::remove);
        List<Variable<LogicExpression>> additionalVariablesList = new ArrayList<>(additionalVariables);
        for (int maxDepth = 1; maxDepth <= 2; maxDepth++) { // It should be enough
            for (int firstWorldMask = 0; firstWorldMask < (1 << n); firstWorldMask++) {
                List<Model> models = build(firstWorldMask, 0, maxDepth);
                for (Model model: models) {
                    if (!model.check(expression)) {
                        maskLoop: for (int mask = 0; mask < (1 << additionalVariablesList.size()); mask++) {
                            Model newModel = model.clone();
                            for (int i = 0; i < additionalVariablesList.size(); i++) {
                                if ((mask & (1 << i)) != 0) {
                                    newModel.forceRecursive(additionalVariablesList.get(i));
                                }
                            }
                            for (LogicExpression exp: mustBeTrue) {
                                if (!newModel.check(exp)) {
                                    continue maskLoop;
                                }
                            }
                            return newModel;
                        }
                    }
                }
                System.out.println(firstWorldMask);
            }
        }
        throw new ExpressionIsTrueException();
    }

    private List<Model> build(int firstWorldMask, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return Collections.singletonList(new Model(new World(variableMasks[firstWorldMask])));
        }

        State state = new State(firstWorldMask, maxDepth - depth);
        if (cache.containsKey(state)) {
            return cache.get(state);
        }

        int notUsedVariablesCount = variables.size() - Integer.bitCount(firstWorldMask);

        int[] notUsedVariablesPositions = new int[notUsedVariablesCount];
        int count = 0;
        for (int i = 0; i < variables.size(); i++) {
            if ((firstWorldMask & (1 << i)) == 0) {
                notUsedVariablesPositions[count++] = i;
            }
        }

        int n = (1 << notUsedVariablesCount);

        List<Model> modelsAnswer = new ArrayList<>();
        for (int neighboursMask = 0; neighboursMask < (1 << n); neighboursMask++) { // Shows what models will be children
            List<List<Model>> children = new ArrayList<>();
            for (int vertexMask = 0; vertexMask < n; vertexMask++) { // Shows number of the neighbour and his forced variables
                if ((neighboursMask & (1 << vertexMask)) != 0) {
                    int childWorldMask = firstWorldMask;
                    for (int i = 0; i < notUsedVariablesCount; i++) {
                        if ((vertexMask & (1 << i)) != 0) {
                            childWorldMask |= (1 << notUsedVariablesPositions[i]);
                        }
                    }
                    children.add(build(childWorldMask, depth + 1, maxDepth));
                }
            }
            merge(firstWorldMask, children, new Model[children.size()], 0, modelsAnswer);
        }

        cache.put(state, modelsAnswer);
        return modelsAnswer;
    }

    private void merge(int start, List<List<Model>> children, Model[] a, int depth, List<Model> ans) {
        if (depth == a.length) {
            World root = new World(variableMasks[start]);
            for (int i = 0; i < children.size(); i++) {
                root.addChild(a[i].getRootWorld());
            }
            ans.add(new Model(root));
        } else {
            for (Model child: children.get(depth)) {
                a[depth] = child;
                merge(start, children, a, depth + 1, ans);
            }
        }
    }

    private static class State {
        private int firstWorldMask;
        private int depth;

        public State(int depth, int firstWorldMask) {
            this.depth = depth;
            this.firstWorldMask = firstWorldMask;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;

            if (firstWorldMask != state.firstWorldMask) return false;
            return depth == state.depth;
        }

        @Override
        public int hashCode() {
            int result = firstWorldMask;
            result = 31 * result + depth;
            return result;
        }
    }
}
