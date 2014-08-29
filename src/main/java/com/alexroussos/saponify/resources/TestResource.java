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
import freemarker.template.*;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Little bits of throwaway code for testing out different ways of doing things.
 */
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    private final RecipeDao recipeDao;

    private final IngredientDao ingredientDao;

    private Configuration configuration;

    public TestResource(RecipeDao recipeDao, IngredientDao ingredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;

        configuration = new Configuration();

        configuration.setClassForTemplateLoading(RecipeView.class, "/com/alexroussos/saponify/views/");

        configuration.setIncompatibleImprovements(new Version(2, 3, 20)); // Newer version, don't need backwards compatibility
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * Manually generate the HTML for a freemarker template
     */
    @GET
    @Path("/manual-render")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public String renderTemplate() throws IOException, TemplateException { // TODO don't throw if using for real

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "My Test 123");
        input.put("point", new Point(4,-5));

        Template template = configuration.getTemplate("freemarker/test.ftl");

        Writer writer = new StringWriter();
        template.process(input, writer);

        return writer.toString();
    }
}
