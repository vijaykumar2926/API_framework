package curd_operations_with_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Delete_project 
{
	@Test
	public void deleteproject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.delete("/projects/TY_PROJ_3202")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();

	}
}
