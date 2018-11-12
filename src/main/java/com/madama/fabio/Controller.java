package com.madama.fabio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.chainOfRules.ChainOfRulesClient;
import com.madama.fabio.view.Billboard;
import com.madama.fabio.view.MessageBoard;

public class Controller {
	private static final Logger logger = Logger.getLogger(Controller.class.getName());

	public void check(Billboard billboard, MessageBoard messageBoard) {
		try {
			ChainOfRulesClient chainClient = new ChainOfRulesClient();
			ArrayList<Player> players = SessionScope.getPlayers();
			players = chainClient.start(players);
			checkWin(players, messageBoard);
			players = moveGui(billboard, players);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "check", e);
		}
	}

	private ArrayList<Player> moveGui(Billboard billboard, ArrayList<Player> players) {
		for (Player player : players) {
			retrieveCoordinatesFromPosition(player);
		}
		billboard.setPlayers(players);
		billboard.repaint();
		return players;
	}

	private Player retrieveCoordinatesFromPosition(Player player) {
		Color color = player.getColor();
		int dimHSpace = 55; /* 450 / 7; space height */
		
		if (player.getSpace() > 0) {
			player.setX(retrieveCoordinatesFromColor(player.getSpace(), color) );
			player.setY((player.getSpace() / 7) * dimHSpace);
		}
		
		logger.log(Level.INFO, "Color: "+player.getColor() + " space: " + player.getSpace() + " X:" + player.getX() + " Y:" + player.getY() + " roud:"
				+ player.getRound());		

		return player;
	}

	private Integer retrieveCoordinatesFromColor(Integer space, Color color) {		
		if (space > 9) {
			space = space % 9;
		}
		int dimWSpace = 84; /* 760 / 9; space width */
		space = space * dimWSpace;
		if (color.equals(Color.GREEN)) {
			return space + 1;
		} else if (color.equals(Color.BLUE)) {
			return space + 2;
		} else if (color.equals(Color.RED)) {
			return space + 3;
		} else if (color.equals(Color.YELLOW)) {
			return space + 4;
		} else if (color.equals(Color.ORANGE)) {
			return space + 5;
		}
		return space;
	}
	
	private void checkWin(ArrayList<Player> players, MessageBoard messageBoard){
		for (Player player : players) {
			if(player.isWin()){
				messageBoard.setText(retrievePlayerName(player.getColor()) +" player win !");
		    	messageBoard.repaint();
			}
		}
	}
	
	private String retrievePlayerName(Color color){
		if (color.equals(Color.GREEN)) {
			return "GREEN";
		} else if (color.equals(Color.BLUE)) {
			return "BLUE";
		} else if (color.equals(Color.RED)) {
			return "RED";
		} else if (color.equals(Color.YELLOW)) {
			return "YELLOW";
		} else if (color.equals(Color.ORANGE)) {
			return "ORANGE";
		}
		return "Color color";
		
	}
}
