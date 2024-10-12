package com.dietbuilder.stategies.impl;

import com.dietbuilder.core.model.user.User;
import com.dietbuilder.core.strategies.impl.HealthYoungHumanDietGenerateStrategy;
import com.dietbuilder.core.model.user.Gender;
import com.dietbuilder.core.model.user.UserGoal;
import com.dietbuilder.domain.repositories.DietRepository;
import com.dietbuilder.domain.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {HealthYoungHumanDietGenerateStrategy.class})
class HealthYoungHumanDietGenerateStrategyTest {

    @Autowired
    private HealthYoungHumanDietGenerateStrategy healthYoungHumanDietGenerateStrategy;

    @MockBean
    private RecipeRepository recipeRepository;

    @MockBean
    private DietRepository dietRepository;

    @Test
    void givenSampleUser_whenProcessed_thenNoExceptionIsThrownAndRepositoriesAreCalled() {
        this.healthYoungHumanDietGenerateStrategy.generateDiet(sampleUser());
        verify(this.dietRepository, times(2)).save(any());
        verify(this.recipeRepository, times(0)).saveAll(any());
        verify(this.recipeRepository, times(5)).findRecipesByCaloriesAndMealTypeExcludingUnwantedIngredients(any(Double.class), any(Double.class), any(String.class), any(List.class));
    }

    private User sampleUser() {
        long userId = 123L;

        return User.builder()
                .userId(123L)
                .gender(Gender.MALE)
                .height(1.75)
                .weight(70.0)
                .age(30)
                .psychicalActivityRatio(1.6)
                .userGoal(UserGoal.REDUCE)
                .numberOfMeals(5)
                .unwantedComestibleProductsIDs(List.of(123L, 234L, 345L, 456L))
                .basalEnergyExpenditure(1507.98)
                .totalEnergyExpenditure(2412.77)
                .build();
    }
}
