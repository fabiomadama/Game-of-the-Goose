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

public class Prison extends AbstractSpaces
{
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(2);
		genericSpacesNumber.add(31);
		genericSpacesNumber.add(52);
	}

	public Prison(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public SessionScope executeRules(SessionScope sessionScope, MessageBoard messageBoard)
	{
		logger.log(Level.INFO, "GenericSpaces");

		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));		
		for (Player item : sessionScope.getPlayers())
		{
			if (item.isStuck())
			{
				item.setStuck(false);
				break;
			}
		}		
		player.setStuck(true);
		player.setSpace(findDestination(sessionScope));
		player.setRound(sessionScope.getRound());
		sessionScope.setRound(sessionScope.getRound() + 1);
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " in Prison, waiting for someone to free you ! ");
		messageBoard.repaint();

		return sessionScope;
	}

}
