package com.agriproject.services;

import java.sql.SQLException;

import com.agriproject.dao.DAOImpl;
import com.agriproject.entity.Farmer;

public class DataBaseService {

	public long getCountOfFarmersRegisteredTillNow() throws ClassNotFoundException, SQLException {
		DAOImpl daoimpl =  new DAOImpl();
		daoimpl.getFarmersCount();
		return daoimpl.getFarmersCount();
	}

	public String createFarmer(String nameOfFarmer, String mobileNumberOfFarmer, String acres, String location, String pincode) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DAOImpl daoimpl = new DAOImpl();
		Farmer farmer = new Farmer();
		farmer.setNameOfFarmer(nameOfFarmer);
		farmer.setMobileNumberOfFarmer(mobileNumberOfFarmer);
		farmer.setLocation(location);
		farmer.setAcres(acres);
		farmer.setPincode(pincode);
		return daoimpl.saveFarmer(farmer);
	}

	public boolean find(String fid) throws ClassNotFoundException, SQLException {
		DAOImpl daoimpl =  new DAOImpl();
		return daoimpl.find(fid);
	}

	public Farmer getFarmerDeatils(String fid) throws ClassNotFoundException, SQLException {
		DAOImpl daoimpl =  new DAOImpl();
		return daoimpl.getFarmerDetails(fid);
	}

	public boolean insertInputDetails(String fid, String name, String price, String quantity, String total) throws ClassNotFoundException, SQLException {
		DAOImpl daoimpl =  new DAOImpl();
		return daoimpl.insertInputDetails(fid,name,price,quantity,total);
	}

	public String[][] getInputHistory(String fid) throws ClassNotFoundException, SQLException {
		DAOImpl daoimpl =  new DAOImpl();
		return daoimpl.getInputHistory(fid);
	}

}
