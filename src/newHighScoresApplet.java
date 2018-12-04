import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class newHighScoresApplet extends JFrame  
{	
	Operation o = new Operation();
	
	String name, strScore, highScoreInfo;
	int score;
	LinkedList<Person> list = new LinkedList<Person>();
	
	private JPanel panel = new JPanel();
	
	private JLabel endingLabel;
	private JLabel scoresInfo;
	
	private JButton somebutton;
	
	public final int WIDTH = 400;				
	public final int HEIGHT = 200;				
	
	public newHighScoresApplet()
	{
		super("High Scores");	
		
		buildPanel();
		
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		   
		
		//setLayout(new FlowLayout((FlowLayout.CENTER))); //mainPanel.setLayout().....
		//panel.setLayout(new BorderLayout());
		
		add(panel);
		
		setLocationRelativeTo(null); 			
		setVisible(true);
	}
	
	public void buildPanel()
	{	
		endingLabel = new JLabel("High Scores");
		
		for(int i = 0; i < list.size(); i++)
		{
			highScoreInfo += list.toString();
		}
		
		JOptionPane.showMessageDialog(null, highScoreInfo);
		
		scoresInfo = new JLabel(highScoreInfo);
		
		panel.setLayout(new BorderLayout());
		
		panel.add(endingLabel, BorderLayout.NORTH);
		panel.add(scoresInfo, BorderLayout.SOUTH);
					
	}
	
	public void read()								// Reads in high scores from text file and sorts.
	{		
		File testFile = new File("scores.txt");
		Person newObj;

			try
			{
				Scanner textScanner = new Scanner(testFile);
				
				for(int i = 0; i < 5; i++)			// Read contents of test.txt into a linked list of <Person>
				{
					name = textScanner.nextLine();
					strScore = textScanner.nextLine();
					
					score = Integer.parseInt(strScore);
					
					newObj = new Person(name, score);
					list.add(newObj);
				}
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}		
			
			sortList();
			
	} // end readInScores() ************************ 
	
	public void sortList()		// Sorts the list by high score 
	{
		Collections.sort(list, new Comparator<Person>() 
				{
				    public int compare(Person o1, Person o2) 
				    {
				        return o2.score - o1.score;
				    }
				});
	} // end sortList() ************************
	
}

