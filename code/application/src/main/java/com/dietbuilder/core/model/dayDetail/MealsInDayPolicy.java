package com.dietbuilder.core.model.dayDetail;

import com.dietbuilder.core.model.recipe.Meal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public enum MealsInDayPolicy {
    THREE(3, Collections.emptyList()),
    FOUR(4, Collections.emptyList()),
    FIVE(5,
            new ArrayList<>(Arrays.asList(
                    new MealDetail("8", "10", 0.20, 0.25, Meal.BREAKFAST, 1),
                    new MealDetail("11", "13", 0.15, 0.20, Meal.BRUNCH, 2),
                    new MealDetail("14", "16", 0.30, 0.35, Meal.DINNER, 3),
                    new MealDetail("17", "18", 0.5, 0.10, Meal.TEA, 4),
                    new MealDetail("19", "20", 0.20, 0.25, Meal.SUPPER, 5))
            )),
    SIX(6, Collections.emptyList());

    private final int numberOfMeals;

    private final List<MealDetail> mealDetails;

    MealsInDayPolicy(int numberOfMeals, List<MealDetail> mealDetails) {
        this.numberOfMeals = numberOfMeals;
        this.mealDetails = mealDetails;
    }

}
