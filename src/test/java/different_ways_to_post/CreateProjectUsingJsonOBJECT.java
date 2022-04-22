package different_ways_to_post;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonOBJECT
{
	@Test
	public void createproject()
	{
		// pre req
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vijay");
		jobj.put("projectName", "tysss"+new Java_library().randomnum());
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()         // perform actions
		.post("/addProject")
		
		.then()        // perform validations
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		
		
		
		
	}
}
