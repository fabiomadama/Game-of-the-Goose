package com.madama.fabio.bean;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.madama.fabio.view.Billboard;
import com.madama.fabio.view.MessageBoard;

public class ConfigureLayoutBean
{
	private JPanel		 table		  = null;
	private Billboard	 billboard	  = null;
	private MessageBoard messageBoard = null;
	private JComponent	 dice		  = null;

	/**
	 * @return the table
	 */
	public JPanel getTable()
	{
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JPanel table)
	{
		this.table = table;
	}

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
	public JComponent getDice()
	{
		return dice;
	}

	/**
	 * @param dice the dice to set
	 */
	public void setDice(JComponent dice)
	{
		this.dice = dice;
	}
}
