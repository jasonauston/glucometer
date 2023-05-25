

abstract class LogFileObject
{
	
	
	private String line;	//	string to hold the line
	
	
	/**
	 * 
	 * accepts a string input, used to create an object for use in the linkedlist and arraylist
	 * @param line
	 */
	public LogFileObject(String line)
	{
		
		this.setLine(line);
		
	}

	/**
	 * getter for the line variable
	 * @return
	 */
	public String getLine()
	{
		return line;
	}

	/**
	 * setter for the line variable
	 * @param line
	 */
	public void setLine(String line)
	{
		this.line = line;
	}
	
}