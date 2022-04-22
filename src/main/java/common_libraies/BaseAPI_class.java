package common_libraies;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPI_class 
{
	public Database_library dLib = new Database_library();
	public Java_library jLib = new Java_library();
	public Restassured_library rLib = new Restassured_library();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		// establish connection with database
		dLib.connectToDatabase();
		System.out.println("=============== DB connection established ==================");
		
		// set BaseURI and Port
		baseURI = "http://localhost";
		port = 8084;
		
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDatabaseConnection();

	}
}
