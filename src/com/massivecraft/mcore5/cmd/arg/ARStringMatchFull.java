package com.massivecraft.mcore5.cmd.arg;

import java.util.Collection;

public class ARStringMatchFull extends ARAbstractStringMatch
{
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //
	
	@Override
	public Integer matches(String arg, String alt)
	{
		return alt.equalsIgnoreCase(arg) ? 0 : null;
	}

	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ARStringMatchFull(String typename, Collection<Collection<String>> altColls)
	{
		super(typename, altColls);
	}
}