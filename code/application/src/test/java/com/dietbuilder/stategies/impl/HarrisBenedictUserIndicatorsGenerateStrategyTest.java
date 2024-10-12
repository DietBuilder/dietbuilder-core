package com.dietbuilder.stategies.impl;

import com.dietbuilder.core.strategies.impl.HarrisBenedictUserIndicatorsGenerateStrategy;
import com.dietbuilder.core.model.user.Gender;
import com.dietbuilder.core.model.user.User;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {HarrisBenedictUserIndicatorsGenerateStrategy.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HarrisBenedictUserIndicatorsGenerateStrategyTest {

    @Autowired
    private HarrisBenedictUserIndicatorsGenerateStrategy strategy;

    @ParameterizedTest
    @MethodSource("sampleMaleUser")
    void givenMaleUser_whenIndicatorsAreCalculated_thenMatchesCorrectValue(User user) {
        User resultUser = strategy.generateIndicators(user);

        assertEquals(1701.28, resultUser.getBasalEnergyExpenditure());
        assertEquals(2722.05, resultUser.getTotalEnergyExpenditure());
    }

    @ParameterizedTest
    @MethodSource("sampleFemaleUser")
    void givenFemaleUser_whenIndicatorsAreCalculated_thenMatchesCorrectValue(User user) {
        User resultUser = strategy.generateIndicators(user);

        assertEquals(1507.98, resultUser.getBasalEnergyExpenditure());
        assertEquals(2412.77, resultUser.getTotalEnergyExpenditure());
    }

    private Stream<Arguments> sampleMaleUser() {
        User user = User.builder()
                .userId(123L)
                .gender(Gender.MALE)
                .height(1.75)
                .weight(70.0)
                .age(30)
                .psychicalActivityRatio(1.6)
                .build();

        return Stream.of(Arguments.of(user));
    }

    private Stream<Arguments> sampleFemaleUser() {
        User user = User.builder()
                .userId(123L)
                .gender(Gender.FEMALE)
                .height(1.75)
                .weight(70.0)
                .age(30)
                .psychicalActivityRatio(1.6)
                .build();

        return Stream.of(Arguments.of(user));
    }
}
