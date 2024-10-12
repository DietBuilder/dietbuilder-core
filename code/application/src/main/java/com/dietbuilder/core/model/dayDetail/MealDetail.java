package com.dietbuilder.core.model.dayDetail;

import com.dietbuilder.core.model.recipe.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MealDetail {

    private String startHour;
    private String endHour;
    private double lowestAmountOfCalories;
    private double greatestAmountOfCalories;
    private Meal meal;
    private int mealNumber;
}
