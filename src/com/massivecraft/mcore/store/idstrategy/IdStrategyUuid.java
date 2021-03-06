package com.massivecraft.mcore.store.idstrategy;

import java.util.UUID;

import com.massivecraft.mcore.store.CollInterface;

public class IdStrategyUuid extends IdStrategyAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static IdStrategyUuid i = new IdStrategyUuid();
	public static IdStrategyUuid get() { return i; }
	private IdStrategyUuid() { super("uuid"); }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public String generateAttempt(CollInterface<?> coll)
	{
		return UUID.randomUUID().toString();
	}
	
}
