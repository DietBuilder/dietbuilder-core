package com.dietbuilder.domain.daos;

import com.dietbuilder.domain.model.recipe.Ingredient;
import com.dietbuilder.domain.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@AllArgsConstructor
public class IngredientDao {

    private IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient) {
        if (Objects.isNull(ingredient.getId())) {
            throw new IllegalArgumentException("IngredientPK cannot be null");
        } else if (Objects.isNull(ingredient.getId().getRecipeId()) || Objects.isNull(ingredient.getId().getComestibleProductId())) {
            throw new IllegalArgumentException("Recipe Id and ComestibleProduct Id cannot be null");
        }

        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        log.info("Ingredient has been saved");
        return savedIngredient;
    }

    public List<Ingredient> saveAll(List<Ingredient> ingredientList) {
        List<Ingredient> savedIngredients = ingredientList.stream().map(this::save).toList();
        log.info("All ingredients have been saved");

        return savedIngredients;
    }

    public void deleteAll(List<Ingredient> ingredients) {
        ingredientRepository.deleteAll(ingredients);
    }

}
