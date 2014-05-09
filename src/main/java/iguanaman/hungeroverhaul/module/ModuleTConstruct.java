package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tconstruct.common.TRepo;
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

			DryingRackRecipes.addDryingRecipe(Items.beef, dryingTime, new ItemStack(TRepo.jerky, 1, 0));
			DryingRackRecipes.addDryingRecipe(Items.chicken, dryingTime, new ItemStack(TRepo.jerky, 1, 1));
			DryingRackRecipes.addDryingRecipe(Items.porkchop, dryingTime, new ItemStack(TRepo.jerky, 1, 2));
			DryingRackRecipes.addDryingRecipe(Items.fish, dryingTime, new ItemStack(TRepo.jerky, 1, 4));
			DryingRackRecipes.addDryingRecipe(Items.rotten_flesh, dryingTime, new ItemStack(TRepo.jerky, 1, 5));
		}

	}

}
