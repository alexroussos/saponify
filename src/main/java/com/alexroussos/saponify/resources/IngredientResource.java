package com.alexroussos.saponify.resources;

import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.Recipe;
import com.alexroussos.saponify.db.IngredientDao;
import com.alexroussos.saponify.db.RecipeDao;
import com.alexroussos.saponify.views.RecipeView;
import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ingredient")
@Produces(MediaType.APPLICATION_JSON)
public class IngredientResource {

    private final IngredientDao ingredientDao;

    public IngredientResource(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @GET
    @Path("/{ingredientId}")
    @UnitOfWork
    public Ingredient getIngredient(@PathParam("ingredientId") LongParam ingredientId) {
        return findSafely(ingredientId.get());
    }

    private Ingredient findSafely(long ingredientId) {
        final Optional<Ingredient> ingredient = ingredientDao.findById(ingredientId);
        if (!ingredient.isPresent()) {
            throw new NotFoundException("No such ingredient");
        }
        return ingredient.get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientDao.create(ingredient);
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<Ingredient> listIngredients() {
        return ingredientDao.findAll();
    }
}
