package com.alexroussos.saponify;

import com.alexroussos.saponify.cli.RenderCommand;
import com.alexroussos.saponify.core.Ingredient;
import com.alexroussos.saponify.core.IngredientAmount;
import com.alexroussos.saponify.core.Recipe;
import com.alexroussos.saponify.core.Template;
import com.alexroussos.saponify.db.IngredientDao;
import com.alexroussos.saponify.db.RecipeDao;
import com.alexroussos.saponify.health.TemplateHealthCheck;
import com.alexroussos.saponify.resources.*;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO guice
public class SaponifyApplication extends Application<SaponifyConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaponifyConfiguration.class);

    public static void main(String[] args) throws Exception {
        new SaponifyApplication().run(args);
    }

    private final HibernateBundle<SaponifyConfiguration> recipeBundle =
            new HibernateBundle<SaponifyConfiguration>(Recipe.class, IngredientAmount.class, Ingredient.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(SaponifyConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    @Override
    public String getName() {
        return "Saponify";
    }

    @Override
    public void initialize(Bootstrap<SaponifyConfiguration> bootstrap) {
        LOGGER.info("Initializing configuration");
        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<SaponifyConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SaponifyConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(recipeBundle);
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(SaponifyConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        LOGGER.info("Starting the HelloWorld App");
        final RecipeDao recipeDao = new RecipeDao(recipeBundle.getSessionFactory());
        final IngredientDao ingredientDao = new IngredientDao(recipeBundle.getSessionFactory());
        final Template template = configuration.buildTemplate();

        environment.healthChecks().register("template", new TemplateHealthCheck(template));
        environment.jersey().register(new ViewResource());
        environment.jersey().register(new ProtectedResource());
        environment.jersey().register(new RecipeResource(recipeDao));
        environment.jersey().register(new IngredientResource(ingredientDao));

        // TODO don't enable until can put behind /admin and secure it
        // environment.servlets().addServlet("metrics-servlet", new MetricsServlet(environment.metrics())).addMapping("/metrics");
    }
}
