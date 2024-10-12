package com.dietbuilder.stategies.impl;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = {DietBuilderApplication.class})
//@EnableConfigurationProperties
//@ActiveProfiles({"integration-test"})
class HealthYoungHumanDietGenerateStrategyTestIT {

//    @Autowired
//    private DietRepository dietRepository;
//
//    @Autowired
//    private HealthYoungHumanDietGenerateStrategy healthYoungHumanDietGenerateStrategy;

//    @Test
//    void givenSampleUser_whenProcessed_thenNoExceptionIsThrown(){
//        Diet diet = this.healthYoungHumanDietGenerateStrategy.generateDiet(sampleCorrectUser());
//
//        Optional<Diet> savedDietOptional = dietRepository.findById(diet.getId());
//
//        assertTrue(savedDietOptional.isPresent());
//
//        Diet savedDiet = savedDietOptional.get();
//
//        assertEquals(diet.getDietStatus(), savedDiet.getDietStatus());
//        assertEquals(diet.getFirstMealsList().size(), savedDiet.getFirstMealsList().size());
//    }
//
//    @Test
//    void givenSampleUser_whenIncorrectNumberOfMeals_thenIllegalStateExceptionIsThrown() {
//        assertThrows(NoSuchElementException.class, () -> this.healthYoungHumanDietGenerateStrategy.generateDiet(sampleUserWithIncorrectNumberOfMeals()));
//    }
//
//    @Test
//    void givenSampleUser_whenMissingUserGoal_thenNullPointerExceptionIsThrown() {
//        assertThrows(IllegalStateException.class, () -> this.healthYoungHumanDietGenerateStrategy.generateDiet(sampleUserWithoutUserGoal()));
//    }

//    private User sampleCorrectUser() {
//        return User.builder()
//                .userId(123L)
//                .gender(Gender.MALE)
//                .height(1.75)
//                .weight(70.0)
//                .age(30)
//                .psychicalActivityRatio(1.6)
//                .userGoal(UserGoal.REDUCE)
//                .numberOfMeals(5)
//                .unwantedComestibleProductsIDs(Arrays.asList(123L, 234L, 345L, 456L))
//                .basalEnergyExpenditure(1507.98)
//                .totalEnergyExpenditure(2412.77)
//                .build();
//    }
//
//    private User sampleUserWithIncorrectNumberOfMeals() {
//        return User.builder()
//                .userId(123L)
//                .gender(Gender.MALE)
//                .height(1.75)
//                .weight(70.0)
//                .age(30)
//                .psychicalActivityRatio(1.6)
//                .userGoal(UserGoal.REDUCE)
//                .unwantedComestibleProductsIDs(Arrays.asList(123L, 234L, 345L, 456L))
//                .basalEnergyExpenditure(1507.98)
//                .totalEnergyExpenditure(2412.77)
//                .numberOfMeals(8)
//                .build();
//    }
//
//    private User sampleUserWithoutUserGoal() {
//        return User.builder()
//                .userId(123L)
//                .gender(Gender.MALE)
//                .height(1.75)
//                .weight(70.0)
//                .age(30)
//                .psychicalActivityRatio(1.6)
//                .numberOfMeals(5)
//                .unwantedComestibleProductsIDs(Arrays.asList(123L, 234L, 345L, 456L))
//                .basalEnergyExpenditure(1507.98)
//                .totalEnergyExpenditure(2412.77)
//                .build();
//    }
}
