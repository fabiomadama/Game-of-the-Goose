/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend;

import java.util.ArrayList;

public class SessionScope
{

	private ArrayList<Player> players;
	private Integer			  round			 = 0;
	private Integer			  dice_1		 = 0;
	private Integer			  dice_2		 = 0;
	private boolean			  diceLaunched_1 = false;
	private boolean			  diceLaunched_2 = false;

	public ArrayList<Player> getPlayers()
	{
		return players;
	}

	public void setPlayers(ArrayList<Player> players)
	{
		this.players = players;
	}

	public Integer getRound()
	{
		return round;
	}

	public void setRound(Integer round)
	{
		this.round = round;
	}

	public Integer getDice_1()
	{
		return this.dice_1;
	}

	public void setDice_1(Integer dice_1)
	{
		this.dice_1 = dice_1;
	}

	public Integer getDice_2()
	{
		return this.dice_2;
	}

	public void setDice_2(Integer dice_2)
	{
		this.dice_2 = dice_2;
	}

	public void resetDice()
	{
		this.dice_1 = 0;
		this.dice_2 = 0;
	}

	public boolean isDiceLaunched_1()
	{
		return diceLaunched_1;
	}

	public void yesDiceLaunched1()
	{
		this.diceLaunched_1 = true;
	}

	public boolean isDiceLaunched_2()
	{
		return diceLaunched_2;
	}

	public void yesDiceLaunched2()
	{
		this.diceLaunched_2 = true;
	}	

	public void resetDiceLanched()
	{
		this.diceLaunched_1 = false;
		this.diceLaunched_2 = false;
	}
}
