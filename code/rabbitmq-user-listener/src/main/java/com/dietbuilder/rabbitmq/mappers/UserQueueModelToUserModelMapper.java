package com.dietbuilder.rabbitmq.mappers;

import com.dietbuilder.core.model.user.Gender;
import com.dietbuilder.core.model.user.User;
import com.dietbuilder.core.model.user.UserGoal;
import org.springframework.stereotype.Component;

@Component
public class UserQueueModelToUserModelMapper {

    public User sourceToDestination(com.dietbuilder.rabbitmq.model.User user) {
        return User.builder()
                .userId(user.getId())
                .gender(Gender.valueOf(user.getGender()))
                .height(user.getHeight())
                .weight(user.getWeight())
                .age(user.getAge())
                .psychicalActivityRatio(user.getPsychicalActivityRatio())
                .numberOfMeals(user.getNumberOfMeals())
                .userGoal(UserGoal.valueOf(user.getUserGoal()))
                .unwantedComestibleProductsIDs(user.getUnwantedComestibleProductsIDs())
                .build();
    }
}
