package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import data.CountryRecipe;
import data.Unit;

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
	
	/**
	 * Get a list of CountryRecipe
	 * @return a list of CountryRecipe
	 */
	
	public static ArrayList<CountryRecipe> getCountryRecipe(){
		Connection conn = DB.getConnection();		
		ArrayList<CountryRecipe> countryRecipeList = new ArrayList<>();
		try {
			if (conn != null) {
				// get Unit from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select * from CountryRecipe");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					CountryRecipe cr = new CountryRecipe();
					cr.setiCountryID(RS.getInt("countryID"));
					cr.setiRecipeID(RS.getInt("recipeID"));

					countryRecipeList.add(cr);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryRecipeList;
	}
	
	/**
	 * Returns an ArrayList of countries with the numbers included recipes
	 * @return ArrayList<CountryRecipe> with all included recipes (iAnzahl)
	 */
	public static ArrayList<CountryRecipe> getCountryRecipeZahl(){
		Connection conn = DB.getConnection();		
		ArrayList<CountryRecipe> countryRecipeList = new ArrayList<>();
		try {
			if (conn != null) {
				// get Unit from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select countryID, count(*) from CountryRecipe group by countryID order by countryID");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					CountryRecipe cr = new CountryRecipe();
					cr.setiCountryID(RS.getInt("countryID"));
					//cr.setiRecipeID(RS.getInt("recipeID"));
					cr.setiAnzahl(RS.getInt("count(*)"));
					countryRecipeList.add(cr);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryRecipeList;
	}
}
