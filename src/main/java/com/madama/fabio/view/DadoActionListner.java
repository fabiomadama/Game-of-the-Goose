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

import com.madama.fabio.Controller;
import com.madama.fabio.SessionScope;

public class DadoActionListner implements java.awt.event.ActionListener {

	private static final Logger logger = Logger.getLogger(DadoActionListner.class.getName());
	private Billboard billboard;
	private MessageBoard messageBoard;
	private JButton dado;
	private JLabel tira;
	private BufferedImage[] facceDado;
	private int lastRoll;
	private int dadoN; // identifico il dado	

	public DadoActionListner(JButton dado, JLabel tira, BufferedImage[] facceDado, int dadoN, Billboard billboard, MessageBoard messageBoard) {
		this.billboard = billboard;
		this.messageBoard = messageBoard;
		this.dado = dado;
		this.tira = tira;
		this.facceDado = facceDado;
		this.dadoN = dadoN;
	}

	public void actionPerformed(ActionEvent e) {

		// XXX semplice validazione del lancio dadi
		if (dadoN == 1 && SessionScope.getDice_1() != 0 && SessionScope.getDice_2() == 0) {
			dado.setEnabled(true);
			return;
		}
		if (dadoN == 2 && SessionScope.getDice_2() != 0 && SessionScope.getDice_1() == 0) {
			dado.setEnabled(true);
			return;
		}

		if (SessionScope.getDice_1() != 0 && SessionScope.getDice_2() != 0) {
			dado.setEnabled(true);
			return;
		}
		//new launch
		dado.setEnabled(false);		
		
		Timer timer = new Timer(250, new ActionListener() {
			private int counter;

			public void actionPerformed(ActionEvent e) {
				if (counter < 10) {
					counter++;
					lastRoll = (int) (Math.random() * 6);
					tira.setIcon(new ImageIcon(facceDado[lastRoll]));
				} else {
					((Timer) e.getSource()).stop();
					dado.setEnabled(true);
					// aggiorno valore dadi
					if (dadoN == 1) {
						SessionScope.setDice_1(lastRoll + 1);
						SessionScope.yesDiceLaunched1();
					} else {
						SessionScope.setDice_2(lastRoll + 1);
						SessionScope.yesDiceLaunched2();
					}
					check();
				}
			}// actionPerformed

		});// Timer

		timer.start();
	}

	private synchronized void check() {
		if (SessionScope.getDice_1() != 0 && SessionScope.getDice_2() != 0 && SessionScope.isDiceLaunched_1() && SessionScope.isDiceLaunched_2()) {
			logger.log(Level.INFO, "############## 1: "+SessionScope.getDice_1()+" 2: "+SessionScope.getDice_2());				
			SessionScope.resetDiceLanched();
			Controller controller = new Controller();
			controller.check(this.billboard, this.messageBoard);
		}
	}
}
