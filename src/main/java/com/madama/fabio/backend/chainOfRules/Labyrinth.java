package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;

public class Labyrinth extends AbstractSpaces {
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(1);
		genericSpacesNumber.add(42);
	}

	public Labyrinth(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);

	}

	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
		logger.log(Level.INFO, "Labyrinth");
		Player player = players.get(getPlayerNumber());
		player.setSpace(33);
		player.setRound(SessionScope.getRound());
		SessionScope.setDice_1(0);
		SessionScope.setDice_2(0);
		SessionScope.setRound(SessionScope.getRound() + 1);

		return players;
	}

}
