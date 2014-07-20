package iguanaman.hungeroverhaul.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class IguanaCommandHunger extends CommandBase
{

    @Override
    public String getCommandName()
    {
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
    public void processCommand(ICommandSender icommandsender, String[] astring)
    {
        if (astring.length > 0)
        {
            EntityPlayerMP entityplayermp = astring.length >= 2 ? getPlayer(icommandsender, astring[0]) : getCommandSenderAsPlayer(icommandsender);
            int foodValue = astring.length >= 2 ? parseIntBounded(icommandsender, astring[1], 0, 20) : parseIntBounded(icommandsender, astring[0], 0, 20);
            entityplayermp.getFoodStats().setFoodLevel(foodValue);
            func_152374_a(icommandsender, this, 1, "Set " + entityplayermp.getDisplayName() + "'s hunger to " + foodValue);
        }
        else
        {
            throw new WrongUsageException("/hunger [player] <value>");
        }
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "/hunger [player] <value>";
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length == 1 ? getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer.getServer().getAllUsernames()) : null;
    }
}
