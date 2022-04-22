package curd_operations_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create_project 
{
	@Test
	public void createproject()
	{
		JSONObject Jobj = new JSONObject();
		Jobj.put("createdBy", "vijay");
		Jobj.put("projectName", "tyss102");
		Jobj.put("status", "Created");
		Jobj.put("teamSize", 20);
		
		baseURI = "http://localhost";
		port = 8084;
		
		 given()
		.body(Jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
		
	}
}
