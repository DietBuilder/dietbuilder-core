package com.dietbuilder.core.model.user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
@Builder(toBuilder = true)
public class User {

    private long userId;

    private Gender gender;

    private Double height;

    private Double weight;

    private Integer age;

    private Double psychicalActivityRatio;

    private Double basalEnergyExpenditure;

    private Double totalEnergyExpenditure;

    private Integer numberOfMeals;

    private UserGoal userGoal;

    private Long dietId;

    private List<Long> unwantedComestibleProductsIDs;
}
