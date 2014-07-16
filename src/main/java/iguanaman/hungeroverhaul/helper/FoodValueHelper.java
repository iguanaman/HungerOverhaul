package iguanaman.hungeroverhaul.helper;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

import iguanaman.hungeroverhaul.api.FoodValues;

public class FoodValueHelper {

    private static HashMap<ItemStack, FoodValues> modifiedFoodValues = Maps.newHashMap();

    public static void addModifiedFoodValues(Item item, FoodValues values) {
        modifiedFoodValues.put(new ItemStack(item), values);
    }

    public static void addModifiedFoodValues(ItemStack stack, FoodValues values) {
        modifiedFoodValues.put(stack, values);
    }

    public static FoodValues getModifiedFoodValues(ItemStack stack) {
        for(Map.Entry<ItemStack, FoodValues> entry : modifiedFoodValues.entrySet()) {
            if(stack.isItemEqual(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
