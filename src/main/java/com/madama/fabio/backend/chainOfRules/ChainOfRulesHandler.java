/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import com.madama.fabio.backend.SessionScope;
import com.madama.fabio.view.MessageBoard;

public interface ChainOfRulesHandler
{
	SessionScope nextChain(SessionScope sessionScope, MessageBoard messageBoard) throws Exception;

	SessionScope doExecute(SessionScope sessionScope, MessageBoard messageBoard) throws Exception;
}
