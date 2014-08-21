package com.alexroussos.saponify.views;

import com.alexroussos.saponify.core.Recipe;
import io.dropwizard.views.View;

public class RecipeView extends View {
    private final Recipe recipe;

    public RecipeView(Recipe recipe) {
        super("freemarker/recipe.ftl");
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}