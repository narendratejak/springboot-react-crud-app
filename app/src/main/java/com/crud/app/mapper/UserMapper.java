package com.crud.app.mapper;

import com.crud.app.dto.UserDto;
import com.crud.app.entity.User;

public class UserMapper {
	
	public static UserDto maptoUserDto(User user) {
		return new UserDto(
				
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail());
	}

	
	public static User mapToUser(UserDto dto) {
		return new User(
				dto.getId(), 
				dto.getFirstName(), 
				dto.getLastName(), 
				dto.getEmail()
			);
	}
}
