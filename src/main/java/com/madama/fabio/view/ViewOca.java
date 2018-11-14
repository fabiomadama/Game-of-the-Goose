/**
 * @author madama fabio
 *
 */
package com.madama.fabio.view;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;

public class ViewOca extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Billboard		  billboard		   = null;
	private MessageBoard	  messageBoard	   = null;
	private JComponent		  dice			   = null;

	public void initGameGui(SessionScope sessionScope)
	{
		// Frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(800, 600));

		ComponentGenerator componentGenerator = new ComponentGenerator();
		JPanel panel = configureLayout(componentGenerator, sessionScope);
		mainFrame.add(panel);
		mainFrame.setJMenuBar(componentGenerator.retrieveMenuBar(sessionScope, billboard));
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	/**
	 * Dispongo i component nel panel
	 */
	private JPanel configureLayout(ComponentGenerator componentGenerator, SessionScope sessionScope)
	{
		JPanel panel = componentGenerator.retrieveTable();
		this.billboard = componentGenerator.retrieveBillboard();
		this.messageBoard = componentGenerator.retrieveMessageBoard();
		this.dice = componentGenerator.retrieveDices(this.billboard, this.messageBoard, sessionScope);

		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup() //
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) //
						.addComponent(billboard)// billboard
						.addGroup(layout.createSequentialGroup() //
								.addComponent(messageBoard) // messageBoard, dice
								.addComponent(dice) //
		/*   */ ))// addGroup
		);//HorizontalGroup

		layout.setVerticalGroup(layout.createSequentialGroup() //
				.addComponent(billboard) // billboard
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE) //
						.addComponent(messageBoard) // messageBoard, dice
						.addComponent(dice) //
		/*    */)//addGroup
		);//VerticalGroup

		return panel;
	}

	/* test methods */
	public void redraw(ArrayList<Player> players)
	{
		this.billboard.setPlayers(players);
		this.billboard.repaint();
	}

	public void writeText(String text)
	{
		this.messageBoard.setText(text);
		this.messageBoard.repaint();
	}

	public void rollTheDice()
	{
		Component[] buttons = this.dice.getComponents();
		((JButton) buttons[0]).doClick();
		((JButton) buttons[1]).doClick();
	}

	public Billboard getBillboard()
	{
		return billboard;
	}

	public MessageBoard getMessageBoard()
	{
		return messageBoard;
	}

}
