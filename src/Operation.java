import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Operation 
{
	LinkedList<Person> list = new LinkedList<Person>();
	Person newObj;
	
	String name, strScore, value, prompt1 = "", fileHolder = "", promptWord = "", userName;	
	String userWord = "", x = "";
	int score, compareScore, deleteIndex, lineNum = 0, incorrectIndex;
	static int level = 1, correct = 0, set = 1;
	
	boolean newHigh = false, b = true;
	
	public void appendLetter(String x)
	{
		userWord += x;
	}
	
	public String getUserWord()
	{
		return userWord;
	}
	
	public void resetWord()
	{
		userWord = "";
	}
	
	public void incrementLevel()
	{
		level++;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void incrementCorrectInput()
	{
		correct++;
	}
	
	int getCorrectInput()
	{
		return correct;
	}
	
	void incrementSet()
	{
		set++;
	}
	
	int getSet() // :D
	{
		return set;
	}
	
	void setIncorrectIndex(int incorrectIndex)
	{
		this.incorrectIndex = incorrectIndex;
	}
	
	int getIncorrectIndex()
	{
		return incorrectIndex;
	}
	
	/*********************************************************************************************************************
	 * Prompt & Getters/Setters 
	 * 
	 *******************************************************************************************************************/
		
	public void prompt() // finds text at given line number - indexes starting at 0. 
	{
		lineNum = generateRandomNumber(0,8);
		File file = new File("words.txt");
		fileHolder = "words.txt";
		
	try
	{	
	promptWord = Files.readAllLines(Paths.get(fileHolder)).get(lineNum);
	
	} // end try
		catch(Exception e)
	{
		System.out.println(e.getMessage());
	}	
	
	setPrompt(promptWord);
			
	} // end prompt() ************************** 
		
	public void setValue(String value)	// Set value1 - the user entry(value)
	{	
		JOptionPane.showMessageDialog(null, "value in setValue() = " + value);
		this.value = value;
	}
	
	public String getValue()				// Get value1
	{
		return value;
	}
	
	void setPrompt(String prompt1)			// Set the prompt from the text file
	{
		this.prompt1 = prompt1;
	}
	
	String getPrompt()
	{
		return prompt1;
	}
	
	public int generateRandomNumber(int min, int max) 	// Generate a random numbers with given parameters
	{
		if (min >= max) 
		{
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	//Integer scoreArray[] = new Integer[5];
	//int max = 0, index = 0;
	//int firstScore, secondScore, thirdScore, fourthScore, fifthScore;
	
	/*****************************************************************************************************************
	 * High Score Text File - Sorting
	 ******************************************************************************************************************/
	public void read()								// Reads in high scores from text file and sorts.
	{		
		File testFile = new File("scores.txt");

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

	public void checkScore(int compareScore)
	{
		read();
		
		Person pObj;
		Iterator<Person> iterator = list.iterator();
		
		while(iterator.hasNext())
		{
			pObj = iterator.next();
			if(compareScore > pObj.getScore())
			{
				setNewHigh();
				deleteIndex = list.indexOf(pObj);
			}
		} // end while
		
		if(getNewHigh())
		{
		userName = JOptionPane.showInputDialog("New high score! Enter Name:");
		
		list.remove(deleteIndex);
		pObj = new Person(userName, compareScore);
		list.add(pObj);
		
		}
		
		sortList();	// Sort the LinkedList 
		
		try
		{
		PrintWriter writer = new PrintWriter("scores.txt");
		for(int i = 0; i < list.size(); i++)
			writer.println(list.get(i));
		
		writer.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}	// end checkScore()
	
	public void setNewHigh()	// True if a new high score is found. 
	{
		newHigh = true;
	}
	
	public boolean getNewHigh()
	{
		return newHigh;
	}
	
	
	//****************************************************************************************************************
	/* Validation
	//****************************************************************************************************************/
	public void setValidationBoolean(boolean b) // Validation if even one character doesn't match the prompt
	{
		this.b = b;
	}
	
	public boolean getValidationBoolean()		// Returns false if input is invalid
	{
		boolean returnB = false;
		
		if(b)
			returnB = true;
		else if(!(b))
			returnB = false;
		
		return returnB;
	}
	
	public void validateInput() // Call setValue1() before calling this method. 
	{
		String prompt;
		
		prompt = getPrompt();
		value = getValue();
		
		JOptionPane.showMessageDialog(null, "getPrompt1() = " + getPrompt() + "\n getValue() = " + getValue()); 
		
		validateWithChar(getValue(), prompt);
		
		if(getValidationBoolean())	// if this flag is true, there was a correct input.
		{
			JOptionPane.showMessageDialog(null, "CORRECT ANSWER after validation! DONE incrementCorrectInput();");
			incrementCorrectInput();
		}
		if(!(getValidationBoolean()))
		{
			JOptionPane.showMessageDialog(null, "INCORRECT ANSWER after validation! Your " + (getIncorrectIndex() + 1) + 
					"th letter was incorrect: \n Your entry: " + getValue());
			
		}
		
	} // end validateInput1()
	
	
	public void validateWithChar(String value, String prompt1) // Recieves user entry (value) and the prompt.
	{
		this.value = value;
		this.prompt1 = prompt1;
	
		boolean someBool = false;
		
		if(value.length() == prompt1.length())
		{
			JOptionPane.showMessageDialog(null, "value1.length() " + value.length() + "prompt1.length() " + prompt1.length());
			someBool = true;
			JOptionPane.showMessageDialog(null, "Correct length!");
		}
		if(!(value.length() == prompt1.length()))
		{
			JOptionPane.showMessageDialog(null, "Incorrect length!");
			setValidationBoolean(false); // set as true --> there is an error
			someBool = false;
		}
		
		//------------------------------If length is correct ------------------------------
		
		if(someBool) // if the value and prompt are the same length
			for(int i = 0; i < prompt1.length(); i++)
			{
				if(value.charAt(i) == prompt1.charAt(i))
				{
//					JOptionPane.showMessageDialog(null, "Equal! value1[ " + i + "]:" + value.charAt(i) + 
//							"\nprompt1[ " + i +"]:" + prompt1.charAt(i));
				}
				
				if(!(value.charAt(i) == prompt1.charAt(i)))
					{
					setValidationBoolean(false);
//					JOptionPane.showMessageDialog(null, "NOT Equal! value1[ " + i + "]:" + value.charAt(i) + 
//							"\nprompt1[ " + i +"]:" + prompt1.charAt(i));
					
					setIncorrectIndex(i);
					}
			}
	
	} // end validateWithChar()
	
		
} // End Operation Class
