package com.agriproject.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agriproject.services.DataBaseService;

/**
 * Servlet implementation class SignUpServlet
 */

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataBaseService dbs = new DataBaseService();
		String nameOfFarmer = request.getParameter("name");
		String mobileNumberOfFarmer = request.getParameter("mobile-number");
		String acres = request.getParameter("acres");
		String location = request.getParameter("location");
		String pincode = request.getParameter("pincode");
		try {
			request.setAttribute("ac",dbs.createFarmer(nameOfFarmer, mobileNumberOfFarmer, acres, location, pincode));
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("successSignup.jsp");
			RequetsDispatcherObj.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
