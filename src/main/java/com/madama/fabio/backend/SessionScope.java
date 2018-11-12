package com.madama.fabio.backend;

import java.util.ArrayList;

public class SessionScope {

	private static ArrayList<Player> players;
	private static Integer round = 0;
	private static Integer dice_1 = 0;
	private static Integer dice_2 = 0;
	private static boolean diceLaunched_1 = false;
	private static boolean diceLaunched_2 = false;

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(ArrayList<Player> players) {
		SessionScope.players = players;
	}

	public static Integer getRound() {
		return round;
	}

	public static void setRound(Integer round) {
		SessionScope.round = round;
	}

	public static Integer getDice_1() {
		return SessionScope.dice_1;
	}

	public static void setDice_1(Integer dice_1) {
		SessionScope.dice_1 = dice_1;
	}

	public static Integer getDice_2() {
		return SessionScope.dice_2;
	}

	public static void setDice_2(Integer dice_2) {
		SessionScope.dice_2 = dice_2;
	}

	public static void resetDice() {
		SessionScope.dice_1 = 0;
		SessionScope.dice_2 = 0;
	}
	
	/* --synchronized method */
	public static boolean isDiceLaunched_1() {
		return diceLaunched_1;
	}
	public static void yesDiceLaunched1() {
		SessionScope.diceLaunched_1 = true;
	}
	public static boolean isDiceLaunched_2() {
		return diceLaunched_2;
	}
	public static void yesDiceLaunched2() {
		SessionScope.diceLaunched_2 = true;
	}
	public static void resetDiceLanched() {
		SessionScope.diceLaunched_1 = false;
		SessionScope.diceLaunched_2 = false;
	}
}
