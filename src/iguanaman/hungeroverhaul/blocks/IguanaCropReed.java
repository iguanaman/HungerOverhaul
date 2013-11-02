package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import net.minecraft.block.BlockReed;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaCropReed extends BlockReed {

	public IguanaCropReed(int par1) {
		super(par1);
        this.disableStats();
	}


    /**
     * Ticks the block if it's been scheduled
     */
	@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.isAirBlock(par2, par3 + 1, par4))
        {
            int l;
            
            for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == this.blockID; ++l) {}

            if (l < 3)
            {
                // biome modifier
                int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
            	try {
            		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
        			if(
        					BiomeDictionary.isBiomeOfType(biome, Type.DESERT) ||
        					BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) || 
        					BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) {
        				biomeModifier = 1;
        			}
    			} catch (Exception var5) {
    				biomeModifier = 1;
    			}
            	
            	 if (par1World.rand.nextInt(biomeModifier) == 0) {
                     int i1 = par1World.getBlockMetadata(par2, par3, par4);

                     if (i1 == 15)
                     {
                         par1World.setBlock(par2, par3 + 1, par4, this.blockID);
                         par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
                     }
                     else
                     {
                         par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 + 1, 4);
                     }
            	 }
            			 
            			 
            	
            }
        }
    }
	

}
