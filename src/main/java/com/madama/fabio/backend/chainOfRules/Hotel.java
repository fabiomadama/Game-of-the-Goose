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
import com.madama.fabio.bean.ChainOfRulesBean;
import com.madama.fabio.view.MessageBoard;

public class Hotel extends AbstractSpaces
{
	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());

	{
		super.genericSpacesNumber = new HashSet<Integer>(1);
		genericSpacesNumber.add(19);
	}

	public Hotel(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public ChainOfRulesBean executeRules(ChainOfRulesBean chainOfRulesBean)
	{
		logger.log(Level.INFO, "Hotel");
		SessionScope sessionScope = chainOfRulesBean.getSessionScope();
		MessageBoard messageBoard = chainOfRulesBean.getMessageBoard();
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(findDestination(sessionScope));
		player.setRound(sessionScope.getRound() +3);
		sessionScope.setRound(sessionScope.getRound() + 1);
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " in Hotel, wait 3 round ! ");

		return chainOfRulesBean;
	}

}
