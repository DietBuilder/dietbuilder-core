package com.dietbuilder.domain.repositories;

import com.dietbuilder.domain.model.recipe.IngredientPK;
import com.dietbuilder.domain.model.recipe.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, IngredientPK> {

    @Transactional
    @Modifying
    @Query(value = "delete from ingredient i where i.comestible_product_id=:comestibleProductId and i.meal_id =:mealId", nativeQuery = true)
    void deleteIngredient(@Param("comestibleProductId") Long comestibleProductId,
                          @Param("mealId") Long mealId);

    @Transactional
    @Modifying
    @Query(value = "delete from ingredient i where i.meal_id =:mealId", nativeQuery = true)
    void deleteAllIngredientsForMeal(@Param("mealId") Long mealId);
}
