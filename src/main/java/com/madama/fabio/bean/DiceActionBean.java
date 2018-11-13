package com.madama.fabio.bean;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.Billboard;
import com.madama.fabio.view.MessageBoard;

public class DiceActionBean
{
	private Billboard		billboard;
	private MessageBoard	messageBoard;
	private JButton			dice;
	private JLabel			diceImg;
	private BufferedImage[]	diceFaces;
	private int				lastRoll;
	private int				diceN;		 // identifico il dado
	private SessionScope	sessionScope;

	/**
	 * @return the billboard
	 */
	public Billboard getBillboard()
	{
		return billboard;
	}

	/**
	 * @param billboard the billboard to set
	 */
	public void setBillboard(Billboard billboard)
	{
		this.billboard = billboard;
	}

	/**
	 * @return the messageBoard
	 */
	public MessageBoard getMessageBoard()
	{
		return messageBoard;
	}

	/**
	 * @param messageBoard the messageBoard to set
	 */
	public void setMessageBoard(MessageBoard messageBoard)
	{
		this.messageBoard = messageBoard;
	}

	/**
	 * @return the dice
	 */
	public JButton getDice()
	{
		return dice;
	}

	/**
	 * @param dice the dice to set
	 */
	public void setDice(JButton dice)
	{
		this.dice = dice;
	}

	/**
	 * @return the diceImg
	 */
	public JLabel getDiceImg()
	{
		return diceImg;
	}

	/**
	 * @param diceImg the diceImg to set
	 */
	public void setDiceImg(JLabel diceImg)
	{
		this.diceImg = diceImg;
	}

	/**
	 * @return the diceFaces
	 */
	public BufferedImage[] getDiceFaces()
	{
		return diceFaces;
	}

	/**
	 * @param diceFaces the diceFaces to set
	 */
	public void setDiceFaces(BufferedImage[] diceFaces)
	{
		this.diceFaces = diceFaces;
	}

	/**
	 * @return the lastRoll
	 */
	public int getLastRoll()
	{
		return lastRoll;
	}

	/**
	 * @param lastRoll the lastRoll to set
	 */
	public void setLastRoll(int lastRoll)
	{
		this.lastRoll = lastRoll;
	}

	/**
	 * @return the diceN
	 */
	public int getDiceN()
	{
		return diceN;
	}

	/**
	 * @param diceN the diceN to set
	 */
	public void setDiceN(int diceN)
	{
		this.diceN = diceN;
	}

	/**
	 * @return the sessionScope
	 */
	public SessionScope getSessionScope()
	{
		return sessionScope;
	}

	/**
	 * @param sessionScope the sessionScope to set
	 */
	public void setSessionScope(SessionScope sessionScope)
	{
		this.sessionScope = sessionScope;
	}
}
