package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.Player;
import com.madama.fabio.SessionScope;

public class Goose extends AbstractSpaces {

	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());
	{
		super.genericSpacesNumber = new HashSet<Integer>(7);
		genericSpacesNumber.add(6); // ladder
		genericSpacesNumber.add(9);
		genericSpacesNumber.add(18);
		genericSpacesNumber.add(27);
		genericSpacesNumber.add(36);
		genericSpacesNumber.add(45);
		genericSpacesNumber.add(54);
	}

	public Goose(ChainOfRulesHandler nextChainObj) {
		super(nextChainObj);

	}

	@Override
	public ArrayList<Player> executeRules(ArrayList<Player> players) {
		logger.log(Level.INFO, "Goose");
		Player player = players.get(getPlayerNumber());

		if (player.getRound() == 0 && findDestination() == 9) {
			player.setSpace(63);
			player.setWin(true);
			logger.log(Level.INFO, "Goose WIN !!");
			return players;
		}
		player.setSpace(findDestination() + SessionScope.getDice_1() + SessionScope.getDice_2());
		player.setRound(SessionScope.getRound());
		SessionScope.setDice_1(0);
		SessionScope.setDice_2(0);
		SessionScope.setRound(SessionScope.getRound() + 1);

		return players;
	}

}
