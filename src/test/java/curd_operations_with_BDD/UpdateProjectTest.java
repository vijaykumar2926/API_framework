package curd_operations_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest 
{
	@Test
	public void updateproject()
	{		
		JSONObject Jobj = new JSONObject();
		Jobj.put("createdBy", "vijay");
		Jobj.put("projectName", "tyss2");
		Jobj.put("status", "Created");
		Jobj.put("teamSize", 12);
		
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(Jobj)
		.contentType(ContentType.JSON)
		
		
		.when()
		.put("/projects/TY_PROJ_002")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
