/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import java.util.HashSet;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.MessageBoard;

public abstract class AbstractSpaces implements ChainOfRulesHandler
{
	private ChainOfRulesHandler	nextChainObj;
	protected HashSet<Integer>	genericSpacesNumber;

	public AbstractSpaces(ChainOfRulesHandler nextChainObj)
	{
		this.nextChainObj = nextChainObj;
	}

	@Override
	public SessionScope nextChain(SessionScope sessionScope, MessageBoard messageBoard) throws Exception
	{
		if (nextChainObj != null)
		{
			return nextChainObj.doExecute(sessionScope, messageBoard);
		}
		else
		{
			return sessionScope;
		}
	}

	/**
	 * Calculate destination
	 * 
	 * @param players
	 * @return
	 */
	public Integer findDestination(SessionScope sessionScope)
	{
		Player player = sessionScope.getPlayers().get(getPlayerNumber(sessionScope));
		return player.getSpace() + sessionScope.getDice_1() + sessionScope.getDice_2();
	}

	/**
	 * Determine if it is the right tool from the space number after the dice roll
	 * 
	 * @param players
	 * @return
	 */
	public boolean doTest(int destination)
	{
		return genericSpacesNumber.contains(destination);
	}

	/**
	 * 
	 * @param messageBoard TODO
	 * @param Apply the rules of the landing space
	 * @return
	 */
	public abstract SessionScope executeRules(SessionScope sessionScope, MessageBoard messageBoard);

	@Override
	public SessionScope doExecute(SessionScope sessionScope, MessageBoard messageBoard) throws Exception
	{
		if (doTest(findDestination(sessionScope)))
		{
			return executeRules(sessionScope, messageBoard);
		}
		else
		{
			return nextChain(sessionScope, messageBoard);
		}
	}

	public Integer getPlayerNumber(SessionScope sessionScope)
	{
		return GooseUtils.whosnext(sessionScope);
	}

}
