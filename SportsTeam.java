//Brian Huang

public class SportsTeam 
{	//declaring variables
	private String nameTeam;
	private String roster;
	private int[] record = {0, 0, 0};	//record[0] = wins, record[1] = losses, record[2] = ties
										//all teams start with a record of 0-0-0
	public SportsTeam(String name, String rost)
	{
		nameTeam = name;	//setting name and roster of the team to the arguments sent in by constructor
		roster = rost;
	}
	public String teamName()	//returning the team name
	{
		return nameTeam;
	}
	
	public String teamRoster()	//returning the roster of the team
	{
		return roster;
	}
	
	public void win()	//setter method that adds one to the win record
	{
		record[0] += 1;
	}
	
	public void lose()	//setter method that adds one to the loss record
	{
		record[1] += 1;
	}
	
	public void tie()	//setter method that adds one to the tie record
	{
		record[2] +=1;
	}
	
	public int winRecord()	//returns wins
	{
		return record[0];
	}
	
	public int lossRecord()	//returns losses
	{
		return record[1];
	}
	
	public int tieRecord()	//returns ties
	{
		return record[2];
	}
	
}
