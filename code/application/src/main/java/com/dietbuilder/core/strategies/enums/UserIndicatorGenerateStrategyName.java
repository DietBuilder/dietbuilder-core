package com.dietbuilder.core.strategies.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserIndicatorGenerateStrategyName {
    HARRIS_BENEDICT_USER_INDICATOR_GENERATE_STRATEGY("HarrisBenedictUserIndicatorGenerateStrategy");

    private final String dietName;
}
