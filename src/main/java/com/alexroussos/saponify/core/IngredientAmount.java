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
}
