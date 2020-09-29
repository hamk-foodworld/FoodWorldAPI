package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.CountryDB;

import data.Country;

@Path ("/foodservice")
public class FoodWorldService {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String serviceName() {
		return "This is a FoodWorld service";
	}
		
	
	//	SELECT COUNTRIES
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getCountry")
	public List<Country> getCountryList() {
		System.out.println("GetCountry??");
		ArrayList<Country> countryList = CountryDB.GetCountry();
		if(countryList == null) {
			System.out.println("es is null");
			return null;
		}else {
			return countryList;
		}
		
	}
}
