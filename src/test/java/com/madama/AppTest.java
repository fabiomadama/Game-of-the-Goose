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

public class AppTest {
	ViewOca view;

	/**
	 * Gui costruita
	 */
	@Before
	public void testInit() {
		// cerco eccezioni nel costruire GUI
		view = new ViewOca();
		view.initGameGui();
//		Assert.assertTrue(true);
	}

	@Test
	public void testMove() {		
		int space = 55;
		
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player();
		player1.setSpace(space);
		player1.setColor(Color.GREEN);
		player1.setRound(1);
		player1.setX(0);
		player1.setY(0);
		players.add(player1);
		
		Player player2 = new Player();
		player2.setSpace(space);
		player2.setColor(Color.BLUE);
		player2.setRound(1);
		player2.setX(0);
		player2.setY(0);
		players.add(player2);	
		
		Player player3 = new Player();
		player3.setSpace(space);
		player3.setColor(Color.RED);
		player3.setRound(1);
		player3.setX(0);
		player3.setY(0);
		players.add(player3);	
		
		Player player4 = new Player();
		player4.setSpace(space);
		player4.setColor(Color.YELLOW);
		player4.setRound(1);
		player4.setX(0);
		player4.setY(0);
		players.add(player4);	
		


  	    GooseUtils.retrieveXYfromSpaces(players);		
		view.redraw(players);
		
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWrite(){
		view.writeText("AAAAAAAAAAA");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		view.writeText("BBBBBBBBBBB");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSimulateDiceRoll(){
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player();
		player1.setSpace(0);
		player1.setColor(Color.BLUE);
		player1.setRound(0);
		player1.setX(0);
		player1.setY(0);
		players.add(player1);
		
		Player player2 = new Player();
		player2.setSpace(0);
		player2.setColor(Color.RED);
		player2.setRound(0);
		player2.setX(0);
		player2.setY(0);
		players.add(player2);
		
		SessionScope.setPlayers(players);
		SessionScope.setDice_1(6);
		SessionScope.setDice_2(3);
		
		Controller controller = new Controller();
		controller.check(view.getBillboard(), view.getMessageBoard());
		
		Assert.assertTrue(true);
	}

	
	@Test
	public void testRegularGame(){
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player();
		player1.setSpace(0);
		player1.setColor(Color.BLUE);
		player1.setRound(0);
		player1.setX(0);
		player1.setY(0);
		players.add(player1);
		
		Player player2 = new Player();
		player2.setSpace(0);
		player2.setColor(Color.RED);
		player2.setRound(0);
		player2.setX(0);
		player2.setY(0);
		players.add(player2);		
		view.redraw(players);
		
		SessionScope.setPlayers(players);
		for(int i=0; i<5; i++){
			view.rollTheDice();
		}
		Assert.assertEquals(Long.valueOf(5), Long.valueOf(SessionScope.getRound()));
	}
	
	
}
