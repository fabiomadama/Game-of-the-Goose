/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.madama.fabio.view.Billboard;
import com.madama.fabio.view.MessageBoard;

public class GooseUtils
{
	private static final Logger logger = Logger.getLogger(GooseUtils.class.getName());

	/**
	 * Determines if the event should be heard
	 * 
	 * @param sessionScope
	 * @param billboard
	 * @param messageBoard
	 */
	public static synchronized void check(SessionScope sessionScope, Billboard billboard, MessageBoard messageBoard)
	{
		if (sessionScope.getDice_1() != 0 && sessionScope.getDice_2() != 0 && sessionScope.isDiceLaunched_1() && sessionScope.isDiceLaunched_2())
		{
			logger.log(Level.INFO, "Dice value 1: " + sessionScope.getDice_1() + " 2: " + sessionScope.getDice_2());
			Controller controller = new Controller();
			controller.check(billboard, messageBoard, sessionScope);
		}
	}

	/**
	 * Init the player property
	 * 
	 * @param sessionScope
	 * @param numPlayers
	 */
	public static void initPlayersAndGame(SessionScope sessionScope, int numPlayers)
	{
		sessionScope.resetDice();
		sessionScope.resetDiceLanched();

		ArrayList<Player> players = new ArrayList<Player>();
		if (numPlayers > 0)
		{
			players.add(new Player(Color.GREEN, 0, 0, 0, 0, false, false));
		}
		if (numPlayers > 1)
		{
			players.add(new Player(Color.BLUE, 0, 0, 0, 0, false, false));
		}
		if (numPlayers > 2)
		{
			players.add(new Player(Color.RED, 0, 0, 0, 0, false, false));
		}
		if (numPlayers > 3)
		{
			players.add(new Player(Color.YELLOW, 0, 0, 0, 0, false, false));
		}
		sessionScope.setPlayers(players);
	}

	/**
	 * Move player on billboard
	 * 
	 * @param billboard
	 * @param players
	 */
	public static void moveGui(Billboard billboard, ArrayList<Player> players)
	{
		players = GooseUtils.retrieveXYfromSpaces(players);
		billboard.setPlayers(players);
		billboard.repaint();
	}

	/**
	 * Calculate who is next
	 * 
	 * @param sessionScope
	 * @return int intedx of list
	 */
	public static int whosnext(SessionScope sessionScope)
	{
		int index = 0;
		if (sessionScope.getRound() != 0)
		{
			for (int i = 0; i < sessionScope.getPlayers().size(); i++)
			{
				Player player = sessionScope.getPlayers().get(i);
				if (!player.isStuck() && player.getRound() < sessionScope.getRound())
				{
					index = i;
					break;
				}
			} // for
		} // if
		return index;
	}// whosnext

	/**
	 * Calculate coordinates from color
	 * 
	 * @param space
	 * @param color
	 * @return
	 */
	private static Integer retrieveCoordinatesFromColor(Integer space, Color color)
	{
		if (color.equals(Color.GREEN))
		{
			return space;
		}
		else if (color.equals(Color.BLUE))
		{
			return space + 15;
		}
		else if (color.equals(Color.RED))
		{
			return space + 30;
		}
		else if (color.equals(Color.YELLOW))
		{
			return space + 45;
		}
		return space;
	}

	/**
	 * Retrieve the player Color to use in message
	 * 
	 * @param color
	 * @return
	 */
	public static String retrievePlayerName(Color color)
	{
		if (color.equals(Color.GREEN))
		{
			return "GREEN";
		}
		else if (color.equals(Color.BLUE))
		{
			return "BLUE";
		}
		else if (color.equals(Color.RED))
		{
			return "RED";
		}
		else if (color.equals(Color.YELLOW))
		{
			return "YELLOW";
		}
		else if (color.equals(Color.ORANGE))
		{
			return "ORANGE";
		}
		return "Color color";

	}

	public static void checkWin(ArrayList<Player> players, MessageBoard messageBoard)
	{
		for (Player player : players)
		{
			if (player.isWin())
			{
				messageBoard.setText(GooseUtils.retrievePlayerName(player.getColor()) + " win the game ! ");
				
			}
		}
	}

	public static boolean checkLook(ArrayList<Player> players, MessageBoard messageBoard)
	{
		if(players.size() == 2 && players.get(0).isStuck() && players.get(1).isStuck()) {
			messageBoard.setText("All locked, end game.. ");
			
			return true;
		}
		return false;
	}

