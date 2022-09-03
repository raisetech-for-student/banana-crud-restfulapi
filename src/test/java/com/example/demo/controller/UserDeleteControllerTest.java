package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserDeleteService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserDeleteControllerTest {
  @MockBean
  UserDeleteService userDeleteService;

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("指定したIDが存在する時")
  void deleteByIdTest() throws Exception {
    mockMvc.perform(delete("/users/11110111101111011110111100"))
        .andExpect(status().isOk())
        .andExpect(content().string("user successfully deleted"));
  }

  @Test
  @DisplayName("指定したIDが存在しない時")
  void deleteByIdNotFoundTest() throws Exception {
    doThrow(new ResourceNotFoundException("resource not found")).when(userDeleteService)
        .deleteById(anyString(), any(), anyString());
    String response = mockMvc.perform(delete("/users/1"))
        .andExpect(status().isNotFound())
        .andReturn().getResponse().getContentAsString();
    ObjectMapper mapper = new ObjectMapper();
    Map responseMessage = mapper.readValue(response, new TypeReference<Map<String, String>>() {
    });
    assertThat(responseMessage.get("message")).isEqualTo("resource not found");
  }
}
