
/**
 * 
 */
package com.agriproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agriproject.dbconnection.DBConnection;
import com.agriproject.entity.Farmer;
import com.agriproject.idgen.IDGenerator;


/**
 * @author DELL
 *
 */
public class DAOImpl implements AGDAO {

	DBConnection dbc = new DBConnection();

	@Override
	public long getFarmersCount() throws ClassNotFoundException, SQLException {
		String query = "select * from farmer_count;";
		Connection con = dbc.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		long farmer_count = rs.getLong(1);
		System.out.println("x"+farmer_count);
		con.close();
		return farmer_count;
	}

	@Override
	public String saveFarmer(Farmer farmer) throws ClassNotFoundException, SQLException {
		IDGenerator idg = new IDGenerator();
		String fid = idg.getIdForNewFarmer(farmer);
		Connection con = dbc.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into farmer_details values(?,?,?,?,?,?)");
		stmt.setString(1, fid);
		stmt.setString(2, farmer.getNameOfFarmer());
		stmt.setString(3, farmer.getMobileNumberOfFarmer());
		stmt.setString(4, farmer.getAcres());
		stmt.setString(5, farmer.getLocation());
		stmt.setString(6, farmer.getPincode());
		stmt.execute();
		stmt = con.prepareStatement("UPDATE farmer_count SET count_of_farmers = ?");
		stmt.setLong(1, getFarmersCount()+1);
		stmt.execute();
		con.close();
		return fid;
	}

	public boolean find(String fid) throws SQLException, ClassNotFoundException {
		Connection con = dbc.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from farmer_details where fid= ?");
		stmt.setString(1, fid);
		try {
		return stmt.execute();
		}
		finally {
			con.close();
		}
	}

	public Farmer getFarmerDetails(String fid) throws ClassNotFoundException, SQLException {
		Connection con = dbc.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from farmer_details where fid= ?");
		stmt.setString(1, fid);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Farmer farmer = new Farmer();
		farmer.setNameOfFarmer(rs.getString("name_of_farmer"));
		farmer.setAcres(rs.getString("acres_of_land"));
		farmer.setLocation(rs.getString("location_of_farming"));
		farmer.setMobileNumberOfFarmer(rs.getString("mobilenumber_of_farmer"));
		farmer.setPincode(rs.getString("pincode"));
		con.close();
		return farmer;
	}

	public boolean insertInputDetails(String fid, String name, String price, String quantity, String total) throws ClassNotFoundException, SQLException {
		Connection con = dbc.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into input_history values(?,?,?,?,?)");
		stmt.setString(1, fid);
		stmt.setString(2, name);
		stmt.setString(3, price);
		stmt.setString(4, quantity);
		stmt.setString(5, total);
		stmt.execute();
		con.close();
		return true;
	}

	public String[][] getInputHistory(String fid) throws ClassNotFoundException, SQLException {
		Connection con = dbc.getConnection();
		//optimization possible.
		int count=0;
		PreparedStatement stmt1 = con.prepareStatement("select count(*) from input_history where fid = ?");
		stmt1.setString(1, fid);
		ResultSet rs = stmt1.executeQuery();
		while (rs.next()){
            count = rs.getInt(1);
        }
//		System.out.println(count);
		String result[][] = new String[count][5];
		PreparedStatement stmt = con.prepareStatement("select * from input_history where fid = ?");
		stmt.setString(1, fid);
		System.out.println(fid+" "+count+" ");
		ResultSet resultset = stmt.executeQuery();
		int j =0; //result index.
		while(resultset.next())
		{
			if(j<count)
			{
			result[j][0] = resultset.getString("name");
			result[j][1] = resultset.getString("quantity");
			result[j][2] = resultset.getString("price");
			result[j][3] = resultset.getString("total");
			j++;
			}
		}
		con.close();
		return result;
	}

	public boolean matchAdminWithPass(String name, String password) throws ClassNotFoundException, SQLException {
		Connection con = dbc.getConnection();
		String pass="";
		PreparedStatement stmt = con.prepareStatement("select password from admin_details where name= ?");
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		if(!rs.next())
		{ System.out.println("pass2");
			con.close();
			return false;
		}
		else
		{  
			pass = rs.getString("password");
		}
		con.close();
		return pass.equals(password);
	}

}
