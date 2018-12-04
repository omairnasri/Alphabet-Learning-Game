import javax.swing.JOptionPane;

public class Validation 
{
	Operation o = new Operation();
	String prompt, value, prompt1;
	
	public void validateInput() // Call setValue1() before calling this method. 
	{
		String prompt;
		
		prompt = o.getPrompt();
		value = o.getValue();
		
		JOptionPane.showMessageDialog(null, "getPrompt1() = " + o.getPrompt() + "\n getValue() = " + o.getValue()); 
		
		validateWithChar(o.getValue(), prompt);
		
		if(o.getValidationBoolean())	// if this flag is true, there was a correct input.
		{
			JOptionPane.showMessageDialog(null, "CORRECT ANSWER after validation! DONE incrementCorrectInput();");
			o.incrementCorrectInput();
		}
		if(!(o.getValidationBoolean()))
		{
			JOptionPane.showMessageDialog(null, "INCORRECT ANSWER after validation! Your " + (o.getIncorrectIndex() + 1) + 
					"th letter was incorrect: \n Your entry: " + o.getValue());
			
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
			o.setValidationBoolean(false); // set as true --> there is an error
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
					o.setValidationBoolean(false);
//					JOptionPane.showMessageDialog(null, "NOT Equal! value1[ " + i + "]:" + value.charAt(i) + 
//							"\nprompt1[ " + i +"]:" + prompt1.charAt(i));
					
					o.setIncorrectIndex(i);
					}
			}
	
	} // end validateWithChar()
	
	

}
