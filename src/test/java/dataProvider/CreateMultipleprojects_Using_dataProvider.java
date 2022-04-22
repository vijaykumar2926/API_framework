package dataProvider;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common_libraies.Java_library;
import curd_operations_with_BDD.Create_project;
import io.restassured.http.ContentType;
import projectLivrary.CreateprojectPOJO;

public class CreateMultipleprojects_Using_dataProvider 
{
	@Test (dataProvider = "getdata")
	public void createProject(String createdBy,String projectName,String Status, int teamSize)
	{
		// pre req
		CreateprojectPOJO data = new CreateprojectPOJO(createdBy, projectName+new Java_library().randomnum(), Status, teamSize);

		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(data)
		.contentType(ContentType.JSON)
		
		// actions
		.when()
		.post("/addProject")
		
		// validation
		.then()
		.log().all();
		
	}
	
	@DataProvider(name = "getdata")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "vijay";
		data[0][1] = "TYSS";
		data[0][2] = "On Going";
		data[0][3] = 10;
		
		data[1][0] = "chitra";
		data[1][1] = "hp";
		data[1][2] = "Created";
		data[1][3] = 20;
		
		data[2][0] = "vinay";
		data[2][1] = "dell";
		data[2][2] = "On Going";
		data[2][3] = 20;
		
		return data;
	}
 }
