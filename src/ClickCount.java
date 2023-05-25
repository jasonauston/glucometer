
public class ClickCount
{

    private static int clickCount = 0;	//	has-a click count
	
    
	/**
	 * setter for clickcount, used by select button
	 * @param clickCount
	 */
	public static void setClickCount(int clickCount)
	{
		ClickCount.clickCount = clickCount;
	}
	
	/**
	 * getter for click count, used by the select button
	 * @return
	 */
	public static int getClickCount()
	{
		
		return clickCount;
		
	}
	
}
