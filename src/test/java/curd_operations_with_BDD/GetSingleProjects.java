package curd_operations_with_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjects 
{
	@Test
	public void getsingleproject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("/projects/TY_PROJ_002")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
