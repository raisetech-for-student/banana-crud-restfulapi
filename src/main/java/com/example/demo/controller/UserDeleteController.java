package com.example.demo.controller;

import com.example.demo.constant.LocalDateConstant;
import com.example.demo.service.UserDeleteService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PatchHttp(論理削除)を処理するControllerクラス
 */
@RestController
@RequestMapping(path = "/users")
public class UserDeleteController {
  private UserDeleteService service;

  public UserDeleteController(UserDeleteService userDeleteService) {
    this.service = userDeleteService;
  }

  /**
   * GUIDによる論理削除処理 <br>
   *
   * @param id ULID
   */

  @PatchMapping(path = "{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
    String deletedAt = LocalDateTime.now().format(DateTimeFormatter
        .ofPattern(LocalDateConstant.FORMAT_HYPHEN_TIME));
    String deletedBy = "API";
    service.deleteById(id, deletedAt, deletedBy);
    return ResponseEntity.ok().body("user successfully deleted");
  }
}
