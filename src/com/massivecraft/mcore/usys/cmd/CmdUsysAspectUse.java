package com.massivecraft.mcore.usys.cmd;

import com.massivecraft.mcore.Perm;
import com.massivecraft.mcore.cmd.MCommand;
import com.massivecraft.mcore.cmd.arg.ARAspect;
import com.massivecraft.mcore.cmd.arg.ARMultiverse;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.usys.Aspect;
import com.massivecraft.mcore.usys.Multiverse;

public class CmdUsysAspectUse extends MCommand
{
	public CmdUsysAspectUse()
	{
		this.addAliases("u", "use");
		this.addRequiredArg("aspect");
		this.addRequiredArg("multiverse");
		
		this.addRequirements(ReqHasPerm.get(Perm.CMD_USYS_ASPECT_USE.node));
	}
	
	@Override
	public void perform()
	{
		Aspect aspect = this.arg(0, ARAspect.get());
		if (aspect == null) return;
		
		Multiverse multiverse = this.arg(1, ARMultiverse.get());
		if (multiverse == null) return;
		
		aspect.setMultiverse(multiverse);
		
		msg("<g>The aspect <h>%s<g> now use multiverse <h>%s<g>.", aspect.getId(), multiverse.getId());
	}
}
