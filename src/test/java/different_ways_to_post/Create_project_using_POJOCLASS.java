package different_ways_to_post;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;
import projectLivrary.CreateprojectPOJO;

public class Create_project_using_POJOCLASS 
{
	@Test
	public void createProject()
	{
		// pre req
		
		CreateprojectPOJO pojo = new CreateprojectPOJO("vijay", "tyss"+new Java_library().randomnum(), "Completed", 20);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()         // perform actions
		.post("/addProject")
		
		.then()        // perform validations
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}
