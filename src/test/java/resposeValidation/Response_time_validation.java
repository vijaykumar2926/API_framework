package resposeValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Response_time_validation
{
	@Test
	public void validateResponseTime()
	{

		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = when()
				.get("/projects");
		long acttime = resp.getTime();
		
		Assert.assertTrue(acttime<2000);
		
		resp.then()
		.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
		System.out.println("response time is less than 2000 MILLISECONDS");
		
		
		
		
	}
}
