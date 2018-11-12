package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.Player;
import com.madama.fabio.SessionScope;

public class Prison extends AbstractSpaces {
	private static final Logger logger = Logger.getLogger( GenericSpaces.class.getName());
	
	{
		super.genericSpacesNumber = new HashSet<Integer>(2);
		genericSpacesNumber.add(42);
		genericSpacesNumber.add(52);
	}
	public Prison(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);
		
	}

	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
	    logger.log(Level.INFO, "GenericSpaces");
		
		Player player = players.get(getPlayerNumber());
		player.setSpace(findDestination());
		for(Player item : players){
			if(item.isStuck()){
				item.setStuck(false);
				break;
			}
		}
		player.setStuck(true);
		player.setRound(SessionScope.getRound());
		SessionScope.setDice_1(0);
		SessionScope.setDice_2(0);
		SessionScope.setRound(SessionScope.getRound() +1);

		return players;
	}

}
