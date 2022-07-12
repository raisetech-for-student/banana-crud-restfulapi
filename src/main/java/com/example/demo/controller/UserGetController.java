package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.LocalDateConstant;
import com.example.demo.entity.User;
import com.example.demo.response.UserResponse;
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
	public ResponseEntity<List<UserResponse>> searchByNameBirthdate(
			@Valid @NotBlank @RequestParam(name = "name") String name,
			@RequestParam(name = "birthdate", required = false) String birthdate) {

		// String型からLocalDate型に変換
		Optional<LocalDate> bd = toLocalDate(birthdate);

		// Userデータを取得
		List<User> userList = service.searchByNameBirthdate(name, bd.orElse(null));

		// UserResponse型に変換
		List<UserResponse> responseList = toUserResponse(userList);

		return ResponseEntity.ok(responseList);
	}

	/**
	 * LocalDate型への変換 <br>
	 * String型の生年月日をLocalDate型へ変換する。
	 *
	 * @param birthdate 生年月日
	 * @return Optional.ofNullable(returnBirthdate) 生年月日
	 */
	private Optional<LocalDate> toLocalDate(String birthdate) {

		// 文字列のフォーマットを初期化
		String format = null;

		// 戻り値として生年月日を初期化
		LocalDate returnBirthdate = null;

		// 生年月日のフォーマットを判別し、セットする
		if (birthdate.contains("/")) {
			format = LocalDateConstant.FORMAT_SLASH;
		} else if (birthdate.contains("-")) {
			format = LocalDateConstant.FORMAT_HYPHEN;
		} else {
			format = LocalDateConstant.FORMAT_NUM;
		}

		try {
			// 引数の生年月日のフォーマットを設定し、String型からLoalDate型に変換
			returnBirthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern(format));

		} catch (Exception e) {
			// 不正なフォーマットや日付である場合、nullを返す
			returnBirthdate = null;

		}

		// ラップした後、生年月日を返す
		return Optional.ofNullable(returnBirthdate);
	}

	/**
	 * UserResponse型への変換 <br>
	 * 抽出したユーザ全件数、User型からUserResponse型に変換する。
	 *
	 * @param userList ユーザリスト
	 * @return userResponseList ユーザフォームリスト
	 */
	private List<UserResponse> toUserResponse(List<User> userList){

		List<UserResponse> userResponseList = userList.stream()
							// UserクラスからUserResponseクラスに変換 ユーザ件数分行う
							.map(user -> new UserResponse(user.getId(), user.getName(), user.getBirthdate()))
							// StreamをListに変換
							.collect(Collectors.toList());

		return userResponseList;
	}

}
