package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken 
{
	@Test
	public void bearertoken()
	{
		baseURI = "https://api.github.com";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "SDET30_restassured_eclipse");
		
		given()
		.auth().oauth2("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")
		.body(jobj)
		
		.when()
		.post("/user/repos")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
		
	}
}
