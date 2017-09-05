//Brian Huang

import java.util.Random;	//importing random methods

public class BaseballGame extends SportsGame
{	//declaring variables
	private int total, randomNum, ageField1, ageField2;
	private float sentimAdv1, sentimAdv2, pitchAdv1, pitchAdv2, finalChance1, finalChance2;

	public BaseballGame(BaseballTeam t1, BaseballTeam t2) 
	{	//sending baseball teams to the constructor
		super(t1, t2);	//inherits SportsGame.class
		
		Random randNum = new Random();	//new random number object
		
		BaseballTeam bteam1 = t1;	//creating teams 1 and 2 from t1 and t2
		BaseballTeam bteam2 = t2;
		
		ageField1 = randNum.nextInt(20);	//getting random age of fields (0-20 years old)
		ageField2 = randNum.nextInt(20);
		
		//adding sentiment value advantage
		if (isHomeT1() && ageField1 > ageField2)	//if team1's field is older, then they will get the adv because they are the home team
			sentimAdv1 = (float) (initialChanceT1() * 0.02);	//casting from double to a float
		if (isHomeT2() && ageField2 > ageField1)
			sentimAdv2 = (float) (initialChanceT2() * 0.02); //team2 will never have the sentimental adv because they are the away team
		
		
		//adding pitcher advantage	
		if (bteam1.numberPitchers() > bteam2.numberPitchers())	//team with more pitchers gets the pitcher adv
			pitchAdv1 = (float) (initialChanceT1() * 0.05);
		if (bteam1.numberPitchers() < bteam2.numberPitchers())
			pitchAdv2 = (float) (initialChanceT2() * 0.05);
		
		
		finalChance1 = chanceT1() + (sentimAdv1 + pitchAdv1);	//adding all the advantages and the (chance+homeadv)
		finalChance2 = chanceT2() + (sentimAdv2 + pitchAdv2);	//finalChance is the original diff + home adv
		
		finalChance1 = finalChance1 * 100;	//multiplying odds by 100
		finalChance2 = finalChance2 * 100;

		total = (int) (finalChance1 + finalChance2);	//casting floats to int, adding odds together
		
		randomNum = randNum.nextInt(total);	//random number from 0 to total
		
		
		if (randomNum == 0)	//if tie
		{
			bteam1.tie();	//adding tie to records
			bteam2.tie();
			didTie(true);	//did this game tie = true
		}
		if (randomNum >= 1 && randomNum <= finalChance1)	// team1 win(home)
		{
			bteam1.win();	//adding win to team1 record
			bteam2.lose();	//adding lose to team2 record
			didTie(false);	//making tie = false
			didHomeWin(true);	//setting the result of the game (home won = true)
		}
		if (randomNum > finalChance1 && randomNum <= total) // team2 win
		{
			bteam1.lose();	//adding a loss to team1 record
			bteam2.win();	//adding a win to team2 record
			didTie(false);	//setting tie = false
			didHomeWin(false);	//setting home win = false
		}
	}
}
