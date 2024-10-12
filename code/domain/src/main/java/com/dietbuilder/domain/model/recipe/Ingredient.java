package com.dietbuilder.domain.model.recipe;

import com.dietbuilder.domain.model.comestible_product.ComestibleProduct;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ingredient")
@Entity
@Builder(toBuilder = true)
@Getter
public class Ingredient {

    @EmbeddedId
    private IngredientPK id;

    @ManyToOne
    @MapsId("comestibleProductId")
    @JoinColumn(name = "comestible_product_id")
    private ComestibleProduct comestibleProduct;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
//    @JsonBackReference
    private Recipe recipe;

    private double amount;

    @Enumerated(EnumType.STRING)
    private IngredientUnit ingredientUnit;

    public Ingredient(Ingredient ingredient) {
        this.id = new IngredientPK(ingredient.comestibleProduct.getId(), ingredient.recipe.getId());
        this.comestibleProduct = ingredient.comestibleProduct;
        this.recipe = ingredient.recipe;
        this.amount = ingredient.amount;
        this.ingredientUnit = ingredient.ingredientUnit;
    }

    public Ingredient(ComestibleProduct comestibleProduct, Recipe recipe, double amount, IngredientUnit ingredientUnit) {
        this.id = new IngredientPK(comestibleProduct.getId(), recipe.getId());
        this.comestibleProduct = comestibleProduct;
        this.recipe = recipe;
        this.amount = amount;
        this.ingredientUnit = ingredientUnit;
    }

    public Ingredient(ComestibleProduct comestibleProduct, Recipe recipe, double amount, String ingredientUnit) {
        this.id = new IngredientPK(comestibleProduct.getId(), recipe.getId());
        this.comestibleProduct = comestibleProduct;
        this.recipe = recipe;
        this.amount = amount;
        switch (ingredientUnit.toLowerCase()) {
            case "g":
                this.ingredientUnit = IngredientUnit.G;
                break;
            case "ml":
                this.ingredientUnit = IngredientUnit.ML;
                break;
            case "szt":
                this.ingredientUnit = IngredientUnit.UNIT;
                break;
            case "łyż":
                this.ingredientUnit = IngredientUnit.SPOON;
                break;
            default:
                throw new IllegalArgumentException("Provided ingredient unit is incorrect");
        }
    }
}