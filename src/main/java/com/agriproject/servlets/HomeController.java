package com.agriproject.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession(false);
		if((hs!=null) && (hs.getAttribute("sessionTRruth")=="true"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("notloggedin.jsp"); 
			rd.forward(request, response);
		}
	}
}
