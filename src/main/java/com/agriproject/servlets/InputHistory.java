package com.agriproject.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agriproject.services.DataBaseService;

/**
 * Servlet implementation class InputHistory
 */
public class InputHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs= request.getSession(false);
		DataBaseService dbs = new DataBaseService();
		try {
			request.setAttribute("result",(String[][])dbs.getInputHistory((String)hs.getAttribute("farmer_id")));
			RequestDispatcher rd = request.getRequestDispatcher("inputHistory.jsp");    
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
