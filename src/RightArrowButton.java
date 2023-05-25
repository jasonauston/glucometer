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
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
	
	
public class RightArrowButton implements ActionListener	//	is-a actionlistener
{
	
	private JButton rightArrow;	//	has-a menu button
    
	
    /**
     * constructor for the menu button
     * @param panel
     * @param panel2
     * @param label
     */
	public RightArrowButton(JPanel panel)
	{
		
		//	button settings
		ImageIcon icon = new ImageIcon("right-arrow.png");
		
		rightArrow = new JButton("");
		rightArrow.setIcon(icon);
		rightArrow.setBounds(6, 22, 104, 83);
		rightArrow.setToolTipText("Press Menu to look at log entries in reverse order.  App will restart after 10 seconds of inactivity after pressing.");
		panel.add(rightArrow);
		
		//	added actionlistener
		rightArrow.addActionListener(this);
		
	}
	
	/**
	 * action performed
	 * this method will count up on click count, selectbutton will count down
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		try
		{
	    	//	opens the log file, builds an arraylist to iterate over to review the previous tests
			LogFileReview.LogFileRead();
			
		}
	    
		catch (IOException e1)
		{
			
			e1.printStackTrace();
			
		}

	    //	if the click count is at max, set to 0
		//	other, clickcount++
	    try
		{
			if (ClickCount.getClickCount() == LogFileStuff.countEntries()-1)
			{
				
				ClickCount.setClickCount(0);
				
			}
			
			else
			{
				
				ClickCount.setClickCount(ClickCount.getClickCount() + 1);
				
			}
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    //	updates the label with the clickcount.  used to show an element on the arraylist at that element
	    TestButton.menuButtonLabelUpdate(ClickCount.getClickCount());
	    
	    //	disables the testbutton when looking at menu and select entries
	    TestButton.testButtonDisable();
	    
	    //	hides the date ad time
	    DateTimeLabel.dateTimeLabelDisable();
	    
	    //	starts inactivity meter
	    InactivityTimer.startTimer();
	    
	}
	
	
	
	
}