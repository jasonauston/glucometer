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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;   
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;



public class LogFileStuff extends LogFileObject
{
	
	public LogFileStuff(String line)
	{
		super(line);
		// TODO Auto-generated constructor stub
	}



	private static BufferedWriter writer;	//	has-a buffered writer
	private static BufferedReader reader;	//	has-a buffered reader
	
	private static final String FILE_NAME = "testResults.csv";	//	has-an immutable string filename
	private static final int MAX_ENTRIES = 10;	//	has-an immutable amount of max entries in that log file
	private static File file;	//	has-a file
	
	private static LinkedList<LogFileStuff> csvList;	//	has-a linkedlist
	
	
	/**
	 * method that will do a few things, ill comment in the method
	 */
	public static void LogFileWrite()
	{
		try
		{
			//	instances a new file
			file = new File(FILE_NAME);
			
			//	checks that the file exists
			if (file.exists())
			{
				//	if its there, this portion is error correcting.
				//	if for some reason there are more than 10 entries, it will remove until theres 10.
				//	i mostly used this in testing but i left it in because if there was an issue, i would rather it not be a memory one
				while (countEntries() > MAX_ENTRIES)
				{
					
					removeOldEntries();
					
				}
				
			}
			
			//	opens a new buffered writer and file writer.  it is set to append mode
			writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
			
			//	variables for date and time, formated in a particular way.
//			formattedDate = getDate();
//			formattedTime = getTime();
			
			//	enters a new line
			writer.newLine();
			
			//	writes the test result, uses the comma as a delimiter and then adds date and time into their own columns too
			writer.write(TestButton.getTestResult() + "," + DateTimeLabel.getDate() + "," + DateTimeLabel.getTime());
			
			//	closes the writer
			writer.close();
		}
		
		catch (IOException e)
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * this method counts the entries in the log file
	 * @return returns the number of log entries
	 * @throws IOException
	 */
	
	public static int countEntries() throws IOException 
	{
		//	temp variable to store number of rows
        int numEntries = 0;
        
        //	opens reader
        reader = new BufferedReader(new FileReader(FILE_NAME));
        
        //	while loops to iterate between the rows
        while (reader.readLine() != null) 
        {
        	
        	//	ticks up each time it finds a row
        	numEntries++;
        	
        }
        
        //	closes reader
        reader.close();
        
        return numEntries;
        
    }
	
	
	/**
	 * method to remove the oldest entries to get to max entries
	 */
	public static void removeOldEntries()
	{
		try
		{
			
			//	opens the reader
			reader = new BufferedReader(new FileReader(FILE_NAME));
			
			//	creates a new linked list, type is from abstract
			csvList = new LinkedList<LogFileStuff>();
			
			//	string to hold the line in the linked list
			String line;
	        
			//	checks of the line is null or not before it starts reading
	        while ((line = reader.readLine()) != null) 
	        {
	        	
	        	//	reads the line into an object from the abstract, and then adds to csvList
	        	LogFileStuff values = new LogFileStuff(line);
	            csvList.add(values);
	            
	        }
	        
	        //	closes the reader
	        reader.close();
			
			
	        //	if the linkedlist is not empty, it removes the element in the number 1 spot (0 is the header)
			if (!csvList.isEmpty()) 
			{
				
				csvList.remove(1);
				
				// opens the writer
				writer = new BufferedWriter(new FileWriter(FILE_NAME, false));
				
				//	writes the linkedlist back into the log file without the line we removed
				for (int i = 0; i < csvList.size(); i++) 
				{
					
				    LogFileStuff values = csvList.get(i);
				    
				    if (i > 0) 
				    {
				    	
				        writer.newLine();
				        
				    }
				    
				    writer.write(String.join(",", values.getLine()));
				    
				}
				
			}
			
		}
		
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
			
		}
		
		catch (IOException e)
		{
			
			e.printStackTrace();
			
		}
		
		//	closes the writer
		
		finally 
		{
			if (writer != null) 
			{
				try 
				{
					writer.close();
					writer = null;
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	

	
	/**
	 * returns max entries used for other classes
	 * @return
	 */
	public static int getMaxEntries()
	{
		return MAX_ENTRIES;
	}
	

}
