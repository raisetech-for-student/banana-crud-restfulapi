package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class UserDeleteServiceTest {
  @MockBean(name = "userMapper")
  private UserMapper userMapper;

  @Autowired
  private UserDeleteService userDeleteService;

  @Test
  @DisplayName("引数に設定したIDと削除日、削除者をもとに正常に論理削除処理が実行されること")
  void deleteByIdTest() {
    doReturn(Optional.of(1)).when(userMapper).searchDeletedById("11110111101111011110111100");
    userDeleteService.deleteById("11110111101111011110111100", "2022-01-04 12:30:30", "API");
    verify(userMapper, times(1)).deleteById(
        "11110111101111011110111100", "2022-01-04 12:30:30", "API"
    );
  }

  @Test
  @DisplayName("引数に指定したIDが存在しない時、ResourceNotFoundExceptionが発生すること")
  void deleteByIdExceptionTest() {
    doReturn(Optional.empty()).when(userMapper).searchDeletedById("1");
    assertThrows(ResourceNotFoundException.class, () -> userDeleteService.deleteById(
        "1", "2022-01-04 12:30:30", "API")
    );
    assertThatThrownBy(() -> {
      throw new ResourceNotFoundException("resource not found");
    })
        .hasMessage("resource not found");
  }
}
