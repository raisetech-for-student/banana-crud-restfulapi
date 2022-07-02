package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DBから抽出したデータを格納するEntityクラス
 *
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
	private LocalDateTime created_at;

	/* 作成者 */
	private String created_by;

	/* 更新日時 */
	private LocalDateTime updated_at;

	/* 更新者 */
	private String updated_by;

	/* 削除日時 */
	private LocalDateTime deleted_at;

	/* 削除者 */
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
