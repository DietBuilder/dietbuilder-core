package com.dietbuilder.core.model.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Recipe {

    private List<Ingredient> ingredients = new ArrayList<>();

    private String mealName;

    private String shortDescription;

    private String longDescription;

    private Meal mealType;
}
