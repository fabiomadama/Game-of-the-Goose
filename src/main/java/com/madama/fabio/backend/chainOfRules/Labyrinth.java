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
	public ChainOfRulesBean executeRules(ChainOfRulesBean chainOfRulesBean)
	{
		logger.log(Level.INFO, "Labyrinth");
		SessionScope sessionScope = chainOfRulesBean.getSessionScope();
		MessageBoard messageBoard = chainOfRulesBean.getMessageBoard();
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(33);
		sessionScope.setRound(sessionScope.getRound() + 1);
		player.setRound(sessionScope.getRound());
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " in Labyrinth, back to 33 ! ");
		

		return chainOfRulesBean;
	}

}
