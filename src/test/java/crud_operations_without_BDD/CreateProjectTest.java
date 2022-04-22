package crud_operations_without_BDD;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void createproject()
	{
		// create pre-requisites
		JSONObject Jobj = new JSONObject();
		Jobj.put("createdBy", "vijay");
		Jobj.put("projectName", "tyss2454");
		Jobj.put("status", "Created");
		Jobj.put("teamSize", 29);
		
		RequestSpecification resg = RestAssured.given();
		resg.body(Jobj);
		resg.contentType(ContentType.JSON);
		
		// Perform the action
		
		Response response = resg.post("http://localhost:8084/addProject");

		// perform verification
		
		System.out.println(response.prettyPeek());
		int act = response.getStatusCode();
		
		Assert.assertEquals(act, 201);
	}
}
