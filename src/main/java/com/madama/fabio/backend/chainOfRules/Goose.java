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

public class Goose extends AbstractSpaces
{

	private static final Logger logger = Logger.getLogger(GenericSpaces.class.getName());
	{
		super.genericSpacesNumber = new HashSet<Integer>(6);
		genericSpacesNumber.add(9);
		genericSpacesNumber.add(18);
		genericSpacesNumber.add(27);
		genericSpacesNumber.add(36);
		genericSpacesNumber.add(45);
		genericSpacesNumber.add(54);
	}

	public Goose(ChainOfRulesHandler nextChainObj)
	{
		super(nextChainObj);

	}

	@Override
	public ChainOfRulesBean executeRules(ChainOfRulesBean chainOfRulesBean)
	{
		logger.log(Level.INFO, "Goose");
		SessionScope sessionScope = chainOfRulesBean.getSessionScope();
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));

		if (player.getRound() == 0 && findDestination(sessionScope) == 9)
		{
			player.setSpace(63);
			player.setWin(true);
			logger.log(Level.INFO, "Goose WIN !!");
		}
		else
		{
			player.setSpace(findDestination(sessionScope) + sessionScope.getDice_1() + sessionScope.getDice_2());
			
		}
		sessionScope.setRound(sessionScope.getRound() + 1);
		player.setRound(sessionScope.getRound());
		MessageBoard messageBoard = chainOfRulesBean.getMessageBoard();
		messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " on Goose, double score ! Go to "+player.getSpace());
		
		return chainOfRulesBean;
	}
}
