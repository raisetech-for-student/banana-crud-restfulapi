package com.example.demo.form;

import java.time.LocalDate;

/**
 * Userクラスから、名前と生年月日を使用者に渡すためのクラス
 *
 */
public class UserForm {

	/* 一意のid */
	private String id;

	/* 名前 */
	private String name;

	/* 生年月日 */
	private LocalDate birthdate;

	public UserForm(String id, String name, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public UserForm(String name, LocalDate birthdate) {
		this.name = name;
		this.birthdate = birthdate;
	}

	public UserForm() {}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

}
