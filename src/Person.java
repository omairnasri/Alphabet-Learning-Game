
public class Person 
{
	String name;
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
		return this.name + "\n" +  this.score;
	}
}
