package com.crud.app.service;

import java.util.List;

import com.crud.app.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto dto);
	
	UserDto getUserById(Long userId);
	
	UserDto getAllusers();
	
	UserDto updateUser(Long id,UserDto dto);
	
	void deleteUser(Long id);

}
