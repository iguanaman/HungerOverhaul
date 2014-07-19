package iguanaman.hungeroverhaul.core;

import java.util.Random;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodEvent;
import iguanaman.hungeroverhaul.api.FoodValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;

public class Hooks
{
	/**
	 * Hooks into ItemStack-aware FoodStats.addStats method
	 * @param foodStats The food stats being added to
	 * @param itemFood The item of food that is being eaten
	 * @param itemStack The ItemStack of the food that is being eaten
	 * @param player The player eating the food
	 * @return The modified food values or null if the default code should be executed
	 */
	public static FoodValues onFoodStatsAdded(FoodStats foodStats, ItemFood itemFood, ItemStack itemStack, EntityPlayer player)
	{
		return FoodValues.getPlayerSpecific(itemFood, itemStack, player);
	}

	public static void onPostFoodStatsAdded(FoodStats foodStats, ItemFood itemFood, ItemStack itemStack, FoodValues foodValues, int hungerAdded, float saturationAdded, EntityPlayer player)
	{
		MinecraftForge.EVENT_BUS.post(new FoodEvent.FoodEaten(player, itemFood, itemStack, foodValues, hungerAdded, saturationAdded));
	}

	public static int getModifiedFoodEatingSpeed(ItemFood itemFood, ItemStack itemStack)
	{
		return FoodValues.getModified(itemFood, itemStack).hunger * 8 + 8;
	}

	public static float getMaxExhaustion(EntityPlayer player)
	{
		EnumDifficulty difficulty = player.worldObj.difficultySetting;
		float hungerLossRate = 3f;
		if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingHunger)
		{
			if (difficulty == EnumDifficulty.PEACEFUL)
				hungerLossRate = 5F;
			else if (difficulty == EnumDifficulty.EASY)
				hungerLossRate = 4F;
		}

		return hungerLossRate / (IguanaConfig.hungerLossRatePercentage / 100F);
	}

	// unused; hook not implemented yet
	public static float getHealthRegenPeriod(EntityPlayer player)
	{
		float wellfedModifier = 1.0F;
		if (player.isPotionActive(HungerOverhaul.potionWellFed))
			wellfedModifier = 0.75F;

		EnumDifficulty difficulty = player.worldObj.difficultySetting;
		float difficultyModifierHealing = 1.0F;
		if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingHealing)
		{
			if (difficulty.getDifficultyId() <= EnumDifficulty.EASY.getDifficultyId())
				difficultyModifierHealing = 0.75F;
			else if (difficulty == EnumDifficulty.HARD)
				difficultyModifierHealing = 1.5F;
		}

		float lowHealthModifier = player.getMaxHealth() - player.getHealth();
		lowHealthModifier *= IguanaConfig.lowHealthRegenRateModifier / 100F;
		lowHealthModifier *= difficultyModifierHealing;
		lowHealthModifier = (float) Math.pow(lowHealthModifier + 1F, 1.5F);

		return 80.0F * difficultyModifierHealing * wellfedModifier * lowHealthModifier
				/ (IguanaConfig.healthRegenRatePercentage / 100F);
	}

    public static void updateTickHook(World world, int x, int y, int z, Random rand)
    {
        int sunlightModifier = world.isDaytime() && world.canBlockSeeTheSky(x, y, z) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0) return;

        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
        try {
            BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
            for (BiomeDictionary.Type biomeType : new BiomeDictionary.Type[]{BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS})
                if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
                    biomeModifier = 1;
                    break;
                }
        } catch (Exception var5) { biomeModifier = 1; }
        if (biomeModifier == 0) return;

        if (rand.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0) return;
    }
}
