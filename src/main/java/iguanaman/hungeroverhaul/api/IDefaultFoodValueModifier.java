package iguanaman.hungeroverhaul.api;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public interface IDefaultFoodValueModifier extends IFoodValueModifier
{
	/**
	 * ItemStack-aware food value modification
	 * 
	 * @param foodValues The current food values
	 * @param itemFood The ItemFood of the food
	 * @param itemStack The ItemStack of the food
	 * @return The modified food values
	 */
	public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemFood itemFood, ItemStack itemStack);
}
