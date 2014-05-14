package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCocoa;
import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaCropReed;
import iguanaman.hungeroverhaul.blocks.IguanaCropVegetable;
import iguanaman.hungeroverhaul.blocks.IguanaStem;
import iguanaman.hungeroverhaul.items.IguanaFood;
import iguanaman.hungeroverhaul.items.IguanaFoodBowl;
import iguanaman.hungeroverhaul.items.IguanaReed;
import iguanaman.hungeroverhaul.items.IguanaSeed;
import iguanaman.hungeroverhaul.items.IguanaSeedFood;
import iguanaman.hungeroverhaul.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModuleVanilla
{

    public static Block carrotNew;
    public static Block potatoNew;
    public static Block wheatNew;
    public static Block pumpkinStemNew;
    public static Block melonStemNew;
    public static Block reedNew;
    public static Block cocoaNew;

    public static void init ()
    {

        // BLOCKS
        reedNew = new IguanaCropReed().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("reeds").setBlockTextureName("reeds");
        Utils.replace(Blocks.reeds, reedNew);
        //GameRegistry.registerBlock(reedNew, ItemBlock.class, null);
        Utils.replace(Items.reeds, new IguanaReed(reedNew).setUnlocalizedName("reeds").setTextureName("reeds").setCreativeTab(CreativeTabs.tabMaterials));

        carrotNew = new IguanaCropVegetable("carrots").setCropItem(Items.carrot).setSeedItem(Items.carrot).setBlockName("carrots").setBlockTextureName("carrots");
        Utils.replace(Blocks.carrots, carrotNew);
        //		GameRegistry.registerBlock(reedNew, ItemBlock.class, null);

        potatoNew = new IguanaCropVegetable("potatoes").setCropItem(Items.potato).setSeedItem(Items.potato).setBlockName("potatoes").setBlockTextureName("potatoes");
        Utils.replace(Blocks.potatoes, potatoNew);
        //		GameRegistry.registerBlock(potatoNew, ItemBlock.class, null);

        wheatNew = new IguanaCrop("crops").setCropItem(Items.wheat).setSeedItem(Items.wheat_seeds).setBlockName("crops").setBlockTextureName("wheat");
        Utils.replace(Blocks.wheat, wheatNew);
        //		GameRegistry.registerBlock(wheatNew, ItemBlock.class, null);
        Utils.replace(Items.wheat_seeds, new IguanaSeed(Blocks.wheat, Blocks.farmland).setUnlocalizedName("seeds").setTextureName("seeds_wheat"));

        pumpkinStemNew = new IguanaStem(Blocks.pumpkin).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("pumpkinStem").setBlockTextureName("pumpkin_stem");
        melonStemNew = new IguanaStem(Blocks.melon_block).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("pumpkinStem").setBlockTextureName("melon_stem");
        Utils.replace(Blocks.pumpkin_stem, pumpkinStemNew);
        Utils.replace(Blocks.melon_stem, melonStemNew);
        //		GameRegistry.registerBlock(pumpkinStemNew, ItemBlock.class, null);
        //		GameRegistry.registerBlock(melonStemNew, ItemBlock.class, null);
        Utils.replace(Items.pumpkin_seeds, new IguanaSeed(Blocks.pumpkin_stem, Blocks.farmland).setUnlocalizedName("seeds_pumpkin").setTextureName("seeds_pumpkin"));
        Utils.replace(Items.melon_seeds, new IguanaSeed(Blocks.melon_stem, Blocks.farmland).setUnlocalizedName("seeds_melon").setTextureName("seeds_melon"));

        cocoaNew = new IguanaCocoa().setHardness(0.2F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("cocoa").setBlockTextureName("cocoa");
        Utils.replace(Blocks.cocoa, cocoaNew);
        //		GameRegistry.registerBlock(cocoaNew, ItemBlock.class, null);

        // ITEMS
        if (!Loader.isModLoaded("pamharvestcraft") || !IguanaConfig.modifyFoodValues)
        {
            Utils.replace(Items.apple,
                    new IguanaFood(((ItemFood) Items.apple).func_150905_g(null), ((ItemFood) Items.apple).func_150906_h(null), false).setUnlocalizedName("apple").setTextureName("apple"));
            Utils.replace(Items.bread,
                    new IguanaFood(((ItemFood) Items.bread).func_150905_g(null), ((ItemFood) Items.bread).func_150906_h(null), false).setUnlocalizedName("bread").setTextureName("bread"));
            Utils.replace(Items.porkchop, new IguanaFood(((ItemFood) Items.porkchop).func_150905_g(null), ((ItemFood) Items.porkchop).func_150906_h(null), true).setUnlocalizedName("porkchopRaw")
                    .setTextureName("porkchop_raw"));
            Utils.replace(Items.cooked_porkchop, new IguanaFood(((ItemFood) Items.cooked_porkchop).func_150905_g(null), ((ItemFood) Items.cooked_porkchop).func_150906_h(null), true)
                    .setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked"));
            Utils.replace(Items.fish,
                    new IguanaFood(((ItemFood) Items.fish).func_150905_g(null), ((ItemFood) Items.fish).func_150906_h(null), false).setUnlocalizedName("fishRaw").setTextureName("fish_raw"));
            Utils.replace(
                    Items.cooked_fished,
                    new IguanaFood(((ItemFood) Items.cooked_fished).func_150905_g(null), ((ItemFood) Items.cooked_fished).func_150906_h(null), false).setUnlocalizedName("fishCooked").setTextureName(
                            "fish_cooked"));
            Utils.replace(Items.cookie, new IguanaFood(((ItemFood) Items.cookie).func_150905_g(null), ((ItemFood) Items.cookie).func_150906_h(null), false).setUnlocalizedName("cookie")
                    .setTextureName("cookie"));
            Utils.replace(Items.melon,
                    new IguanaFood(((ItemFood) Items.melon).func_150905_g(null), ((ItemFood) Items.melon).func_150906_h(null), false).setUnlocalizedName("melon").setTextureName("melon"));
            Utils.replace(Items.beef,
                    new IguanaFood(((ItemFood) Items.beef).func_150905_g(null), ((ItemFood) Items.beef).func_150906_h(null), true).setUnlocalizedName("beefRaw").setTextureName("beef_raw"));
            Utils.replace(
                    Items.cooked_beef,
                    new IguanaFood(((ItemFood) Items.cooked_beef).func_150905_g(null), ((ItemFood) Items.cooked_beef).func_150906_h(null), true).setUnlocalizedName("beefCooked").setTextureName(
                            "beef_cooked"));
            Utils.replace(Items.chicken,
                    new IguanaFood(((ItemFood) Items.chicken).func_150905_g(null), ((ItemFood) Items.chicken).func_150906_h(null), true).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
                            .setUnlocalizedName("chickenRaw").setTextureName("chicken_raw"));
            Utils.replace(Items.cooked_chicken,
                    new IguanaFood(((ItemFood) Items.cooked_chicken).func_150905_g(null), ((ItemFood) Items.cooked_chicken).func_150906_h(null), true).setUnlocalizedName("chickenCooked")
                            .setTextureName("chicken_cooked"));
            Utils.replace(Items.rotten_flesh,
                    new IguanaFood(((ItemFood) Items.rotten_flesh).func_150905_g(null), ((ItemFood) Items.rotten_flesh).func_150906_h(null), true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F)
                            .setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh"));
            Utils.replace(
                    Items.baked_potato,
                    new IguanaFood(((ItemFood) Items.baked_potato).func_150905_g(null), ((ItemFood) Items.baked_potato).func_150906_h(null), false).setUnlocalizedName("potatoBaked").setTextureName(
                            "potato_baked"));
            Utils.replace(Items.poisonous_potato, new IguanaFood(((ItemFood) Items.poisonous_potato).func_150905_g(null), ((ItemFood) Items.poisonous_potato).func_150906_h(null), false)
                    .setPotionEffect(Potion.poison.id, 5, 0, 0.6F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous"));
            Utils.replace(
                    Items.pumpkin_pie,
                    new IguanaFood(((ItemFood) Items.pumpkin_pie).func_150905_g(null), ((ItemFood) Items.pumpkin_pie).func_150906_h(null), false).setUnlocalizedName("pumpkinPie")
                            .setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood));
            Utils.replace(Items.mushroom_stew, new IguanaFoodBowl(((ItemFood) Items.mushroom_stew).func_150905_g(null), ((ItemFood) Items.mushroom_stew).func_150906_h(null), false)
                    .setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew"));
            Utils.replace(Items.carrot, new IguanaSeedFood(((ItemFood) Items.carrot).func_150905_g(null), ((ItemFood) Items.carrot).func_150906_h(null), Blocks.carrots, Blocks.farmland)
                    .setUnlocalizedName("carrots").setTextureName("carrot"));
            Utils.replace(Items.potato, new IguanaSeedFood(((ItemFood) Items.potato).func_150905_g(null), ((ItemFood) Items.potato).func_150906_h(null), Blocks.potatoes, Blocks.farmland)
                    .setUnlocalizedName("potato").setTextureName("potato"));
        }
        else
        {
            Items.apple = new IguanaFood(1, 0.05F, false).setUnlocalizedName("apple").setTextureName("apple");
            Items.bread = new IguanaFood(3, 0.2F, false).setUnlocalizedName("bread").setTextureName("bread");
            Items.porkRaw = new IguanaFood(1, 0.05F, true).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
            Items.porkCooked = new IguanaFood(2, 0.15F, true).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
            Items.fishRaw = new IguanaFood(1, 0.05F, false).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
            Items.fishCooked = new IguanaFood(2, 0.1F, false).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
            Items.cookie = new IguanaFood(1, 0.05F, false).setUnlocalizedName("cookie").setTextureName("cookie");
            Items.melon = new IguanaFood(1, 0.05F, false).setUnlocalizedName("melon").setTextureName("melon");
            Items.beef = new IguanaFood(1, 0.05F, true).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
            Items.beefCooked = new IguanaFood(2, 0.15F, true).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
            Items.chicken = new IguanaFood(1, 0.05F, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.15F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
            Items.chickenCooked = new IguanaFood(2, 0.15F, true).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
            Items.rotten_flesh = new IguanaFood(1, 0.05F, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.4F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
            Items.bakedPotato = new IguanaFood(2, 0.15F, false).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
            Items.poisonousPotato = new IguanaFood(1, 0.05F, false).setPotionEffect(Potion.poison.id, 5, 0, 0.3F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
            Items.pumpkinPie = new IguanaFood(3, 0.15F, false).setUnlocalizedName("pumpkinPie").setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood);
            Items.bowlSoup = new IguanaFoodBowl(2, 0.1F, false).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
            Items.carrot = new IguanaSeedFood(1, 0.05F, Items.carrot, Blocks.farmland).setUnlocalizedName("carrots").setTextureName("carrot");
            Items.potato = new IguanaSeedFood(1, 0.05F, Items.potato, Blocks.farmland).setUnlocalizedName("potato").setTextureName("potato");
        }

    }

}
