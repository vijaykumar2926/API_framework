package common_libraies;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This library contain generic method related to RestAssured 
 * @author vijay
 *
 */
public class Restassured_library 
{
	/**
	 * This method will return Json path 
	 * @param resp
	 * @param Jsonpath
	 * @return
	 */
	public String getJsonPath(Response resp , String Jsonpath)
	{
		String value = resp.jsonPath().get(Jsonpath);
		return value;
	}
}
