<#-- @ftlvariable name="" type="com.example.views.RecipeView" -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="description" content="Calculates soap recipes and predicts properties based on types of fats and oils.">
        <meta name="keywords" content="soap, recipe, calculator, fat, oil, lye, saponification">
        <meta name="author" content="Alex Roussos">
        <title>Saponify</title>
        <link href="../../assets/css/bootstrap.min.css" type="text/css" rel="stylesheet" >
        <link href="../../assets/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet" >
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../../assets/css/recipe.css" type="text/css" rel="stylesheet" >
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/recipe.js"></script>
    </head>
    <body>
        <!-- calls getRecipe().getName() and sanitizes it -->
        <h1>Recipe Name: ${recipe.name?html}</h1>
        <ul>
        <#list recipe.ingredientAmount as ingredient>
            <li>Ingredient ${ingredient.ingredient.name?html}: ${ingredient.amountGrams?html} g</li>
        </#list>
        <ul>

        <h1>Add Ingredient</h1>

    </body>
</html>