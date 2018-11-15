package com.madama.fabio.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.SessionScope;

public class MenuItemListener implements ActionListener
{
	private SessionScope sessionScope;
	private Billboard	 billboard;
	private MessageBoard messageBoard;

	public MenuItemListener(SessionScope sessionScope, Billboard billboard, MessageBoard messageBoard)
	{
		this.sessionScope = sessionScope;
		this.billboard = billboard;
		this.messageBoard = messageBoard;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GooseUtils.initPlayersAndGame(sessionScope, Integer.valueOf(e.getActionCommand()));
		this.messageBoard.setText("Start game !");
		GooseUtils.moveGui(billboard, sessionScope.getPlayers());

	}
}
