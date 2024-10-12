package com.dietbuilder.core.strategies;

import com.dietbuilder.core.strategies.enums.UserIndicatorGenerateStrategyName;
import com.dietbuilder.core.model.user.User;

public interface UserIndicatorsGenerateStrategy {
    User generateIndicators(User user);
    UserIndicatorGenerateStrategyName getStrategy();
}
