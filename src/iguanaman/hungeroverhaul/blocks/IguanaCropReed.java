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
    	
    	int sunlightModifier = par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0) return;
    	
        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplierSugarcane;
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
    	if (biomeModifier == 0) return;
    	
    	if (par5Random.nextInt(IguanaConfig.sugarcaneCropRegrowthMultiplier * biomeModifier) != 0) return;

    	super.updateTick(par1World, par2, par3, par4, par5Random);
    }
	

}
