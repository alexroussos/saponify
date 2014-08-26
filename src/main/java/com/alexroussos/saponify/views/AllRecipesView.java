package com.alexroussos.saponify.views;

import com.alexroussos.saponify.core.Recipe;
import io.dropwizard.views.View;

import java.util.List;

public class AllRecipesView extends View {
    private final List<Recipe> recipes;

    public AllRecipesView(List<Recipe> recipes) {
        super("freemarker/all-recipes.ftl");
        this.recipes = recipes;
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }
}