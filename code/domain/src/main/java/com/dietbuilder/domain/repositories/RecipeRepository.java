package com.dietbuilder.domain.repositories;

import com.dietbuilder.domain.model.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "FROM recipes", nativeQuery = true)
    List<Recipe> findRecipesByCaloriesAndMealTypeExcludingUnwantedIngredients(double lowestAmountOfCalories, double greatestAmountOfCalories,
                                                                          String mealType, List<Long> unwantedComestibleProductsIDs);
    List<Recipe> findAllByOrderByRecipeNameAsc();

    List<Recipe> findByRecipeNameContainsIgnoreCase(String productName);

    @Query(value = "select meal_name from meals", nativeQuery = true)
    List<String> findMealNames();
}
