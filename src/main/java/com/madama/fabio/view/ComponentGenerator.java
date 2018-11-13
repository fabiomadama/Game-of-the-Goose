/**
 * @author madama fabio
 *
 */
package com.madama.fabio.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.bean.DiceActionBean;

public class ComponentGenerator
{
	public JPanel retrieveTable()
	{
		// Panel
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 600));
		panel.setBackground(Color.BLACK);
		return panel;
	}

	public JMenuBar retrieveMenuBar(SessionScope sessionScope)
	{
		JMenuBar menuBar = new JMenuBar();
		menuBar.setDoubleBuffered(true);
		Dimension dimension = new Dimension(100, 30);
		menuBar.setMaximumSize(dimension);
		menuBar.setMinimumSize(dimension);
		menuBar.setName("menuBar");

		JMenu fileMenu = new JMenu("File");
		Dimension dimensionMenu = new Dimension(50, 21);
		menuBar.setDoubleBuffered(true);
		menuBar.setMaximumSize(dimensionMenu);
		menuBar.setMinimumSize(dimensionMenu);

		MenuItemListener menuItemListener = new MenuItemListener(sessionScope);

		JMenuItem menuItemPlayers2 = new JMenuItem("2 players ");
		menuItemPlayers2.setActionCommand("2");
		menuItemPlayers2.addActionListener(menuItemListener);
		fileMenu.add(menuItemPlayers2);

		JMenuItem menuItemPlayers3 = new JMenuItem("3 players ");
		menuItemPlayers3.setActionCommand("3");
		menuItemPlayers3.addActionListener(menuItemListener);
		fileMenu.add(menuItemPlayers3);

		JMenuItem menuItemPlayers4 = new JMenuItem("4 players ");
		menuItemPlayers4.setActionCommand("4");
		menuItemPlayers4.addActionListener(menuItemListener);
		fileMenu.add(menuItemPlayers4);

		menuBar.add(fileMenu);

		JMenu helpMenu = new JMenu();
		Dimension dimensionHelp = new Dimension(50, 21);
		menuBar.setMaximumSize(dimensionHelp);
		menuBar.setMinimumSize(dimensionHelp);
		helpMenu.setText("Help");
		helpMenu.setName("helpMenu");
		menuBar.add(helpMenu);

		return menuBar;
	}

	public Billboard retrieveBillboard()
	{
		// Panel
		//JPanel panel = new JPanel();
		Billboard panel = new Billboard();
		Dimension dimension = new Dimension(760, 450);
		panel.setMaximumSize(dimension);
		panel.setMinimumSize(dimension);
		panel.setBackground(Color.YELLOW);
		return panel;
	}

	public MessageBoard retrieveMessageBoard()
	{
		// Panel
		MessageBoard panel = new MessageBoard();
		Dimension dimension = new Dimension(600, 70);
		panel.setMaximumSize(dimension);
		panel.setMinimumSize(dimension);
		panel.setBackground(Color.GRAY);
		return panel;
	}

	public JPanel retrieveDices(Billboard billboard, MessageBoard messageBoard, SessionScope sessionScope)
	{
		// Panel
		JPanel panel = new JPanel();
		Dimension dimension = new Dimension(154, 70);
		panel.setMaximumSize(dimension);
		panel.setMinimumSize(dimension);
		panel.setBackground(Color.WHITE);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(retriveDice(1, billboard, messageBoard, sessionScope));
		panel.add(retriveDice(2, billboard, messageBoard, sessionScope));

		return panel;
	}

	public JButton retriveDice(int dadoN, Billboard billboard, MessageBoard messageBoard, SessionScope sessionScope)
	{
		// DADO
		JButton dice = new JButton();
		Dimension dimension = new Dimension(70, 70);
		dice.setMaximumSize(dimension);
		dice.setMinimumSize(dimension);
		BufferedImage[] diceFaces = new BufferedImage[6];

		try
		{
			BufferedImage img = ImageIO.read(new File("./image/dado.png"));
			int width = 290 / 6;
			for (int index = 0; index < 6; index++)
			{
				diceFaces[index] = img.getSubimage(width * index, 0, 50, 40);
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		JLabel diceImg = new JLabel(new ImageIcon(diceFaces[0]));
		dice.add(diceImg);

		DiceActionBean diceActionBean = new DiceActionBean();
		diceActionBean.setDice(dice);
		diceActionBean.setDiceN(dadoN);
		diceActionBean.setDiceImg(diceImg);
		diceActionBean.setDiceFaces(diceFaces);
		diceActionBean.setBillboard(billboard);
		diceActionBean.setMessageBoard(messageBoard);
		diceActionBean.setSessionScope(sessionScope);

		dice.addActionListener(new DiceActionListner(diceActionBean));
		return dice;
	}
}
