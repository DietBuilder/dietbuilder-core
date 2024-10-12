package com.dietbuilder.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String gender;

    private double height;

    private double weight;

    private int age;

    private double psychicalActivityRatio;

    private int numberOfMeals;

    private String userGoal;

    private List<Long> unwantedComestibleProductsIDs;

}
