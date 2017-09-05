//Brian Huang


public class SportsGame 
{	//declaring variables, initializing some
	private String nameTeam1, nameTeam2;
	private int addDiff=0;
	private float homeAdv1, homeAdv2, chance1, chance2, team1Diff, team2Diff;
	private boolean homeT1 = true, homeT2 = false, result, tie;
					//homeT1 always true because team1 is always the home team
	public SportsGame(SportsTeam t1, SportsTeam t2)
	{	
		SportsTeam team1 = t1;	//setting team1 and team2 to the arguments sent in by constructor
		SportsTeam team2 = t2;
		
		nameTeam1 = team1.teamName();
		nameTeam2 = team2.teamName();	
		
		team1Diff = team1.winRecord() - team1.lossRecord();
		team2Diff = team2.winRecord() - team2.lossRecord();
		
		if (team1Diff > team2Diff)	//if t2 diff is less than t1 diff
		{
			if (team2Diff <= 0)	//determining if the lesser diff is less than or equal to 0
			{
				addDiff = 0;
				while (team2Diff != 1)	//runs until lesser diff = 1
				{
					team2Diff++;	//adds 1 to team2Diff
					addDiff++;		//adds 1 to variable that determines how much to add to other diff(lesser diff already added)
				}
				team1Diff += addDiff;	//adds addDiff  to the other diff
			}
		}
		else if (team1Diff < team2Diff)	//if t1 diff is less than t2 diff
		{
			if (team1Diff <= 0)	//determining if lesser diff is 0 or less
			{
				addDiff = 0;
				while (team1Diff != 1)	//runs until lesser diff is 1
				{
					team1Diff++;	//adds 1 to team1 diff
					addDiff++;	//variable that keeps track of how much is needed to add to each diff
				}
				team2Diff += addDiff;	//adds addDiff to other diff
			}
		}	//if none of the diffs are negative or both are zero, this loop will not affect the initial diffs
		
		if (team1Diff == team2Diff)	
		{
			team1Diff = 1;
			team2Diff = 1;
		}
		//if both diffs are the same, the chance for both becomes 				
		//because same number/ same number = 1
				
		
		if (isHomeT1() == true)
		{						
			homeAdv1 = (float) (team1Diff * 0.05);	
		}	
		if (isHomeT2() == true)
		{
			homeAdv2 = (float) (team2Diff * 0.05);
		}
		//adding the home advantage (both baseball and football have this adv)										
		chance1 = (team1Diff + homeAdv1);	
		chance2 = (team2Diff + homeAdv2);
	}	
	
	public String team1Name()	//returning team 1 name
	{
		return nameTeam1;
	}
	
	public String team2Name()	//returning team 2 name
	{
		return nameTeam2;
	}
	
	public boolean isHomeT1()	//returns if team1 is home or not
	{
		return homeT1;
	}
	
	public boolean isHomeT2()	//returns if team2 is home our not
	{
		return homeT2;
	}
	
	public float initialChanceT1()	//returning the initial chance from just the differentials, no adv added
	{								//team1
		return team1Diff;
	}								//these are needed to calculate the other advantages because they are
									//0.0x * the initial chance acquired from the differentials
	public float initialChanceT2()
	{
		return team2Diff;	//team2 initial chance
	}
	
	public float chanceT1()	//returning the odds of the initial chance + the home adv chance
	{
		return chance1;	
	}
	
	public float chanceT2()	//returning the odds of the initial chance + home adv 
	{
		return chance2;
	}
	
	public void didTie(boolean wasItATie)	//a setter method that sets whether the game was a tie or not
	{
		tie = wasItATie;
	}
	
	public boolean wasTie()	 //returns if the game was a tie
	{
		return tie;
	}
	
	public void didHomeWin(boolean whatHappened)	//setter method that sets whether the home team won or lost
	{
		result = whatHappened;
	}
	
	public boolean result()	//returns whether the home team won or lost
	{
		return result;
	}
}
