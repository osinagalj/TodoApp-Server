package com.todoList.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.todoList.app.persistance.model.Task;
import com.todoList.app.persistance.repository.TaskRepository;

@Service
public class TaskServiceImp implements TaskService{

	@Autowired
	TaskRepository taskRepository;

	@Override
	public Task register(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task update(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public void remove(Long id) {
		taskRepository.deleteById(id);
		return;
	}

	@Override
	public Task findTaskById(Long id) throws ResourceNotFoundException {
		return taskRepository.findTasktById(id);
	}
	
	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		Iterator<Task> it = taskRepository.findAll().iterator();
		while (it.hasNext()) {
			Task t = it.next();
			tasks.add(t);
		}
		return tasks;
	}
	
	@Override
	public List<Task> getAllTasks(Long folder_id) {
		List<Task> tasks = new ArrayList<Task>();
		Iterator<Task> it = taskRepository.findAll().iterator();
		while (it.hasNext()) {
			Task t = it.next();
			//if(t.getFolder() !=null) //eliminar dep
			//	if(t.getFolder().getId().equals(folder_id))
			//		tasks.add(t);
		}
		return tasks;
	}
}
