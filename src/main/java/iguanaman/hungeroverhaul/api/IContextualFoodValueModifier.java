package iguanaman.hungeroverhaul.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IContextualFoodValueModifier extends IFoodValueModifier
{
    /**
     * ItemStack/player-aware food value modification
     * 
     * @param foodValues The current food values
     * @param itemStack The ItemStack of the food
     * @param player The player that the food values will be applied to
     * @return The modified food values
     */
    public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack, EntityPlayer player);
}
