package com.dietbuilder.rest.mappers;

import com.dietbuilder.model.DietDto;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.domain.model.diet.RecipeToDiet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DietDtoDietModelMapper {

//    private List<MealInDietDetail> ;

//    public Diet sourceToDestination(DietDto source) {
//        return Diet.builder()
//                .id(source.getId())
//                .dietStatus(DietStatus.valueOf(source.getDietStatus().getValue()))
//                .mealLists()
//                .firstMealsList(source.getFirstMealsList())
//                .secondMealsList(source.getSecondMealsList())
//                .thirdMealsList(source.getThirdMealsList())
//                .fourthMealsList(Objects.nonNull(source.getFourthMealsList()) ? source.getFourthMealsList() : null)
//                .fifthMealsList(Objects.nonNull(source.getFifthMealsList()) ? source.getFifthMealsList() : null)
//                .sixthMealsList(Objects.nonNull(source.getSixthMealsList()) ? source.getSixthMealsList() : null)
//                .seventhMealsList(Objects.nonNull(source.getSeventhMealsList()) ? source.getSeventhMealsList() : null)
//                .build();
//    }

    public DietDto destinationToSource(Diet destination) {
        return new DietDto()
                .id(destination.getId())
                .dietStatus(DietDto.DietStatusEnum.valueOf(destination.getDietStatus().toString()))
                .firstMealsList(getMealListPerDay(destination.getRecipeList(), 1))
                .secondMealsList(getMealListPerDay(destination.getRecipeList(), 2))
                .thirdMealsList(getMealListPerDay(destination.getRecipeList(), 3))
                .fourthMealsList(getMealListPerDay(destination.getRecipeList(), 4))
                .fifthMealsList(getMealListPerDay(destination.getRecipeList(), 5))
                .sixthMealsList(getMealListPerDay(destination.getRecipeList(), 6))
                .seventhMealsList(getMealListPerDay(destination.getRecipeList(), 7));
    }

//    private List<MealInDietDetail> aggregateMealLists(DietDto source) {
//        List<Long> aggregatedList = new ArrayList<>();
//        for
//
//        return
//    }

    private List<Long> getMealListPerDay(List<RecipeToDiet> mealInDietDetailList, int mealNumber) {
        List<Long> filteredMealInDietList = mealInDietDetailList.stream()
                .filter(mealInDietDetail -> mealInDietDetail.getMealNumber() == mealNumber)
                .map(mealInDietDetail -> mealInDietDetail.getRecipeId())
                .toList();
        return filteredMealInDietList.size() > 0 ? filteredMealInDietList : null;
    }
}
