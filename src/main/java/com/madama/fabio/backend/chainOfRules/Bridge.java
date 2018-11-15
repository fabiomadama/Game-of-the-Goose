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

public class Bridge extends AbstractSpaces
{
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(1);
		genericSpacesNumber.add(6); // ladder
	}

	public Bridge(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public SessionScope executeRules(SessionScope sessionScope, MessageBoard messageBoard)
	{
		logger.log(Level.INFO, "Bridge");

		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(6 + sessionScope.getDice_1() + sessionScope.getDice_2());
		player.setRound(sessionScope.getRound());
		sessionScope.setRound(sessionScope.getRound() + 1);
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " on Bridge, double score ! ");
		

		return sessionScope;
	}

}
