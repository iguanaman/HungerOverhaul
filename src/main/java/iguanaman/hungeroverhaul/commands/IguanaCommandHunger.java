package iguanaman.hungeroverhaul.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;

public class IguanaCommandHunger extends CommandBase {

	@Override
	public String getCommandName() {
		return "hunger";
	}

	/**
	 * Return the required permission level for this command.
	 */
	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (astring.length > 0)
		{
			EntityPlayerMP entityplayermp = astring.length >= 2 ? getPlayer(icommandsender, astring[0]) : getCommandSenderAsPlayer(icommandsender);
			int foodValue = astring.length >= 2 ? parseIntWithMinMax(icommandsender, astring[1], 0, 20) : parseIntWithMinMax(icommandsender, astring[0], 0, 20);
			entityplayermp.foodStats.setFoodLevel(foodValue);
			notifyAdmins(icommandsender, 1, "Set " + entityplayermp.getEntityName() + "'s hunger to " + foodValue, new Object[0]);
		} else
			throw new WrongUsageException("hunger [player] <value>", new Object[0]);

	}


	/**
	 * Parses an int from the given sring with a specified minimum.
	 */
	public static int parseIntWithMinMax(ICommandSender par0ICommandSender, String par1Str, int min, int max)
	{
		return parseIntBounded(par0ICommandSender, par1Str, min, max);
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return null;
	}

}
