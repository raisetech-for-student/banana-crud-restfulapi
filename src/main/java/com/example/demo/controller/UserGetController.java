package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserGetService;

@Controller
public class UserGetController {

	private UserGetService service;

	public UserGetController(UserGetService userGetService) {
		this.service = userGetService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserForm>> searchByNameBirthdate(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "birthdate", required = false) String birthdate) {
		return ResponseEntity.ok(service.searchByNameBirthdate(name, birthdate));
	}
}
