package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
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

  public void deleteById(String id, String deletedAt, String deletedBy) {
    Optional<Integer> deleted = mapper.searchDeletedById(id);
    if (deleted.isPresent()) {
      mapper.deleteById(id, deletedAt, deletedBy);
    } else {
      throw new ResourceNotFoundException("resource not found");
    }
  }
}
