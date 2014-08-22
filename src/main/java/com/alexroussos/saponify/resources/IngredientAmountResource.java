package com.alexroussos.saponify.resources;

import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.IngredientAmount;
import com.alexroussos.saponify.db.IngredientAmountDao;
import com.alexroussos.saponify.db.IngredientDao;
import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ingredient-amount")
@Produces(MediaType.APPLICATION_JSON)
public class IngredientAmountResource {

    private final IngredientAmountDao ingredientAmountDao;

    public IngredientAmountResource(IngredientAmountDao ingredientAmountDao) {
        this.ingredientAmountDao = ingredientAmountDao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public IngredientAmount addIngredientAmount(IngredientAmount ingredientAmount) {
        // TODO recipe shouldn't have same ingredient twice
        // TODO recipe must exist fk constraint
        return ingredientAmountDao.create(ingredientAmount);
    }
}
