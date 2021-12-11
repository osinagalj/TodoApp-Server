package com.todoList.app.api.dto;

import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public class UserInput {

	private String name;
	private String username;
	
	@Size(min = 6, message = "The password must have 6 digits")
	private String password;
	private String rol;
	
	public UserInput() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
