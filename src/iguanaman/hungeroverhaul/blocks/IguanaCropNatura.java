package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import mods.natura.Natura;
import mods.natura.blocks.crops.CropBlock;

public class IguanaCropNatura extends CropBlock {
	
	public Type[] biomes = new Type[]{Type.FOREST, Type.PLAINS};

	public IguanaCropNatura(int id) {
		super(id);
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

    /**
     * Harvest crops by right clicking on them (also bone meal)
     */
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
       int par5 = par1World.getBlockMetadata(par2, par3, par4);
       if(par5 == 3) {
       		super.dropBlockAsItem(par1World, par2, par3, par4, par5, par6);
	       	par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
	        return true;
       }
       else
       {
           return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
       }
    }

    /**
     * Apply bonemeal to the crops.
     */
    @Override
    public void fertilize (World world, int x, int y, int z)
    {
   	   if (world.difficultySetting < 3 || IguanaConfig.difficultyScalingBoneMeal == false)
   	   {
	        int meta = world.getBlockMetadata(x, y, z);
	        if (meta != 3 && meta != 8)
	        {
	            if (meta < 3)
	            {
	                int output = Natura.random.nextInt(3) + 1 + meta;
		            if (world.difficultySetting == 2 && IguanaConfig.difficultyScalingBoneMeal) output = 1 + meta;
	                if (output > 3) output = 3;
	                world.setBlockMetadataWithNotify(x, y, z, output, 3);
	            }
	            else
	            {
	                int output = Natura.random.nextInt(4) + 1 + meta;
		            if (world.difficultySetting == 2 && IguanaConfig.difficultyScalingBoneMeal) output = 1 + meta;
	                if (output > 8) output = 8;
	                world.setBlockMetadataWithNotify(x, y, z, output, 3);
	            }
	        }
   	   }
    }


    @Override
    public ArrayList<ItemStack> getBlockDropped (World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if (metadata == 3 || metadata == 8)
        {
        	int count = IguanaConfig.producePerHarvestMin + world.rand.nextInt(IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
            for (int i = 0; i < count; i++)
            {
                int id = idDropped(metadata, world.rand, 0);
                if (id > 0) ret.add(new ItemStack(id, 1, damageDropped(metadata)));
            }
        }
        else
        {
        	ret.add(new ItemStack(this.getSeedItem(metadata), 1, seedDamageDropped(metadata)));
        }
        
        return ret;
    }

}
