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


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;



public class DateTimeLabel
{
	
	private static JLabel label;	//	has-a label
	private Timer timer;	//	has-a timer
	private static DateTimeFormatter time;	//	has-a time
    private static DateTimeFormatter date;	//	has-a date	
    private static String formattedDate;	//	has-a formatted date
	private static String formattedTime;	//	has-a formated time
	

	/**
	 * constructor to build out the system clock and time display
	 * @param panel
	 * @param label
	 */
	public DateTimeLabel(JPanel panel, JLabel label) 
	{
		
		//	updates the label for the class
        DateTimeLabel.label = label;
        
        //	panel settings
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.SOUTH);
        
        //	timer set to update it every second
        timer = new Timer(1000, new ActionListener() 
        {
        	
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	//	updates date and time to the panel
                UpdateDateTime();
                
            }
            
        });
        
        //	timer start
        timer.start();
        
    }
	
	/**
	 * formating for the label
	 */
	public void UpdateDateTime()
	{
		
		label.setText(getDate() + "         " + getTime());
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);

	}
	
	/**
	 * turns off the label, used in other classes
	 */
	public static void dateTimeLabelDisable()
	{
		
		label.setVisible(false);
		
	}
	
	/**
	 * gets the time and returns in a formated way
	 * @return
	 */
	public static String getTime()
	{
		
		LocalDateTime now = LocalDateTime.now();
        time = DateTimeFormatter.ofPattern("HH:mm:ss");

        formattedTime = now.format(time);
		return formattedTime;
		
	}
	
	/**
	 * gets the date and returns in a formated way
	 * @return
	 */
	public static String getDate()
	{
		
		LocalDateTime now = LocalDateTime.now();
        date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        formattedDate = now.format(date);
        
		return formattedDate;
		
	}		

}
