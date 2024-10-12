package com.dietbuilder.core.model.diet;

import com.dietbuilder.domain.model.diet.DietStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Builder(toBuilder = true)
@EqualsAndHashCode
@Data
public class Diet {

    private Long id;

    private DietStatus dietStatus;

    private List<Long> firstMealsList;

    private List<Long> secondMealsList;

    private List<Long> thirdMealsList;

    private List<Long> fourthMealsList;

    private List<Long> fifthMealsList;

    private List<Long> sixthMealsList;

    private List<Long> seventhMealsList;
}
