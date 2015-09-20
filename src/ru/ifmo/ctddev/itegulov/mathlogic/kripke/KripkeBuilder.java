package ru.ifmo.ctddev.itegulov.mathlogic.kripke;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Variable;

import java.util.*;

/**
 * @author Daniyar Itegulov
 */
public class KripkeBuilder {

    private static KripkeBuilder ourInstance = new KripkeBuilder();

    // No instances for you
    private KripkeBuilder() {
    }

    public static KripkeBuilder getInstance() {
        return ourInstance;
    }

    public Model findModel(LogicExpression expression) throws ExpressionIsTrueException {
        List<World> worlds = generateWorlds(expression);
        Model model = new Model(worlds.get(0));
        List<Model> allModels = generateModel(model, worlds, new ArrayList<>());
        if (checkAllModels(expression, 0, allModels, model)) {
            throw new ExpressionIsTrueException("Формула общезначима");
        } else {
            return model;
        }
    }

    private boolean checkAllModels(LogicExpression expr, int index, List<Model> allModels, Model mainModel) {
        Model model = allModels.get(index);

        if (model == allModels.get(allModels.size() - 1)) {
            model.setActive(true);
            if (!mainModel.check(expr)) {
                return false;
            }
            model.setActive(false);
            return mainModel.check(expr);
        }

        model.setActive(false);
        int next = index + 1;
        if (model.getSubtree() != 0) {
            next = index + model.getSubtree();
        }

        if (!checkAllModels(expr, next, allModels, mainModel)) {
            return false;
        }

        model.setActive(true);
        return checkAllModels(expr, index + 1, allModels, mainModel);

    }

    private List<World> generateWorlds(LogicExpression expression) {
        Map<String, Variable<LogicExpression>> map = new HashMap<>();
        expression.getVariables(map);
        List<Variable<LogicExpression>> variables = new ArrayList<>(map.values());
        List<World> worlds = new ArrayList<>();
        for (long i = 0; i < (1 << variables.size()); ++i) {
            World world = new World();
            for (int j = 0; j < variables.size(); ++j) {
                if ((i & (1 << j)) != 0) {
                    world.forceVariable(variables.get(j));
                }
            }
            worlds.add(world);
        }
        return worlds;
    }

    private List<Model> generateModel(Model model, List<World> worlds, List<Model> allModels) {
        worlds.stream().filter(world -> model.getWorld().isLesserSubset(world)).forEach(world -> {
            model.addChild(world);
            Model toAdd = model.getChildren().get(model.getChildren().size() - 1);
            allModels.add(toAdd);
            generateModel(toAdd, worlds, allModels);
            model.setSubtree(model.getSubtree() + toAdd.getSubtree() + 1);
        });
        return allModels;
    }
}
