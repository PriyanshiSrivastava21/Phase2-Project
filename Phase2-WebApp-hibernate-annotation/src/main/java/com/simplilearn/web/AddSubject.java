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
import com.simplilearn.model.Subject;
import com.simplilearn.util.HibernateSessionUtil;


@WebServlet("/addsubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddSubject() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		request.getRequestDispatcher("addsubject.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("index.html").include(request,response);
		
		String subjectName=request.getParameter("name");
		
		
		try {
			
			SessionFactory factory =HibernateSessionUtil.buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			Subject subject=new Subject(subjectName);
			session.save(subject);
			tx.commit();
			if(session!=null) {
				out.println("<h3 style='color:green'> Subject is created successfully! </h3>");
			}
			session.close();
		}catch(Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed! </h3>");
		}
		
		
	}

}

