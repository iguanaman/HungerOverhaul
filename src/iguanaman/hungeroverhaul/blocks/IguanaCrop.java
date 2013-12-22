package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaCrop extends BlockCrops { // implements IFarmable, ICrop

	int cropID;
	int cropMeta;
	int seedID;

	public Type[] biomes = new Type[]{Type.FOREST, Type.PLAINS};

	String veg;


	public IguanaCrop(int par1, String veg)
	{
		super(par1);
		this.veg = veg;
	}

	/**
	 * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
	 * blockID passed in. Args: blockID
	 */
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return par1 == Block.tilledField.blockID;
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

	/**
	 * Apply bonemeal to the crops.
	 */
	@Override
	public void fertilize(World par1World, int par2, int par3, int par4)
	{
		if (par1World.difficultySetting < 3 || !IguanaConfig.difficultyScalingBoneMeal) {
			int r = 1;
			if (par1World.difficultySetting < 1 && !IguanaConfig.difficultyScalingBoneMeal) r = par1World.rand.nextInt(3);
			int l = Math.min(par1World.getBlockMetadata(par2, par3, par4) + r, 7);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		}

	}


	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		if (metadata >= 7)
		{

			int produce = IguanaConfig.producePerHarvestMin + world.rand.nextInt(1 + IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
			if (produce > 0) ret.add(new ItemStack(getCropItem(), produce, getCropItemMeta()));

			int seeds = IguanaConfig.seedsPerHarvestMin + world.rand.nextInt(1 + IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin);
			if (seeds > 0) ret.add(new ItemStack(getSeedItem(), seeds, 0));
		} else
			ret.add(new ItemStack(getSeedItem(), 1, 0));

		return ret;
	}

	/**
	 * Generate a crop produce ItemStack for this crop.
	 */
	 @Override
	 protected int getCropItem()
	 {
		 return cropID;
	 }

	 protected int getCropItemMeta()
	 {
		 return cropMeta;
	 }

	 public IguanaCrop setCropItem(int id)
	 {
		 return this.setCropItem(id, 0);
	 }

	 protected IguanaCrop setCropItem(int id, int meta)
	 {
		 cropID = id;
		 cropMeta = meta;
		 return this;
	 }

	 /**
	  * Generate a seed ItemStack for this crop.
	  */
	 @Override
	 protected int getSeedItem()
	 {
		 return seedID;
	 }

	 public IguanaCrop setSeedItem(int par1)
	 {
		 seedID = par1;
		 return this;
	 }

	 @Override
	 public int damageDropped(int par1)
	 {
		 return par1 == 7 ? getCropItemMeta() : 0;
	 }

	 /**
	  * Harvest crops by right clicking on them (also bone meal)
	  */
	 @Override
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		 int par5 = par1World.getBlockMetadata(par2, par3, par4);
		 if(par5 >= 7) {
			 super.dropBlockAsItem(par1World, par2, par3, par4, par5, par6);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
			 return true;
		 } else
			 return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	 }

}
