package iguanaman.hungeroverhaul.util;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Note: This is only used when {@link IguanaConfig#difficultyScalingBoneMeal} is set to {@code true}
 */
public abstract class BonemealModification
{
    public void onBonemeal(World world, int x, int y, int z, Block block, int meta)
    {
    }

    public abstract int getNewMeta(World world, int x, int y, int z, Block block, int currentMeta);
}
