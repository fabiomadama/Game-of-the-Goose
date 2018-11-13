package com.madama.fabio.backend.chainOfRules;

import com.madama.fabio.backend.SessionScope;

public interface ChainOfRulesHandler
{
	SessionScope nextChain(SessionScope sessionScope) throws Exception;

	SessionScope doExecute(SessionScope sessionScope) throws Exception;
}
