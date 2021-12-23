package com.todoList.app.service;


import static org.junit.jupiter.api.Assertions.assertNotNull; 
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.todoList.app.persistance.model.Folder;

import com.todoList.app.persistance.repository.FolderRepository;

public class FolderServiceTest {

	@Mock
	private FolderRepository folderRepository;
	
	@InjectMocks
	private FolderServiceImp folderService;
	
	Folder folder;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		
		//Init folder
		folder = new Folder();
		folder.setId((long) 99);
		folder.setName("Folder test1");
		folder.setTasks(new HashSet<>());
	}
	
	@Test
	void getAllFolders() {
		when(folderRepository.findAll()).thenReturn(Arrays.asList(folder));
		assertNotNull(folderService.getAllFolders());
	}
	
	@Test
	void register() {
		//when(folderRepository.save(any())).thenReturn(folder);
		//assertNotNull(folderService.register(new Folder("Folder test2")));
	}
	
	
}
