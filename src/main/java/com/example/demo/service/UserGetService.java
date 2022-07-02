package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

/**
 * GetHttpを処理するServiceクラス
 *
 */
@Service
public class UserGetService {

	private UserMapper mapper;

	public UserGetService(UserMapper userMapper) {
		this.mapper = userMapper;
	}

	/**
	 * 名前と生年月日による検索処理 <br>
	 * 名前と生年月日を用いて、該当するユーザを検索する。
	 *
	 * @param name 名前
	 * @param birthdate 生年月日
	 * @return 抽出したユーザリスト
	 */
	public List<User> searchByNameBirthdate(String name, LocalDate birthdate){

		// Userデータを取得
		List<User> userList = mapper.searchByNameBirthdate(name, birthdate);

		return userList;
	}

}
