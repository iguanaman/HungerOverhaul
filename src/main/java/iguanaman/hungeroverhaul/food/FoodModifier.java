package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.api.IDefaultFoodValueModifier;
import iguanaman.hungeroverhaul.helper.FoodValueHelper;

import net.minecraft.item.ItemStack;

public class FoodModifier implements IDefaultFoodValueModifier
{

	@Override
	public int getPriority()
	{
		// affect food values before most other modifiers
		return Integer.MIN_VALUE/2;
	}

	@Override
	public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack)
	{
        return FoodValueHelper.getModifiedFoodValues(itemStack);
	}

}
