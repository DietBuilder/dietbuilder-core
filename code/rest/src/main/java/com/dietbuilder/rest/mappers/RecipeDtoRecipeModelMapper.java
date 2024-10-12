package com.dietbuilder.rest.mappers;

import com.dietbuilder.domain.daos.IngredientDao;
import com.dietbuilder.domain.daos.RecipeDao;
import com.dietbuilder.domain.exceptions.RecipeNotFoundException;
import com.dietbuilder.domain.model.recipe.Ingredient;
import com.dietbuilder.model.RecipeDto;
import com.dietbuilder.domain.model.recipe.Meal;
import com.dietbuilder.domain.model.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@AllArgsConstructor
public class RecipeDtoRecipeModelMapper {

    private RecipeDao recipeDao;

    private IngredientDtoIngredientModelMapper ingredientMapper;

    private IngredientDao ingredientDao;


    public Recipe sourceToDestination(RecipeDto source) {
        return Recipe.builder()
                .id(Objects.nonNull(source.getId()) ? source.getId() : 0)
                .ingredients(Objects.nonNull(source.getIngredients()) ? ingredientMapper.sourceToDestination(source.getIngredients()) : new ArrayList<>())
                .recipeName(source.getRecipeName())
                .shortDescription(source.getShortDescription())
                .longDescription(source.getLongDescription())
                .meal(Meal.valueOf(source.getMeal().toString()))
                .build();
    }


    public RecipeDto destinationToSource(Recipe destination) {
        RecipeDto recipeDto = new RecipeDto();
        return recipeDto
                .id(destination.getId())
                .ingredients(Objects.nonNull(destination.getIngredients()) ? ingredientMapper.destinationToSource(destination.getIngredients()) : new ArrayList<>())
                .recipeName(destination.getRecipeName())
                .shortDescription(destination.getShortDescription())
                .longDescription(destination.getLongDescription())
                .meal(Objects.nonNull(destination.getMeal()) ? RecipeDto.MealEnum.valueOf(destination.getMeal().toString()) : null);
    }

    public Recipe updateRecipe(RecipeDto givenRecipe) {
        Recipe currentRecipe;
        try {
            currentRecipe = recipeDao.get(givenRecipe.getId());
        } catch (RecipeNotFoundException e) {
            log.info("Recipe with this ID does not exist. Creating new one.");
            return sourceToDestination(givenRecipe);
        }

        List<Ingredient> ingredientsToSave = currentRecipe.getIngredients();
        ingredientsToSave = replaceIngredients(ingredientsToSave, ingredientMapper.sourceToDestination(givenRecipe.getIngredients()), currentRecipe);

        return Recipe.builder()
                .id(givenRecipe.getId())
                .ingredients(ingredientsToSave)
                .recipeName(Objects.nonNull(givenRecipe.getRecipeName()) ? givenRecipe.getRecipeName() : currentRecipe.getRecipeName())
                .shortDescription(givenRecipe.getShortDescription() != null ? givenRecipe.getShortDescription() : currentRecipe.getShortDescription())
                .longDescription(givenRecipe.getLongDescription() != null ? givenRecipe.getLongDescription() : currentRecipe.getLongDescription())
                .meal(givenRecipe.getMeal() != null ? Meal.valueOf(givenRecipe.getMeal().getValue()) : currentRecipe.getMeal())
                .build();
    }

    List<Ingredient> replaceIngredients(List<Ingredient> currentIngredients, List<Ingredient> newIngredients, Recipe recipe) {
        currentIngredients.clear();
        currentIngredients.addAll(newIngredients);
        return currentIngredients.stream()
                .map(ingredient -> ingredient.toBuilder().recipe(recipe).build())
                .map(Ingredient::new)
                .toList();
    }
}
