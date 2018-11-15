package com.madama.fabio.bean;

import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.MessageBoard;

public class ChainOfRulesBean {
	SessionScope sessionScope;
	MessageBoard messageBoard;

	public SessionScope getSessionScope() {
		return sessionScope;
	}

	public void setSessionScope(SessionScope sessionScope) {
		this.sessionScope = sessionScope;
	}

	public MessageBoard getMessageBoard() {
		return messageBoard;
	}

	public void setMessageBoard(MessageBoard messageBoard) {
		this.messageBoard = messageBoard;
	}

}
