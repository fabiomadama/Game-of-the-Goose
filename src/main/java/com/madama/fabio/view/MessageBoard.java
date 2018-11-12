package com.madama.fabio.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author fabio
 * 
 *         Panel for status messages is extension of JPanel class for allow to
 *         modify the content at runtime
 */
public class MessageBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel labelText = new JLabel();

	public MessageBoard() {
		super();
		add(labelText);
	}

	public void setText(String text) {
		this.labelText.setText(text);
	}
}
