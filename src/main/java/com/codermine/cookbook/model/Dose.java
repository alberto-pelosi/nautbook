package com.codermine.cookbook.model;

import io.micronaut.data.annotation.*;


@MappedEntity("recipe_ingredient")
public class Dose {

    @Id
    @GeneratedValue
    private Long id;

    @Relation(Relation.Kind.MANY_TO_ONE)
    private Recipe recipe;

    @Relation(Relation.Kind.MANY_TO_ONE)
    private Ingredient ingredient;

    private Double quantity;

    private UnitOfMeasure unitOfMeasure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                '}';
    }
}
