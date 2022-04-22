package rmgAPITestUsingFRAMEWORK;

import org.testng.annotations.Test;


import common_libraies.BaseAPI_class;
import common_libraies.EndPoints_library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLivrary.CreateprojectPOJO;

import static io.restassured.RestAssured.*;

public class Create_project_using_Api_And_verify_in_Database extends BaseAPI_class{
	
	@Test
	public void createProjectVerifyInDb() throws Throwable
	{
		//Step 1: create Pre req
		CreateprojectPOJO pLib = new CreateprojectPOJO("vijay", "Amdocs "+jLib.randomnum(), "On Going", 20);
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		 
	                   	  .when()
		                  .post(EndPoints_library.CreateProject);
		
		//Step 2: Capture the project ID
		String expData = rLib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		//Step 3: Verify the project in API response
		given()
		 .pathParam("pid", expData)
		.when()
		 .get(EndPoints_library.Getsingleproject+"/{pid}")
		.then().log().all();
		System.out.println("Data successfuly verifies in API response");
		
		//Step 4: Verify the project in Database
		String query = "select * from project";
		String data = dLib.executeQueryAndGetData(query,expData, 1);
		System.out.println(data);
		System.out.println("data verifed successfully in databse");
		 
		
	}

}
