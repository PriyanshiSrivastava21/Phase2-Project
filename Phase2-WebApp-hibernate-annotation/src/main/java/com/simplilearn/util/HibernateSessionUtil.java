package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Student;
import com.simplilearn.model.Subject;
import com.simplilearn.model.Teacher;
import com.simplilearn.model.Class;

public class HibernateSessionUtil {
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		factory =new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Class.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
	return factory;
	}
	

}
