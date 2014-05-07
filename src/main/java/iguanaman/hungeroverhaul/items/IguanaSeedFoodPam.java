package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropPam;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import assets.pamharvestcraft.ItemPamSeedFood;
import cpw.mods.fml.common.Loader;

public class IguanaSeedFoodPam extends ItemPamSeedFood {

	public IguanaSeedFoodPam(int par1, int par2, float par3, int par4) {
		super(par1, par2, par3, par4);

		if (Loader.isModLoaded("Thaumcraft"))
			if (!ThaumcraftApi.exists(itemID, -1))
				ThaumcraftApi.registerObjectTag(itemID, -1, new AspectList()
				.add(Aspect.SEED, 1)
						);
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
			if (Block.blocksList[cropID] instanceof IguanaCropPam)
				theBiomes = IguanaCropPam.biomes[cropID];

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
