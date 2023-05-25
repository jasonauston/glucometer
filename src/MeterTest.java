/**
* Lead Author(s):
* @author Jason Auston; student ID 0001946438
*
* References:
* Morelli, R., & Walde, R. (2016). 
* Java, Java, Java: Object-Oriented Problem Solving
* Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
* <<Add more references here>>
*
* Version: 1
*/


import java.util.Random;

public class MeterTest
{

	private int testResultRandom;	//	has-a test result
	private String testResult;	//	has-a String version of the test result
	
	
	/**
	 * constructor, builds RNG test result
	 */
	public MeterTest()
	{
		
		//	creates an RNG instance
		Random randomNumberGenerator = new Random();
		
		//	creates a number between 0-500
		testResultRandom = randomNumberGenerator.nextInt(500);
		
		//	sets as the int test result
		setTestResult();
	}

	/**
	 * getter for string test result
	 * @return String test result
	 */
	public String getTestResult()
	{
		return testResult;
	}

	/**
	 * setter with if statements for the String test result
	 */
	public void setTestResult()
	{
		
		if (testResultRandom >= 400)
		{
			
			//	diabetes meters normally have a limit for how high they can read, i set it to 400
			testResult = "HI";
			
		}
		
		else if (testResultRandom <= 60)
		{
			
			// There's also a low reading too. i set it to 60.
			testResult = "LO";
			
		}
		
		else 
		{
			
			//	if not too high or too low, it just records the number as a String.
			testResult = String.valueOf(testResultRandom);
					
			
		}
	}
	

}
