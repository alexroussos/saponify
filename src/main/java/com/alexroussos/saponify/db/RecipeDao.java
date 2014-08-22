package com.alexroussos.saponify.db;

import com.alexroussos.saponify.core.IngredientAmount;
import com.alexroussos.saponify.core.Recipe;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class RecipeDao extends AbstractDAO<Recipe> {
    public RecipeDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Recipe> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Recipe create(Recipe recipe) {
        return persist(recipe);
    }

    public Recipe addIngredient(long recipeId, IngredientAmount ingredientAmount) {
        Optional<Recipe> recipeOptional = findById(recipeId);
        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            recipe.addIngredientAmount(ingredientAmount);
            return persist(recipe);
        } else {
            // TODO error here
            return null;
        }
    }

    public List<Recipe> findAll() {
        return list(namedQuery("com.alexroussos.saponify.core.Recipe.findAll"));
    }
}
