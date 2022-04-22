package request_chaining;

import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLivrary.CreateprojectPOJO;

import static io.restassured.RestAssured.*;

public class Create_project_and_GET_project
{
	@Test
	public void createAndGetProject()
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
		
		String Pid = resp.jsonPath().get("projectId");
		
		System.out.println(Pid);
		
		resp.then().log().all();
		
		// create a get request and pass projectid as path parameter
		
		given()
		.pathParam("path", Pid)
		
		.when()
		.get("/projects/{path}")
		
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
}
