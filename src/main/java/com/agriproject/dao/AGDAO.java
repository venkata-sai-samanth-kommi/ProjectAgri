package com.agriproject.dao;

import java.sql.SQLException;

import com.agriproject.entity.Farmer;

public interface AGDAO {
	public long getFarmersCount() throws ClassNotFoundException, SQLException;
	public String saveFarmer(Farmer farmer) throws ClassNotFoundException, SQLException;
}
