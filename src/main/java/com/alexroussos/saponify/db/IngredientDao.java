package com.alexroussos.saponify.db;

import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.Recipe;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class IngredientDao extends AbstractDAO<Ingredient> {
    public IngredientDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Ingredient> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Ingredient create(Ingredient ingredient) {
        return persist(ingredient);
    }

    public List<Ingredient> findAll() {
        return list(namedQuery("com.alexroussos.saponify.core.Ingredient.findAll"));
    }
}
