package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import assets.pamharvestcraft.TileEntityPamCrop;
import assets.pamweeeflowers.BlockPamFlowerCrop;
import assets.pamweeeflowers.PamWeeeFlowers;
import assets.pamweeeflowers.TileEntityPamFlowerCrop;

public class IguanaCropPamFlower extends BlockPamFlowerCrop {

	public IguanaCropPamFlower(int par1) {
		super(par1);
		
    	if (Loader.isModLoaded("Thaumcraft"))
    	{
    	   if (!ThaumcraftApi.exists(blockID, -1))
    	   {
    		   ThaumcraftApi.registerObjectTag(blockID, -1, new AspectList()
    		   .add(Aspect.CROP, 2).add(Aspect.HUNGER, 1)
    		   );
    	   }
    	}
	}

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	int sunlightModifier = par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0) return;
    	if (par5Random.nextInt(IguanaConfig.flowerRegrowthMultiplier) != 0) return;
    	super.updateTick(par1World, par2, par3, par4, par5Random);
    }

    /**
     * Harvest crops by right clicking on them (also bone meal)
     */
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

        if(!par1World.isRemote) {
           Random random = new Random();
           TileEntityPamFlowerCrop tileentitypamflowercrop = (TileEntityPamFlowerCrop)par1World.getBlockTileEntity(par2, par3, par4);
           if(tileentitypamflowercrop != null) {
              int cropID = tileentitypamflowercrop.getCropID();
              int stage = tileentitypamflowercrop.getGrowthStage();
              {
                 int cropDrops = random.nextInt(2) + 1;
                 if(stage == 2) {
               	  	tileentitypamflowercrop.setGrowthStage(0);
                     par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 0.7D, (double)par4 + 0.5D, new ItemStack(PamWeeeFlowers.pamFlower, cropDrops, cropID)));                    }
                 	return true;
                 }
              }
           }
        return false;
    }


}
