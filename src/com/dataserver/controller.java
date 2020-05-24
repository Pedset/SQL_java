package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		data dt = new data();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("name").isEmpty() || request.getParameter("password").isEmpty()) {
			out.print("<br><p style=\"color:red;\">" + " You need to type in a username and a password" + "</p><br><br>");
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
		}
		else {
			try {
				if(dt.check(request.getParameter("userType"),request.getParameter("name"),request.getParameter("password"))) {
					
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
				else {
					out.print("<br><p style=\"color:red;\"> Incorrect username or password! </p><br><br>");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
		}
	
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
