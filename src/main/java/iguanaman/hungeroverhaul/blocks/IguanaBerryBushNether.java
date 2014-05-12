package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import mods.natura.blocks.crops.NetherBerryBush;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaBerryBushNether extends NetherBerryBush {

	public IguanaBerryBushNether() {
		super();
	}

	/* Bush growth */
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
			if(BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) biomeModifier = 1;
		} catch (Exception var5) { biomeModifier = 1; }

		if (par5Random.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0) return;

		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public boolean boneFertilize (World world, int x, int y, int z, Random random)
	{
		if (world.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
		{
			int meta = world.getBlockMetadata(x, y, z);
			if (meta / 4 < 2)
			{
				if (random.nextBoolean())
				{
					int setMeta = random.nextInt(2) + 1 + meta / 4;
					if (setMeta > 2) setMeta = 2;
					if (world.difficultySetting.getDifficultyId() == 2 && IguanaConfig.difficultyScalingBoneMeal) setMeta = 1;
					world.setBlockMetadataWithNotify(x, y, z, meta % 4 + setMeta * 4, 4);
				}
				return true;
			}

			Block block = world.getBlock(x, y + 1, z);
			if (block == null || block.isAir(world, x, y + 1, z))
			{
				if (random.nextInt(6) == 0) world.setBlock(x, y + 1, z, block, meta % 4, 3);
				return true;
			}
		}
		return false;
	}
}
