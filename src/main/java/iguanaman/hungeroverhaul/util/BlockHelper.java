package iguanaman.hungeroverhaul.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockHelper {

    public static Item getSeedDropps(Block block) {
        if(block == Blocks.wheat) {
            return Items.wheat_seeds;
        } else if(block == Blocks.potatoes) {
            return Items.potato;
        } else if(block == Blocks.carrots) {
            return Items.carrot;
        }
        return null;
    }

    public static Item getPlantDrops(Block block) {
        if(block == Blocks.wheat) {
            return Items.wheat;
        } else {
            return getSeedDropps(block);
        }
    }
}
