package iguanaman.hungeroverhaul.util;

import mods.natura.blocks.crops.CropBlock;
import mods.natura.common.NContent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;

public class BlockHelper
{
    public static ItemStack getSeedOfBlock(Block block, int meta)
    {
        return getSeedsOfBlock(block, meta, 1);
    }

    public static ItemStack getSeedsOfBlock(Block block, int meta, int num)
    {
        return new ItemStack(getSeedItem(block, meta), num, getSeedMetadata(block, meta));
    }

    public static ItemStack getProduceOfBlock(Block block, int meta)
    {
        return getProduceOfBlock(block, meta, 1);
    }

    public static ItemStack getProduceOfBlock(Block block, int meta, int num)
    {
        return new ItemStack(getProduceItem(block, meta), num, getProduceMetadata(block, meta));
    }

    public static Item getSeedItem(Block block, int meta)
    {
        return block.getItemDropped(0, RandomHelper.random, 0);
    }

    public static Item getProduceItem(Block block, int meta)
    {
        return block.getItemDropped(meta, RandomHelper.random, 0);
    }

    public static int getProduceMetadata(Block block, int meta)
    {
        return block.damageDropped(meta);
    }

    public static int getSeedMetadata(Block block, int meta)
    {
        if (Loader.isModLoaded("Natura") && block == NContent.crops)
        {
            return ((CropBlock) block).seedDamageDropped(meta);
        }
        else
        {
            return block.damageDropped(0);
        }
    }
}
