package iguanaman.hungeroverhaul.module;

import net.minecraft.item.ItemStack;

import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.util.RecipeRemover;
import mods.natura.common.NContent;
import squeek.applecore.api.food.FoodValues;

public class ModuleNatura
{
    public static void init()
    {
        RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
        RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
        RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 1);
        RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 2);

        //TODO Figure out how iguana_man calculated the FoodValues
        for(int i = 0; i < 4; i++)
            FoodModifier.setModifiedFoodValues(new ItemStack(NContent.berryItem, 1, i), new FoodValues(0, 0F));
        FoodModifier.setModifiedFoodValues(NContent.berryMedley, new FoodValues(0, 0F));
    }

    /*public static Block cactusNew;

    public static void init() {
    	String tempName;
    	
    	cactusNew = new IguanaCactus().setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("cactus").setBlockTextureName("cactus");
    	tempName = Block.blockRegistry.getNameForObject(Blocks.cactus);
    	Blocks.cactus = cactusNew;
    	Utils.replace(Blocks.cactus, tempName);
    }*/

}
