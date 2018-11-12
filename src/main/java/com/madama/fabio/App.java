package com.madama.fabio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.madama.fabio.view.ViewOca;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args)
	{
		App.initLog();
		ViewOca oca = new ViewOca();
		
		oca.initGameGui();
		
		/* test */
		ArrayList<Player> players = new ArrayList<Player>(1);
		Player player1 = new Player();
		player1.setSpace(0);
		player1.setColor(Color.BLUE);
		player1.setRound(0);
		player1.setX(0);
		player1.setY(0);
		players.add(player1);
		
		Player player2 = new Player();
		player2.setSpace(0);
		player2.setColor(Color.RED);
		player2.setRound(0);
		player2.setX(0);
		player2.setY(0);
		players.add(player2);		
		SessionScope.setPlayers(players);
	}
	
	private static void initLog(){
		Logger log = Logger.getLogger("App");
		log.setLevel(Level.ALL);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		log.addHandler(handler);
	}
}
