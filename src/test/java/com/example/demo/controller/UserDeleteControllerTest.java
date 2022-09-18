package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserDeleteService;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserDeleteControllerTest {
  @MockBean
  UserDeleteService userDeleteService;

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("ユーザーを論理削除できること")
  void deleteByIdTest() throws Exception {
    doNothing().when(userDeleteService).deleteById(anyString(), any(), anyString());
    mockMvc.perform(delete("/users/11110111101111011110111100"))
        .andExpect(status().isOk())
        .andExpect(json().isEqualTo("{\"message\": \"user successfully deleted\"}"));
  }

  @Test
  @DisplayName("存在しないユーザーIDを論理削除しようとした時にNotFoundが返ってくること、ZonedDateTimeをモック化して検証")
  void deleteByIdNotFoundTest() throws Exception {
    ZonedDateTime zonedDateTime = ZonedDateTime.of(2022, 9, 5, 0, 0, 0, 0, ZoneId.of("Asia/Tokyo"));
    try (MockedStatic<ZonedDateTime> zonedDateTimeMockedStatic = mockStatic(ZonedDateTime.class)) {
      zonedDateTimeMockedStatic.when(ZonedDateTime::now).thenReturn(zonedDateTime);
      doThrow(new ResourceNotFoundException("resource not found")).when(userDeleteService)
          .deleteById(anyString(), any(), anyString());
      mockMvc.perform(delete("/users/1"))
          .andExpect(status().isNotFound())
          .andExpect(json().isEqualTo(
              "{" +
                  "\"error\":\"Not Found\"," +
                  "\"message\":\"resource not found\"," +
                  "\"path\":\"/users/1\"," +
                  "\"status\":\"404\"," +
                  "\"timestamp\":\"2022-09-05T00:00+09:00[Asia/Tokyo]\"" +
                  "}"
          ));
    }
  }

  @Test
  @DisplayName("存在しないユーザーIDを論理削除しようとした時にNotFoundが返ってくること、ClockをMock化して検証")
  void deleteByIdNotFoundClockTest() throws Exception {
    String zonedDateTime = "2022-09-04T15:00:00Z";
    Clock clock = Clock.fixed(Instant.parse(zonedDateTime), ZoneId.of("Asia/Tokyo"));
    try (MockedStatic<Clock> zonedDateTimeMockedStatic = mockStatic(Clock.class)) {
      zonedDateTimeMockedStatic.when(ZonedDateTime::now).thenReturn(clock);
      doThrow(new ResourceNotFoundException("resource not found")).when(userDeleteService)
          .deleteById(anyString(), any(), anyString());
      mockMvc.perform(delete("/users/1"))
          .andExpect(status().isNotFound())
          .andExpect(json().isEqualTo(
              "{" +
                  "\"error\":\"Not Found\"," +
                  "\"message\":\"resource not found\"," +
                  "\"path\":\"/users/1\"," +
                  "\"status\":\"404\"," +
                  "\"timestamp\":\"2022-09-05T00:00+09:00[Asia/Tokyo]\"" +
                  "}"
          ));
    }
  }
}
