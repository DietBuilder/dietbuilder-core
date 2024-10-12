package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.RecipesApi;
import com.dietbuilder.rest.mappers.RecipeDtoRecipeModelMapper;
import com.dietbuilder.domain.daos.RecipeDao;
import com.dietbuilder.domain.exceptions.RecipeNotFoundException;
import com.dietbuilder.model.RecipeDto;
import com.dietbuilder.domain.model.recipe.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class RecipeController implements RecipesApi {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private RecipeDtoRecipeModelMapper recipeDtoMealDocumentMapper;

    @Override
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        Recipe recipe;
        try {
            recipe = recipeDao.get(id);
        } catch (RecipeNotFoundException e) {
            log.error("Meal with this ID does not exist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(recipeDtoMealDocumentMapper.destinationToSource(recipe));
    }

    @Override
    public ResponseEntity<List<RecipeDto>> getRecipesByName(@PathVariable String recipeName) {
        List<Recipe> recipes = recipeDao.getAllByName(recipeName);

        List<RecipeDto> result = recipes.stream().map(recipe -> recipeDtoMealDocumentMapper.destinationToSource(recipe)).toList();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        List<Recipe> recipes = recipeDao.getAll();
        List<RecipeDto> result = recipes.stream().map(m -> recipeDtoMealDocumentMapper.destinationToSource(m)).toList();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<RecipeDto> insertRecipe(RecipeDto recipeDto) {
        Recipe savedRecipe = recipeDao.save(recipeDtoMealDocumentMapper.sourceToDestination(recipeDto));
        return ResponseEntity.ok(recipeDtoMealDocumentMapper.destinationToSource(savedRecipe));
    }

    @Override
    public ResponseEntity<RecipeDto> updateRecipe(@RequestBody RecipeDto recipe) {
        Recipe recipeToSave = recipeDtoMealDocumentMapper.updateRecipe(recipe);
        Recipe savedRecipe = recipeDao.updateRecipe(recipeToSave);
        return ResponseEntity.ok(recipeDtoMealDocumentMapper.destinationToSource(savedRecipe));
    }

    @Override
    public ResponseEntity<Void> deleteRecipe(@RequestBody RecipeDto recipe) {
        recipeDao.delete(Recipe.builder().id(recipe.getId()).build());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) {
        recipeDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
