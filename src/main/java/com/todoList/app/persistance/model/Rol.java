package com.todoList.app.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="Rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "name")
	@Enumerated(EnumType.STRING)
	private EnumRol name;

	public Rol() {}
	
	public Rol(String name) {
		super();
		this.name = EnumRol.valueOf(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



		
}
