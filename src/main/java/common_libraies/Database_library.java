package common_libraies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contain generic methods relates+d to database
 * @author vijay
 *
 */
public class Database_library 
{
	Driver driver;
	Connection con;
	
	/**
	 * This method will establish connection with database
	 * @throws Throwable
	 */
	public void connectToDatabase() throws Throwable
	{
		driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(Constants_library.dbURL, Constants_library.dbUsername, Constants_library.dbPassword);
	}
	
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDatabaseConnection() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method will check for the expected data in database 
	 * and return the expected data if it is present in database 
	 * else it will return empty string
	 * @param query
	 * @param expdata
	 * @param column
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query ,String expdata ,int column) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String data = result.getString(column);
			if (data.equalsIgnoreCase(expdata)) 
			{
				flag = false;
				break;
			}
		}
		
		if (flag) 
		{
			System.out.println(expdata+" is verified in database");
			return expdata;
		}else {
			System.out.println(expdata+" is verified in database");
			return "";
		}
	}
	
	
}
