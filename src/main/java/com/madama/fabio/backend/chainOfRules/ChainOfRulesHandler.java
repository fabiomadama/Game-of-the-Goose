package com.madama.fabio.backend.chainOfRules;

import java.util.ArrayList;

import com.madama.fabio.Player;

public interface ChainOfRulesHandler {
	ArrayList<Player> nextChain(ArrayList<Player> players) throws Exception;

	ArrayList<Player> doExecute(ArrayList<Player> players) throws Exception;
}
