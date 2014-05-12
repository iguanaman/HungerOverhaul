package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.pam.harvestcraft.BlockPamFruit;

import cpw.mods.fml.common.Loader;

public class IguanaFruit extends BlockPamFruit {

	Type[] biomes = new Type[]{Type.JUNGLE, Type.SWAMP};

	public IguanaFruit(String fruit) {
		super(fruit);

		if (Loader.isModLoaded("Thaumcraft"))
			if (!ThaumcraftApi.exists(Item.getItemFromBlock(this), -1))
				ThaumcraftApi.registerObjectTag(new ItemStack(this), new int[] {-1}, new AspectList().add(Aspect.CROP, 2).add(Aspect.HUNGER, 1));
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
			for (Type biomeType : biomes)
				if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
					//FMLLog.warning("biome is type: " + biomeType.toString(), new Object());
					biomeModifier = 1;
					break;
				}
		} catch (Exception var5) { biomeModifier = 1; }

		if (par5Random.nextInt(IguanaConfig.treeCropRegrowthMultiplier * biomeModifier) != 0) return;

		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	/**
	 * Harvest crops by right clicking on them (also bone meal)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		int par5 = par1World.getBlockMetadata(par2, par3, par4);
		if(par5 >= 2) {
			super.dropBlockAsItem(par1World, par2, par3, par4, par5, par6);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
			return true;
		} else
			return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);

	}

	/**
	 * Apply bonemeal to the crops.
	 */
	@Override
	public void fertilize(World par1World, int par2, int par3, int par4)
	{
		int meta = Math.min(par1World.getBlockMetadata(par2, par3, par4) + 1, 2);
		if (par1World.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
			par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
	}
}
