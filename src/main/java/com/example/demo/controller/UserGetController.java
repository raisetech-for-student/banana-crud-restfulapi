package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserGetService;

@RestController

public class UserGetController {

	private UserGetService service;

	public UserGetController(UserGetService userGetService) {
		this.service = userGetService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserForm>> searchByNameBirthdate(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "birthdate", required = false)
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate) {
		return ResponseEntity.ok(service.searchByNameBirthdate(name, birthdate));
	}

//	@GetMapping("/users")
//	public ResponseEntity<List<UserForm>> searchByNameBirthdate(
//			@ModelAttribute UserForm userForm,
//			BindingResult result) {
//			if (result.hasErrors()) {
//				System.out.println("ここまでOK");
//			}
//		return ResponseEntity.ok(service.searchByNameBirthdate(userForm.getName(), userForm.getBirthdate()));
//	}
}
