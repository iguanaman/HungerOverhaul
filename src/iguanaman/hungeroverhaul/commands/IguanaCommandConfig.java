package iguanaman.hungeroverhaul.commands;

import iguanaman.hungeroverhaul.IguanaConfig;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class IguanaCommandConfig extends CommandBase {

	@Override
	public String getCommandName() {
		return "hungeroverhaul";
	}
	
    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		boolean worked = false;
		
		if (astring.length == 2)
		{
			String setting = astring[0];
			String value = astring[1];
			if (setting.equalsIgnoreCase("addFoodTooltips"))
			{
				IguanaConfig.addFoodTooltips = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addFoodRotting"))
			{
				IguanaConfig.addFoodRotting = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("modifyFoodEatingSpeed"))
			{
				IguanaConfig.modifyFoodEatingSpeed = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("cropsNeedSunlight"))
			{
				IguanaConfig.cropsNeedSunlight = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addGuiText"))
			{
				IguanaConfig.addGuiText = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("modifyHoeUse"))
			{
				IguanaConfig.modifyHoeUse = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingBoneMeal"))
			{
				IguanaConfig.difficultyScalingBoneMeal = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addSleepHungerLoss"))
			{
				IguanaConfig.addSleepHungerLoss = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingSleepHungerLoss"))
			{
				IguanaConfig.difficultyScalingSleepHungerLoss = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("hoeToolDamageMultiplier") && isInteger(value))
			{
				IguanaConfig.hoeToolDamageMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("wrongBiomeRegrowthMultiplier") && isInteger(value))
			{
				IguanaConfig.wrongBiomeRegrowthMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("cropRegrowthMultiplier") && isInteger(value))
			{
				IguanaConfig.cropRegrowthMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("treeCropRegrowthMultiplier") && isInteger(value))
			{
				IguanaConfig.treeCropRegrowthMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("seedsPerHarvestMin") && isInteger(value))
			{
				IguanaConfig.seedsPerHarvestMin = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("seedsPerHarvestMax") && isInteger(value))
			{
				IguanaConfig.seedsPerHarvestMax = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("producePerHarvestMin") && isInteger(value))
			{
				IguanaConfig.producePerHarvestMin = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("producePerHarvestMax") && isInteger(value))
			{
				IguanaConfig.producePerHarvestMax = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("modFoodValueDivider") && isInteger(value))
			{
				IguanaConfig.modFoodValueDivider = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("seedChance") && isInteger(value))
			{
				IguanaConfig.seedChance = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("seedChanceDifficultyModifier") && isInteger(value))
			{
				IguanaConfig.seedChanceDifficultyModifier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("eggTimeoutMultiplier") && isInteger(value))
			{
				IguanaConfig.eggTimeoutMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("breedingTimeoutMultiplier") && isInteger(value))
			{
				IguanaConfig.breedingTimeoutMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("childDurationMultiplier") && isInteger(value))
			{
				IguanaConfig.childDurationMultiplier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("foodRotSpeed") && isInteger(value))
			{
				IguanaConfig.foodRotSpeed = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScaling"))
			{
				IguanaConfig.difficultyScaling = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingEffects"))
			{
				IguanaConfig.difficultyScalingEffects = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingHealing"))
			{
				IguanaConfig.difficultyScalingHealing = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingHunger"))
			{
				IguanaConfig.difficultyScalingHunger = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("difficultyScalingRespawnHunger"))
			{
				IguanaConfig.difficultyScalingRespawnHunger = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("constantHungerLoss"))
			{
				IguanaConfig.constantHungerLoss = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addLowStatEffects"))
			{
				IguanaConfig.addLowStatEffects = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addLowStatNausea"))
			{
				IguanaConfig.addLowStatNausea = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addLowStatSlowness"))
			{
				IguanaConfig.addLowStatSlowness = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addLowStatWeakness"))
			{
				IguanaConfig.addLowStatWeakness = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("addLowStatMiningSlowdown"))
			{
				IguanaConfig.addLowStatMiningSlowdown = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("foodRegensHealth"))
			{
				IguanaConfig.foodRegensHealth = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("disableHunger"))
			{
				IguanaConfig.disableHunger = Boolean.parseBoolean(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("damageOnStarve") && isInteger(value))
			{
				IguanaConfig.damageOnStarve = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("minHungerToHeal") && isInteger(value))
			{
				IguanaConfig.minHungerToHeal = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("respawnHungerValue") && isInteger(value))
			{
				IguanaConfig.respawnHungerValue = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("respawnHungerDifficultyModifier") && isInteger(value))
			{
				IguanaConfig.respawnHungerDifficultyModifier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("hungerLossRatePercentage") && isInteger(value))
			{
				IguanaConfig.hungerLossRatePercentage = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("healthRegenRatePercentage") && isInteger(value))
			{
				IguanaConfig.healthRegenRatePercentage = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("lowHealthRegenRateModifier") && isInteger(value))
			{
				IguanaConfig.lowHealthRegenRateModifier = Integer.parseInt(value);
				worked = true;
			}
			else if (setting.equalsIgnoreCase("foodHealDivider") && isInteger(value))
			{
				IguanaConfig.foodHealDivider = Integer.parseInt(value);
				worked = true;
			}
			
			if (worked) notifyAdmins(icommandsender, 0, "Set '" + setting + "' to '" + value + "'", new Object[0]);
		}

		if (!worked) throw new WrongUsageException("/" + getCommandName() + " <settingname> <value>", new Object[0]);			
	}


    /**
     * Parses an int from the given sring with a specified minimum.
     */
    public static int parseIntWithMinMax(ICommandSender par0ICommandSender, String par1Str, int min, int max)
    {
        return parseIntBounded(par0ICommandSender, par1Str, min, max);
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/" + getCommandName() + " <settingname> <value>";
	}

}
