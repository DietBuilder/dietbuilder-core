package com.dietbuilder.controllers;

//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ComestibleProductControllerTest {

//    @MockBean
//    private SequenceGeneratorService sequenceGeneratorService;
//
//    @MockBean
//    private ComestibleProductRepository comestibleProductRepository;
//
//    @Autowired
//    private MockMvc mvc;
//
//    private final long COMESTIBLE_PRODUCT_ID = 1L;
//
//    @Test
//    void givenSampleGetByIdRequest_whenProcessing_thenGetCorrectReturn() throws Exception {
//        when(this.comestibleProductRepository.findById(COMESTIBLE_PRODUCT_ID)).thenReturn(Optional.of(sampleProduct().get(0)));
//
//        final String URI = "/comestibleProducts/byId/{comestibleProductId}";
//
//        this.mvc.perform(get(URI, COMESTIBLE_PRODUCT_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(COMESTIBLE_PRODUCT_ID))
//                .andReturn();
//    }
//
//    @Test
//    void givenSampleGetByIdRequest_whenDoNotFindComestibleProduct_thenThrowComestibleProductNotFoundException() throws Exception {
//        doThrow(new ComestibleProductNotFoundException("asd")).when(this.comestibleProductRepository).findById(COMESTIBLE_PRODUCT_ID);
//
//        final String URI = "/comestibleProducts/byId/{comestibleProductId}";
//
//        this.mvc.perform(get(URI, COMESTIBLE_PRODUCT_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().is4xxClientError())
//                .andReturn();
//    }
//
//    @Test
//    void givenSampleGetByNameRequest_whenProcessing_thenGetCorrectReturn() throws Exception {
//        when(this.comestibleProductRepository.findByProductNameContainsIgnoreCase(any())).thenReturn(sampleProduct());
//
//        final String URI = "/comestibleProducts/byName/{comestibleProductName}";
//
//        this.mvc.perform(get(URI, COMESTIBLE_PRODUCT_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.length()").value(2))
//                .andExpect(jsonPath("$.[0].id").value(COMESTIBLE_PRODUCT_ID))
//                .andExpect(jsonPath("$.[0].productName").value("Arbuz"))
//                .andReturn();
//    }
//
//    @Test
//    void givenSampleGetAllRequest_whenProcessing_thenGetCorrectReturn() throws Exception {
//        when(this.comestibleProductRepository.findAll()).thenReturn(sampleProduct());
//
//        final String URI = "/comestibleProducts";
//
//        this.mvc.perform(get(URI)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2))
//                .andExpect(result -> {
//                    final String resultBody = result.getResponse().getContentAsString();
//                    final ObjectMapper mapper = new ObjectMapper();
//                    final List<ComestibleProduct> comestibleProducts = mapper.readValue(resultBody, List.class);
//                    assertEquals(2, comestibleProducts.size());
//                })
//                .andReturn();
//    }
//
//    @Test
//    void givenSampleInsertRequest_whenProcessing_thenGetCorrectReturn() throws Exception {
//
//        final String URI = "/comestibleProducts";
//
//        this.mvc.perform(post(URI)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\":1, \"productName\":\"Arbuz\"}")
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void givenSampleInsertUpdateRequest_whenProcessing_thenGotCorrectReturn() throws Exception {
//        final String URI = "/comestibleProducts";
//
//        this.mvc.perform(patch(URI)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\":1, \"productName\":\"Arbuz\"}")
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void givenSampleInsertDeleteRequest_whenProcessing_thenGotCorrectReturn() throws Exception {
//        final String URI = "/comestibleProducts";
//
//        this.mvc.perform(delete(URI)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\":1, \"productName\":\"Arbuz\"}")
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void givenSampleInsertDeleteRequestById_whenProcessing_thenGotCorrectReturn() throws Exception {
//        final String URI = "/comestibleProducts/byId/{comestibleProductId}";
//
//        this.mvc.perform(delete(URI, COMESTIBLE_PRODUCT_ID)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8))
//                .andExpect(status().isOk());
//    }
//
//    private List<ComestibleProduct> sampleProduct() {
//        ComestibleProduct one = ComestibleProduct.builder()
//                .id(COMESTIBLE_PRODUCT_ID)
//                .productName("Arbuz")
//                .build();
//
//        ComestibleProduct two = ComestibleProduct.builder()
//                .id(COMESTIBLE_PRODUCT_ID)
//                .productName("Mleko")
//                .build();
//
//        return List.of(one, two);
//    }
}
