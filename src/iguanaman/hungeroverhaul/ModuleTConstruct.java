package iguanaman.hungeroverhaul;

import tconstruct.common.TContent;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.util.config.PHConstruct;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBush;
import iguanaman.hungeroverhaul.blocks.IguanaCactus;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBushNether;
import iguanaman.hungeroverhaul.blocks.IguanaCropVegetable;
import iguanaman.hungeroverhaul.blocks.IguanaSaguaro;
import iguanaman.hungeroverhaul.items.IguanaSeedNatura;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.blocks.trees.SaguaroBlock;
import mods.natura.common.NContent;
import mods.natura.common.PHNatura;
import mods.natura.items.NaturaSeeds;
import mods.natura.items.blocks.BerryBushItem;
import mods.natura.items.blocks.NetherBerryBushItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class ModuleTConstruct {
	
	public static Block cactusNew;

	public static void init() {

		if(Loader.isModLoaded("TConstruct")) {
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
		}

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
