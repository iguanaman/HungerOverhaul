package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;

import java.util.List;

import mods.natura.items.NaturaSeeds;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaSeedNatura extends NaturaSeeds {

	public IguanaSeedNatura(int id, int cropID, int soilID) {
		super(id, cropID, soilID);
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (IguanaConfig.wrongBiomeRegrowthMultiplier > 1)
		{
			Type[] theBiomes = null;
			if (Block.blocksList[blockType] instanceof IguanaCropNatura)
				theBiomes = ((IguanaCropNatura)Block.blocksList[blockType]).biomes;

			if (theBiomes != null) {
				String tooltip = "";
				for(Type biomeType : theBiomes)
					tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
				par3List.add("Crop grows best in:");
				par3List.add(tooltip.substring(0, tooltip.length() - 2));
			}
		}
	}
}
