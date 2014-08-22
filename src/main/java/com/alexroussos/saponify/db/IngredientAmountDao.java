package com.alexroussos.saponify.db;

import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.IngredientAmount;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class IngredientAmountDao extends AbstractDAO<IngredientAmount> {
    public IngredientAmountDao(SessionFactory factory) {
        super(factory);
    }

    public List<IngredientAmount> getIngredientsInRecipe(Long recipeId) {
        return list(namedQuery("SELECT ia FROM IngredientAmount ia WHERE ia.recipe_id = :recipeId"));
    }

    public IngredientAmount create(IngredientAmount ingredientAmount) {
        return persist(ingredientAmount);
    }
}
