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
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.madama.fabio.backend.Player;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.bean.ConfigureLayoutBean;

public class ViewOca extends JFrame
{
	private static final long serialVersionUID = 1L;

	public void initGameGui(SessionScope sessionScope)
	{
		// Frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(800, 600));

		ComponentGenerator componentGenerator = new ComponentGenerator();
		ConfigureLayoutBean configureLayoutBean = configureLayout(componentGenerator, sessionScope);
		mainFrame.add(configureLayoutBean.getTable());
		mainFrame.setJMenuBar(
				componentGenerator.retrieveMenuBar(sessionScope, configureLayoutBean.getBillboard(), configureLayoutBean.getMessageBoard()));
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);

	}

	/**
	 * Dispongo i component nel panel
	 */
	private ConfigureLayoutBean configureLayout(ComponentGenerator componentGenerator, SessionScope sessionScope)
	{
		JPanel table = componentGenerator.retrieveTable();
		Billboard billboard = componentGenerator.retrieveBillboard();
		MessageBoard messageBoard = componentGenerator.retrieveMessageBoard();
		JPanel dice = componentGenerator.retrieveDices(billboard, messageBoard, sessionScope);

		GroupLayout layout = new GroupLayout(table);
		table.setLayout(layout);
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

		ConfigureLayoutBean configureLayoutBean = new ConfigureLayoutBean();
		configureLayoutBean.setBillboard(billboard);
		configureLayoutBean.setMessageBoard(messageBoard);
		configureLayoutBean.setDice(dice);
		configureLayoutBean.setTable(table);

		return configureLayoutBean;
	}
	/* test methods */
//		public void redraw(ArrayList<Player> players)
//		{
//			this.billboard.setPlayers(players);
//			this.billboard.repaint();
//		}
//	
//		public void writeText(String text)
//		{
//			this.messageBoard.setText(text);
//			this.
//		}
//	
//		public void rollTheDice()
//		{
//			Component[] buttons = this.dice.getComponents();
//			((JButton) buttons[0]).doClick();
//			((JButton) buttons[1]).doClick();
//		}
//	
//		public Billboard getBillboard()
//		{
//			return billboard;
//		}
//	
//		public MessageBoard getMessageBoard()
//		{
//			return messageBoard;
//		}
}
