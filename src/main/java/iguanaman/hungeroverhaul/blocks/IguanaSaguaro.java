package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import mods.natura.blocks.trees.SaguaroBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaSaguaro extends SaguaroBlock {

	public IguanaSaguaro() {
		super();
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		// biome modifier
		int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
		try {
			BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
			if(BiomeDictionary.isBiomeOfType(biome, Type.DESERT)) biomeModifier = 1;
		} catch (Exception var5) { biomeModifier = 1; }

		if (par5Random.nextInt(IguanaConfig.cactusRegrowthMultiplier * biomeModifier) != 0) return;

		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

}
