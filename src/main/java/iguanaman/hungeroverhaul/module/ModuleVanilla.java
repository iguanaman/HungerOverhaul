package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.food.FoodModifier;
import net.minecraft.init.Items;
import cpw.mods.fml.common.Loader;

public class ModuleVanilla
{
    public static void init()
    {
        if (Loader.isModLoaded("harvestcraft") || IguanaConfig.modifyFoodValues)
        {
            FoodModifier.setModifiedFoodValues(Items.apple, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.bread, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(Items.porkchop, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_porkchop, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.fish, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_fished, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(Items.cookie, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.melon, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.beef, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_beef, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.chicken, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_chicken, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.rotten_flesh, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.baked_potato, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.poisonous_potato, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.pumpkin_pie, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.mushroom_stew, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(Items.carrot, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.potato, new FoodValues(1, 0.05F));
        }
    }
}
