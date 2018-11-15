/**
 * @author madama fabio
 *
 */
package com.madama.fabio.backend.chainOfRules;

import com.madama.fabio.bean.ChainOfRulesBean;

public class ChainOfRulesClient
{

	//ascending order
	private End			  end			= new End(null);
	private Bone		  bone			= new Bone(end);
	private Labyrinth	  labyrinth		= new Labyrinth(bone);
	private Hotel		  inn			= new Hotel(labyrinth);
	private Prison		  prison		= new Prison(inn);
	private Goose		  goose			= new Goose(prison);
	private GenericSpaces genericSpaces	= new GenericSpaces(goose);

	public ChainOfRulesBean start(ChainOfRulesBean chainOfRulesBean) throws Exception
	{
		return genericSpaces.doExecute(chainOfRulesBean);
	}

}
