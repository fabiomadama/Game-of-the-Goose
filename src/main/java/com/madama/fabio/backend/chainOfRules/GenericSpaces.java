package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.Player;
import com.madama.fabio.SessionScope;

public class GenericSpaces extends AbstractSpaces {
	private static final Logger logger = Logger.getLogger( GenericSpaces.class.getName());
	

	
	{
		super.genericSpacesNumber = new HashSet<Integer>(50);
		genericSpacesNumber.add(1);
		genericSpacesNumber.add(2);
		genericSpacesNumber.add(3);
		genericSpacesNumber.add(4);
		genericSpacesNumber.add(5);
		genericSpacesNumber.add(7);
		genericSpacesNumber.add(8);
		genericSpacesNumber.add(10);
		
		genericSpacesNumber.add(11);
		genericSpacesNumber.add(12);
		genericSpacesNumber.add(13);
		genericSpacesNumber.add(14);
		genericSpacesNumber.add(15);
		genericSpacesNumber.add(16);
		genericSpacesNumber.add(17);
		genericSpacesNumber.add(20);
		
		genericSpacesNumber.add(21);
		genericSpacesNumber.add(22);
		genericSpacesNumber.add(13);
		genericSpacesNumber.add(24);
		genericSpacesNumber.add(25);
		genericSpacesNumber.add(26);
		genericSpacesNumber.add(28);
		genericSpacesNumber.add(29);
		genericSpacesNumber.add(30);
		
		genericSpacesNumber.add(32);
		genericSpacesNumber.add(33);
		genericSpacesNumber.add(34);
		genericSpacesNumber.add(35);
		genericSpacesNumber.add(37);
		genericSpacesNumber.add(38);
		genericSpacesNumber.add(39);
		genericSpacesNumber.add(40);
		
		genericSpacesNumber.add(41);	
		genericSpacesNumber.add(43);
		genericSpacesNumber.add(44);
		genericSpacesNumber.add(46);
		genericSpacesNumber.add(47);
		genericSpacesNumber.add(48);
		genericSpacesNumber.add(49);
		genericSpacesNumber.add(50);
		
		genericSpacesNumber.add(51);	
		genericSpacesNumber.add(53);
		genericSpacesNumber.add(55);
		genericSpacesNumber.add(56);
		genericSpacesNumber.add(57);
		genericSpacesNumber.add(59);
		genericSpacesNumber.add(60);
		
		genericSpacesNumber.add(61);
		genericSpacesNumber.add(62);
	}	

	public GenericSpaces(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);
	}
	
	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
		logger.log(Level.INFO, "GenericSpaces");
		Player player = players.get(getPlayerNumber());
		player.setSpace(findDestination());		
		SessionScope.resetDice();
		SessionScope.setRound(SessionScope.getRound() +1);		
		player.setRound(SessionScope.getRound());
		return players;
	}
}
