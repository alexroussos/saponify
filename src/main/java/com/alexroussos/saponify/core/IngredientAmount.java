package com.alexroussos.saponify.core;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_amount")
public class IngredientAmount {

    @Id
    @SequenceGenerator(name = "ingredientAmountSeq", sequenceName="ingredient_amount_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ingredientAmountSeq")
    private long id;

    @Column(name = "recipe_id")
    private long recipeId;

    @Column(name = "ingredient_id", nullable = false)
    private long ingredientId;

    @Column(name = "amount_grams", nullable = false)
    private Float amountGrams;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Float getAmountGrams() {
        return amountGrams;
    }

    public void setAmountGrams(Float amountGrams) {
        this.amountGrams = amountGrams;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }
}
