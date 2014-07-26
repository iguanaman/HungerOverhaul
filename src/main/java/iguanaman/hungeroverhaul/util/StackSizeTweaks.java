package iguanaman.hungeroverhaul.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import iguanaman.hungeroverhaul.IguanaConfig;
import squeek.applecore.api.food.FoodValues;

public class StackSizeTweaks
{

    public static void init()
    {
        for (Object obj : Item.itemRegistry)
        {
            Item item = (Item) obj;
            if (item instanceof ItemFood)
            {
                ItemStack stack = new ItemStack(item);
                FoodValues values = FoodValues.get(stack);
                if (values.hunger <= 2)
                    item.setMaxStackSize(16 * IguanaConfig.foodStackSizeMultiplier);
                else if (values.hunger <= 5)
                    item.setMaxStackSize(8 * IguanaConfig.foodStackSizeMultiplier);
                else if (values.hunger <= 8)
                    item.setMaxStackSize(4 * IguanaConfig.foodStackSizeMultiplier);
                else if (values.hunger <= 11)
                    item.setMaxStackSize(2 * IguanaConfig.foodStackSizeMultiplier);
                else
                    item.setMaxStackSize(IguanaConfig.foodStackSizeMultiplier);
            }
        }
    }
}
