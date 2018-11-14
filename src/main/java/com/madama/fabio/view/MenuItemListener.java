package com.madama.fabio.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.SessionScope;

public class MenuItemListener implements ActionListener
{
	SessionScope sessionScope;
	Billboard	 billboard;

	public MenuItemListener(SessionScope sessionScope, Billboard billboard)
	{
		this.sessionScope = sessionScope;
		this.billboard = billboard;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GooseUtils.initPlayersAndGame(sessionScope, Integer.valueOf(e.getActionCommand()));
		GooseUtils.moveGui(billboard, sessionScope.getPlayers());
	}
}
