package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import net.minecraft.block.BlockReed;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaCropReed extends BlockReed {

	public static Type[] biomes = new Type[]{Type.JUNGLE, Type.SWAMP};

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
        if (IguanaConfig.cropsNeedSunlight && (!par1World.isDaytime() || !par1World.canBlockSeeTheSky(par2, par3, par4))) return;
        
        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
    	try {
    		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
    		for (Type biomeType : this.biomes) {
    			if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
                	//FMLLog.warning("biome is type: " + biomeType.toString(), new Object());
    				biomeModifier = 1;
    				break;
    			}
    		}
		} catch (Exception var5) { biomeModifier = 1; }
    	
    	if (par5Random.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0) return;

    	super.updateTick(par1World, par2, par3, par4, par5Random);
    }
	

}