	public static ArrayList<Player> retrieveXYfromSpaces(ArrayList<Player> players)
	{
		for (Player player : players)
		{

			switch (player.getSpace())
			{
				case 1:
					player.setX(10);
					player.setY(10);
					break;
				case 2:
					player.setX(80);
					player.setY(10);
					break;
				case 3:
					player.setX(160);
					player.setY(10);
					break;
				case 4:
					player.setX(250);
					player.setY(10);
					break;
				case 5:
					player.setX(340);
					player.setY(10);
					break;
				case 6:
					player.setX(430);
					player.setY(10);
					break;
				case 7:
					player.setX(510);
					player.setY(10);
					break;
				case 8:
					player.setX(610);
					player.setY(10);
					break;
				case 9:
					player.setX(700);
					player.setY(10);
					break;
				case 10:
					player.setX(15);
					player.setY(70);
					break;
				case 11:
					player.setX(70);
					player.setY(70);
					break;
				case 12:
					player.setX(155);
					player.setY(70);
					break;
				case 13:
					player.setX(245);
					player.setY(70);
					break;
				case 14:
					player.setX(335);
					player.setY(70);
					break;
				case 15:
					player.setX(420);
					player.setY(70);
					break;
				case 16:
					player.setX(510);
					player.setY(70);
					break;
				case 17:
					player.setX(600);
					player.setY(70);
					break;
				case 18:
					player.setX(685);
					player.setY(70);
					break;
				case 19:
					player.setX(15);
					player.setY(130);
					break;
				case 20:
					player.setX(70);
					player.setY(130);
					break;
				case 21:
					player.setX(155);
					player.setY(130);
					break;
				case 22:
					player.setX(245);
					player.setY(130);
					break;
				case 23:
					player.setX(335);
					player.setY(130);
					break;
				case 24:
					player.setX(420);
					player.setY(130);
					break;
				case 25:
					player.setX(510);
					player.setY(130);
					break;
				case 26:
					player.setX(600);
					player.setY(130);
					break;
				case 27:
					player.setX(685);
					player.setY(130);
					break;
				case 28:
					player.setX(15);
					player.setY(190);
					break;
				case 29:
					player.setX(70);
					player.setY(190);
					break;
				case 30:
					player.setX(155);
					player.setY(190);
					break;
				case 31:
					player.setX(245);
					player.setY(190);
					break;
				case 32:
					player.setX(335);
					player.setY(190);
					break;
				case 33:
					player.setX(420);
					player.setY(190);
					break;
				case 34:
					player.setX(510);
					player.setY(190);
					break;
				case 35:
					player.setX(600);
					player.setY(190);
					break;
				case 36:
					player.setX(685);
					player.setY(190);
					break;
				case 37:
					player.setX(15);
					player.setY(255);
					break;
				case 38:
					player.setX(70);
					player.setY(255);
					break;
				case 39:
					player.setX(155);
					player.setY(255);
					break;
				case 40:
					player.setX(245);
					player.setY(255);
					break;
				case 41:
					player.setX(335);
					player.setY(255);
					break;
				case 42:
					player.setX(420);
					player.setY(255);
					break;
				case 43:
					player.setX(510);
					player.setY(255);
					break;
				case 44:
					player.setX(600);
					player.setY(255);
					break;
				case 45:
					player.setX(685);
					player.setY(255);
					break;
				case 46:
					player.setX(15);
					player.setY(315);
					break;
				case 47:
					player.setX(70);
					player.setY(315);
					break;
				case 48:
					player.setX(155);
					player.setY(315);
					break;
				case 49:
					player.setX(245);
					player.setY(315);
					break;
				case 50:
					player.setX(335);
					player.setY(315);
					break;
				case 51:
					player.setX(420);
					player.setY(315);
					break;
				case 52:
					player.setX(510);
					player.setY(315);
					break;
				case 53:
					player.setX(600);
					player.setY(315);
					break;
				case 54:
					player.setX(685);
					player.setY(315);
					break;
				case 55:
					player.setX(15);
					player.setY(380);
					break;
				case 56:
					player.setX(70);
					player.setY(380);
					break;
				case 57:
					player.setX(155);
					player.setY(380);
					break;
				case 58:
					player.setX(245);
					player.setY(380);
					break;
				case 59:
					player.setX(335);
					player.setY(380);
					break;
				case 60:
					player.setX(420);
					player.setY(380);
					break;
				case 61:
					player.setX(510);
					player.setY(380);
					break;
				case 62:
					player.setX(600);
					player.setY(380);
					break;
				case 63:
					player.setX(685);
					player.setY(380);
					break;

				default:
					logger.log(Level.SEVERE, "unknown position");
					break;
			}
			player.setY(retrieveCoordinatesFromColor(player.getY(), player.getColor()));
			logger.log(Level.INFO, "Color: " + player.getColor() + " space: " + player.getSpace() + " X:" + player.getX() + " Y:" + player.getY()
					+ " round:" + player.getRound());
		} // for
		return players;

	}
}
