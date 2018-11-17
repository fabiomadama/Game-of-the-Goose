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
	public ChainOfRulesBean executeRules(ChainOfRulesBean chainOfRulesBean)
	{
		logger.log(Level.INFO, "Bridge");
		SessionScope sessionScope = chainOfRulesBean.getSessionScope();
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		player.setSpace(6 + sessionScope.getDice_1() + sessionScope.getDice_2());
		sessionScope.setRound(sessionScope.getRound() + 1);
		player.setRound(sessionScope.getRound());
		MessageBoard messageBoard = chainOfRulesBean.getMessageBoard();
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " on Bridge, double score ! Go to "+player.getSpace());		

		return chainOfRulesBean;
	}

}
