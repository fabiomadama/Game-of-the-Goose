package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;

public class Hotel extends AbstractSpaces {
	private static final Logger logger = Logger.getLogger( GenericSpaces.class.getName());
	
	{
		super.genericSpacesNumber = new HashSet<Integer>(1);
		genericSpacesNumber.add(19);
	}
	public Hotel(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);
		
	}

	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
		logger.log(Level.INFO, "Hotel");
		
		Player player = players.get(getPlayerNumber());
		player.setSpace(findDestination());		
		player.setRound(SessionScope.getRound() +3);
		SessionScope.setDice_1(0);
		SessionScope.setDice_2(0);
		SessionScope.setRound(SessionScope.getRound() +1);

		return players;
	}

}
