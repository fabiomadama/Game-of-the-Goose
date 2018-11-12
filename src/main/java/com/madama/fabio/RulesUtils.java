package com.madama.fabio;

import java.util.ArrayList;

public class RulesUtils {

	public static int whosnext(ArrayList<Player> players) {
		int index = 0;
		if (SessionScope.getRound() != 0) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getRound() < SessionScope.getRound()) {
					index = i;
				}
			} // for
		} // if
		return index;
	}// whosnext
}
