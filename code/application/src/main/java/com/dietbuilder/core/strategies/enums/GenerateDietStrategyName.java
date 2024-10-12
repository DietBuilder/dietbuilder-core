package com.dietbuilder.core.strategies.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenerateDietStrategyName {
    HEALTH_YOUNG_HUMAN_DIET_GENERATE_STRATEGY("HealthYoungHumanDietGenerateStrategy");

    private final String dietName;
}
