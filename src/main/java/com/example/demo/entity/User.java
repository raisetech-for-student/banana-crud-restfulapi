package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

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

  public User(
      String id,
      String name,
      LocalDate birthdate,
      int deleted,
      LocalDateTime createdAt,
      String createdBy,
      LocalDateTime updatedAt,
      String updatedBy,
      LocalDateTime deletedAt,
      String deletedBy
  ) {
    this.id = id;
    this.name = name;
    this.birthdate = birthdate;
    this.deleted = deleted;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
    this.deletedAt = deletedAt;
    this.deletedBy = deletedBy;
  }

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

  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<String> getDeletedBy() {
    return Optional.ofNullable(deletedBy);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return getDeleted() == user.getDeleted()
        && Objects.equals(getId(), user.getId())
        && Objects.equals(getName(), user.getName())
        && Objects.equals(getBirthdate(), user.getBirthdate())
        && Objects.equals(getCreatedAt(), user.getCreatedAt())
        && Objects.equals(getCreatedBy(), user.getCreatedBy())
        && Objects.equals(getUpdatedAt(), user.getUpdatedAt())
        && Objects.equals(getUpdatedBy(), user.getUpdatedBy())
        && Objects.equals(getDeletedAt(), user.getDeletedAt())
        && Objects.equals(getDeletedBy(), user.getDeletedBy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getBirthdate(), getDeleted(), getCreatedAt(),
        getCreatedBy(), getUpdatedAt(), getUpdatedBy(), getDeletedAt(), getDeletedBy());
  }
}
