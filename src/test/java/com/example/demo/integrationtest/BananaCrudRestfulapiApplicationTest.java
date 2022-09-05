package com.example.demo.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BananaCrudRestfulapiApplicationTest {
  @Autowired
  MockMvc mockMvc;

  ZonedDateTime zonedDateTime = ZonedDateTime.of(2022, 9, 5, 0, 0, 0, 0, ZoneId.of("Asia/Tokyo"));

  @Test
  @DataSet(value = "common/users.yml")
  @DisplayName("ユーザーを論理削除できること")
  void deleteByIdTest() throws Exception {
    mockMvc.perform(delete("/users/11110111101111011110111100"))
        .andExpect(status().isOk())
        .andExpect(json().isEqualTo("{\"message\": \"user successfully deleted\"}"));
  }

  @Test
  @DataSet(value = "common/users.yml")
  @DisplayName("存在しないユーザーIDを論理削除しようとした時にNotFoundが返ってくること")
  void deleteByIdNotFoundTest() throws Exception {
    try (MockedStatic<ZonedDateTime> zonedDateTimeMockedStatic = mockStatic(ZonedDateTime.class)) {
      zonedDateTimeMockedStatic.when(ZonedDateTime::now).thenReturn(zonedDateTime);
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
