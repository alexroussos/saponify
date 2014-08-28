package com.alexroussos.saponify.views;

import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.Recipe;
import io.dropwizard.views.View;

import java.util.List;

public class RecipeView extends View {
    private final Recipe recipe;
    private final List<Ingredient> ingredients;

    public RecipeView(Recipe recipe, List<Ingredient> ingredients) {
        super("freemarker/recipe.ftl");
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public List<Ingredient> getIngredients() { return ingredients; }
}