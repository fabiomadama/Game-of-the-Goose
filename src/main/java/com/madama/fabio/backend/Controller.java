package com.madama.fabio.backend;

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
			GooseUtils.checkWin(players, messageBoard);
			players = moveGui(billboard, players);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "check", e);
		}
	}

	private ArrayList<Player> moveGui(Billboard billboard, ArrayList<Player> players) {
		players = GooseUtils.retrieveXYfromSpaces(players);
		billboard.setPlayers(players);
		billboard.repaint();
		return players;
	}
}
