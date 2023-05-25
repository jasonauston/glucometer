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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
	
	
public class LeftArrowButton implements ActionListener	//	is-an action listener
{
	
	private JButton leftArrow;	//	has-a select button
	
	
	/**
	 * constructor for the select button
	 * @param panel
	 */
	public LeftArrowButton(JPanel panel)
	{
		
		//	button settings
		ImageIcon icon = new ImageIcon("left-arrow.png");
		
		leftArrow = new JButton("");
		leftArrow.setIcon(icon);
		leftArrow.setBounds(133, 22, 107, 83);
		leftArrow.setToolTipText("Press Select to look at log entries in reverse order.  App will restart after 10 seconds of inactivity after pressing.");
		panel.add(leftArrow);
		
		//	adding action listener
		leftArrow.addActionListener(this);

	}
	
	
	/**
	 * action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		try
		{
	    	
			//	performed logfile read method.  this is what populates the arraylist for review
			LogFileReview.LogFileRead();
			
		}
	    
		catch (IOException e1)
		{
			
			e1.printStackTrace();
			
		}

	    
		//	click count is monitored in the menubutton class
		//	if 0, set to max
		//	otherwise, subtract 1
	    if (ClickCount.getClickCount() <= 0)
		{
			
	    	try
			{
				ClickCount.setClickCount(LogFileStuff.countEntries()-1);
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	    
		else
		{
			
			ClickCount.setClickCount(ClickCount.getClickCount() - 1);
			
		}
	    
	    //	updates the click count
	    TestButton.menuButtonLabelUpdate(ClickCount.getClickCount());
	    
//		disables the testbutton when looking at menu and select entries
	    TestButton.testButtonDisable();
	    
	    //	disables the date and time when you review log files
	    DateTimeLabel.dateTimeLabelDisable();
	    
	    //	starts inactivity timer
	    InactivityTimer.startTimer();
	    
	}
	
}