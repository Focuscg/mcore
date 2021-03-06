package com.massivecraft.mcore.store;

import java.util.HashMap;
import java.util.Map;

import com.massivecraft.mcore.store.idstrategy.IdStrategy;

public abstract class DriverAbstract<R> implements Driver<R>
{
	public DriverAbstract(String name)
	{
		this.name = name;
	}
	
	protected String name;
	@Override public String getName() { return this.name; }

	protected Map<String, IdStrategy> idStrategies = new HashMap<String, IdStrategy>();
	@Override
	public boolean registerIdStrategy(IdStrategy idStrategy)
	{
		if (idStrategies.containsKey(idStrategy.getName())) return false;
		idStrategies.put(idStrategy.getName(), idStrategy);
		return true;
	}
	
	@Override
	public IdStrategy getIdStrategy(String idStrategyName)
	{
		return idStrategies.get(idStrategyName);
	}
}
