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

public class Controller
{
	private static final Logger logger = Logger.getLogger(Controller.class.getName());

	public void check(Billboard billboard, MessageBoard messageBoard, SessionScope sessionScope)
	{
		try
		{
			ChainOfRulesClient chainClient = new ChainOfRulesClient();
			sessionScope = chainClient.start(sessionScope);
			ArrayList<Player> players = sessionScope.getPlayers();
			GooseUtils.checkWin(sessionScope.getPlayers(), messageBoard);
			moveGui(billboard, players);
		}
		catch (Exception e)
		{
			logger.log(Level.SEVERE, "check", e);
		}
	}

	private void moveGui(Billboard billboard, ArrayList<Player> players)
	{
		players = GooseUtils.retrieveXYfromSpaces(players);
		billboard.setPlayers(players);
		billboard.repaint();
	}
}
