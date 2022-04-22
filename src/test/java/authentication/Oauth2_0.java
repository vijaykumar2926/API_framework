package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 
{
	@Test
	public void OuthAuthentication()
	{
		
		// create a request to generate the token
		
		Response resp = given()
		.formParam("client_id", "SDET30COOPS")
		.formParam("client_secret", "500b2b6ba0a682b3b4a715c9552d2eff")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://vijay.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		// create a request using the generated token
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3121)
		.pathParam("end_point", "eggs-collect")
		
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/{end_point}")
		
		.then()
		.log().all();
		
		
		
	}
}
