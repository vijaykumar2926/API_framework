package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParamaters 
{
	@Test
	public void pathParameter()
	{
		// pre req
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		 .formParam("createdBy", "vijay")
		 .formParam("projectName", "tyss")
		 .formParam("status", "Created")
		 .formParam("teamSize", 30)
		 .contentType(ContentType.JSON)
		 
		 .when()
		 .post("/addProject")
		 
		 .then()
		 .log().all();
	}
}
