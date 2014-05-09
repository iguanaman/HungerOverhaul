package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaStem extends BlockStem {

	public Type[] biomes = new Type[]{Type.JUNGLE, Type.SWAMP};

	public IguanaStem(Block par2Block) {
		super(par2Block);
	}

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

		if (par5Random.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0) return;

		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public void func_149874_m(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

		if (l > 7)
			l = 7;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}


	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(field_149877_a == Blocks.pumpkin ? Items.pumpkin_seeds : Items.melon_seeds));
		return ret;
	}
}
