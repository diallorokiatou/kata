package com.onepoint.source.model;

import java.util.Scanner;

public class Bowling 
{
	int number_players;
	Player player;
	Score scoreBoard;
	Scanner sc;
	
	public Bowling() 
	{
		// Get player name
		sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du joueur "  + " :");
		String name = sc.next();
		player = new Player(name);
	}
	
	public void start() 
	{
		System.out.println("######################## Player " + player.name + " ####################################");
		player.play();
	}
}
