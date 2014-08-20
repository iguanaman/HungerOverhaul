package iguanaman.hungeroverhaul.json;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import squeek.applecore.api.food.FoodValues;

/**
 * Class for serializing Foods to/from json based on format from Jaded's Blood mod by Minalien
 * https://github.com/Minalien/JadedsBlood
 */
public class Food {
    //Registry Name
    public static String name = "";
    public static String oreName = "";
    public static int meta = 0;
    public static int count = 1;
    public static float saturationModifier = 0.0F;
    public static int hunger = 0;
    public static boolean hasOredictEntry() {
        return oreName.isEmpty();
    }
    //TODO handle blocks as well!!
    public static ItemStack toItemStack () {
        Item i = GameData.getItemRegistry().getObject(name);
        if (i == null) {
            Block b = GameData.getBlockRegistry().getObject(name);
            if(b != null)
                i = Item.getItemFromBlock(b);
        }
        return i == null ? null : new ItemStack(GameData.getItemRegistry().getObject(name), count, meta);
    }
    public static FoodValues toFoodValues() {
        return new FoodValues(hunger, saturationModifier);
    }

    public static Food fromItemStack (ItemStack is, FoodValues fv) {
        return fromItemStack(is, fv.saturationModifier, fv.hunger);
    }

    public static Food fromItemStack (ItemStack is, Float saturationModifier, int hunger) {
        Food fd = new Food();
        fd.name = GameData.getItemRegistry().getNameForObject(is.getItem());
        if(fd.name == null || fd.name.isEmpty())
            fd.name = GameData.getBlockRegistry().getNameForObject(is.getItem());
        if(fd.name == null || fd.name.isEmpty())
            return null;
        fd.meta = is.getItemDamage();
        fd.count = is.stackSize;
        int[] oreIds = OreDictionary.getOreIDs(is);
        if(oreIds.length > 0)
            fd.oreName = OreDictionary.getOreName(oreIds[0]);
        fd.saturationModifier = saturationModifier;
        fd.hunger = hunger;
        return fd;
    }
}

