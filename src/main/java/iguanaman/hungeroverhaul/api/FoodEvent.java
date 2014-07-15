package iguanaman.hungeroverhaul.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.Event;

public class FoodEvent extends Event
{
	public final EntityPlayer player;

	public FoodEvent(EntityPlayer player)
	{
		this.player = player;
	}

	public static class FoodEaten extends FoodEvent
	{
		public final FoodValues foodValues;
		public final int hungerAdded;
		public final float saturationAdded;
		public final ItemFood itemFood;
		public final ItemStack itemStack;

		public FoodEaten(EntityPlayer player, ItemFood itemFood, ItemStack itemStack, FoodValues foodValues, int hungerAdded, float saturationAdded)
		{
			super(player);
			this.itemFood = itemFood;
			this.itemStack = itemStack;
			this.foodValues = foodValues;
			this.hungerAdded = hungerAdded;
			this.saturationAdded = saturationAdded;
		}
	}
}
