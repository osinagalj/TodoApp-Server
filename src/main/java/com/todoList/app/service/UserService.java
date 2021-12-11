package com.todoList.app.service;

import java.util.List;
import com.todoList.app.persistance.model.User;

public interface UserService {
	User findUserById(Long id);
	void remove(Long id);
	User register(User p);
	List<User> getAllUsers();

}
