package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path ("/foodservice")
public class FoodWorldService {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String serviceName() {
		return "This is a FoodWorld service";
	}
	
	
	//	SELECT COUNTRIES
	
}
