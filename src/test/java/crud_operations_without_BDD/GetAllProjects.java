package crud_operations_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects 
{
	@Test
	public void getallprojects() 
	{
		// perform action
		Response response = RestAssured.get("http://localhost:8084/projects");
		response.then().log().all();
		int actcode = response.getStatusCode();
		Assert.assertEquals(actcode, 200);
	}
}
