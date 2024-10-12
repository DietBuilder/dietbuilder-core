package com.dietbuilder.domain.daos;

import com.dietbuilder.domain.exceptions.RecipeNotFoundException;
import com.dietbuilder.domain.model.recipe.Ingredient;
import com.dietbuilder.domain.model.recipe.Recipe;
import com.dietbuilder.domain.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class RecipeDao {

  private RecipeRepository recipeRepository;

  private IngredientDao ingredientDao;

  public Recipe get(long id) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(id);

    if (recipeOptional.isPresent()){
      log.info("Recipe with id: " + id + " has been found");
      return recipeOptional.get();
    } else {
      throw new RecipeNotFoundException("Cannot find recipe with id: " + id);
    }
  }

  public List<Recipe> getAllByName(String recipeName) {
    List<Recipe> recipes = recipeRepository.findByRecipeNameContainsIgnoreCase(recipeName);
    log.info("Recipes list has been found");
    return recipes;
  }

  public List<Recipe> getAll() {
    List<Recipe> recipes = recipeRepository.findAllByOrderByRecipeNameAsc();
    log.info("Recipes list has been found");
    return recipes;
  }

  public Recipe save(Recipe recipe) {
    List<Ingredient> ingredientsToSave = recipe.getIngredients();
    Recipe savedRecipe = recipeRepository.save(recipe.toBuilder().ingredients(null).build());
    ingredientsToSave = ingredientsToSave.stream()
            .map(ingredient -> ingredient.toBuilder().recipe(savedRecipe).build())
            .map(Ingredient::new)
            .toList();

    ingredientDao.saveAll(ingredientsToSave);
    log.info("Recipe has been saved");
    return savedRecipe;
  }

  public void saveAll(List<Recipe> recipes) {
    recipes.forEach(this::save);
    log.info("Recipes has been saved");
  }

  public Recipe updateRecipe(Recipe recipe) {
    Recipe updatedRecipe = recipeRepository.save(recipe);
    ingredientDao.deleteAll(recipe.getIngredients());
    log.info("Recipe has been saved");
    return updatedRecipe;
  }

  public void delete(Recipe recipe) {
    recipeRepository.delete(recipe);
    log.info("Recipe has been deleted");
  }

  public void deleteById(long id) {
    recipeRepository.deleteById(id);
    log.info("Recipe has been deleted");
  }

  public void deleteAll() {
    recipeRepository.deleteAll();
    log.info("All recipes have been deleted");
  }
}
