package com.madama.fabio.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.madama.fabio.backend.GooseUtils;
import com.madama.fabio.backend.SessionScope;

public class MenuItemListener implements ActionListener
{
	SessionScope sessionScope;

	public MenuItemListener(SessionScope sessionScope)
	{
		this.sessionScope = sessionScope;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		GooseUtils.initPlayers(sessionScope, Integer.valueOf(e.getActionCommand()));
	}
}
