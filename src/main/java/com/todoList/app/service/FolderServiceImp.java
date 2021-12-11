package com.todoList.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.app.persistance.model.Folder;
import com.todoList.app.persistance.model.Task;
import com.todoList.app.persistance.repository.FolderRepository;
import com.todoList.app.persistance.repository.TaskRepository;

@Service
public class FolderServiceImp implements FolderService{

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	TaskRepository taskRepository;

	
	
	@Override
	public Folder register(Folder Folder) {
		return folderRepository.save(Folder);
	}
	
	@Override
	public Folder update(Folder Folder) {
		return folderRepository.save(Folder);
	}
	
	@Override
	public void remove(Long id) {
		Folder f= folderRepository.findFolderById(id);
		for(Task t: f.getBooks()) {
			taskRepository.delete(t);
		}
		folderRepository.deleteById(id);
		return;
	}

	@Override
	public Folder findFolderById(Long id){
		return folderRepository.findFolderById(id);
	}
	
	@Override
	public Folder findFolderByName(String name){
		return folderRepository.findFolderByName(name);
	}
	
	
	@Override
	public void addTask(Long folder_id, Task task) {
		Folder folder = folderRepository.findFolderById(folder_id);
		folder.addTask(task);
		folderRepository.save(folder);
	}
	
	
	@Override
	public List<Folder> getAllFolders() {
		List<Folder> Folders = new ArrayList<Folder>();
		Iterator<Folder> it = folderRepository.findAll().iterator();
		while (it.hasNext()) {
			Folder folder = it.next();
			Folders.add(folder);
		}
		return Folders;
	}

}
