package com.agriproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataBaseService dbs = new DataBaseService();
		PrintWriter out = response.getWriter();
		String fid = request.getParameter("fid");
		try {
			if (dbs.find(fid)) {
				HttpSession hs = request.getSession();
				hs.setAttribute("sessionTRruth", "true");
				hs.setAttribute("farmer_id", fid);
				hs.setAttribute("uname", dbs.getFarmerDeatils(fid).getNameOfFarmer());
				RequestDispatcher rd = request.getRequestDispatcher("HomeController");
				System.out.println("bwjbrvjhb");
				rd.forward(request, response);
			} else {
				out.print("user not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
