package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class saveInfo
 */
@WebServlet("/saveInfo")
public class saveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveInfo() {
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
		
		if(request.getParameter("txt").length()<21) {
			try {
				dt.saveUserData(request.getParameter("txt"));
				out.print("<br><p style=\"color:green;\">successfully saved</p><br><br>");
				request.getRequestDispatcher("welcome.jsp").include(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			out.print("<br><p style=\"color:red;\">Should be less than 20 characters</p><br><br>");
			request.getRequestDispatcher("welcome.jsp").include(request, response);
			
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
