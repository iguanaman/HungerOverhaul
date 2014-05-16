package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.RecipeRemover;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBush;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBushNether;
import iguanaman.hungeroverhaul.blocks.IguanaCactus;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaSaguaro;
import iguanaman.hungeroverhaul.items.IguanaSeedNatura;
import iguanaman.hungeroverhaul.util.Utils;
import mods.natura.common.NContent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModuleNatura {

	public static Block cactusNew;

	public static void init() {

		cactusNew = new IguanaCactus().setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("cactus").setBlockTextureName("cactus");
		Blocks.cactus = cactusNew;
		Utils.replace(Blocks.cactus, cactusNew);

		NContent.crops = new IguanaCropNatura();
		NContent.berryBush = new IguanaBerryBush();
		NContent.netherBerryBush = new IguanaBerryBushNether();
		NContent.saguaro = new IguanaSaguaro().setBlockName("saguaro.block");
		NContent.seeds = new IguanaSeedNatura(NContent.crops, Blocks.farmland).setUnlocalizedName("barley.seed");
		
		Utils.replace(NContent.crops, new IguanaCropNatura());
		Utils.replace(NContent.berryBush, new IguanaBerryBush());
		Utils.replace(NContent.netherBerryBush, new IguanaBerryBushNether());
		Utils.replace(NContent.saguaro, new IguanaSaguaro().setBlockName("saguaro.block"));
		Utils.replace(NContent.seeds, new IguanaSeedNatura(NContent.crops, Blocks.farmland).setUnlocalizedName("barley.seed"));

		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 1);
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 2);

	}

}
