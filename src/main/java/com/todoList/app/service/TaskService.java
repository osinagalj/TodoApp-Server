package com.todoList.app.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.todoList.app.persistance.model.Task;

public interface TaskService {

	Task findTaskById(Long id)  throws ResourceNotFoundException;
	void remove(Long id);
	Task register(Task p);
	Task update(Task task);
	List<Task> getAllTasks();
	List<Task> getAllTasks(Long folder_id);
	
}
