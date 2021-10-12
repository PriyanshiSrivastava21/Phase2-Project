package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.Student;
import com.simplilearn.model.Class;
import com.simplilearn.util.HibernateSessionUtil;


@WebServlet("/add-student-with-class")
public class AddStudentWithClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddStudentWithClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		request.getRequestDispatcher("addstudentwithclass.html").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		
		String studentName=request.getParameter("name");
		
		String studentMarks=request.getParameter("marks");
		//student_class
		
		String class_name=request.getParameter("class_name");
		
		
		try {
			
			SessionFactory factory =HibernateSessionUtil.buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			Student student=new Student(studentName,Double.parseDouble(studentMarks));
			
			Class classes=new Class(class_name);
		
			student.setClasses(classes);
			
			session.save(student);
			
			tx.commit();
			if(session!=null) {
				out.println("<h3 style='color:green'> Student is created with class successfully! </h3>");
			}
			session.close();
		}catch(Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed! </h3>");
		}
		
	}

}
