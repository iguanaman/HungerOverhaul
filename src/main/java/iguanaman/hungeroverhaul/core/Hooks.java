package iguanaman.hungeroverhaul.core;

import iguanaman.hungeroverhaul.api.FoodEvent;
import iguanaman.hungeroverhaul.api.FoodValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;
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
}
