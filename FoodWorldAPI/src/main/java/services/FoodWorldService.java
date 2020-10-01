package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.CountryDB;
import database.RecipeDB;
import database.IngredientDB;
import database.UnitDB;

import data.Country;
import data.Recipe;
import data.Ingredient;
import data.Unit;
import data.Rating;

@Path ("/foodservice")
public class FoodWorldService {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String serviceName() {
		return "This is a FoodWorld service";
	}
		
	//	Country
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getCountry")
	public List<Country> getCountryList() {
		System.out.println("GetCountry??");
		ArrayList<Country> countryList = CountryDB.GetCountry();

		return countryList;	
	}
	
	//	Recipe
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getRecipe")
	public List<Recipe> getRecipeList() {
		System.out.println("GetRecipe??");
		ArrayList<Recipe> recipeList = RecipeDB.GetRecipe();
		
		return recipeList;	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getRecipe/{p1}")
	public Recipe getRecipeIng(@PathParam("p1") int id) {
		
		System.out.println("GetRecipeIng??");
		Recipe r = RecipeDB.getRecipeIng(id);

		return r;	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getCountryRecipe/{p1}")
	public List<Recipe> getCountryRecipeList(@PathParam("p1") int id) {
		
		System.out.println("GetCountryRecipeList??");
		ArrayList<Recipe> recipeList = RecipeDB.getCountryRecipe(id);

		return recipeList;	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addRecipe")
	public Recipe addRecipe(Recipe r) {
		System.out.println("AddRecipe???");
		RecipeDB.addJsonRecipe(r);		
		return r;
	}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addRating")
	public void setRating(Rating ra) {
		System.out.println("setRecipe???");
		RecipeDB.setRating(ra);
	}
	
	//	Ingredient
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getIngredient")
	public List<Ingredient> getIngredientList() {
		System.out.println("GetIngredient??");
		ArrayList<Ingredient> ingredientList = IngredientDB.GetIngredient();

		return ingredientList;	
	}
	
	//	Unit
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getUnit")
	public List<Unit> getUnitList() {
		System.out.println("GetUnit??");
		ArrayList<Unit> unitList = UnitDB.GetUnit();

		return unitList;	
	}

	
}
