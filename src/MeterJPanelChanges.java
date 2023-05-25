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


import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;


public class MeterJPanelChanges
{
	
	/**
	 * constructor with arguments, updates label with the test result when a test is performed
	 * @param testResult2
	 * @param label
	 */
	public static void JPanelChanges(String testResult2, JLabel label)
	{

		label.setText(testResult2);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 72));

	}
	
	/**
	 * constructor to update the label during the testing process.  
	 * starts at insert test strip and changes to insert blood
	 * @param label
	 * @throws Exception
	 */
	public static void JPanelChanges(JLabel label) throws Exception
	{
		
		//	checks boolean statements to output the correct text on the label
		//	normally on the meter there would be a switch activated when a strip is present that would instruct the user to insert blood.
		if (TestButton.isInsertStrip() == false)
		{
			
			label.setText("Insert Test Strip");
			label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

			
		}
		
		else if (TestButton.isInsertStrip() == true && TestButton.isInsertBlood() == false)
		{
			
			label.setText("Insert blood on strip");

			
		}
		
		//	throws exception if there are any errors
		else throw new Exception();
		
	}
	
	
	/**
	 * method to display previous results
	 * iterates through an array that contains the results based from a log file
	 * @param label
	 * @param arrayValue
	 */
	public static void JPanelRead(JLabel label, int arrayValue) 
	{
		
		//	copying an arraylist to use here
		ArrayList<LogFileReview> csvArrList = LogFileReview.getCsvArrayList();
		
		//	putting the elements of the arraylist at the value of an arrayValue into a string array 
		LogFileReview csvArray = csvArrList.get(arrayValue);
		
		//	converts the array into a string separated by carriage returns
		String csvString = String.join("\r\n", csvArray.getLine());
		
		//	updates the label output
		label.setText(csvString);
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
	     
	}

}
