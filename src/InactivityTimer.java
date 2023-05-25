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


import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InactivityTimer 
{
    
	private static Timer inactivityTimer;	//	has-a timer

	/**
	 * method to start the timer
	 */
    public static void startTimer() 
    {
    	//	if the timer is already running
    	if (inactivityTimer != null && inactivityTimer.isRunning()) 
    	{
    		
    		//	stop the timer
            inactivityTimer.stop();
            
        }
    	
    	//	gives settings for the timer
        inactivityTimer = new Timer(10000, new ActionListener() 
        {
        	
        	//	the timer times out, it will activate the resetApp() method
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	resetApp();
            	
            }
            
        });
        
        //	no repeat
        inactivityTimer.setRepeats(false);
        
        //	start timer
        inactivityTimer.start();
        
        
    }

    /**
     * resets the app
     */
    private static void resetApp() 
    {
    	
    	//	closes the instance of the JFrame
    	DiabetesMeterJFrame.closeApp();

    	//	calls the main method to restart from the beginning
        String[] args = {};
        DiabetesMeterJFrame.main(args);
        
    }
    
}
