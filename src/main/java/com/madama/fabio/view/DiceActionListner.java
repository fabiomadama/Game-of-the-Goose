package com.madama.fabio.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.madama.fabio.backend.Controller;
import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.bean.DiceActionBean;

public class DiceActionListner implements java.awt.event.ActionListener
{

	private static final Logger	logger = Logger.getLogger(DiceActionListner.class.getName());
	private Billboard			billboard;
	private MessageBoard		messageBoard;
	private JButton				dice;
	private JLabel				diceImg;
	private BufferedImage[]		facceDice;
	private int					lastRoll;
	private int					diceN;														 // identifico il Dice	
	private SessionScope		sessionScope;

	public DiceActionListner(DiceActionBean diceActionBean)
	{
		this.billboard = diceActionBean.getBillboard();
		this.messageBoard = diceActionBean.getMessageBoard();
		this.dice = diceActionBean.getDice();
		this.diceImg = diceActionBean.getDiceImg();
		this.facceDice = diceActionBean.getDiceFaces();
		this.diceN = diceActionBean.getDiceN();
		this.sessionScope = diceActionBean.getSessionScope();
	}

	public void actionPerformed(ActionEvent e)
	{
		// XXX semplice validazione del lancio dadi
		if (diceN == 1 && this.sessionScope.getDice_1() != 0 && this.sessionScope.getDice_2() == 0)
		{
			dice.setEnabled(true);
			return;
		}
		if (diceN == 2 && this.sessionScope.getDice_2() != 0 && this.sessionScope.getDice_1() == 0)
		{
			dice.setEnabled(true);
			return;
		}

		if (sessionScope.getDice_1() != 0 && this.sessionScope.getDice_2() != 0)
		{
			dice.setEnabled(true);
			return;
		}
		//new launch
		dice.setEnabled(false);

		Timer timer = new Timer(250, new ActionListener() {
			private int counter;

			public void actionPerformed(ActionEvent e)
			{
				if (counter < 10)
				{
					counter++;
					lastRoll = (int) (Math.random() * 6);
					diceImg.setIcon(new ImageIcon(facceDice[lastRoll]));
				}
				else
				{
					((Timer) e.getSource()).stop();
					dice.setEnabled(true);
					// aggiorno valore dadi
					if (diceN == 1)
					{
						sessionScope.setDice_1(lastRoll + 1);
						sessionScope.yesDiceLaunched1();
					}
					else
					{
						sessionScope.setDice_2(lastRoll + 1);
						sessionScope.yesDiceLaunched2();
					}
					check();
				}
			}// actionPerformed

		});// Timer
		timer.start();
	}

	private synchronized void check()
	{
		if (sessionScope.getDice_1() != 0 && this.sessionScope.getDice_2() != 0 && this.sessionScope.isDiceLaunched_1()
				&& this.sessionScope.isDiceLaunched_2())
		{
			logger.log(Level.INFO, "############## 1: " + this.sessionScope.getDice_1() + " 2: " + this.sessionScope.getDice_2());
			sessionScope.resetDiceLanched();
			Controller controller = new Controller();
			controller.check(this.billboard, this.messageBoard, this.sessionScope);
		}
	}
}
