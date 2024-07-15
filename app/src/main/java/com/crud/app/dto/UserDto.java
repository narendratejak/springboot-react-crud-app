package com.crud.app.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;





public class UserDto {
	
	
	private Long id;
	
	@NotNull(message="firstName shoud not be null")
	@NotEmpty(message="firstName shoud not be empty")
	private String firstName;
	
	@NotNull(message="LastName shoud not be null")
	@NotEmpty(message="LastName shoud not be empty")
	private String lastName;
	
	
	private String email;
	
	private UserDto user;
	private List<UserDto> usersList;
	private int statusCode;
    private String error;
    private String message;
    
    
	


	

	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public List<UserDto> getUsersList() {
		return usersList;
	}


	public void setUsersList(List<UserDto> usersList) {
		this.usersList = usersList;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	

}
