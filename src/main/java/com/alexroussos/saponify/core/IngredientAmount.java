package com.alexroussos.saponify.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_amount")
@Data
public class IngredientAmount {

    @Id
    @SequenceGenerator(name = "ingredientAmountSeq", sequenceName="ingredient_amount_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ingredientAmountSeq")
    private long id;

    @Column(name = "recipe_id")
    private long recipeId;

    // TODO inflate this on retrieval / map to Ingredient
    @Column(name = "ingredient_id", nullable = false)
    private long ingredientId;

    @Column(name = "amount_grams", nullable = false)
    private Float amountGrams;

    // freemarker doesn't recognize lombok-generated setters/getters
    public long getId() {
        return id;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public Float getAmountGrams() {
        return amountGrams;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setAmountGrams(Float amountGrams) {
        this.amountGrams = amountGrams;
    }

    public void setId(long id) {
        this.id = id;
    }
}
