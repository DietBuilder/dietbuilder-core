package com.dietbuilder.core.services;

import com.dietbuilder.core.model.user.User;
import com.dietbuilder.core.strategies.GenerateDietStrategy;
import com.dietbuilder.core.strategies.UserIndicatorsGenerateStrategy;
import com.dietbuilder.core.strategies.enums.GenerateDietStrategyName;
import com.dietbuilder.core.strategies.enums.UserIndicatorGenerateStrategyName;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.domain.model.user.BMIClassification;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DietService {

    private Map<UserIndicatorGenerateStrategyName, UserIndicatorsGenerateStrategy> userIndicatorsGenerateStrategies;

    private Map<GenerateDietStrategyName, GenerateDietStrategy> generateDietStrategies;

    @Autowired
    public DietService(Set<UserIndicatorsGenerateStrategy> indicatorsGenerateStrategies, Set<GenerateDietStrategy> generateDietStrategies) {
        loadUserIndicatorsGenerateStrategies(indicatorsGenerateStrategies);
        loadGenerateDietStrategies(generateDietStrategies);
    }

    public Diet createDiet(User user) {
        final BMIClassification bmiClassification = calculateBMIClassification(user);

        // new conditions and strategies to be implemented
        if (true) {
            user = findUserIndicatorsGenerateStrategy(UserIndicatorGenerateStrategyName.HARRIS_BENEDICT_USER_INDICATOR_GENERATE_STRATEGY)
                    .generateIndicators(user);
        }

        log.info("Health indicators for user with id: " + user.getUserId() + " has been generated.");

        Diet diet;

        if (true) {
            log.info("Start of generating diet for user with id: " + user.getUserId());
            diet = findGenerateDietStrategy(GenerateDietStrategyName.HEALTH_YOUNG_HUMAN_DIET_GENERATE_STRATEGY)
                    .generateDiet(user);
        }

        log.info("Diet has been generated: {}", diet);

        return diet;
    }


    private BMIClassification calculateBMIClassification(User user) {
        final double bmi = (user.getWeight() / Math.pow(user.getHeight(), 2));
        return Arrays.stream(BMIClassification.values())
                .filter(e -> e.getLowerBmiBound() < bmi && e.getUpperBmiBound() > bmi)
                .findAny()
                .orElseThrow();
    }

    private void loadGenerateDietStrategies(Set<GenerateDietStrategy> strategies) {
        this.generateDietStrategies = new HashMap<>();
        strategies.forEach(strategy -> {
            generateDietStrategies.put(strategy.getStrategy(), strategy);
        });
    }

    private void loadUserIndicatorsGenerateStrategies(Set<UserIndicatorsGenerateStrategy> strategies) {
        this.userIndicatorsGenerateStrategies = new HashMap<>();
        strategies.forEach(strategy -> {
            userIndicatorsGenerateStrategies.put(strategy.getStrategy(), strategy);
        });
    }

    private GenerateDietStrategy findGenerateDietStrategy(GenerateDietStrategyName strategyName) {
        return generateDietStrategies.get(strategyName);
    }

    private UserIndicatorsGenerateStrategy findUserIndicatorsGenerateStrategy(UserIndicatorGenerateStrategyName strategyName) {
        return userIndicatorsGenerateStrategies.get(strategyName);
    }
}
