package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

	private String id;
	private String name;
	private LocalDate birthdate;
	private int deleted;
	private LocalDateTime created_at;
	private String created_by;
	private LocalDateTime updated_at;
	private String updated_by;
	private LocalDateTime deleted_at;
	private String deleted_by;

	public User() {}

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

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}

	public String getDeleted_by() {
		return deleted_by;
	}


}
