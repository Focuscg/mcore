package com.massivecraft.mcore.usys.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.mcore.Perm;
import com.massivecraft.mcore.cmd.MCommand;
import com.massivecraft.mcore.cmd.arg.ARInteger;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.usys.Multiverse;
import com.massivecraft.mcore.usys.MultiverseColl;
import com.massivecraft.mcore.util.Txt;

public class CmdUsysMultiverseList extends MCommand
{
	public CmdUsysMultiverseList()
	{
		this.addAliases("l", "list");
		this.addOptionalArg("page", "1");
		
		this.addRequirements(ReqHasPerm.get(Perm.CMD_USYS_MULTIVERSE_LIST.node));
	}
	
	@Override
	public void perform()
	{
		Integer pageHumanBased = this.arg(0, ARInteger.get(), 1);
		if (pageHumanBased == null) return;
		
		// Create Messages
		List<String> lines = new ArrayList<String>();
		
		for (Multiverse multiverse : MultiverseColl.get().getAll())
		{
			lines.add("<h>"+multiverse.getId()+" <i>has "+Txt.implodeCommaAndDot(multiverse.getUniverses(), "<aqua>%s", "<i>, ", " <i>and ", "<i>."));
		}
				
		// Send them
		lines = Txt.parseWrap(lines);
		this.sendMessage(Txt.getPage(lines, pageHumanBased, "Multiverse List", sender));
	}
}
