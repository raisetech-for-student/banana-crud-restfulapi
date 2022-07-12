package com.example.demo.response;

import java.time.LocalDate;

/**
 * Userクラスから、名前と生年月日を使用者に渡すためのクラス
 *
 */
public class UserResponse {

	/* 一意のid */
	private String id;

	/* 名前 */
	private String name;

	/* 生年月日 */
	private LocalDate birthdate;

	public UserResponse(String id, String name, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public UserResponse() {}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getBirthdate() {
		return this.birthdate;
	}

}
