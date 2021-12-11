package com.todoList.app.api.dto;

public class FolderInput {
	private String name;
	
	
	public FolderInput() {
	}
	
	public FolderInput(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
