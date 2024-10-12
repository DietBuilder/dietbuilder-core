package com.dietbuilder.core.strategies.impl;

import com.dietbuilder.core.model.dayDetail.MealDetail;
import com.dietbuilder.core.model.dayDetail.MealsInDayPolicy;
import com.dietbuilder.core.strategies.GenerateDietStrategy;
import com.dietbuilder.core.strategies.enums.GenerateDietStrategyName;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.domain.model.diet.DietStatus;
import com.dietbuilder.domain.model.diet.RecipeToDiet;
import com.dietbuilder.domain.model.recipe.Recipe;
import com.dietbuilder.domain.model.user.UnwantedComestibleProducts;
import com.dietbuilder.core.model.user.User;
import com.dietbuilder.domain.repositories.DietRepository;
import com.dietbuilder.domain.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class HealthYoungHumanDietGenerateStrategy extends GenerateDietStrategy {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private DietRepository dietRepository;

    @Override
    public Diet generateDiet(User user) {
        Diet diet = Diet.builder().dietStatus(DietStatus.IN_CREATION).recipeList(new ArrayList<>()).build();

        dietRepository.save(diet);

        double caloriesPerDay = CaloriesCalculator.calculateAmountOfCaloriesPerDay(user);

        MealsInDayPolicy mealsInDayPolicy = Arrays.stream(MealsInDayPolicy.values())
                .filter(policy -> policy.getNumberOfMeals() == user.getNumberOfMeals())
                .findAny()
                .orElseThrow();

        for (int i = 0; i < mealsInDayPolicy.getNumberOfMeals(); i++) {
            diet = findMeals(diet, caloriesPerDay, mealsInDayPolicy.getMealDetails().get(i), user.getUnwantedComestibleProductsIDs());
        }

        diet = diet.toBuilder().dietStatus(DietStatus.ACTIVE).build();

        dietRepository.save(diet);

        log.info("Diet has been created and saved.");

        return diet;
    }

    private Diet findMeals(Diet diet, double caloriesPerDay, MealDetail mealDetail, List<Long> unwantedComestibleProductsIDs) {
        double lowestAmountOfCalories = caloriesPerDay * mealDetail.getLowestAmountOfCalories();
        double greatestAmountOfCalories = caloriesPerDay * mealDetail.getGreatestAmountOfCalories();

        List<Recipe> recipes = recipeRepository.findRecipesByCaloriesAndMealTypeExcludingUnwantedIngredients(lowestAmountOfCalories,
                greatestAmountOfCalories,
                mealDetail.getMeal().toString(),
                unwantedComestibleProductsIDs);

        List<RecipeToDiet> recipesToDiet = recipes.stream()
                .map(recipe -> new RecipeToDiet(recipe.getId(), mealDetail.getMealNumber(), diet)).toList();

        List<RecipeToDiet> recipeList = diet.getRecipeList();

        recipeList.addAll(recipesToDiet);

        return diet.toBuilder().recipeList(recipeList).build();
    }

    @Override
    public GenerateDietStrategyName getStrategy() {
        return GenerateDietStrategyName.HEALTH_YOUNG_HUMAN_DIET_GENERATE_STRATEGY;
    }
}
