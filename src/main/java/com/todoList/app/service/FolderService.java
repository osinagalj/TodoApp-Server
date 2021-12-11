package com.todoList.app.service;

import java.util.List;
import com.todoList.app.persistance.model.Folder;
import com.todoList.app.persistance.model.Task;


public interface FolderService {
	List<Folder> getAllFolders();
	Folder findFolderByName(String name);
	Folder findFolderById(Long id);
	void remove(Long id);
	Folder register(Folder p);
	Folder update(Folder folder);
	void addTask(Long folder, Task task);
	
}
