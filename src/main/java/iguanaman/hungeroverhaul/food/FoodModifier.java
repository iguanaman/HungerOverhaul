package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.config.IguanaConfig;
import iguanaman.hungeroverhaul.util.ItemAndBlockList;
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
    public static ItemAndBlockList blacklist = new ItemAndBlockList();

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void getModifiedFoodValues(FoodEvent.GetFoodValues event)
    {
        if (!IguanaConfig.modifyFoodValues)
            return;

        if (blacklist.contains(event.food))
            return;

        FoodValues modifiedFoodValues = lookupModifiedFoodValues(event.food);
        if (modifiedFoodValues != null)
            event.foodValues = modifiedFoodValues;
        else
        {
            int hunger = Math.max(Math.round(event.foodValues.hunger / IguanaConfig.foodHungerDivider), 1);
            float saturation = event.foodValues.saturationModifier;
            if (IguanaConfig.foodHungerToSaturationDivider != 0)
            {
                saturation = hunger / (float) IguanaConfig.foodHungerToSaturationDivider;
            }
            saturation /= IguanaConfig.foodSaturationDivider;
            event.foodValues = new FoodValues(hunger, saturation);
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
