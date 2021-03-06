package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.model.Class;
import com.simplilearn.util.HibernateSessionUtil;

@WebServlet("/list-class")
public class ListClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListClasses() { }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		try {
			//load session factory 
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			// create a session object
			Session session = factory.openSession();
			// read products
			List<Class> classes = session.createQuery("from Class").list();
			
			//show data as table.
			out.print("<h1>List of Class :- </h1>");
			
			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
			out.print("<table >");
			out.print("<tr>");
				out.print("<th> Class Id</th>");
				out.print("<th> Class name </th>");
				
			out.print("</tr>");
			
			for(Class p : classes) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				
				//out.print("<td>"+p.getMarks()+"</td>");
				
				out.print("</tr>");
			}
			out.print("</table>");
			
			//close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}