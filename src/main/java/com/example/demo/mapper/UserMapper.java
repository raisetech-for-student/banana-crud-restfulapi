package com.example.demo.mapper;

import com.example.demo.entity.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ユーザ検索処理を行うMapperインターフェイス
 */
@Mapper
public interface UserMapper {
  /**
   * 名前と生年月日による検索処理 <br>
   * 名前と生年月日を用いて、該当するユーザを検索する。
   * 名前：前方一致
   * 生年月日：完全一致
   *
   * @param name      名前
   * @param birthdate 生年月日
   * @return 抽出したユーザリスト
   */
  public List<User> searchByNameBirthdate(
      @Param("name") String name,
      @Param("birthdate") LocalDate birthdate
  );

  /**
   * ULIDによる検索処理 <br>
   * ULIDを用いて、該当するユーザを検索する。
   *
   * @param id ULID
   * @return 抽出したユーザ
   */
  public Optional<User> searchById(
      @Param("id") String id
  );


  /**
   * 論理削除処理 <br>
   * ULIDを用いて、該当するユーザを論理削除する。
   *
   * @param id        ULID
   * @param deletedAt 削除日
   * @param deletedBy 削除者
   */
  public void deleteById(
      @Param("id") String id,
      @Param("deletedAt") LocalDateTime deletedAt,
      @Param("deletedBy") String deletedBy
  );
}
