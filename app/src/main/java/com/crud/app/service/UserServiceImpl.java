package com.crud.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.app.dto.UserDto;
import com.crud.app.entity.User;
import com.crud.app.exception.ResourceNotFoudException;
import com.crud.app.mapper.UserMapper;
import com.crud.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDto createUser(UserDto dto) {
		
		Optional<User> byEmail = repository.findByEmail(dto.getEmail());
		
		if(byEmail.isPresent()) {
			
			dto.setStatusCode(400);
			dto.setError("Email already Exist");
			
			return dto;
			
		}
		
		User mapToUser = UserMapper.mapToUser(dto);
		
		User save = repository.save(mapToUser);
		
		UserDto maptoUserDto = UserMapper.maptoUserDto(save);
		
		//UserDto dto1 = new UserDto();
		dto.setUser(maptoUserDto);
		dto.setMessage("User Createde Successfully");
		dto.setStatusCode(201);
		
		return dto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		User orElseThrow = repository.findById(userId).orElseThrow(() ->  
					new ResourceNotFoudException("Employee Id not exist with Given Id "+userId));
		UserDto maptoUserDto = UserMapper.maptoUserDto(orElseThrow);
		return maptoUserDto;
	}

	@Override
	public UserDto getAllusers() {
		List<User> all = repository.findAll();
		
		UserDto dto = new UserDto();
		
		
		
		List<UserDto> collect = all.stream().map((user) -> UserMapper.maptoUserDto(user)).collect(Collectors.toList());
		dto.setUsersList(collect);
		dto.setMessage("Data Fetched succesfully");
		dto.setStatusCode(201);
		return dto;
	}

	@Override
	public UserDto updateUser(Long id, UserDto dto) {
		User user = repository.findById(id).orElseThrow(()-> new ResourceNotFoudException("user Is not Exist with given number  "+id));
		
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		
		User save = repository.save(user);
		return UserMapper.maptoUserDto(save);
	}

	@Override
	public void deleteUser(Long id) {
		
		User user = repository.findById(id).orElseThrow(()-> new ResourceNotFoudException("user Is not Exist with given number  "+id));
		repository.deleteById(id);
	}

}
