package com.madama.fabio.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.madama.fabio.backend.Player;

/**
 * 
 * @author fabio
 *
 * * 
 *         Panel for billboard is extension of JPanel class for allow to
 *         modify the content at runtime
 */
public class Billboard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> players = new ArrayList<Player>(0);
    
	@Override
    protected void paintComponent(Graphics g) {        
		super.paintComponent(g);
		try
		{
			BufferedImage bgImage = ImageIO.read(new File("./image/billboard.png"));
			g.drawImage(bgImage, 0, 0, null);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		for(Player player : players){
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(player.getColor());
	        g2.fillOval(player.getX(), player.getY(), 20, 20);
        }        
    }

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
}
