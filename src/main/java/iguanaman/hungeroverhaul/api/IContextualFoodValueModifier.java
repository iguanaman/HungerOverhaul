package iguanaman.hungeroverhaul.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public interface IContextualFoodValueModifier extends IFoodValueModifier
{
	/**
	 * ItemStack/player-aware food value modification
	 * 
	 * @param foodValues The current food values
	 * @param itemFood The ItemFood of the food
	 * @param itemStack The ItemStack of the food
	 * @param player The player that the food values will be applied to
	 * @return The modified food values
	 */
	public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemFood itemFood, ItemStack itemStack, EntityPlayer player);
}
