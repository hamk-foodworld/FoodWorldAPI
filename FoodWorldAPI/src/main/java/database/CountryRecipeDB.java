package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import data.CountryRecipe;

public class CountryRecipeDB {
	/**
	 * N:M Table between Country and Recipe, make connection between each other
	 * @param iCountryIDP
	 * @param iRecipeIDP
	 * @return
	 */
	public static boolean addToTable(int iCountryIDP, int iRecipeIDP) {
		Connection conn = DB.getConnection();		
		try {
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement("insert into CountryRecipe(countryID, recipeID) values(?,?)");
				stmt.setInt(1, iCountryIDP);
				stmt.setInt(1, iRecipeIDP);

				int i = stmt.executeUpdate();
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
