package com.dietbuilder.controllers;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DietControllerTest {

//    @InjectMocks
//    private DietController dietController;
//
//    @Mock
//    private DietDao dietDao;
//
//    @Mock
//    private DietDtoDietDocumentMapper mapper;
//
//    private final Long DIET_ID = 1L;
//
//    private final Long USER_ID = 1L;
//
//    @Test
//    void givenDietId_whenFindByDietId_thenReturnsCorrectDiet() throws Exception {
//        when(this.dietDao.findDietByDietId(DIET_ID)).thenReturn(Optional.of(sampleDiet()));
//
//        final String URI = "/diets/byDietId/{dietId}";
//
//        this.mvc.perform(get(URI, DIET_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(DIET_ID))
//                .andExpect(jsonPath("$.dietStatus").value("ACTIVE"))
//                .andReturn();
//    }
//
//    @Test
//    void givenUserId_whenProcessing_thenReturnsCorrectDiet() throws Exception {
//        when(this.dietRepository.findById(DIET_ID)).thenReturn(Optional.of(sampleDiet()));
//        when(this.userRepository.findById(USER_ID)).thenReturn(Optional.of(sampleUser()));
//
//        final String URI = "/diets/byUserId/{userId}";
//
//        this.mvc.perform(get(URI, DIET_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(DIET_ID))
//                .andExpect(jsonPath("$.dietStatus").value("ACTIVE"))
//                .andReturn();
//    }
//
//    private Diet sampleDiet() {
//        return Diet.builder()
//                .id(DIET_ID)
//                .dietStatus(DietStatus.ACTIVE)
//                .firstMealsList(new ArrayList<>())
//                .secondMealsList(new ArrayList<>())
//                .thirdMealsList(new ArrayList<>())
//                .fourthMealsList(new ArrayList<>())
//                .fifthMealsList(new ArrayList<>())
//                .build();
//    }
//
//    private User sampleUser() {
//        return User.builder()
//                .userId(USER_ID)
//                .dietId(DIET_ID)
//                .build();
//    }

}
