
public class Person 
{
	String name, x;
	int score;
	
	Person(){}
	
	Person(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getScore()
	{
		return score;
	}
	public String toString()
	{
		x = Integer.toString(getScore());
		return this.name + "\n" +  this.x;
		//return this.name + "\n" +  this.score;
	}
}
