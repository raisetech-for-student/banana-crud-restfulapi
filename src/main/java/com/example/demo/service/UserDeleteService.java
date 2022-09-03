package com.example.demo.service;

import com.example.demo.constant.LocalDateConstant;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * ユーザの論理削除処理を行うServiceクラス
 */
@Service
public class UserDeleteService {
  private UserMapper mapper;

  public UserDeleteService(UserMapper userMapper) {
    this.mapper = userMapper;
  }

  public void deleteById(String id, LocalDateTime deletedAt, String deletedBy) {
    String strDeletedAt = deletedAt
        .format(DateTimeFormatter.ofPattern(LocalDateConstant.FORMAT_HYPHEN_TIME));
    Optional<User> deleted = mapper.searchById(id);
    if (deleted.isPresent() && deleted.get().getDeleted() == 0) {
      mapper.deleteById(id, strDeletedAt, deletedBy);
    } else {
      throw new ResourceNotFoundException("resource not found");
    }
  }
}
