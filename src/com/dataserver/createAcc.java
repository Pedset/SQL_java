package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createAcc
 */
@WebServlet("/createAcc")
public class createAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		
		data dt = new data();
		
		PrintWriter out = response.getWriter();
		try {
			if (request.getParameter("newName").isEmpty() || request.getParameter("newPassword1").isEmpty()) {
				out.print("<br><p style=\"color:red;\">You need to type in a username or a password</p><br><br>");
				request.getRequestDispatcher("createAcc.jsp").include(request, response);
			}
			else {
				
			
				if (request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))){
					
					if(dt.checkUser(request.getParameter("userType"), request.getParameter("newName"))==false) {
					
						if(dt.createUser(request.getParameter("userType"), request.getParameter("newName"), request.getParameter("newPassword1"))) {
						out.print("<br><p style=\"color:green;\">Account created successfully</p><br><br>");
						request.getRequestDispatcher("index.jsp").include(request, response);
					}
						else {
							out.print("<br><p style=\"color:red;\">Something went wrong. Sry!</p><br><br>");
							request.getRequestDispatcher("createAcc.jsp").include(request, response);
						}
				}
				else {
					out.print("<br><p style=\"color:red;\">User already exists</p><br><br>");
					request.getRequestDispatcher("createAcc.jsp").include(request, response);
					
				}		
			}
				else {
					out.print("<br><p style=\"color:red;\">Passwords do not match, try again.</p><br><br>");
					request.getRequestDispatcher("createAcc.jsp").include(request, response);
				}
						
						
			  }
			
			}
	
		
		catch (Exception e) {
			out.print("Error");
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
