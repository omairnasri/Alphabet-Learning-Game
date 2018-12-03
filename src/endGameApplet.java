import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class endGameApplet extends JFrame  
{	
	Operation o = new Operation();
	
	private JLabel endingLabel;
	private JLabel scoreLabel;
	
	private JButton somebutton;
	
	public final int WIDTH = 400;				
	public final int HEIGHT = 200;				
	
	public endGameApplet()
	{
		super("End of Game");
		
		buildEndLabel();
		
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		   
		
		setLayout(new FlowLayout((FlowLayout.CENTER))); //mainPanel.setLayout().....
		
		add(endingLabel);
		add(scoreLabel);
		
		
		setLocationRelativeTo(null); 			
		setVisible(true);
	}
	
	public void buildEndLabel()
	{
		endingLabel = new JLabel("Thank you for playing the alphabet learning game!");
		scoreLabel = new JLabel("Your final score is:" + o.getCorrectInput());
		o.checkScore(o.getCorrectInput());
				
	}
}

