package com.agriproject.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.agriproject.services.DataBaseService;

/**
 * Servlet implementation class EnterInputHistory
 */
@WebServlet("/EnterInputHistory")
public class EnterInputHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
		String name = request.getParameter("nameofinput");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String total = request.getParameter("total");
		DataBaseService dbs = new DataBaseService();
		String fid = (String)session.getAttribute("farmer_id");
		try {
			if(dbs.insertInputDetails(fid,name,price,quantity,total))
			{
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("inputInsertSuccess.jsp");
				RequetsDispatcherObj.forward(request, response);
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
