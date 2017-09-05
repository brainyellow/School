//Brian Huang

import java.util.Random;	//importing random methods

public class BaseballTeam extends SportsTeam
{	//declaring variable
	private int pitchers;
	
	public BaseballTeam(String name, String rost) 
	{
		super(name, rost);	//inherits SportsTeam.class
		
		Random randNum = new Random();	//new random number object
		pitchers = 1 + randNum.nextInt(5);	//adds a random amount of pitchers (max 5) to 1
	}
	
	public int numberPitchers()	//returns number of pitchers
	{
		return pitchers;
	}

}
