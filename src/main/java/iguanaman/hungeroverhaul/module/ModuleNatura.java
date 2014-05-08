package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.RecipeRemover;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBush;
import iguanaman.hungeroverhaul.blocks.IguanaBerryBushNether;
import iguanaman.hungeroverhaul.blocks.IguanaCactus;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaSaguaro;
import iguanaman.hungeroverhaul.items.IguanaSeedNatura;
import mods.natura.common.NContent;
import mods.natura.common.PHNatura;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModuleNatura {

	public static Block cactusNew;

	public static void init() {

		Block.blocksList[Block.cactus.blockID] = null;
		cactusNew = new IguanaCactus(81).setHardness(0.4F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("cactus").setTextureName("cactus");
		GameRegistry.registerBlock(cactusNew, ItemBlock.class, null);

		Block.blocksList[NContent.crops.blockID] = null;
		Block.blocksList[NContent.berryBush.blockID] = null;
		Block.blocksList[NContent.netherBerryBush.blockID] = null;
		Block.blocksList[NContent.saguaro.blockID] = null;
		NContent.crops = new IguanaCropNatura(PHNatura.floraCropsID);
		NContent.berryBush = new IguanaBerryBush(PHNatura.berryBlockID);
		NContent.netherBerryBush = new IguanaBerryBushNether(PHNatura.netherBerryBlock);
		NContent.saguaro = new IguanaSaguaro(PHNatura.saguaroID).setUnlocalizedName("saguaro.block");

		Item.itemsList[NContent.seeds.itemID] = null;
		NContent.seeds = new IguanaSeedNatura(PHNatura.barleySeedID, NContent.crops.blockID, Block.tilledField.blockID).setUnlocalizedName("barley.seed");

		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem.itemID, 1);
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem.itemID, 2);

	}

}
