/**
 * @author madama fabio
 *
 */
package com.madama.fabio;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.ViewOca;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args)
	{
		App.initLog();
		ViewOca oca = new ViewOca();
		SessionScope sessionScope = new SessionScope();
		oca.initGameGui(sessionScope);
	}

	private static void initLog()
	{
		Logger log = Logger.getLogger("App");
		log.setLevel(Level.ALL);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		log.addHandler(handler);
	}
}
