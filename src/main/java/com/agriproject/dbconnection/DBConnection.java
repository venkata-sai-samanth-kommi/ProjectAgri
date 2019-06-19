package com.agriproject.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		DBDetails dbdts = new DBDetails();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbdts.getUrl(), dbdts.getUname(), dbdts.getPwd());
		return con;
	}
}
