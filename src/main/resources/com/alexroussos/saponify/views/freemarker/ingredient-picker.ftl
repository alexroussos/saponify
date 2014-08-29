    <div id="ingredient-picker">
        <h2>Add Ingredient</h2>

        <ul>
            <#list ingredients as ingredient>
                <li onclick="addIngredient(this)" data-ingredient-id="${ingredient.id}">${ingredient.name?html} [${ingredient.sapNaoh}]</li>
            </#list>
        </ul>
        <div id="ingredient-picker-message" />
    </div>