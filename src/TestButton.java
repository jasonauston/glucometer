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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestButton implements ActionListener	//	is-an actionlistner
{
	
	private static boolean insertStrip = false;	//	has-a insert strip boolean
	private static boolean insertBlood = false;	//	has-a insert blood boolean

	
	private static JButton button;	//	has-a button
	private static JLabel label;	//	has-a label
	
	private static String testResult;	//	has-a test result

	/**
	 * constructor for the button
	 * @param panel
	 * @param label
	 */
	public TestButton(JPanel panel, JLabel label)
	{
		//	updates label for the class
		TestButton.label = label;
		
		//	button settings
		button = new JButton("Test");
		button.setBounds(54, 117, 138, 29);
		button.setToolTipText("Press Test to simulate testing activities.  App will restart after 10 seconds of inactivity after pressing.");
		panel.add(button);
		
		//	attaches the actionlistener
		button.addActionListener(this);
		
		
    }
	
	/**
	 * gets the test result
	 * @return testResult
	 */
	public static String getTestResult()
	{
		return testResult;
	}
	
	
	/**
	 * action performed, ill comment through it
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//	if the strip is not inserted
	    if (!insertStrip) 
	    {
	    	//	when you click the button, it changes insertStrip to true
	        insertStrip = true;
	        
	        try
			{
	        	//	updates the panel
				MeterJPanelChanges.JPanelChanges(label);
				
			}
	        
			catch (Exception e1)
			{
				
				e1.printStackTrace();
				
			}
	        
	    } 
	    
	    //	if insert blood is false..
	    else if (!insertBlood)
	    {
	       
	    	//	sets to true
	    	insertBlood = true;

	    	//	creates a new test instance
	        MeterTest test = new MeterTest();
	        
	        //	testResult is 
	        testResult = test.getTestResult();
	        LogFileStuff.LogFileWrite();
	        
//	    	disables the test button
		    testButtonDisable();
	        
	        try
			{
	        	
	        	//	updates the panel with a test result
				MeterJPanelChanges.JPanelChanges(testResult, label);
				
			}
	        
			catch (Exception e1)
	        
			{
				
				e1.printStackTrace();
				
			}
	    }
	    
	    //	starts the inactivity timer
	    InactivityTimer.startTimer();
	    
	    
	    

	}
	
	/**
	 * updates the label when displaying other stuff from log file
	 * @param arrayValue
	 */
	public static void menuButtonLabelUpdate(int arrayValue)
	{
		
		try
		{
			
			//	updates the panel with an arrayvalue to look up
			MeterJPanelChanges.JPanelRead(label, arrayValue);
			
		}
		
		catch (Exception e)
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * boolean for strip insert
	 * @return
	 */
	public static boolean isInsertStrip()
	{
		return insertStrip;
	}
	
	/**
	 * boolean for blood insert
	 * @return
	 */
	public static boolean isInsertBlood()
	{
		return insertBlood;
	}
	
	/**
	 * disables the testbutton when using the menu and select buttons
	 */
	public static void testButtonDisable()
	{
		
		button.setEnabled(false);
		
	}
	
	/**
	 * setter for boolean insertstrip
	 * @param insertStrip
	 */
	public static void setInsertStrip(boolean insertStrip)
	{
		TestButton.insertStrip = insertStrip;
	}

	
	/**
	 * setter for boolean insertblood
	 * @param insertStrip
	 */
	public static void setInsertBlood(boolean insertBlood)
	{
		TestButton.insertBlood = insertBlood;
	}


}
