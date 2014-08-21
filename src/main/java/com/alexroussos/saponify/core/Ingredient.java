package com.alexroussos.saponify.core;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@NamedQueries({
    @NamedQuery(
        name = "com.alexroussos.saponify.core.Ingredient.findAll",
        query = "SELECT i FROM Ingredient i"
    ),
    @NamedQuery(
        name = "com.alexroussos.saponify.core.Ingedient.findById",
        query = "SELECT i FROM Ingredient i WHERE i.id = :id"
    )
})
public class Ingredient {
    @Id
    @SequenceGenerator(name = "ingredientSeq", sequenceName="ingredient_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ingredientSeq")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sapNaoh", nullable = false)
    private Float sapNaoh;

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

    public Float getSapNaoh() {
        return sapNaoh;
    }

    public void setSapNaoh(Float sapNaoh) {
        this.sapNaoh = sapNaoh;
    }
}
