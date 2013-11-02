package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.natura.Natura;
import mods.natura.blocks.crops.CropBlock;

public class IguanaCropNatura extends CropBlock {

	public IguanaCropNatura(int id) {
		super(id);
	}

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick (World world, int x, int y, int z, Random random)
    {
        this.checkFlowerChange(world, x, y, z);

        int light = world.getBlockLightValue(x, y, z);
        if (light >= 9 && 
        		((IguanaConfig.cropsNeedSunlight && world.isDaytime() && world.canBlockSeeTheSky(x, y, z))
        		|| !IguanaConfig.cropsNeedSunlight)
        		)
        {
            int meta = world.getBlockMetadata(x, y, z);

            if (meta != 3 && meta != 8)
            {
                float grow = this.getGrowthRate(world, x, y, z, meta, light);

                if (random.nextInt((int) ((60.0F * (float)IguanaConfig.cropRegrowthMultiplier) / grow) + 1) == 0)
                {
                    meta++;
                    world.setBlockMetadataWithNotify(x, y, z, meta, 2);
                }
            }
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
	                if (output > 3)
	                    output = 3;
	                world.setBlockMetadataWithNotify(x, y, z, output, 3);
	            }
	            else
	            {
	                int output = Natura.random.nextInt(4) + 1 + meta;
		            if (world.difficultySetting == 2 && IguanaConfig.difficultyScalingBoneMeal) output = 1 + meta;
	                if (output > 8)
	                    output = 8;
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
            int count = quantityDropped(metadata, fortune, world.rand);
            for (int i = 0; i < count; i++)
            {
                int id = idDropped(metadata, world.rand, 0);
                if (id > 0)
                {
                    ret.add(new ItemStack(id, 1, damageDropped(metadata)));
                }
            }
        }
        
        ret.add(new ItemStack(this.getSeedItem(metadata), 1, seedDamageDropped(metadata)));

        return ret;
    }

}
