package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserGetService;

/**
 * GetHttpを処理するControllerクラス
 *
 */
@RestController
@Validated
public class UserGetController {

	private UserGetService service;

	public UserGetController(UserGetService userGetService) {
		this.service = userGetService;
	}

	/**
	 * 名前と生年月日による検索処理 <br>
	 * 名前と生年月日を用いて、該当するユーザを検索する。
	 *
	 * @param name 名前
	 * @param birthdate 生年月日
	 * @return 抽出したユーザリスト
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserForm>> searchByNameBirthdate(
			@Valid @NotBlank @RequestParam(name = "name") String name,
			@RequestParam(name = "birthdate", required = false) String birthdate) {

		return ResponseEntity.ok(service.searchByNameBirthdate(name, birthdate));
	}

}
