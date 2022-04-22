package resposeValidation;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Dynamic_response_validation
{
	@Test
	public void ResponseValidation()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		String exp = "TY_PROJ_817";
		
		Response resp = when()
		.get("/projects");
		
		List<String> pids = resp.jsonPath().get("projectId");
		boolean flag = false;
		for (String act : pids) 
		{
			if (act.equalsIgnoreCase(exp)) 
			{
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		
		resp.then().log().all();
		
		
	}
}
