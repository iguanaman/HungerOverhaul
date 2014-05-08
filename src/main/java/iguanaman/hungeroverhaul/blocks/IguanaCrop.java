package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaCrop extends BlockCrops { // implements IFarmable, ICrop

	Item crop;
	int cropMeta;
	Item seed;
	protected IIcon[] iconArray;

	public Type[] biomes = new Type[]{Type.FOREST, Type.PLAINS};

	String veg;


	public IguanaCrop(String veg)
	{
		super();
		this.veg = veg;
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
	public void func_149863_m(World par1World, int par2, int par3, int par4)
	{
		if (par1World.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal) {
			int r = 1;
			if (par1World.difficultySetting.getDifficultyId() < 1 && !IguanaConfig.difficultyScalingBoneMeal) r = par1World.rand.nextInt(3);
			int l = Math.min(par1World.getBlockMetadata(par2, par3, par4) + r, 7);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		}

	}


	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		if (metadata >= 7)
		{

			int produce = IguanaConfig.producePerHarvestMin + world.rand.nextInt(1 + IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
			if (produce > 0) ret.add(new ItemStack(func_149865_P(), produce, getCropItemMeta()));

			int seeds = IguanaConfig.seedsPerHarvestMin + world.rand.nextInt(1 + IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin);
			if (seeds > 0) ret.add(new ItemStack(func_149866_i(), seeds, 0));
		} else
			ret.add(new ItemStack(func_149866_i(), 1, 0));

		return ret;
	}

	/**
	 * Generate a crop produce ItemStack for this crop.
	 */
	 @Override
	 protected Item func_149865_P()
	 {
		 return crop;
	 }

	 protected int getCropItemMeta()
	 {
		 return cropMeta;
	 }

	 public IguanaCrop setCropItem(Item item)
	 {
		 return this.setCropItem(item, 0);
	 }

	 protected IguanaCrop setCropItem(Item item, int meta)
	 {
		 crop = item;
		 cropMeta = meta;
		 return this;
	 }

	 /**
	  * Generate a seed ItemStack for this crop.
	  */
	 @Override
	 protected Item func_149866_i()
	 {
		 return seed;
	 }

	 public IguanaCrop setSeedItem(Item par1)
	 {
		 seed = par1;
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
