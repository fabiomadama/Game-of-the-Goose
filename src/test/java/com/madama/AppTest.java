package com.madama;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.madama.fabio.backend.Controller;
import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.ViewOca;

/**
 * Unit test for simple App.
 */

public class AppTest
{
	ViewOca view;

	/**
	 * Gui costruita
	 */
	@Before
	public void testInit()
	{
		// cerco eccezioni nel costruire GUI
		view = new ViewOca();
		SessionScope sessionScope = new SessionScope();
		view.initGameGui(sessionScope);
		Assert.assertTrue(true);
	}

	@Test
	public void testMove()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player(Color.GREEN, 1, 0, 100, 0, false, false));
		players.add(new Player(Color.BLUE, 55, 0, 200, 0, false, false));

		GooseUtils.retrieveXYfromSpaces(players);
		view.redraw(players);

		try
		{
			Thread.sleep(1800);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		Assert.assertTrue(true);
	}

	@Test
	public void testWrite()
	{
		view.writeText("AAAAAAAAAAA");
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		view.writeText("BBBBBBBBBBB");
		Assert.assertTrue(true);
	}

	@Test
	public void testSimulateDiceRoll()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player(Color.GREEN, 0, 0, 0, 0, false, false));
		players.add(new Player(Color.BLUE, 0, 0, 0, 0, false, false));

		SessionScope sessionScope = new SessionScope();
		sessionScope.setPlayers(players);
		sessionScope.setDice_1(6);
		sessionScope.setDice_2(3);

		Controller controller = new Controller();
		controller.check(view.getBillboard(), view.getMessageBoard(), sessionScope);

		Assert.assertTrue(true);
	}

	@Test
	public void testRegularGame()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player(Color.GREEN, 0, 0, 0, 0, false, false));
		players.add(new Player(Color.BLUE, 0, 0, 0, 0, false, false));
		players.add(new Player(Color.RED, 0, 0, 0, 0, false, false));
		players.add(new Player(Color.YELLOW, 0, 0, 0, 0, false, false));

		SessionScope sessionScope = new SessionScope();
		sessionScope.setPlayers(players);
		for (int i = 0; i < 5; i++)
		{
			view.rollTheDice();
		}
		Assert.assertEquals(Long.valueOf(5), Long.valueOf(sessionScope.getRound()));
	}
}
