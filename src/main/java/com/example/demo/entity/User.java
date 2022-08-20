package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DBから抽出したデータを格納するEntityクラス
 */
public class User {
  /* 一意のid */
  private String id;

  /* 名前 */
  private String name;

  /* 生年月日 */
  private LocalDate birthdate;

  /* 削除フラグ */
  private int deleted;

  /* 作成日時 */
  private LocalDateTime createdAt;

  /* 作成者 */
  private String createdBy;

  /* 更新日時 */
  private LocalDateTime updatedAt;

  /* 更新者 */
  private String updatedBy;

  /* 削除日時 */
  private LocalDateTime deletedAt;

  /* 削除者 */
  private String deletedBy;

  public User() {
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public int getDeleted() {
    return deleted;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

  public String getDeletedBy() {
    return deletedBy;
  }

}
