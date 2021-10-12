package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_detail")
public class Class {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="class_name")
	private String class_name;
	
	
	
	public Class() {
		super();
	}
	
	public Class(String name) {
		super();
		this.class_name = name;
		
	}

	public Class(int id, String name) {
		super();
		this.id = id;
		this.class_name = name;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return class_name;
	}

	public void setName(String name) {
		this.class_name = name;
	}

	
	@Override
	public String toString() {
		return "Class[id=" + id + ", name=" + class_name + "]";
	}
	
	
	
	
}
