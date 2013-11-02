package iguanaman.hungeroverhaul;

import iguanaman.hungeroverhaul.blocks.IguanaBerryBush;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaNetherBerryBush;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.common.NContent;
import mods.natura.common.PHNatura;
import mods.natura.items.blocks.BerryBushItem;
import mods.natura.items.blocks.NetherBerryBushItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModuleNatura {

	public static void init() {
		Block.blocksList[NContent.crops.blockID] = null;
		Block.blocksList[NContent.berryBush.blockID] = null;
		Block.blocksList[NContent.netherBerryBush.blockID] = null;
        NContent.crops = new IguanaCropNatura(PHNatura.floraCropsID);
        NContent.berryBush = new IguanaBerryBush(PHNatura.berryBlockID);
        NContent.netherBerryBush = new IguanaNetherBerryBush(PHNatura.netherBerryBlock);
        
		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
		RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem.itemID, 1);
		RecipeRemover.removeFurnaceRecipe(NContent.plantItem.itemID, 2);
	}

}
