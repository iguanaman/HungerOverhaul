package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import mods.natura.blocks.crops.NetherBerryBush;

public class IguanaNetherBerryBush extends NetherBerryBush {

	public IguanaNetherBerryBush(int id) {
		super(id);
	}
	
    /* Bush growth */

    @Override
    public void updateTick (World world, int x, int y, int z, Random random1)
    {
        if (world.isRemote)
        {
            return;
        }

        int height;

        for (height = 1; world.getBlockId(x, y - height, z) == this.blockID; ++height)
        {
            ;
        }

        if (random1.nextInt(75 * IguanaConfig.cropRegrowthMultiplier) == 0)
        {
            int md = world.getBlockMetadata(x, y, z);
            if (md < 12)
            {
                world.setBlock(x, y, z, blockID, md + 4, 3);
            }
            if (random1.nextInt(3) == 0 && height < 3 && world.getBlockId(x, y + 1, z) == 0 && md >= 8)
            {
                world.setBlock(x, y + 1, z, blockID, md % 4, 3);
            }
        }
    }

    @Override
    public boolean boneFertilize (World world, int x, int y, int z, Random random)
    {
   	   if (world.difficultySetting < 3 || IguanaConfig.difficultyScalingBoneMeal == false)
   	   {
	        int meta = world.getBlockMetadata(x, y, z);
	        if (meta / 4 < 2)
	        {
	            if (random.nextBoolean())
	            {
	                int setMeta = random.nextInt(2) + 1 + meta / 4;
		            if (setMeta > 2) setMeta = 2;
		            if (world.difficultySetting == 2 && IguanaConfig.difficultyScalingBoneMeal) setMeta = 1;
	                world.setBlockMetadataWithNotify(x, y, z, meta % 4 + setMeta * 4, 4);
	            }
	            return true;
	        }
	
	        Block block = Block.blocksList[world.getBlockId(x, y + 1, z)];
	        if (block == null || block.isAirBlock(world, x, y + 1, z))
	        {
	            if (random.nextBoolean())
	            {
	                if (random.nextInt(3) == 0)
	                    world.setBlock(x, y + 1, z, this.blockID, meta % 4, 3);
	            }
	
	            return true;
	        }
   	   }

        return false;
    }
}
