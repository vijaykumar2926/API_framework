package common_libraies;

import java.util.Random;

/**
 * This class contains generic methods related java 
 * @author vijay
 *
 */
public class Java_library 
{
	/**
	 * This method will generate random number
	 * @return
	 */
	public int randomnum()
	{
		Random random = new Random();
		int rnum = random.nextInt(1000);
		return rnum;
	}
}
