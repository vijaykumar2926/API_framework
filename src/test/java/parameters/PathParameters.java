package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters 
{
	@Test
	public void pathParameters()
	{
		// prereq

		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("path", "TY_PROJ_821")
		
		.when()
		.get("/projects/{path}")
		
		.then()
		.log()
		.all();
	}
}
