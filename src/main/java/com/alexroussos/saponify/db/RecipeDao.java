package com.alexroussos.saponify.db;

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

    public List<Recipe> findAll() {
        return list(namedQuery("com.alexroussos.saponify.core.Recipe.findAll"));
    }
}
