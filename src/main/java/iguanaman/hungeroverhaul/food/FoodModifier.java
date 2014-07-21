package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.api.IDefaultFoodValueModifier;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FoodModifier implements IDefaultFoodValueModifier
{
    private static HashMap<ItemStack, FoodValues> modifiedFoodValues = new HashMap<ItemStack, FoodValues>();

    @Override
    public int getPriority()
    {
        // affect food values before most other modifiers
        return Integer.MIN_VALUE / 2;
    }

    @Override
    public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack)
    {
        FoodValues modifiedFoodValues = lookupModifiedFoodValues(itemStack);
        if (modifiedFoodValues != null)
            return modifiedFoodValues;
        else
        {
            int foodValue = Math.max(Math.round(foodValues.hunger / (float) IguanaConfig.modFoodValueDivider), 1);
            float saturationValue = Math.max(foodValue / 20F, 0F);
            return new FoodValues(foodValue, saturationValue);
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
