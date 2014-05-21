package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.blocks.IguanaBerryBush;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBushNether;
import iguanaman.hungeroverhaul.blocks.IguanaCactus;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaSaguaro;
import iguanaman.hungeroverhaul.items.IguanaSeedNatura;
import iguanaman.hungeroverhaul.util.RecipeRemover;
import iguanaman.hungeroverhaul.util.Utils;
import mods.natura.common.NContent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModuleNatura {

	public static Block cactusNew;

	public static void init() {
		String tempName;
		
		cactusNew = new IguanaCactus().setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("cactus").setBlockTextureName("cactus");
		tempName = Block.blockRegistry.getNameForObject(Blocks.cactus);
		Blocks.cactus = cactusNew;
		Utils.replace(Blocks.cactus, tempName);

		tempName = Block.blockRegistry.getNameForObject(NContent.crops);
		NContent.crops = new IguanaCropNatura();
		Utils.replace(NContent.crops, tempName);
		
		tempName = Block.blockRegistry.getNameForObject(NContent.berryBush);
		NContent.berryBush = new IguanaBerryBush();
		Utils.replace(NContent.berryBush, tempName);
		
		tempName = Block.blockRegistry.getNameForObject(NContent.netherBerryBush);
		NContent.netherBerryBush = new IguanaBerryBushNether();
		Utils.replace(NContent.netherBerryBush, tempName);
		
		tempName = Block.blockRegistry.getNameForObject(NContent.saguaro);
		NContent.saguaro = new IguanaSaguaro().setBlockName("saguaro.block");
		Utils.replace(NContent.saguaro, tempName);
		
		tempName = Item.itemRegistry.getNameForObject(NContent.seeds);
		NContent.seeds = new IguanaSeedNatura(NContent.crops, Blocks.farmland).setUnlocalizedName("barley.seed");
		Utils.replace(NContent.seeds, tempName);

		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 1);
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 2);

	}

}
