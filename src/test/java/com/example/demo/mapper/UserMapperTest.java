package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
  @Autowired
  UserMapper userMapper;

  @Test
  @DataSet(value = "common/users.yml")
  @DisplayName("ユーザーをIDで検索できること")
  void searchByIdTest() {
    Optional<User> expectedUser = Optional.of(new User(
        "11110111101111011110111100",
        "AA",
        LocalDate.of(2022, 01, 01),
        0,
        LocalDateTime.of(2022, 01, 02, 12, 30, 30),
        "API",
        LocalDateTime.of(2022, 01, 02, 12, 30, 30),
        "API",
        null,
        null
    ));
    Optional<User> user = userMapper.searchById("11110111101111011110111100");
    assertThat(user).isEqualTo(expectedUser);
  }

  @Test
  @DataSet(value = "common/users.yml")
  @ExpectedDataSet(value = "delete/deleteUsers.yml")
  @DisplayName("ユーザーを論理削除できること")
  void deleteByIdTest() {
    userMapper.deleteById(
        "11110111101111011110111100",
        LocalDateTime.of(2022, 01, 04, 12, 30, 30),
        "API"
    );
  }
}
