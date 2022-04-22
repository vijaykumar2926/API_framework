package crud_operations_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject 
{
	@Test
	public void getsingleproject() 
	{
		// create pre Requisites
		
		
		// perform action
		
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_002");
		
		// perform validation
		
		response.prettyPeek();
		int act = response.getStatusCode();
		Assert.assertEquals(act, 200);
	}
}
