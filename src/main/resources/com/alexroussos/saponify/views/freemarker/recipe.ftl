<#-- @ftlvariable name="" type="com.example.views.RecipeView" -->
<html>
    <body>
        <!-- calls getRecipe().getName() and sanitizes it -->
        <h1>Hello, ${recipe.name?html}!</h1>
    </body>
</html>