    <div id="ingredient-picker">
        <h2>Add Ingredient</h2>

        <#list ingredients as ingredient>
            <li>${ingredient.name?html} [${ingredient.sapNaoh}]</li>
        </#list>
    </div>