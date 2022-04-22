package different_ways_to_post;

import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProject()
	{
		
		// pre req
		
		HashMap map = new HashMap();
		map.put("createdBy", "vijay");
		map.put("projectName", "tysss"+new Java_library().randomnum());
		map.put("status", "Completed");
		map.put("teamSize", 10);
		
		baseURI = "http://localhost";
		port = 8084;
			
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()         // perform actions
		.post("/addProject")
		
		.then()        // perform validations
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}
