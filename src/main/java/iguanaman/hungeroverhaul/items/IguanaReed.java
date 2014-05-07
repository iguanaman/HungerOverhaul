package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropReed;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaReed extends ItemReed {

	public IguanaReed(int par1, Block par2Block) {
		super(par1, par2Block);
		// TODO Auto-generated constructor stub
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (IguanaConfig.wrongBiomeRegrowthMultiplierSugarcane > 1)
		{
			String tooltip = "";
			for(Type biomeType : IguanaCropReed.biomes)
				tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
			par3List.add("Crop grows best in:");
			par3List.add(tooltip.substring(0, tooltip.length() - 2));
		}
	}

}
