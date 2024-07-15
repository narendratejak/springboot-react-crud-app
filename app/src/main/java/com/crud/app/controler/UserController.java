package com.crud.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crud.app.dto.UserDto;

import com.crud.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//Add User Rest API
	
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto dto){
		
		UserDto user = service.createUser(dto);
		
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}
	
	//Build get Employee By Id
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto> getUerById(@PathVariable("id") Long id){
		UserDto userById = service.getUserById(id);
		
		return ResponseEntity.ok(userById);
	}
	
	//Build get All Users
	@GetMapping("/all")
	public ResponseEntity<UserDto> getAllUsers(){
		UserDto allusers = service.getAllusers();
		
		return ResponseEntity.ok(allusers);
	}
	
	//update User
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> upateUser(@PathVariable("id") Long id,@RequestBody UserDto dto){
		
		UserDto updateUser = service.updateUser(id, dto);
		
		return ResponseEntity.ok(updateUser);
		
	}
	
	//delete User
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		
		service.deleteUser(id);
		return ResponseEntity.ok("User Deleted Successfully");
		
	}
	
	

}
