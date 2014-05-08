package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.common.TContent;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.util.config.PHConstruct;
import cpw.mods.fml.common.Loader;

public class ModuleTConstruct {

	public static Block cactusNew;

	public static void init() {

		if(Loader.isModLoaded("TConstruct"))
			try {
				if (!PHConstruct.enableHealthRegen)
				{
					PHConstruct.enableHealthRegen = true;
					IguanaConfig.healthRegenRatePercentage = 0;
				}
				if (PHConstruct.alphaRegen)
				{
					PHConstruct.alphaRegen = false;
					IguanaConfig.foodRegensHealth = true;
				}
			} catch (Exception ex) {}

		if (IguanaConfig.dryingRackTimeMultiplier != 1)
		{
			DryingRackRecipes.recipes.clear();

			int dryingTime = 20 * 60 * 20; //in minutes

			DryingRackRecipes.addDryingRecipe(Item.beefRaw, dryingTime, new ItemStack(TContent.jerky, 1, 0));
			DryingRackRecipes.addDryingRecipe(Item.chickenRaw, dryingTime, new ItemStack(TContent.jerky, 1, 1));
			DryingRackRecipes.addDryingRecipe(Item.porkRaw, dryingTime, new ItemStack(TContent.jerky, 1, 2));
			DryingRackRecipes.addDryingRecipe(Item.fishRaw, dryingTime, new ItemStack(TContent.jerky, 1, 4));
			DryingRackRecipes.addDryingRecipe(Item.rottenFlesh, dryingTime, new ItemStack(TContent.jerky, 1, 5));
		}

	}

}
