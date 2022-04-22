package resposeValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Static_response_validation_getAll
{
	@Test
	public void validateResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		String exp = "TY_PROJ_002";
		
		Response resp = when()
		.get("/projects");
		
		String act = resp.jsonPath().get("[0].projectId");
		
	
		Assert.assertEquals(act, exp);
		System.out.println("data vereified");
		
		resp.then()
		.log().all();
		
		
	}
}
