package iguanaman.hungeroverhaul.api;

import net.minecraft.item.ItemStack;

public interface IDefaultFoodValueModifier extends IFoodValueModifier
{
	/**
	 * ItemStack-aware food value modification
	 * 
	 * @param foodValues The current food values
	 * @param itemStack The ItemStack of the food
	 * @return The modified food values
	 */
	public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack);
}
