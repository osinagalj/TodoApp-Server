package com.todoList.app.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.todoList.app.api.dto.TaskInput;
import com.todoList.app.api.exceptions.TaskRequestException;
import com.todoList.app.persistance.model.Task;
import com.todoList.app.service.FolderService;
import com.todoList.app.service.TaskService;


@RestController
@RequestMapping("tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	FolderService folderService;
	
	@PostMapping(path = "/")
	public ResponseEntity<Task> createTask(@RequestBody TaskInput task){
		Task t = new Task();
		t.setDone(task.getDone());
		t.setName(task.getName());
		
		Task newTask = taskService.register(t);
		folderService.addTask(task.getFolder_id(), newTask);
		return ResponseEntity.ok(newTask);
	}
	
	/*
	@GetMapping(path = "/tasks/{id}")
	public ResponseEntity<Task> getTask(@PathVariable(value = "id") Long id){
		Task task = taskService.findTaskById(id);
				//.orElseThrow(() -> new Exception("Task don"));
		//if(task == null)
		///	throw new TaskRequestException("The task dosn't exists");
		return ResponseEntity.ok(task);
		
		
	}
	*/
	

	@GetMapping(path = "/")
	public ResponseEntity<List<Task>> getTasks( ){
		List<Task> list = taskService.getAllTasks();
		return ResponseEntity.ok(list);
	}
	

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long id){
		taskService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @RequestBody Task task) throws ResourceNotFoundException{
		
		Task employee = taskService.findTaskById(id);//.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
	    	     
		return ResponseEntity.ok(taskService.update(task));
	}
}
