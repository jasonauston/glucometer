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



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class DiabetesMeterJFrame extends JFrame	//	is-a JFrame
{
	
	
	private static final long serialVersionUID = 1L;	//	has-a serial, added to suppress a warning
	
	private static DiabetesMeterJFrame frame;	//	has-a frame
	
	private JPanel panel;	//	has-a panel
	private JPanel contentPane;	//	has-another panel
	private JPanel panel1;	//	has-a third panel
	private JPanel panel2;	//	has-a fourth panel
	
	private static JLabel label;	//	has-a label
	private JLabel label2;	//	has-a second label
	
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{	
		
		try
		{
			//	creates an instance of the JFrame, sets to visible.
			frame = new DiabetesMeterJFrame();
			frame.setVisible(true);
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		TestButton.setInsertStrip(false);
		TestButton.setInsertBlood(false);
	}
	
	
	/**
	 * constructor that builds the JFrame and its accessories
	 */
	
	public DiabetesMeterJFrame()
	{
		//	JFrame window settings
		setTitle("Diabetes Meter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//	panel to hold everything on the frame
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		//	this panel contains the buttons
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout());
		
		//	this panel contains the testing portion
		panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(new FlowLayout());
		
		
		//	this panel contains the date and time
		panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new FlowLayout());
		label2 = new JLabel();
		panel2.setPreferredSize(label2.getPreferredSize());
		
		//	Initial settings for the label
		label = new JLabel("Insert Test Strip");
		label.setBounds(54, 5, 138, 140);
		panel1.add(label);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		//	loads buttons onto panel
		new LeftArrowButton(panel);
		new RightArrowButton(panel);
		new TestButton(panel, label);
		
		//	loads date and time on the bottom of the panel
		new DateTimeLabel(panel2, label2);
		
		
	}
	
	/**
	 * disposes the frame.  used in part to reset the jframe
	 */
	public static void closeApp() {
	    
	    frame.dispose();
	}

	
}
