package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.LocalDateConstant;
import com.example.demo.entity.User;
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

		// String型からLoalDate型に変換
		LocalDate bd = toLocalDate(birthdate);

		// Userデータを取得
		List<User> userList = service.searchByNameBirthdate(name, bd);

		// UserForm型に変換
		List<UserForm> formList = toUserForm(userList);

		return ResponseEntity.ok(formList);
	}

	/**
	 * LocalDate型への変換 <br>
	 * String型の生年月日をLocalDate型へ変換する。
	 *
	 * @param birthdate 生年月日
	 * @return returnBirthdate 生年月日
	 */
	private LocalDate toLocalDate(String stringBirthdate) {

		// 文字列のフォーマットを初期化
		String format = null;

		// 戻り値として生年月日を初期化
		LocalDate returnBirthdate = null;

		// 生年月日のフォーマットを判別し、セットする
		if (stringBirthdate.contains("/")) {
			format = LocalDateConstant.FORMAT_SLASH;
		} else if (stringBirthdate.contains("-")) {
			format = LocalDateConstant.FORMAT_HYPHEN;
		} else {
			format = LocalDateConstant.FORMAT_NUM;
		}

		try {
			// 引数の生年月日のフォーマットを設定
			DateTimeFormatter Formatter = DateTimeFormatter.ofPattern(format);

			// String型からLoalDate型に変換
			returnBirthdate = LocalDate.parse(stringBirthdate, Formatter);

		} catch (Exception e) {
			// 不正なフォーマットや日付である場合、nullを返す
			returnBirthdate = null;

		}

		return returnBirthdate;
	}

	/**
	 * UserForm型への変換 <br>
	 * 抽出したユーザ全件数、User型からUserForm型に変換する。
	 *
	 * @param userList ユーザリスト
	 * @return userFormList ユーザフォームリスト
	 */
	private List<UserForm> toUserForm(List<User> userList){
		// 変換後のuserFormを追加するための配列を初期化
		ArrayList<UserForm> userFormList = new ArrayList<UserForm>();

		// 抽出したユーザ全件数を変換
		for (User user : userList) {
			userFormList.add(new UserForm(user.getId(), user.getName(), user.getBirthdate()));
		}

		return userFormList;
	}

}
