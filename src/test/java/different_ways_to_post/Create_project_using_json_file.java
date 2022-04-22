package different_ways_to_post;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;

public class Create_project_using_json_file 
{

	@Test
	public void createproject()
	{
		// pre req
		
		File file =new File(".\\data.json");
				
		baseURI = "http://localhost";
		port = 8084;
			
		given()
		.body(file)
		.contentType(ContentType.JSON)
			
		.when()         // perform actions
		.post("/addProject")
		
		.then()        // perform validations
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}
