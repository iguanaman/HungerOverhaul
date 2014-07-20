package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.IguanaConfig;
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
        return Integer.MIN_VALUE / 2;
    }

    @Override
    public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack)
    {
        FoodValues modifiedFoodValues = FoodValueHelper.getModifiedFoodValues(itemStack);
        if (modifiedFoodValues != null)
            return modifiedFoodValues;
        else
        {
            int foodValue = Math.max(Math.round(foodValues.hunger / (float) IguanaConfig.modFoodValueDivider), 1);
            float saturationValue = Math.max(foodValue / 20F, 0F);
            return new FoodValues(foodValue, saturationValue);
        }
    }

}
