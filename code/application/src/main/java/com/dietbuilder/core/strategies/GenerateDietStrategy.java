package com.dietbuilder.core.strategies;

import com.dietbuilder.core.strategies.enums.GenerateDietStrategyName;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.core.model.user.User;

import java.util.Objects;

public abstract class GenerateDietStrategy {
    public abstract Diet generateDiet(User user);
    public abstract GenerateDietStrategyName getStrategy();

    protected static class CaloriesCalculator {
        public static double calculateAmountOfCaloriesPerDay(User user) {
            if (Objects.isNull(user.getUserGoal())) {
                throw new IllegalStateException("User goal cannot be null");
            }

            switch (user.getUserGoal()) {
                case REDUCE:
                    return calculateAmountOfCaloriesPerDayWhenReducting(user);
                case CARRY:
                    return calculateAmountOfCaloriesPerDayWhenCarrying(user);
                case MAINTAIN:
                    return user.getTotalEnergyExpenditure();
                default:
                    throw new IllegalStateException("Unexpected userGoal: " + user.getUserGoal());
            }
        }

        private static double calculateAmountOfCaloriesPerDayWhenReducting(User user) {
            double differenceBetweenBEEAndTEE = user.getTotalEnergyExpenditure() - user.getBasalEnergyExpenditure();

            double caloriesDeficit = (differenceBetweenBEEAndTEE * 0.75) <= 500 ? (differenceBetweenBEEAndTEE * 0.75) : 500;

            return (user.getTotalEnergyExpenditure() - caloriesDeficit);
        }

        private static double calculateAmountOfCaloriesPerDayWhenCarrying(User user) {
            double differenceBetweenBEEAndTEE = user.getTotalEnergyExpenditure() - user.getBasalEnergyExpenditure();

            double caloriesDeficit = (differenceBetweenBEEAndTEE * 0.75) <= 500 ? (differenceBetweenBEEAndTEE * 0.75) : 500;

            return (user.getTotalEnergyExpenditure() + caloriesDeficit);
        }
    }
}
