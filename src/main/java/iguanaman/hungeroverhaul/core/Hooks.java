package iguanaman.hungeroverhaul.core;

import iguanaman.hungeroverhaul.util.FoodValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;

public class Hooks
{
	/**
	 * Hooks into ItemStack-aware FoodStats.addStats method
	 * @param foodStats The food stats being added to
	 * @param itemFood The food that is being eaten
	 * @param itemStack The ItemStack of the food that is being eaten
	 * @param foodValues The food values to be modified
	 * @param player The player eating the food
	 * @return false if the default values should be used; true if the modified food values should be used
	 */
	public static boolean modifyFoodValues(FoodStats foodStats, ItemFood itemFood, ItemStack itemStack, FoodValues foodValues, EntityPlayer player)
	{
		System.out.println(player.getDisplayName() + " ate " + itemStack.getDisplayName());
		foodValues.hunger = 0;
		return true;
	}
}
