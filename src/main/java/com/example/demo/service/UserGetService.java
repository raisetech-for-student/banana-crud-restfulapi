package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.mapper.UserMapper;

@Service
public class UserGetService {

	private UserMapper mapper;

	public UserGetService(UserMapper userMapper) {
		this.mapper = userMapper;
	}

	public List<UserForm> searchByNameBirthdate(String name, LocalDate birthdate){
		List<User> userList = mapper.searchByNameBirthdate(name, birthdate);
		return toUserForm(userList);
	}
//	public List<UserForm> searchByNameBirthdate(String name, LocalDate birthdate){
//		List<User> userList = mapper.searchByNameBirthdate(name, birthdate);
//		return toUserForm(userList);
//	}

	// UserクラスをUserFormクラスに変換
	public List<UserForm> toUserForm(List<User> userList){
		ArrayList<UserForm> formList = new ArrayList<UserForm>();

		// 抽出したユーザ数だけformListに追加
		for (User user : userList) {
			formList.add(new UserForm(user.getId(), user.getName(), user.getBirthdate()));
		}
		return formList;
	}

}
