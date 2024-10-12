package com.dietbuilder.core.strategies.impl;

import com.dietbuilder.core.strategies.UserIndicatorsGenerateStrategy;
import com.dietbuilder.core.strategies.enums.UserIndicatorGenerateStrategyName;
import com.dietbuilder.core.model.user.Gender;
import com.dietbuilder.core.model.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class HarrisBenedictUserIndicatorsGenerateStrategy implements UserIndicatorsGenerateStrategy {

    @Override
    public User generateIndicators(User user) {
        user = user.getGender().equals(Gender.MALE)
                ? user.toBuilder().basalEnergyExpenditure(generateBEEForMale(user)).build()
                : user.toBuilder().basalEnergyExpenditure(generateBEEForFemale(user)).build();

        return user.toBuilder().totalEnergyExpenditure(generateTEE(user)).build();
    }

    private Double generateBEEForMale(User user) {
        double result = (66.5 + (13.75 * user.getWeight()) + (5.003 * user.getHeight() * 100) - (6.775 * user.getAge()));

        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private Double generateBEEForFemale(User user) {
        double result = (655.1 + (9.563 * user.getWeight()) + (1.85 * user.getHeight() * 100) - (4.676 * user.getAge()));

        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private Double generateTEE(User user) {
        double result = user.getBasalEnergyExpenditure() * user.getPsychicalActivityRatio();

        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public UserIndicatorGenerateStrategyName getStrategy() {
        return UserIndicatorGenerateStrategyName.HARRIS_BENEDICT_USER_INDICATOR_GENERATE_STRATEGY;
    }
}
