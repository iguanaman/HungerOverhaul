package iguanaman.hungeroverhaul.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class FoodValues
{
	public final int hunger;
	public final float saturationModifier;

	public FoodValues(int hunger, float saturationModifier)
	{
		this.hunger = hunger;
		this.saturationModifier = saturationModifier;
	}

	public FoodValues(FoodValues other)
	{
		this(other.hunger, other.saturationModifier);
	}

	public float getSaturationIncrement()
	{
		return Math.min(20, hunger * saturationModifier * 2f);
	}

	/**
	 * Get the unmodified food values of a food item
	 */
	public static FoodValues getUnmodified(ItemStack itemStack)
	{
		if (itemStack.getItem() instanceof ItemFood)
			return FoodValues.getUnmodified((ItemFood) itemStack.getItem(), itemStack);
		else
			return null;
	}

	public static FoodValues getUnmodified(ItemFood itemFood, ItemStack itemStack)
	{
		return new FoodValues(itemFood.func_150905_g(itemStack), itemFood.func_150906_h(itemStack));
	}

	/**
	 * Get the default food values of a food item
	 */
	public static FoodValues getModified(ItemStack itemStack)
	{
		if (itemStack.getItem() instanceof ItemFood)
			return FoodValues.getModified((ItemFood)itemStack.getItem(), itemStack);
		else
			return null;
	}

	public static FoodValues getModified(ItemFood itemFood, ItemStack itemStack)
	{
		return FoodValues.getUnmodified(itemFood, itemStack).applyDefaultModifiers(itemFood, itemStack);
	}

	/**
	 * Get the actual food values of a food item for a given player
	 */
	public static FoodValues getPlayerSpecific(ItemStack itemStack, EntityPlayer player)
	{
		if (itemStack.getItem() instanceof ItemFood)
			return FoodValues.getPlayerSpecific((ItemFood)itemStack.getItem(), itemStack, player);
		else
			return null;
	}

	public static FoodValues getPlayerSpecific(ItemFood itemFood, ItemStack itemStack, EntityPlayer player)
	{
		return FoodValues.getModified(itemFood, itemStack).applyContextualModifiers(itemFood, itemStack, player);
	}

	FoodValues applyDefaultModifiers(ItemFood itemFood, ItemStack itemStack)
	{
		FoodValues newDefaultFoodValues = this;
		for (IDefaultFoodValueModifier modifier : FoodModifierRegistry.getDefaultFoodModifiers())
		{
			FoodValues modifiedFoodValues = modifier.getModifiedFoodValues(newDefaultFoodValues, itemStack);
			if (modifiedFoodValues != null)
				newDefaultFoodValues = modifiedFoodValues;
		}
		return newDefaultFoodValues;
	}

	FoodValues applyContextualModifiers(ItemFood itemFood, ItemStack itemStack, EntityPlayer player)
	{
		FoodValues actualFoodValues = this;
		for (IContextualFoodValueModifier modifier : FoodModifierRegistry.getContextualFoodModifiers())
		{
			FoodValues modifiedFoodValues = modifier.getModifiedFoodValues(actualFoodValues, itemStack, player);
			if (modifiedFoodValues != null)
				actualFoodValues = modifiedFoodValues;
		}
		return actualFoodValues;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + hunger;
		result = prime * result + Float.floatToIntBits(saturationModifier);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodValues other = (FoodValues) obj;
		if (hunger != other.hunger)
			return false;
		if (Float.floatToIntBits(saturationModifier) != Float.floatToIntBits(other.saturationModifier))
			return false;
		return true;
	}

}
