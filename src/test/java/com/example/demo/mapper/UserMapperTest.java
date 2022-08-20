package com.example.demo.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
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
  @ExpectedDataSet(value = "delete/deleteUsers.yml")
  void ユーザーを論理削除できること() {
    userMapper.deleteById(
        "11110111101111011110111100",
        "2022-01-04 12:30:30",
        "API"
    );
  }
}
