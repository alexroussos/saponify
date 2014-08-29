<#-- @ftlvariable name="" type="com.example.views.AllRecipesView" -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="description" content="Calculates soap recipes and predicts properties based on types of fats and oils.">
        <meta name="keywords" content="soap, recipe, calculator, fat, oil, lye, saponification">
        <meta name="author" content="Alex Roussos">
        <title>My Recipes - Saponify</title>
        <link href="../../assets/css/bootstrap.min.css" type="text/css" rel="stylesheet" >
        <link href="../../assets/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet" >
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../../assets/css/recipe.css" type="text/css" rel="stylesheet" >
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/recipe.js"></script>
    </head>
    <#include "nav.ftl">
    <body>
        <h1>Recipes</h1>
        <ul>
        <#list allRecipes as recipe>
            <li><a href="../${recipe.id}/view">${recipe.name}</a></li>
        </#list>
        <ul>

        <h2>Create Recipe</h2>
        <form id="createRecipe" action="/recipe">
            Recipe name:
            <input type="text" name="RecipeName" value="My Soap..."><br>
            <input type="submit" value="Create">
        </form>

        <div id="result" />
    </body>
</html>