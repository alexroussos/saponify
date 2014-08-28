package com.alexroussos.saponify.resources;

import com.alexroussos.saponify.core.IngredientAmount;
import com.alexroussos.saponify.core.Recipe;
import com.alexroussos.saponify.db.IngredientDao;
import com.alexroussos.saponify.db.RecipeDao;
import com.alexroussos.saponify.views.AllRecipesView;
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

    private final IngredientDao ingredientDao;

    public RecipeResource(RecipeDao recipeDao, IngredientDao ingredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
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
    @Timed(name = "add-ingredient")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Recipe addIngredient(@PathParam("recipeId") LongParam recipeId, IngredientAmount ingredientAmount) {
        Recipe recipe = findSafely(recipeId.get());
        recipe.addIngredientAmount(ingredientAmount);
        return recipe;
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<Recipe> listRecipes() {
        return recipeDao.findAll();
    }

    @GET
    @Path("/{recipeId}/view")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public RecipeView getRecipeView(@PathParam("recipeId") LongParam recipeId) {
        return new RecipeView(findSafely(recipeId.get()), ingredientDao.findAll());
    }

    @GET
    @Path("/all/view")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public AllRecipesView getAllRecipesView() {
        return new AllRecipesView(recipeDao.findAll());
    }
}
