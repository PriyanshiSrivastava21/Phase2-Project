package com.simplilearn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	
	
	@Column(name="student_marks")
	private double marks;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Class classes;
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Teacher> teachers;
	
	
	
	public Student() {
		super();
	}
	
	public Student(String name,  Double marks) {
		super();
		this.name = name;
		
		this.marks = marks;
	}

	public Student(int id, String name,  Double marks) {
		super();
		this.id = id;
		this.name = name;
		
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	

	

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}
	

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}
	
	public Set<Teacher> getTeachers(){
		return teachers;
		
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers=teachers;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ",  marks=" + marks + "]";
	}
	
	
	
	
}
