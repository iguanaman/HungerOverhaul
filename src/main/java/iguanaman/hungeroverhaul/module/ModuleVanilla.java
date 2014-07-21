package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.helper.FoodValueHelper;
import net.minecraft.init.Items;
import cpw.mods.fml.common.Loader;

public class ModuleVanilla
{
    public static void init()
    {
        if (Loader.isModLoaded("harvestcraft") || IguanaConfig.modifyFoodValues)
        {
            FoodValueHelper.addModifiedFoodValues(Items.apple, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.bread, new FoodValues(3, 0.2F));
            FoodValueHelper.addModifiedFoodValues(Items.porkchop, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_porkchop, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.fish, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_fished, new FoodValues(2, 0.1F));
            FoodValueHelper.addModifiedFoodValues(Items.cookie, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.melon, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.beef, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_beef, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.chicken, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_chicken, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.rotten_flesh, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.baked_potato, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.poisonous_potato, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.pumpkin_pie, new FoodValues(3, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.mushroom_stew, new FoodValues(2, 0.1F));
            FoodValueHelper.addModifiedFoodValues(Items.carrot, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.potato, new FoodValues(1, 0.05F));
        }
    }
}
