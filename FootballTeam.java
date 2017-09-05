//Brian Huang

import java.util.Random;

public class FootballTeam extends SportsTeam
{	//declaring variable
	private boolean cheerleaders = false;

	public FootballTeam(String name, String rost) 
	{	//sending arguments to constructor
		super(name, rost);
		
		Random randNum = new Random();
		if (randNum.nextInt(3) == 0)	//1/3 chance of having cheerleaders (some teams are poor)
			cheerleaders = true;
	}
	
	public boolean hasCheerleaders()	//returns whether the team has cheerleaders or not
	{
		return cheerleaders;
	}
}
