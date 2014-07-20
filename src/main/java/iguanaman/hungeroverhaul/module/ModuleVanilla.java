package iguanaman.hungeroverhaul.module;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.helper.FoodValueHelper;

public class ModuleVanilla
{
    public static void init()
    {
        if (Loader.isModLoaded("harvestcraft") || IguanaConfig.modifyFoodValues)
        {
            FoodValueHelper.addModifiedFoodValues(Items.apple, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.bread, new FoodValues(3, 0.2F));
            FoodValueHelper.addModifiedFoodValues(Items.porkchop, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_porkchop, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.fish, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_fished, new FoodValues(2, 0.1F));
            FoodValueHelper.addModifiedFoodValues(Items.cookie, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.melon, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.beef, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_beef, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.chicken, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.cooked_chicken, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.rotten_flesh, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.baked_potato, new FoodValues(2, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.poisonous_potato, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.pumpkin_pie, new FoodValues(3, 0.15F));
            FoodValueHelper.addModifiedFoodValues(Items.mushroom_stew, new FoodValues(2, 0.1F));
            FoodValueHelper.addModifiedFoodValues(Items.carrot, new FoodValues(1, 0.05F));
            FoodValueHelper.addModifiedFoodValues(Items.potato, new FoodValues(1, 0.05F));
        }
    }

    /*
    public static Block pumpkinStemNew;
    public static Block melonStemNew;
    public static Block reedNew;
    public static Block cocoaNew;

    public static void init ()
    {
        // BLOCKS
        String tempName;
        
        reedNew = new IguanaCropReed().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("reeds").setBlockTextureName("reeds");
        tempName = Block.blockRegistry.getNameForObject(Blocks.reeds);
        Blocks.reeds = reedNew;
        Utils.replace(Blocks.reeds, tempName);
        tempName = Item.itemRegistry.getNameForObject(Items.reeds);
        Items.reeds = new IguanaReed(reedNew).setUnlocalizedName("reeds").setTextureName("reeds").setCreativeTab(CreativeTabs.tabMaterials);
        Utils.replace(Items.reeds, tempName);

        tempName = Item.itemRegistry.getNameForObject(Items.wheat_seeds);
        Items.wheat_seeds = new IguanaSeed(Blocks.wheat, Blocks.farmland).setUnlocalizedName("seeds").setTextureName("seeds_wheat");
        Utils.replace(Items.wheat_seeds, tempName);

        pumpkinStemNew = new IguanaStem(Blocks.pumpkin).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("pumpkinStem").setBlockTextureName("pumpkin_stem");
        melonStemNew = new IguanaStem(Blocks.melon_block).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("pumpkinStem").setBlockTextureName("melon_stem");
        tempName = Block.blockRegistry.getNameForObject(Blocks.pumpkin_stem);
        Blocks.pumpkin_stem = pumpkinStemNew;
        Utils.replace(Blocks.pumpkin_stem, tempName);
        tempName = Block.blockRegistry.getNameForObject(Blocks.melon_stem);
        Blocks.melon_stem = melonStemNew;
        Utils.replace(Blocks.melon_stem, tempName);
        tempName = Item.itemRegistry.getNameForObject(Items.pumpkin_seeds);
        Items.pumpkin_seeds = new IguanaSeed(Blocks.pumpkin_stem, Blocks.farmland).setUnlocalizedName("seeds_pumpkin").setTextureName("seeds_pumpkin");
        Utils.replace(Items.pumpkin_seeds, tempName);
        tempName = Item.itemRegistry.getNameForObject(Items.melon_seeds);
        Items.melon_seeds = new IguanaSeed(Blocks.melon_stem, Blocks.farmland).setUnlocalizedName("seeds_melon").setTextureName("seeds_melon");
        Utils.replace(Items.melon_seeds, tempName);

        cocoaNew = new IguanaCocoa().setHardness(0.2F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("cocoa").setBlockTextureName("cocoa");
        tempName = Block.blockRegistry.getNameForObject(Blocks.cocoa);
        Blocks.cocoa = cocoaNew;
        Utils.replace(Blocks.cocoa, tempName);
    }*/
}
