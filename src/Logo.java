import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.event.ActionEvent;

public class Logo extends JFrame
{
	Operation o = new Operation();
	
	private JButton aButton, bButton, cButton, dButton, eButton, fButton, gButton, hButton, iButton, jButton, kButton, 
	lButton, mButton, nButton, oButton, pButton, qButton, rButton, sButton, tButton, uButton, vButton, wButton, 
	xButton, yButton, zButton;
	
	private JButton submitButton;
	
	private JPanel mainGamePanel = new JPanel();
	private JPanel submitPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel mainLettersPanel = new JPanel();
	
	private JLabel inputLabel;
	private JLabel infoLabel;
	
	private JTextField promptTextField;
	
	private JPanel firstLettersPanel = new JPanel();
	private JPanel secondLettersPanel = new JPanel();
	private JPanel thirdLettersPanel = new JPanel();
	
	
	public Logo()
	{
		super("Start");
		buildInputPanel();
		buildSubmitPanel();
		buildLettersPanel();
		
		
		int WIDTH = 500;
		int HEIGHT = 600;
		
		mainGamePanel.setLayout(new BorderLayout());
		mainGamePanel.add(submitPanel, BorderLayout.CENTER);
		mainGamePanel.add(inputPanel, BorderLayout.NORTH);
		mainGamePanel.add(mainLettersPanel, BorderLayout.SOUTH);
		
		
		//add(submitPanel);
		add(mainGamePanel);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	private void buildInputPanel()
	{
		// attaching image with prompt
		o.prompt();
		String p = o.getPrompt();
		
		//JOptionPane.showMessageDialog(null, "Prompt is: " + p);

		if(o.getLevel() >= 10)
		{
			dispose();
			new endGameApplet();
		}
		inputLabel = new JLabel("Enter " + p); 
		infoLabel = new JLabel("Level: " + o.getLevel());
		promptTextField = new JTextField(7);
		
		inputPanel.add(inputLabel);
		inputPanel.add(infoLabel);
		inputPanel.add(promptTextField );
	}
	
	
	public void buildSubmitPanel()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) 
					{ // Here
						dispose();
						JOptionPane.showMessageDialog(null, "Submit button clicked:  " + o.getUserWord());
						
						try
						{
						//JOptionPane.showMessageDialog(null, "o.setValue + value = " + val);
						o.setValue(o.getUserWord());
						o.validateInput();
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
						}
						
						
					} // To Here
				}
			);
		
		submitPanel.add(submitButton);
	}
	
	public void buildLettersPanel()
	{
		
	aButton = new JButton(new ImageIcon("images/a.png"));
	bButton = new JButton(new ImageIcon("images/b.png"));
	cButton = new JButton(new ImageIcon("images/c.png"));
	dButton = new JButton(new ImageIcon("images/d.png"));
	eButton = new JButton(new ImageIcon("images/e.png"));
	fButton = new JButton(new ImageIcon("images/f.png"));
	gButton = new JButton(new ImageIcon("images/g.png"));
	hButton = new JButton(new ImageIcon("images/h.png"));
	iButton = new JButton(new ImageIcon("images/i.png"));
	jButton = new JButton(new ImageIcon("images/j.png"));
	kButton = new JButton(new ImageIcon("images/k.png"));
	lButton = new JButton(new ImageIcon("images/l.png"));
	mButton = new JButton(new ImageIcon("images/m.png"));
	nButton = new JButton(new ImageIcon("images/n.png"));
	oButton = new JButton(new ImageIcon("images/o.png"));
	pButton = new JButton(new ImageIcon("images/p.png"));
	qButton = new JButton(new ImageIcon("images/q.png"));
	rButton = new JButton(new ImageIcon("images/r.png"));
	sButton = new JButton(new ImageIcon("images/s.png"));
	tButton = new JButton(new ImageIcon("images/t.png"));
	uButton = new JButton(new ImageIcon("images/u.png"));
	vButton = new JButton(new ImageIcon("images/v.png")); 
	wButton = new JButton(new ImageIcon("images/w.png"));
	xButton = new JButton(new ImageIcon("images/x.png"));
	yButton = new JButton(new ImageIcon("images/y.png")); 
	zButton = new JButton(new ImageIcon("images/z.png"));
	
	firstLettersPanel.add(aButton);
	firstLettersPanel.add(bButton);
	firstLettersPanel.add(cButton);
	firstLettersPanel.add(dButton);
	firstLettersPanel.add(eButton);
	firstLettersPanel.add(fButton);
	firstLettersPanel.add(gButton);
	firstLettersPanel.add(hButton);

	secondLettersPanel.add(iButton);
	secondLettersPanel.add(jButton);
	secondLettersPanel.add(kButton);
	secondLettersPanel.add(lButton);
	secondLettersPanel.add(mButton);
	secondLettersPanel.add(nButton);
	secondLettersPanel.add(oButton);
	secondLettersPanel.add(pButton);
	secondLettersPanel.add(qButton);

	thirdLettersPanel.add(rButton);
	thirdLettersPanel.add(sButton);
	thirdLettersPanel.add(tButton);
	thirdLettersPanel.add(uButton);
	thirdLettersPanel.add(vButton);
	thirdLettersPanel.add(wButton);
	thirdLettersPanel.add(xButton);
	thirdLettersPanel.add(yButton);
	thirdLettersPanel.add(zButton);
	
	mainLettersPanel.setLayout(new BorderLayout());
	mainLettersPanel.add(firstLettersPanel, BorderLayout.NORTH);
	mainLettersPanel.add(secondLettersPanel, BorderLayout.CENTER);
	mainLettersPanel.add(thirdLettersPanel, BorderLayout.SOUTH);
	
	
	aButton.setPreferredSize(new java.awt.Dimension(50, 50));
	bButton.setPreferredSize(new java.awt.Dimension(50, 50));
	cButton.setPreferredSize(new java.awt.Dimension(50, 50));
	dButton.setPreferredSize(new java.awt.Dimension(50, 50));
	eButton.setPreferredSize(new java.awt.Dimension(50, 50));
	fButton.setPreferredSize(new java.awt.Dimension(50, 50));
	gButton.setPreferredSize(new java.awt.Dimension(50, 50));
	hButton.setPreferredSize(new java.awt.Dimension(50, 50));
	iButton.setPreferredSize(new java.awt.Dimension(50, 50));
	jButton.setPreferredSize(new java.awt.Dimension(50, 50));
	kButton.setPreferredSize(new java.awt.Dimension(50, 50));
	lButton.setPreferredSize(new java.awt.Dimension(50, 50));
	mButton.setPreferredSize(new java.awt.Dimension(50, 50));
	nButton.setPreferredSize(new java.awt.Dimension(50, 50));
	oButton.setPreferredSize(new java.awt.Dimension(50, 50));
	pButton.setPreferredSize(new java.awt.Dimension(50, 50));
	qButton.setPreferredSize(new java.awt.Dimension(50, 50));
	rButton.setPreferredSize(new java.awt.Dimension(50, 50));
	sButton.setPreferredSize(new java.awt.Dimension(50, 50));
	tButton.setPreferredSize(new java.awt.Dimension(50, 50));
	uButton.setPreferredSize(new java.awt.Dimension(50, 50));
	vButton.setPreferredSize(new java.awt.Dimension(50, 50));
	wButton.setPreferredSize(new java.awt.Dimension(50, 50));
	xButton.setPreferredSize(new java.awt.Dimension(50, 50));
	yButton.setPreferredSize(new java.awt.Dimension(50, 50));
	zButton.setPreferredSize(new java.awt.Dimension(50, 50));
	
	aButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, "A button clicked");
					o.appendLetter("a");
				}
			}
		);
	bButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("b");
				}
			}
		);
	cButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("c");
				}
			}
		);
	dButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("d");
				}
			}
		);
	eButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("e");
				}
			}
		);
	fButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("f");
				}
			}
		);
	gButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("g");
				}
			}
		);
	hButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("h");
				}
			}
		);
	iButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("i");
				}
			}
		);
	jButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("j");
				}
			}
		);
	kButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("k");
				}
			}
		);
	lButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("l");
				}
			}
		);
	mButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("m");
				}
			}
		);
	nButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("n");
				}
			}
		);
	oButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("o");
				}
			}
		);
	pButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("p");
				}
			}
		);
	qButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("q");
				}
			}
		);
	rButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("r");
				}
			}
		);
	sButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("s");
				}
			}
		);
	tButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("t");
				}
			}
		);
	uButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("u");
				}
			}
		);
	vButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("v");
				}
			}
		);
	wButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("w");
				}
			}
		);
	xButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("x");
				}
			}
		);
	yButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("y");
				}
			}
		);
	zButton.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//JOptionPane.showMessageDialog(null, " button clicked");
					o.appendLetter("z");
				}
			}
		);	
	
	} // End buildLettersPanel()

	
	
	public static void main(String a[])
	{
		//LogoOperation o = new LogoOperation();
		new Logo();
	
	}
}

	