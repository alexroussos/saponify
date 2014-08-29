    <div id="ingredient-picker">
        <h2>Add Ingredient</h2>

        <ul>
            <#list ingredients as ingredient>
                <li>${ingredient.name?html} [${ingredient.sapNaoh}]</li>
            </#list>
        </ul>
    </div>