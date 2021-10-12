package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_detail")
public class Teacher {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="teacher_name")
	private String teacher_name;
	
	
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name) {
		super();
		this.teacher_name = name;
		
	}

	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.teacher_name = name;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return teacher_name;
	}

	public void setName(String name) {
		this.teacher_name = name;
	}

	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + teacher_name + "]";
	}
	
	
	
	
}
