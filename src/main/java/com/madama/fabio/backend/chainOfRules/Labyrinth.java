/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;

public class Labyrinth extends AbstractSpaces
{
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(1);
		genericSpacesNumber.add(42);
	}

	public Labyrinth(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public SessionScope executeRules(SessionScope sessionScope)
	{
		logger.log(Level.INFO, "Labyrinth");
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(33);
		player.setRound(sessionScope.getRound());
		sessionScope.setDice_1(0);
		sessionScope.setDice_2(0);
		sessionScope.setRound(sessionScope.getRound() + 1);

		return sessionScope;
	}

}
