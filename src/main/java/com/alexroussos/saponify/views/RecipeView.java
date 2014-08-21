package com.alexroussos.saponify.views;

import com.alexroussos.saponify.core.Recipe;
import io.dropwizard.views.View;

public class RecipeView extends View {
    private final Recipe recipe;
    public enum Template{
    	FREEMARKER("freemarker/recipe.ftl"),
    	MUSTACHE("mustache/recipe.mustache");

    	private String templateName;
    	private Template(String templateName){
    		this.templateName = templateName;
    	}

    	public String getTemplateName(){
    		return templateName;
    	}
    }

    public RecipeView(RecipeView.Template template, Recipe recipe) {
        super(template.getTemplateName());
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}