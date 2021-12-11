package com.todoList.app.api.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoList.app.api.dto.UserInput;
import com.todoList.app.api.dto.UserOutput;
import com.todoList.app.persistance.model.Rol;
import com.todoList.app.persistance.model.User;
import com.todoList.app.persistance.repository.RolRepository;
import com.todoList.app.service.UserService;


@RestController
@RequestMapping("/api/v0/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	RolRepository rolRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping(path = "/login")
	public ResponseEntity<UserOutput> login(@RequestBody UserInput user){
		UserOutput User = new UserOutput(); //= userService.findUserById(id);
		return ResponseEntity.ok(User);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<User> createUser(@RequestBody UserInput user){
		User new_user = modelMapper.map(user, User.class);
		new_user.setRol(rolRepository.findByName(user.getRol()));
		return ResponseEntity.ok(userService.register(new_user));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
		User User = userService.findUserById(id);
		return ResponseEntity.ok(User);
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<User>> getUsers(){
		List<User> list = userService.getAllUsers();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id){
		userService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "/rols")
	public ResponseEntity<List<Rol>> getRols(){
		List<Rol> rols = new ArrayList<>();
		Iterator<Rol> it =  rolRepository.findAll().iterator();
	
		while (it.hasNext()) {
			Rol t = it.next();
			rols.add(t);
		}
		
		return ResponseEntity.ok(rols);
	}
	
	@GetMapping(path = "/total")
	public ResponseEntity<Long> getUsersAmount(){
		Long x = userService.getAllUsers().stream().count();
		return ResponseEntity.ok(x);
	}
	
}



