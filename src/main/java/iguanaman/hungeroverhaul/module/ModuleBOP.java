package iguanaman.hungeroverhaul.module;

import net.minecraft.item.ItemStack;

import biomesoplenty.api.content.BOPCItems;
import iguanaman.hungeroverhaul.food.FoodModifier;
import squeek.applecore.api.food.FoodValues;

public class ModuleBOP
{
    public static void init()
    {
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 0), new FoodValues(1, 0.05F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 1), new FoodValues(1, 0.05F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 2), new FoodValues(1, 0.05F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 4), new FoodValues(3, 0.15F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 5), new FoodValues(3, 0.15F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 6), new FoodValues(3, 0.15F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 8), new FoodValues(1, 0.05F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 9), new FoodValues(1, 0.05F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 10), new FoodValues(3, 0.2F));
        FoodModifier.setModifiedFoodValues(new ItemStack(BOPCItems.food, 1, 11), new FoodValues(1, 0.05F));
    }
}
