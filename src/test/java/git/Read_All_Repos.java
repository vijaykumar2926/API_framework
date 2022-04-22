package git;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Read_All_Repos 
{
	@Test
	public void readAllRepos()
	{
		baseURI = "https://api.github.com";
		
		given()
		.pathParam("username", "vijaykumar2926")
		
		.when()
		.get("/users/{username}/repos")
		
		.then()
		.log().all();
	
	}
}
