package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import mods.natura.blocks.crops.BerryBush;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaBerryBush extends BerryBush {

	public Type[] biomes = new Type[]{Type.FOREST, Type.PLAINS};

	public IguanaBerryBush(int id) {
		super(id);
	}

	/* Bush growth */
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int sunlightModifier = par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
		if (sunlightModifier == 0) return;

		// biome modifier
		int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
		try {
			BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
			for (Type biomeType : biomes)
				if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
					//FMLLog.warning("biome is type: " + biomeType.toString(), new Object());
					biomeModifier = 1;
					break;
				}
		} catch (Exception var5) { biomeModifier = 1; }
		if (biomeModifier == 0) return;

		if (par5Random.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier ) != 0) return;

		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public boolean boneFertilize (World world, int x, int y, int z, Random random)
	{
		if (world.difficultySetting < 3 || IguanaConfig.difficultyScalingBoneMeal == false)
		{
			int meta = world.getBlockMetadata(x, y, z);

			if (meta / 4 < 2)
			{
				int setMeta = random.nextInt(2) + 1 + meta / 4;
				if (setMeta > 2) setMeta = 2;
				if (world.difficultySetting == 2 && IguanaConfig.difficultyScalingBoneMeal) setMeta = 1;
				world.setBlockMetadataWithNotify(x, y, z, meta % 4 + setMeta * 4, 4);
				return true;
			}

			Block block = Block.blocksList[world.getBlockId(x, y + 1, z)];
			if (block == null || block.isAirBlock(world, x, y + 1, z))
			{
				if (random.nextInt(3) == 0) world.setBlock(x, y + 1, z, blockID, meta % 4, 3);
				return true;
			}
		}

		return false;
	}

}
