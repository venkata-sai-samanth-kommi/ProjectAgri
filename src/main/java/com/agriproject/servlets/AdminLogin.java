package com.agriproject.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agriproject.services.DataBaseService;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("aid");
		String password = request.getParameter("password");
		DataBaseService dbs = new DataBaseService();
		try {
			if(dbs.matchAdminWithPass(name,password))
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("admin", name);
				RequestDispatcher rd = request.getRequestDispatcher("farmerIndex.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("adminNotFound.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("adminNotFound.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
