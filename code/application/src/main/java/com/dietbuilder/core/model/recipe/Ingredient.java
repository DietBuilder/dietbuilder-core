package com.dietbuilder.core.model.recipe;

import com.dietbuilder.core.model.comestibleProduct.ComestibleProduct;
import com.dietbuilder.domain.model.recipe.IngredientUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode
public class Ingredient {

    private ComestibleProduct comestibleProduct;

    private Double amount;

    private IngredientUnit ingredientUnit;

    public Ingredient(ComestibleProduct comestibleProduct, double amount, IngredientUnit ingredientUnit) {
        this.comestibleProduct = comestibleProduct;
        this.amount = amount;
        this.ingredientUnit = ingredientUnit;
    }

    public Ingredient(ComestibleProduct comestibleProduct, double amount, String ingredientUnit) {
        this.comestibleProduct = comestibleProduct;
        this.amount = amount;
        List<IngredientUnit> ingredientUnits = Arrays.stream(IngredientUnit.values()).sequential()
                .filter(enumIngredientUnit -> enumIngredientUnit.toString().equals(ingredientUnit)).collect(Collectors.toList());
        if (ingredientUnits.isEmpty()) {
            throw new IllegalArgumentException("Provided ingredient unit is incorrect");
        }
    }
}
