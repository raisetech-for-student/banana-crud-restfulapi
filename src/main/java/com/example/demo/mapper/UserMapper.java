package com.example.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

/**
 * GetHttpを処理するMapperインターフェイス
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * 名前と生年月日による検索処理 <br>
	 * 名前と生年月日を用いて、該当するユーザを検索する。
	 *
	 * @param name 名前
	 * @param birthdate 生年月日
	 * @return 抽出したユーザリスト
	 */
	public List<User> searchByNameBirthdate(
			@Param("name") String name,
			@Param("birthdate") LocalDate birthdate);
}
