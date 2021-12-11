package com.todoList.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.todoList.app.persistance.model.Rol;
import com.todoList.app.persistance.model.User;
import com.todoList.app.persistance.repository.RolRepository;
import com.todoList.app.persistance.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository UserRepository;
	
	@Override
	public User register(User user) {
		return UserRepository.save(user);
	}
	

	
	@Override
	public void remove(Long id) {
		UserRepository.deleteById(id);
		return;
	}

	@Override
	public User findUserById(Long id) throws ResourceNotFoundException {
		return UserRepository.findUserById(id);
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> Users = new ArrayList<User>();
		Iterator<User> it = UserRepository.findAll().iterator();
		while (it.hasNext()) {
			User t = it.next();
			Users.add(t);
		}
		return Users;
	}
	
}
