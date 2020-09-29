package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.Statement;

import data.Country;

public class CountryDB {
	//	Data Country
	public static ArrayList<Country> GetCountry() {
		System.out.println("Some wrong....");
		ArrayList<Country> countryList = new ArrayList<>();
		Connection conn = DB.getConnection();
		System.out.println(conn.toString());
		System.out.println("Some wrong3....");
		try {
			if (conn != null) {
				// get country from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select * from Country");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					Country c = new Country();
					c.setiCountryID(RS.getInt("countryID"));
					c.setsName(RS.getString("name"));
					
					if(RS.getString("flag")!= null) {
						c.setsFlag(RS.getString("flag"));
					}
					
					if(RS.getByte("flagBlob")!= 0) {
						c.setByFlagBlob(RS.getBytes("flagBlob"));
					}
					
					countryList.add(c);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryList;
	}
}
