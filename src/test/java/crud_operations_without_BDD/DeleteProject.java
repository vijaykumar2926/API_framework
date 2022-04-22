package crud_operations_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject 
{
	@Test
	public void deleteproject()
	{
		// create pre req
		// perform actions
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_822");
		// perform validation
		
		System.out.println(response.prettyPeek());
		
		int stscode = response.getStatusCode();
		Assert.assertEquals(stscode, 204);
		
		
	}
}
