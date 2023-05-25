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


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LogFileReview extends LogFileObject
{
	
	
	public LogFileReview(String line)
	{
		super(line);
		// TODO Auto-generated constructor stub
	}

	private static BufferedReader reader;	//	has-a reader
	
	private static final String FILE_NAME = "testResults.csv";	//	has-a file name
	private static ArrayList<LogFileReview> csvArrayList = null;	//	has-an ArrayList
	
	public static void LogFileRead() throws IOException
	{
		try
		{
			
			//	opens the reader
			reader = new BufferedReader(new FileReader(FILE_NAME));
			
			//	creating the array list 
			csvArrayList = new ArrayList<LogFileReview>();
			
			//	string to pass elements from the arraylist
			String line;
	        
			//	while the line is not null, it reads from the file
	        while ((line = reader.readLine()) != null) 
	        {
	        	
	        	//	copies to string array
	        	LogFileReview values = new LogFileReview(line);
	        	csvArrayList.add(values);
	            
	        }
			
		}
		
		
		
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			
			//	closes the reader
			reader.close();
			
		}

	}
	
	/**
	 * getter for the arraylist to use in other classes
	 * @return	csvArrayList
	 */
	public static ArrayList<LogFileReview> getCsvArrayList() 
	{
		
		return csvArrayList;
       
    }


}