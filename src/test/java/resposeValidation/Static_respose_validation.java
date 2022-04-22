package resposeValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_libraies.Java_library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLivrary.CreateprojectPOJO;

import static io.restassured.RestAssured.*;

public class Static_respose_validation
{
	@Test
	public void responseValidation()
	{
		// prereq
		
		baseURI = "http://localhost";
		port = 8084;
		CreateprojectPOJO pojo = new CreateprojectPOJO("vijay", "qwerty "+new Java_library().randomnum(), "Created", 20);
		
		Response resp = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		String act = resp.jsonPath().get("projectName");
		Assert.assertTrue(act.contains("qwerty"));
		System.out.println("data verified");
		resp.then().log().all();
		
		
		

	}
}
