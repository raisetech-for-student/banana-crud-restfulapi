package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

	// 名前と生年月日で検索
	public List<User> searchByNameBirthdate(
			@Param("name") String name, 
			@Param("birthdate") String birthdate);
}
