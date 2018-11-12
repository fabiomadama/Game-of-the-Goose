package com.madama;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.madama.fabio.Controller;
import com.madama.fabio.Player;
import com.madama.fabio.SessionScope;
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
		ArrayList<Player> players = new ArrayList<Player>(2);
		Player player1 = new Player();
		player1.setSpace(1);
		player1.setColor(Color.BLUE);
		player1.setRound(1);
		player1.setX(690);
		player1.setY(350);
		players.add(player1);
		
		Player player2 = new Player();
		player2.setSpace(1);
		player2.setColor(Color.RED);
		player2.setRound(1);
		player2.setX(700);
		player2.setY(430);
		players.add(player2);		
		view.redraw(players);
		SessionScope.setPlayers(players);
		
		try {
			Thread.sleep(1500);
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
		ArrayList<Player> players = new ArrayList<Player>(2);
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
		ArrayList<Player> players = new ArrayList<Player>(2);
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
