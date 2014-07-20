package iguanaman.hungeroverhaul.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Loader;
import mods.natura.common.NContent;

public class BlockHelper
{

    public static Item getSeedDropps(Block block)
    {
        if (block == Blocks.wheat)
        {
            return Items.wheat_seeds;
        }
        else if (block == Blocks.potatoes)
        {
            return Items.potato;
        }
        else if (block == Blocks.carrots)
        {
            return Items.carrot;
        }
        else if (Loader.isModLoaded("Natura") && block == NContent.crops)
        {
            return NContent.plantItem;
        }
        return null;
    }

    public static Item getPlantDrops(Block block)
    {
        if (block == Blocks.wheat)
        {
            return Items.wheat;
        }
        else if (Loader.isModLoaded("Natura") && block == NContent.crops)
        {
            return NContent.seeds;
        }
        else
        {
            return getSeedDropps(block);
        }
    }

    public static int getSeedMetadata(Block block, int meta)
    {
        if (Loader.isModLoaded("Natura") && block == NContent.crops)
        {
            if (meta < 4)
                return 0;
            else
                return 1;
        }
        else
        {
            return 0;
        }
    }
}
