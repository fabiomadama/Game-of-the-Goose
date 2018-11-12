package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;

public class End extends AbstractSpaces {
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(0);	
	}
	
	public End(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);

	}

	@Override
	public boolean doTest(int destination) {
		return destination >= 63;
	}

	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
		logger.log(Level.INFO, "End");

		Player player = players.get(getPlayerNumber()); 		
		player.setSpace(calcolateDestination(player));
		player.setRound(SessionScope.getRound());
		SessionScope.setDice_1(0);
		SessionScope.setDice_2(0);
		SessionScope.setRound(SessionScope.getRound() + 1);

		return players;
	}

	private int calcolateDestination(Player player) {
		if (findDestination() == 63) {
			player.setWin(true);
			logger.log(Level.INFO, "Goose WIN !!");
		}
		if (findDestination() > 63) {
			return (63 - (findDestination() - 63));
		}
		return findDestination();
	}
}
