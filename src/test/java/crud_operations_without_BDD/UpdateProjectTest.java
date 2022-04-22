package crud_operations_without_BDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateproject()
	{
		// create pre req
		
		JSONObject Jobj = new JSONObject();
		Jobj.put("createdBy", "vijay");
		Jobj.put("projectName", "tyss2");
		Jobj.put("status", "Created");
		Jobj.put("teamSize", 20);
		
		RequestSpecification req = RestAssured.given();
		req.body(Jobj);
		req.contentType(ContentType.JSON);
		
		// perform action
		
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_002");
		
		// validation
		System.out.println(response.prettyPeek());
		int act = response.getStatusCode();
		Assert.assertEquals(act, 200);
	}
}
