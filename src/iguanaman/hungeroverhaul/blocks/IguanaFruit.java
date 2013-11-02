package iguanaman.hungeroverhaul.blocks;


import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.oredict.OreDictionary;
import assets.pamharvestcraft.BlockPamFruit;

public class IguanaFruit extends BlockPamFruit {

	public IguanaFruit(int i, String fruit) {
		super(i, fruit);
        this.setBiomes(new Type[]{Type.JUNGLE, Type.SWAMP});
		
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

	ArrayList<Type> biomes;

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        int var6 = par1World.getBlockMetadata(par2, par3, par4);

        if (var6 < 2)
        {
            // biome modifier
            int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
        	try {
        		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
        		if (this.biomes.contains(biome)) {biomeModifier = 1;}
			} catch (Exception var5) {
				biomeModifier = 1;
			}

            if (par5Random.nextInt(20 * IguanaConfig.treeCropRegrowthMultiplier * biomeModifier) == 0)
            {
                ++var6;
                par1World.setBlock(par2, par3, par4, super.blockID, var6, 2);
            }
        }
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
	        super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	        return true;
       }
       else
       {
           return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
        }
       
    }

    protected IguanaFruit setBiomes(Type[] par1)
    {
    	this.biomes = new ArrayList<Type>();
    	for(Type biome : par1) {this.biomes.add(biome);}
        return this;
    }
    
    /**
     * Apply bonemeal to the crops.
     */
    @Override
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        int meta = Math.min(par1World.getBlockMetadata(par2, par3, par4) + 1, 2);
  	   if (par1World.difficultySetting < 3 || !IguanaConfig.difficultyScalingBoneMeal) 
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
    }
}
