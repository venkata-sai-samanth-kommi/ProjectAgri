/**
 * 
 */
package com.agriproject.idgen;

import java.sql.SQLException;

import com.agriproject.entity.Farmer;
import com.agriproject.services.DataBaseService;

/**
 * @author SaiSamanth_Kommi
 *
 */
public class IDGenerator {

	/**
	 * This method will generate a unique id for the farmer.
	 * 
	 * @param farmer
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String getIdForNewFarmer(Farmer farmer) throws ClassNotFoundException, SQLException {
		DataBaseService dbs = new DataBaseService();
		long farmer_count = dbs.getCountOfFarmersRegisteredTillNow();
		System.out.println(farmer_count);
		int number_of_zeros_to_append = 7 - (int) Math.floor(Math.log10(farmer_count+1)+1);// seven indicates digits
		System.out.println(number_of_zeros_to_append);// remaining in id after
																					// usage of first three
																							// letters of pincode;
		String toBeAppended = "";
		if(farmer_count==0)
			toBeAppended = "000000";
		else
		for (int i = 0; i < number_of_zeros_to_append; i++) {
			toBeAppended = toBeAppended + "0";
		}
		System.out.println(toBeAppended);		
		System.out.println("PA" + farmer.getPincode().substring(0, 3) + toBeAppended + (farmer_count+1));
		return "PA" + farmer.getPincode().substring(0, 3) + toBeAppended + (farmer_count+1);
	}

}
