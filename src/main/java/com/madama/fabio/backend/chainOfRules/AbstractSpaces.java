/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import java.util.HashSet;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.bean.ChainOfRulesBean;

public abstract class AbstractSpaces implements ChainOfRulesHandler
{
	private ChainOfRulesHandler	nextChainObj;
	protected HashSet<Integer>	genericSpacesNumber;

	public AbstractSpaces(ChainOfRulesHandler nextChainObj)
	{
		this.nextChainObj = nextChainObj;
	}

	@Override
	public ChainOfRulesBean nextChain(ChainOfRulesBean chainOfRulesBean) throws Exception
	{
		if (nextChainObj != null)
		{
			return nextChainObj.doExecute(chainOfRulesBean);
		}
		else
		{
			return chainOfRulesBean;
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
	public abstract ChainOfRulesBean executeRules(ChainOfRulesBean chainOfRulesBean);

	@Override
	public ChainOfRulesBean doExecute(ChainOfRulesBean chainOfRulesBean) throws Exception
	{
		if (doTest(findDestination(chainOfRulesBean.getSessionScope())))
		{
			return executeRules(chainOfRulesBean);
		}
		else
		{
			return nextChain(chainOfRulesBean);
		}
	}

	public Integer getPlayerNumber(SessionScope sessionScope)
	{
		return GooseUtils.whosnext(sessionScope);
	}

}
