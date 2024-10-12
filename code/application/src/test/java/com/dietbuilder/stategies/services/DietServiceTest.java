package com.dietbuilder.stategies.services;

import com.dietbuilder.core.services.DietService;
import com.dietbuilder.core.strategies.impl.HarrisBenedictUserIndicatorsGenerateStrategy;
import com.dietbuilder.core.strategies.impl.HealthYoungHumanDietGenerateStrategy;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.domain.model.diet.DietStatus;
import com.dietbuilder.core.model.user.Gender;
import com.dietbuilder.core.model.user.User;
import com.dietbuilder.core.model.user.UserGoal;
import com.dietbuilder.domain.repositories.DietRepository;
import com.dietbuilder.domain.repositories.RecipeRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DietService.class, HarrisBenedictUserIndicatorsGenerateStrategy.class, HealthYoungHumanDietGenerateStrategy.class})
@MockBean(classes = {DietRepository.class, RecipeRepository.class})
class DietServiceTest {
    
    @Autowired
    private DietService dietService;

    @ParameterizedTest
    @MethodSource("sampleUser")
    void givenSampleUser_whenGeneratingDiet_thenReturnsGeneratedDiet(User user) {
        Diet diet = this.dietService.createDiet(user);

        assertThat(diet.getDietStatus().equals(DietStatus.ACTIVE));
        assertThat(Objects.nonNull(diet.getRecipeList()));
    }

    private static Stream<Arguments> sampleUser() {
        long userId = 123L;

        User user = User.builder()
                .userId(userId)
                .gender(Gender.MALE)
                .height(1.75)
                .weight(70.0)
                .age(30)
                .psychicalActivityRatio(1.6)
                .userGoal(UserGoal.REDUCE)
                .numberOfMeals(5)
                .unwantedComestibleProductsIDs(List.of(21L, 2L))
                .build();

        return Stream.of(Arguments.of(user));
    } 
}
