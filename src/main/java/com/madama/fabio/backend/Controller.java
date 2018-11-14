/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.backend.chainOfRules.ChainOfRulesClient;
import com.madama.fabio.view.Billboard;
import com.madama.fabio.view.MessageBoard;

public class Controller {
	private static final Logger logger = Logger.getLogger(Controller.class.getName());

	/**
	 * Depending on the value of the dice, the player's position and the direct
	 * consequences are determined
	 * 
	 * @param billboard
	 * @param messageBoard
	 * @param sessionScope
	 */
	public void check(Billboard billboard, MessageBoard messageBoard, SessionScope sessionScope) {
		try {
			ChainOfRulesClient chainClient = new ChainOfRulesClient();
			sessionScope = chainClient.start(sessionScope, messageBoard);
			ArrayList<Player> players = sessionScope.getPlayers();
			GooseUtils.moveGui(billboard, players);
			GooseUtils.checkWin(sessionScope.getPlayers(), messageBoard);
			if (!GooseUtils.checkLook(sessionScope.getPlayers(), messageBoard)) {
				sessionScope.resetDiceLanched();
				sessionScope.resetDice();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "check", e);
		}
	}
}
