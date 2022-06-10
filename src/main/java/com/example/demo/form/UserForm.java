package com.example.demo.form;

import java.time.LocalDate;

public class UserForm {

	private String id;
	private String name;
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
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

}
