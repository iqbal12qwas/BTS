package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	@JsonProperty("users")
	private Users users;

	public UserDto() {
	}

	public UserDto(Users users) {
		super();
		this.users = users;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
