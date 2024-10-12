package com.dietbuilder.domain.model.user;

import lombok.Getter;

@Getter
public enum BMIClassification {
    STARVED(0, 16),
    SKINNINESS(16, 16.99),
    UNDERWEIGHT(17, 18.49),
    CORRECT_VALUE(18.5, 24.99),
    FLESH(25, 29.99),
    FIRST_LEVEL_OBESITY(30, 34.99),
    SECOND_LEVEL_OBESITY(35, 39.99),
    EXTREME_OBESITY(40, 100);

    private final double lowerBmiBound;
    private final double upperBmiBound;

    BMIClassification(double lowerBmiBound, double upperBmiBound) {
        this.lowerBmiBound = lowerBmiBound;
        this.upperBmiBound = upperBmiBound;
    }
}
