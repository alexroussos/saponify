package com.alexroussos.saponify.core;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
@NamedQueries({
    @NamedQuery(
        name = "com.alexroussos.saponify.core.Recipe.findAll",
        query = "SELECT r FROM Recipe r"
    ),
    @NamedQuery(
        name = "com.alexroussos.saponify.core.Recipe.findById",
        query = "SELECT r FROM Recipe r WHERE r.id = :id"
    )
})
public class Recipe {
    @Id
    @SequenceGenerator(name = "recipeSeq", sequenceName="recipe_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "recipeSeq")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "recipeId", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<IngredientAmount> ingredientAmount = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe addIngredientAmount(IngredientAmount ingredientAmount) {
        this.ingredientAmount.add(ingredientAmount);
        return this;
    }

    public List<IngredientAmount> getIngredientAmount() {return ingredientAmount;}

    public void setIngredientAmount(List<IngredientAmount> ingredientAmount) {this.ingredientAmount = ingredientAmount;}
}
