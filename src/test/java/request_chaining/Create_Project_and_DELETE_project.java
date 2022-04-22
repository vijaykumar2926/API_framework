package request_chaining;

import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLivrary.CreateprojectPOJO;

import static io.restassured.RestAssured.*;

public class Create_Project_and_DELETE_project 
{
	@Test
	public void createAndDeleteProject()
	{
		// create new project
		
		baseURI = "http://localhost";
		port = 8084;
		
		CreateprojectPOJO pLib = new CreateprojectPOJO("vijay", "werty "+new Java_library().randomnum(), "Created", 20);
				
		Response resp = given()
						.body(pLib)
						.contentType(ContentType.JSON)
		
						.when()
						.post("/addProject");
				
		// capture project id
			
		Object Pid = resp.jsonPath().get("projectId");
				
		System.out.println(Pid);
				
		resp.then().log().all();
		
		// delete the project by passing projectid as path parameter
		
		given()
		.pathParam("path", Pid)
		
		.when()
		.delete("/projects/{path}")
		
		.then()
		.assertThat().statusCode(204).log().all();		
		
		
	}
}
