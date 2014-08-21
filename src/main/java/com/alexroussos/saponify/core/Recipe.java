package com.alexroussos.saponify.core;

import javax.persistence.*;

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
}
