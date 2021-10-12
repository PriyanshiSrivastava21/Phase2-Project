package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Student;
import com.simplilearn.model.Teacher;
import com.simplilearn.util.HibernateSessionUtil;


@WebServlet("/add-student-with-teacher")
public class AddStudentWithTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddStudentWithTeacher() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		request.getRequestDispatcher("addstudentwithteacher.html").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		
		String studentName=request.getParameter("name");
		
		String studentMarks=request.getParameter("marks");
		
		String teacher1Name=request.getParameter("teacher1_name");
		String teacher2Name=request.getParameter("teacher2_name");
		try {
			SessionFactory factory =HibernateSessionUtil.buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			Student student=new Student(studentName,Double.parseDouble(studentMarks));
			
			Set<Teacher> teachers=new HashSet<>();
			
			Teacher teacher1=new Teacher(teacher1Name);
			Teacher teacher2=new Teacher(teacher2Name);
			teachers.add(teacher1);
			teachers.add(teacher2);
			student.setTeachers(teachers);
			session.save(student);
			tx.commit();
			
			
		if(session!=null) {
			out.println("<h3 style='color:green'> Student is created with teachers successfully! </h3>");
		}
		session.close();
	}catch(Exception e) {
		out.print("<h3 style='color:red'> Hibernate session is failed! </h3>");
	}
	
}

}
