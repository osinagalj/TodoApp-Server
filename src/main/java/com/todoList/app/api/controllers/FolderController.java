package com.todoList.app.api.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.todoList.app.api.dto.FolderInput;
import com.todoList.app.persistance.model.Folder;
import com.todoList.app.persistance.model.Task;
import com.todoList.app.service.FolderService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("folders")
public class FolderController {
		
	@Autowired
	FolderService folderService;
	
	
	@PostMapping(path = "/")
	@ApiOperation("Use this method to create a new folder")
	public ResponseEntity<Folder> createFolder(@RequestBody FolderInput folder){
		Folder t = new Folder();
		t.setName(folder.getName());
		t.setTasks(new HashSet<>());
		return ResponseEntity.ok(folderService.register(t));
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation("Fetch a single folder by id")
	public ResponseEntity<Folder> getFolder(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(folderService.findFolderById(id));
	}
	
	@GetMapping(path = "/tasks/{id}")
	@ApiOperation("Use this method to get all the tasks associated with a folder by its id")
	public ResponseEntity<Set<Task>> getTasksByFolder(@PathVariable(value = "id") Long name){
		Set<Task> list = folderService.findFolderById(name).getTasks();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/")
	@ApiOperation("Fetch list of folders")
	public ResponseEntity<List<Folder>> getFolders( ){
		List<Folder> list = folderService.getAllFolders();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation("Use this method to delete a folder and all the tasks contained in it")
	public ResponseEntity<?> deleteFolder(@PathVariable(value = "id") Long id){
		folderService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
}

