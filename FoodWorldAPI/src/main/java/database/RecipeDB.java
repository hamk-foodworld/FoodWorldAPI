package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.Ingredient;
import data.Recipe;


public class RecipeDB {
	/**
	 * Returns an ArrayList of all Recipe
	 * @return all Recipe in an ArrayList
	 */
	public static ArrayList<Recipe> GetRecipe() {
		ArrayList<Recipe> RecipeList = new ArrayList<>();
		Connection conn = DB.getConnection();
		
		//Date dtToday = new Date();
		
		try {
			if (conn != null) {
				// get Recipe from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select * from Recipe");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					Recipe r = new Recipe();
					r = getRecipe(RS);									
					
					RecipeList.add(r);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RecipeList;
	}
	
	/**
	 * Return an object with all ingredients in it
	 * @param integer id of the specific Recipe
	 * @return Object Recipe with a List of Ingredients 
	 */
	
	public static Recipe getRecipeIng(int id){
		Connection conn = DB.getConnection();
		List<Ingredient> IngredientList = new ArrayList<Ingredient>();
		Recipe r = new Recipe();
		try {
			if (conn != null) {
				// get Recipe from database
				boolean firstRound = true;
				Statement stmt = conn.createStatement();
				String sSQL = "select * from Recipe r, Ingredient i where r.recipeID = i.recipeID and r.recipeID = ?";
				
				PreparedStatement pstmt;
				ResultSet RS;
				
				try {
					pstmt = conn.prepareStatement(sSQL);
					pstmt.setInt(1, id);
										
					RS = pstmt.executeQuery();
					
					//	Recipe r = new Recipe();
					
					while (RS.next()) {
						if(firstRound) {
							firstRound = false;
							r = getRecipe(RS);
						}
						System.out.println("Ingredient!");
						System.out.println();
						Ingredient i = new Ingredient();
						i.setiID(RS.getInt("id"));
						i.setsName(RS.getString("iname"));
						i.setiAmount(RS.getInt("amount"));
						
						IngredientList.add(i);
					}
					r.setIngredients(IngredientList);
					pstmt.close();
					RS.close();					
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	/**
	 * Return an ArrayList of Recipe to one specific country
	 * @param id is an integer of the countryID
	 * @return an ArrayList of Recipe to one specific country
	 */
	
	public static ArrayList<Recipe> getCountryRecipe(int id){
		ArrayList<Recipe> RecipeList = new ArrayList<>();
		Connection conn = DB.getConnection();
		
		//Date dtToday = new Date();
		
		try {
			if (conn != null) {
				// get Recipe from database				
				//Statement stmt = conn.createStatement();
				String sSQL = "select *\r\n" + 
						"from Recipe r, Country c, Countryrecipe cr\r\n" + 
						"where r.recipeID = cr.recipeID and\r\n" + 
						"c.countryID = cr.countryID and \r\n" + 
						"c.countryID = ?";
				PreparedStatement pstmt;
				ResultSet RS;
				
				try {
					pstmt = conn.prepareStatement(sSQL);
					pstmt.setInt(1, id);
										
					RS = pstmt.executeQuery();
					while(RS.next()) {
						Recipe r = new Recipe();
						r = getRecipe(RS);
						RecipeList.add(r);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RecipeList;		
	}
	
	private static Recipe getRecipe(ResultSet RS) {
		Recipe r = new Recipe();
		try {			
			r.setiRecipeID(RS.getInt("recipeID"));
			r.setsName(RS.getString("name"));
			r.setiCookingTime(RS.getInt("cookingTime"));
			r.setsDescription(RS.getString("description"));
			r.setiAmountPeople(RS.getInt("amountPeople"));
			r.setiRating(RS.getInt("rating"));
			r.setsPreparation(RS.getString("preparation"));
			r.setByVegan(RS.getByte("vegan"));
			r.setByVegetarian(RS.getByte("vegetarian"));
			r.setByGluten(RS.getByte("gluten"));
			r.setByLactose(RS.getByte("lactose"));
			r.setDtEntrydate(RS.getDate("entrydate"));					
			r.setsPic(RS.getString("pic"));
			r.setByPicBlob(RS.getBytes("picBlob"));
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return r;
	}
}
