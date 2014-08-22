package com.alexroussos.saponify.resources;

import com.alexroussos.saponify.core.IngredientAmount;
import com.alexroussos.saponify.core.Recipe;
import com.alexroussos.saponify.db.RecipeDao;
import com.alexroussos.saponify.views.RecipeView;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {

    private final RecipeDao recipeDao;

    public RecipeResource(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GET
    @Path("/{recipeId}")
    @Timed(name = "get-recipe")
    @UnitOfWork
    public Recipe getRecipe(@PathParam("recipeId") LongParam recipeId) {
        return findSafely(recipeId.get());
    }

    private Recipe findSafely(long recipeId) {
        final Optional<Recipe> recipe = recipeDao.findById(recipeId);
        if (!recipe.isPresent()) {
            throw new NotFoundException("No such recipe");
        }
        return recipe.get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Recipe createRecipe(Recipe recipe) {
        return recipeDao.create(recipe);
    }

    @POST
    @Path("/{recipeId}/addIngredient")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addIngredient(@PathParam("recipeId") LongParam recipeId, IngredientAmount ingredientAmount) {
        recipeDao.addIngredient(recipeId.get(), ingredientAmount);
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<Recipe> listRecipes() {
        return recipeDao.findAll();
    }

    @GET
    @Path("/{recipeId}/view_freemarker")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public RecipeView getRecipeViewFreemarker(@PathParam("recipeId") LongParam recipeId) {
        return new RecipeView(findSafely(recipeId.get()));
    }
}
