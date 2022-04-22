package curd_operations_with_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_All_Projects
{
	@Test
	public void getallprojects()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}
