package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;


import data.Ingredient;

public class IngredientDB {
	public static ArrayList<Ingredient> GetIngredient() {
		ArrayList<Ingredient> IngredientList = new ArrayList<>();
		Connection conn = DB.getConnection();
		
		try {
			if (conn != null) {
				// get Ingredient from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select * from Ingredient");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					Ingredient i = new Ingredient();					
					i.setiID(RS.getInt("id"));
					i.setsName(RS.getString("iname"));
					i.setiAmount(RS.getInt("amount"));
					
					IngredientList.add(i);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return IngredientList;
	}
}
