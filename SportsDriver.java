//Brian Huang

import java.util.Scanner;	//importing
import java.io.*;

public class SportsDriver 
{
	public static void main(String[] args) 
	throws IOException
	{	//initializing variables								scoreMargin is for right justifying the final scores
		int bteamCount=0, fteamCount=0, bteamNum=0, fteamNum=0, scoreMargin=29;
		String fileLine, teamName, roster;
		
		
		String inputFile = args[0];	//setting inputFile = first argument
		String outputFile = args[1];
		
		File file = new File(inputFile);	//command line argument, first file is the input file
		
		Scanner fileReader = new Scanner(file);	//scanner for reading the files
		Scanner teamCount = new Scanner(file);	//scanner dedicated for counting amount of teams
		
		PrintWriter writer = new PrintWriter(outputFile);	//writes to output file
		
		while (teamCount.hasNextLine())	//this loop is to find out how many teams there are of each sport
		{
			fileLine = teamCount.nextLine();	
			//getting the number of baseball and football teams
			if (fileLine.contains("Baseball-"))
				bteamCount++;
			if (fileLine.contains("Football-"))
				fteamCount++;
		}
		teamCount.close();	//closing teamCount scanner
		//listing amount of teams
		writer.println("There are " + bteamCount + " baseball teams and " + fteamCount + " football teams.\n");
		writer.println();	//spacing
		
		
		BaseballTeam[] bteam = new BaseballTeam[bteamCount];	//making object arrays of football and baseball teams
		FootballTeam[] fteam = new FootballTeam[fteamCount];	//makes the correct amount of teams from the teamCounts
		
		while (fileReader.hasNextLine())
		{
			fileLine = fileReader.nextLine();	//setting fileLine = nextLine in the file
			
			if (fileLine.contains("Baseball-")) //creates a new baseball team when line contains "Baseball-"
			{
				teamName = fileReader.nextLine();	//creating teams from the data on the input file
				roster = fileReader.nextLine();
				bteam[bteamNum++] = new BaseballTeam(teamName, roster);	//creating new baseball teams until next line no longer contains "Baseball-"
			}
			if (fileLine.contains("Football-"))	//if the line in the file contains "Football-"
			{
				teamName = fileReader.nextLine();	//setting the team name and roster to the data on the input file
				roster = fileReader.nextLine();
				fteam[fteamNum++] = new FootballTeam(teamName, roster);	//creating new football teams until next line no longer contains "Football-"
			}
		}
		fileReader.close();	//closing file reader
		
		
		//baseball games
		writer.println("Baseball games:\n");
		writer.println("  |Home|                     |Away|\n");
		
			//first loops sets which team will be team1 (home team)
		for (int i = 0; i < bteam.length; i++)	//loops make sure every team plays each other twice
		{	//second loop sets which team will be team2 (away team)
			for (int j = 0; j < bteam.length; j++)
			{	
				if(i != j)	//making sure a team doesn't play against itself
				{
					BaseballGame bgame = new BaseballGame(bteam[i], bteam[j]);	//creating new baseball game

					if(bgame.wasTie())	//if tie
					{
						writer.println("The game between " + bteam[i].teamName() + " and " +
								bteam[j].teamName() + " ended up being a tie game.");
					}
					if(bgame.result() == true)	//if team1 win (home)
					{
						writer.println(bteam[i].teamName() + " won against " + bteam[j].teamName());
					}
					if(bgame.result() == false)	//if team1 lose
					{
						writer.println(bteam[i].teamName() + " lost against " + bteam[j].teamName());
					}
				}			
			}
			writer.println();	//spacing
		}
		writer.println("===================================");	//divider
		
		
		//Football games
		writer.println("Football games:\n");
		writer.println("  |Home|                     |Away|\n");
		
		for (int i = 0; i < fteam.length; i++)	//home team = team[i]
		{
			for (int j = 0; j < fteam.length; j++)	//away team = team[j]
			{
				if(i != j)	//makes sure a team doesnt play itself
				{
					FootballGame fgame = new FootballGame(fteam[i], fteam[j]);	//creating new football game
					
					if(fgame.wasTie())	//if game is tie
					{
						writer.println("The game between " + fteam[i].teamName() + " and " +
								fteam[j].teamName() + " ended up being a tie game.");
					}
					if(fgame.result() == true)	//if team 1 wins (home)
					{
						writer.println(fteam[i].teamName() + " won against " + fteam[j].teamName());
					}
					if(fgame.result() == false)	//if team 1 loses
					{
						writer.println(fteam[i].teamName() + " lost against " + fteam[j].teamName());
					}
				}
			}
			writer.println();
		}
		writer.println();	//spacing
		
		//writing final scores of teams
		//BASEBALL
		writer.println("\nFinal Scores - Baseball\n");
		writer.println("===================================");
		
		for(int i = 0; i < bteam.length; i++)	//printing scores for all of the baseball teams
		{
			writer.print(bteam[i].teamName());
			for(int j = 0; j < (scoreMargin - bteam[i].teamName().length()); j++)//right justifying the scores
			{
				writer.print(" ");
			}
			writer.print(bteam[i].winRecord() + "-" + bteam[i].lossRecord() + "-" + bteam[i].tieRecord()); //printing scores to output file
			writer.println();
		}
		writer.println();//spacing
		writer.println("Final Scores - Football\n");
		writer.println("===================================");	//divider
		
		
		//FOOTBALL
		for(int i = 0; i < fteam.length; i++)	//printing scores for all of the football teams
		{
			writer.print(fteam[i].teamName());
			for(int j = 0; j < (scoreMargin - fteam[i].teamName().length()); j++)//right justifying the scores
			{
				writer.print(" ");	//printing a space for each time it loops
			}
			writer.print(fteam[i].winRecord() + "-" + fteam[i].lossRecord() + "-" + fteam[i].tieRecord());	//printing out team's record
			writer.println();//spacing
		}
		System.out.println("Results printed to " + outputFile);	//tells user where the data is written
		writer.close();	// closing writer
	}
}
