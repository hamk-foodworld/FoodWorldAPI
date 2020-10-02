package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Array;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import data.Ingredient;
import data.Recipe;
import data.Rating;
import data.FavRecipe;

import database.IngredientDB;


public class RecipeDB {
	private static String sTABLE_SCHEMA = "foodworld";
	/**
	 * Returns an ArrayList of all Recipe
	 * @return all Recipe in an ArrayList
	 */
	public static ArrayList<Recipe> GetRecipe() {
		ArrayList<Recipe> RecipeList = new ArrayList<>();
		Connection conn = DB.getConnection();
		
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
				//String sSQL = "select * from Recipe r, Ingredient i where r.recipeID = i.recipeID and r.recipeID = ?";
				String sSQL = "select * from Recipe r, Ingredient i, Unit u where r.recipeID = i.recipeID and i.unitID = u.id and r.recipeID = ?";
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
						i.setsUnit(RS.getString("uname"));
						i.setsAcronym(RS.getString("acronym"));
						//i.set setsAcronym(RS.getString("sAcronym"));
						
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

		try {
			if (conn != null) {
				// get Recipe from database				
				//Statement stmt = conn.createStatement();
				String sSQL = "select *\r\n" + 
						"from Recipe r, Country c, CountryRecipe cr\r\n" + 
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
	
	/**
	 * Receive the input data of the users to create a new recipe
	 * @param Recipe object
	 * @return new recipe object but the recipeID is not correct
	 */
	
	public static Recipe addJsonRecipe(Recipe r) {
		Date now = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String sToday = formatter.format(now);
                
        System.out.println("Systemtime:" + now.toLocaleString());
        System.out.println("Date now: " + now);
        System.out.println("String sToday: " + sToday);
        
		String sSQLRecipe="insert into Recipe"
		+ "(name,cookingTime,description,amountPeople,preparation,"
		+ "vegan,vegetarian,gluten,lactose,entrydate,pic,rating) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int iRecipeID;
		
		Connection conn = DB.getConnection();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sSQLRecipe);
			System.out.println("RecipeID: " + r.getiRecipeID());
			pstmt.setString(1, r.getsName());
			pstmt.setInt(2, r.getiCookingTime());
			pstmt.setString(3, r.getsDescription());
			pstmt.setInt(4, r.getiAmountPeople());
			pstmt.setString(5, r.getsPreparation());
			pstmt.setByte(6, r.getByVegan());
			pstmt.setByte(7, r.getByVegetarian());
			pstmt.setByte(8, r.getByGluten());
			pstmt.setByte(9, r.getByLactose());
			pstmt.setString(10, (sToday));
			pstmt.setString(11, r.getsPic());
			pstmt.setInt(12, 0);
			pstmt.execute();
			
			//	Get RecipeID
			iRecipeID = getAutoIncrementValue("Recipe");
			System.out.println("Neue RecipeID: " + iRecipeID + "DBRecipeID: " + r.getiRecipeID());
			
			if(! addToIngredients(r.getIngredients(), iRecipeID)) {
				System.out.println("Error in AddIngredients!!");
			}			
			
			if(! addToMatchingTable(iRecipeID, r.getiCountryID())) {
				System.out.println("Error in AddMatchingTable!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return r;
	}
	/**
	 * Add all ingredients of one recipe in the database
	 * @param ingListP List of all Ingredients in the object recipe
	 * @param iReciptID
	 * @return true => success false => error
	 * @throws SQLException 
	 */
	public static boolean addToIngredients(List<Ingredient> ingListP, int iReciptID){
		Connection conn = DB.getConnection();
		//Connection conn = DB.getConnectionCommit();
		String sSQL = "insert into Ingredient (iname,amount,recipeID,unitID) values (?,?,?,?)";
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sSQL);
			Iterator<Ingredient> it = ingListP.iterator();
			while(it.hasNext()){
				Ingredient i = it.next();
				pstmt.setString(1, i.getsName());
				pstmt.setInt(2, i.getiAmount());
				pstmt.setInt(3, iReciptID);
				pstmt.setInt(4, i.getiUnit());
				
				//Integer unit = Integer.parseInt(i.getsUnit());
				//pstmt.setInt(4, unit);
				
				
				pstmt.execute();				
			}

			conn.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return false;
	}
	
	public static boolean addToMatchingTable(int iRecipeIDP, int iCountryIDP) {
		Connection conn = DB.getConnection(); 
		String sSQL = "insert into CountryRecipe (countryID,recipeID) values (?,?)";
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sSQL);
			pstmt.setInt(1, iCountryIDP);
			pstmt.setInt(2, iRecipeIDP);
			pstmt.execute();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return false;		
	}
	/**
	 * Recieve a list of recipeID (Integer) and returns an ArrayList of recipe
	 * @param iList recipeID in a integer list
	 * @return ArrayList of all favorite recipe
	 */
	public static ArrayList<Recipe> getFav(List<Integer> iList){
		ArrayList<Recipe> RecipeList = new ArrayList<>(); 
		Connection conn = DB.getConnection(); 
		String sSQL = "select * from Recipe where recipeID in (?)";
		String sqlIN = iList.stream()
				.map(x -> String.valueOf(x))
				.collect(Collectors.joining(",", "(", ")"));
		
		sSQL = sSQL.replace("(?)", sqlIN);
		PreparedStatement pstmt;
		ResultSet RS;
		
		try {
			pstmt = conn.prepareStatement(sSQL);
			RS = pstmt.executeQuery();
			
			while(RS.next()) {
				Recipe r = new Recipe();
				r = getRecipe(RS);				
				RecipeList.add(r);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return RecipeList;
	}
	
	/**
	 * Get one object of recipe
	 * @param ResultSet RS
	 * @return object recipe
	 */
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
	
	private static int getAutoIncrementValue(String sTableNameP) {
		Connection conn = DB.getConnection(); 
		String sSQL = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
		
		PreparedStatement pstmt;
		ResultSet RS;
		int iAutoIncrement = 0;
		
		try {
			pstmt = conn.prepareStatement(sSQL);
			pstmt.setString(1, sTABLE_SCHEMA);
			pstmt.setString(2, sTableNameP);
			System.out.println("Table Schema: " + sTABLE_SCHEMA + " / TableName: " + sTableNameP);				
			RS = pstmt.executeQuery();
			
			while(RS.next()) {
				//	-1 catch the right Auto_Increment value
				iAutoIncrement = RS.getInt("AUTO_INCREMENT") - 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return iAutoIncrement;
	}
	
	/**
	 * Increase or Decrease rating of a recipe by pressing the heart icon
	 * isbState: true => Like / false => dislike 
	 * @param object of Rating have bState and iRecipeID
	 */	
	public static void setRating(Rating ra) {
		Connection conn = DB.getConnection(); 
		String sSQL = "Update Recipe set rating = rating + ? where recipeID = ?";
		int like = 0;
		
		like = ((ra.isbState()) ? 1 : -1);
		
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sSQL);
			pstmt.setInt(1, like);
			pstmt.setInt(2, ra.getiRecipeID());
			pstmt.execute();
			
			conn.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//	return getRating(iRecipeP); 
	}
	
}
