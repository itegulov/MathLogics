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
    private LogicExpression expression;
    private Map<State, Set<Model>> cache = new HashMap<>();

    public KripkeBuilder(LogicExpression expression) {
        Map<String, Variable<LogicExpression>> map = new HashMap<>();
        expression.getVariables(map);
        variables = new ArrayList<>(map.values());
        this.expression = expression;
    }


    public Model build() throws ExpressionIsTrueException {
        int n = variables.size();
        for (int maxDepth = 1; maxDepth <= variables.size() * 2; maxDepth++) { // It should be enough
            for (int firstWorldMask = 0; firstWorldMask < (1 << n); firstWorldMask++) {
                Set<Model> models = build(firstWorldMask, 0, maxDepth);
                for (Model model: models) {
                    if (!model.check(expression)) {
                        return model;
                    }
                }
                System.out.println(firstWorldMask);
            }
        }
        throw new ExpressionIsTrueException();
    }

    private Set<Model> build(int firstWorldMask, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return Collections.singleton(new Model(new World(firstWorldMask, variables)));
        }

        State state = new State(firstWorldMask, depth);
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

        Set<Model> modelsAnswer = new HashSet<>();
        for (int neighboursMask = 0; neighboursMask < (1 << n); neighboursMask++) { // Shows what models will be children
            List<Set<Model>> children = new ArrayList<>();
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

    private void merge(int start, List<Set<Model>> children, Model[] a, int depth, Set<Model> ans) {
        if (depth == a.length) {
            World root = new World(start, variables);
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
