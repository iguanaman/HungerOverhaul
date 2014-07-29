package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.IguanaConfig;
import squeek.applecore.api.food.FoodEvent;
import squeek.applecore.api.food.FoodValues;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FoodModifier
{
    private static HashMap<ItemStack, FoodValues> modifiedFoodValues = new HashMap<ItemStack, FoodValues>();

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void getModifiedFoodValues(FoodEvent.GetFoodValues event)
    {
        FoodValues modifiedFoodValues = lookupModifiedFoodValues(event.food);
        if (modifiedFoodValues != null)
            event.foodValues = modifiedFoodValues;
        else if (IguanaConfig.modFoodValueDivider != 1)
        {
            int foodValue = Math.max(Math.round(event.foodValues.hunger / (float) IguanaConfig.modFoodValueDivider), 1);
            float saturationValue = Math.max(foodValue / 20F, 0F);
            event.foodValues = new FoodValues(foodValue, saturationValue);
        }
    }

    public static void setModifiedFoodValues(Item item, FoodValues values)
    {
        modifiedFoodValues.put(new ItemStack(item), values);
    }

    public static void setModifiedFoodValues(ItemStack stack, FoodValues values)
    {
        modifiedFoodValues.put(stack, values);
    }

    private static FoodValues lookupModifiedFoodValues(ItemStack stack)
    {
        for (Map.Entry<ItemStack, FoodValues> entry : modifiedFoodValues.entrySet())
        {
            if (stack.isItemEqual(entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return null;
    }

}
