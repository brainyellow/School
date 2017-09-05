//Brian Huang

import java.util.Random;

public class FootballGame extends SportsGame
{	//declaring variables
	private int total, randomNum, randomCoin;
	private float headsAdv1, headsAdv2, cheerAdv1, cheerAdv2, finalChance1, finalChance2;
	private boolean heads;

	public FootballGame(FootballTeam t1, FootballTeam t2) 
	{	//sending football teams as arguments to the constructor
		super(t1, t2);
		
		FootballTeam fteam1 = t1;	//setting fteam1 and fteam2 to arguments passed from constructor
		FootballTeam fteam2 = t2;
		
		Random randNum = new Random();	//new random object
		
		
		if (fteam1.hasCheerleaders())	//cheerleader advantage
			cheerAdv1 = (float) (initialChanceT1() * 0.02);	//casting from double to a float
		if (fteam2.hasCheerleaders())
			cheerAdv1 = (float) (initialChanceT2() * 0.02);
		
		
		Random coinToss = new Random();
		randomCoin = coinToss.nextInt(1);
		
		if (randomCoin == 0)	//determines direction of wind
			heads = true;		//50/50 chance of heads or tails
		if (randomCoin == 1)
			heads = false;
		
		if (heads == true)	//if heads
			headsAdv1 = (float) (initialChanceT1() * 0.05);	//making headsadv = baseOdds * 0.05
		if (heads == false)	//if tails
			headsAdv2 = (float) (initialChanceT2() * 0.05);
			

		finalChance1 = chanceT1() + (cheerAdv1 + headsAdv1);	//adding the adv to the chances
		finalChance2 = chanceT2() + (cheerAdv2 + headsAdv2);
		
		finalChance1 = finalChance1 * 100;	//multiplying chances by 100
		finalChance2 = finalChance2 * 100;
		
		total = (int) (finalChance1 + finalChance2);	//casting to int
		
		randomNum = randNum.nextInt(total);	//setting randomNum equal to a random number from 0-total
		
		if (randomNum == 0)	//if tie
		{
			fteam1.tie();	//adding a tie to team records
			fteam2.tie();
			didTie(true);	//setting didTie to true
		}
		if (randomNum >= 1 && randomNum <= finalChance1)	// team1 win(home)
		{
			fteam1.win();	//adding a win for team1
			fteam2.lose();	//adding a loss for team2
			didHomeWin(true);	//setting the result of the game
			didTie(false);	//setting didTie to false
		}
		if (randomNum > finalChance1 && randomNum <= total) // team2 win
		{
			fteam1.lose();	//adding a loss to scoring record (team1)
			fteam2.win();	//adding a win to scoring record (team2)
			didHomeWin(false);	//setting result of the game
			didTie(false);	//setting didTie to false because it wasn't a tie
		}	
	}
}
