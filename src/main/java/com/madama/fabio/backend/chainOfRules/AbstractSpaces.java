package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;
import java.util.HashSet;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.SessionScope;

public abstract class AbstractSpaces implements ChainOfRulesHandler {
	private ChainOfRulesHandler nextChainObj;
	protected HashSet<Integer> genericSpacesNumber;
	
	public AbstractSpaces(ChainOfRulesHandler nextChainObj){
		this.nextChainObj = nextChainObj;
	}
	
	@Override
	public ArrayList<Player> nextChain(ArrayList<Player> players) throws Exception {
		if (nextChainObj != null) {
			return nextChainObj.doExecute(players);
		} else {
			return new ArrayList<Player>();
		}
	}
	
	/**
	 * Calculate destination
	 * @param players
	 * @return
	 */
	public Integer findDestination(){
		Player player = SessionScope.getPlayers().get(getPlayerNumber());
		return player.getSpace() + SessionScope.getDice_1() + SessionScope.getDice_2();		
	}
	
	/**
	 * Determine if it is the right tool from the space number after the dice roll
	 * @param players
	 * @return
	 */
	public boolean doTest(int destination) {
		return genericSpacesNumber.contains(destination);
	}
	
	/**
	 * 
	 * @param Apply the rules of the landing space
	 * @return
	 */
	public abstract ArrayList<Player> executeRules(ArrayList<Player> players);
	
	@Override
	public ArrayList<Player> doExecute(ArrayList<Player> players) throws Exception {
		if (doTest(findDestination())) {
			return executeRules(players);
		} else {
			return nextChain(players);
		}
	}

	public Integer getPlayerNumber() {
		return GooseUtils.whosnext(SessionScope.getPlayers());
	}

}
