/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.MessageBoard;

public class End extends AbstractSpaces
{
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(0);
	}

	public End(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public boolean doTest(int destination)
	{
		return destination >= 63;
	}

	@Override
	public SessionScope executeRules(SessionScope sessionScope, MessageBoard messageBoard)
	{
		logger.log(Level.INFO, "End");

		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(calcolateDestination(sessionScope, player, messageBoard));
		player.setRound(sessionScope.getRound());
		sessionScope.resetDiceValue();
		sessionScope.setRound(sessionScope.getRound() + 1);

		return sessionScope;
	}

	private int calcolateDestination(SessionScope sessionScope, Player player, MessageBoard messageBoard)
	{
		if (findDestination(sessionScope) == 63)
		{
			player.setWin(true);
			logger.log(Level.INFO, "Goose WIN !!");
		}
		if (findDestination(sessionScope) > 63)
		{
			messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " try again ! ");
			messageBoard.repaint();
			return (63 - (findDestination(sessionScope) - 63));
		}
		return findDestination(sessionScope);
	}
}
