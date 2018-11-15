/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import com.madama.fabio.bean.ChainOfRulesBean;

public interface ChainOfRulesHandler
{
	ChainOfRulesBean nextChain(ChainOfRulesBean chainOfRulesBean) throws Exception;

	ChainOfRulesBean doExecute(ChainOfRulesBean chainOfRulesBean) throws Exception;
}
