package iguanaman.hungeroverhaul.module;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import iguanaman.hungeroverhaul.api.FoodValues;
import iguanaman.hungeroverhaul.food.FoodModifier;

public class ModuleVanilla extends FoodModifier
{
    @Override
    public FoodValues getModifiedFoodValues(FoodValues foodValues, ItemStack itemStack) {
        Item item = itemStack.getItem();
        if(item == Items.apple) {
            return new FoodValues(1, 0.05F);
        } else if(item == Items.bread) {

        }
        return null;
    }

    /*public static Block carrotNew;
    public static Block potatoNew;
    public static Block wheatNew;
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

        carrotNew = new IguanaCropVegetable("carrots").setCropItem(Items.carrot).setSeedItem(Items.carrot).setBlockName("carrots").setBlockTextureName("carrots");
        tempName = Block.blockRegistry.getNameForObject(Blocks.carrots);
        Blocks.carrots = carrotNew;
        Utils.replace(Blocks.carrots, tempName);
        
        potatoNew = new IguanaCropVegetable("potatoes").setCropItem(Items.potato).setSeedItem(Items.potato).setBlockName("potatoes").setBlockTextureName("potatoes");
        tempName = Block.blockRegistry.getNameForObject(Blocks.potatoes);
        Blocks.potatoes = potatoNew;
        Utils.replace(Blocks.potatoes, tempName);

        wheatNew = new IguanaCrop("crops").setCropItem(Items.wheat).setSeedItem(Items.wheat_seeds).setBlockName("crops").setBlockTextureName("wheat");
        tempName = Block.blockRegistry.getNameForObject(Blocks.wheat);
        Blocks.wheat = wheatNew;
        Utils.replace(Blocks.wheat, tempName);
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

        // ITEMS
        if (!Loader.isModLoaded("harvestcraft") || !IguanaConfig.modifyFoodValues)
        {
        	tempName = Item.itemRegistry.getNameForObject(Items.apple);
        	Items.apple = new IguanaFood(((ItemFood) Items.apple).func_150905_g(null), ((ItemFood) Items.apple).func_150906_h(null), false).setUnlocalizedName("apple").setTextureName("apple");
        	Utils.replace(Items.apple, tempName);
        	
        	tempName = Item.itemRegistry.getNameForObject(Items.bread);
            Items.bread = new IguanaFood(((ItemFood) Items.bread).func_150905_g(null), ((ItemFood) Items.bread).func_150906_h(null), false).setUnlocalizedName("bread").setTextureName("bread");
            Utils.replace(Items.bread, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.porkchop);
            Items.porkchop = new IguanaFood(((ItemFood) Items.porkchop).func_150905_g(null), ((ItemFood) Items.porkchop).func_150906_h(null), true).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
            Utils.replace(Items.porkchop, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.cooked_porkchop);
            Items.cooked_porkchop = new IguanaFood(((ItemFood) Items.cooked_porkchop).func_150905_g(null), ((ItemFood) Items.cooked_porkchop).func_150906_h(null), true).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
            Utils.replace(Items.cooked_porkchop, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.fish);
            Items.fish = new IguanaFood(((ItemFood) Items.fish).func_150905_g(null), ((ItemFood) Items.fish).func_150906_h(null), false).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
            Utils.replace(Items.fish, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.cooked_fished);
            Items.cooked_fished = new IguanaFood(((ItemFood) Items.cooked_fished).func_150905_g(null), ((ItemFood) Items.cooked_fished).func_150906_h(null), false).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
            Utils.replace(Items.cooked_fished, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.cookie);
            Items.cookie = new IguanaFood(((ItemFood) Items.cookie).func_150905_g(null), ((ItemFood) Items.cookie).func_150906_h(null), false).setUnlocalizedName("cookie").setTextureName("cookie");
            Utils.replace(Items.cookie, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.melon);
            Items.melon = new IguanaFood(((ItemFood) Items.melon).func_150905_g(null), ((ItemFood) Items.melon).func_150906_h(null), false).setUnlocalizedName("melon").setTextureName("melon");
            Utils.replace(Items.melon, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.beef);
            Items.beef = new IguanaFood(((ItemFood) Items.beef).func_150905_g(null), ((ItemFood) Items.beef).func_150906_h(null), true).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
            Utils.replace(Items.beef, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.cooked_beef);
            Items.cooked_beef = new IguanaFood(((ItemFood) Items.cooked_beef).func_150905_g(null), ((ItemFood) Items.cooked_beef).func_150906_h(null), true).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
            Utils.replace(Items.cooked_beef, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.chicken);
            Items.chicken = new IguanaFood(((ItemFood) Items.chicken).func_150905_g(null), ((ItemFood) Items.chicken).func_150906_h(null), true).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
            Utils.replace(Items.chicken, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.cooked_chicken);
            Items.cooked_chicken = new IguanaFood(((ItemFood) Items.cooked_chicken).func_150905_g(null), ((ItemFood) Items.cooked_chicken).func_150906_h(null), true).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
            Utils.replace(Items.cooked_chicken, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.rotten_flesh);
            Items.rotten_flesh = new IguanaFood(((ItemFood) Items.rotten_flesh).func_150905_g(null), ((ItemFood) Items.rotten_flesh).func_150906_h(null), true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
            Utils.replace(Items.rotten_flesh, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.baked_potato);
            Items.baked_potato = new IguanaFood(((ItemFood) Items.baked_potato).func_150905_g(null), ((ItemFood) Items.baked_potato).func_150906_h(null), false).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
            Utils.replace(Items.baked_potato, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.poisonous_potato);
            Items.poisonous_potato = new IguanaFood(((ItemFood) Items.poisonous_potato).func_150905_g(null), ((ItemFood) Items.poisonous_potato).func_150906_h(null), false).setPotionEffect(Potion.poison.id, 5, 0, 0.6F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
            Utils.replace(Items.poisonous_potato, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.pumpkin_pie);
            Items.pumpkin_pie = new IguanaFood(((ItemFood) Items.pumpkin_pie).func_150905_g(null), ((ItemFood) Items.pumpkin_pie).func_150906_h(null), false).setUnlocalizedName("pumpkinPie").setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood);
            Utils.replace(Items.pumpkin_pie, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.mushroom_stew);
            Items.mushroom_stew = new IguanaFoodBowl(((ItemFood) Items.mushroom_stew).func_150905_g(null), ((ItemFood) Items.mushroom_stew).func_150906_h(null), false).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
            Utils.replace(Items.mushroom_stew, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.carrot);
            Items.carrot = new IguanaSeedFood(((ItemFood) Items.carrot).func_150905_g(null), ((ItemFood) Items.carrot).func_150906_h(null), Blocks.carrots, Blocks.farmland).setUnlocalizedName("carrots").setTextureName("carrot");
            Utils.replace(Items.carrot, tempName);
            
            tempName = Item.itemRegistry.getNameForObject(Items.potato);
            Items.potato = new IguanaSeedFood(((ItemFood) Items.potato).func_150905_g(null), ((ItemFood) Items.potato).func_150906_h(null), Blocks.potatoes, Blocks.farmland).setUnlocalizedName("potato").setTextureName("potato");
            Utils.replace(Items.potato, tempName);
        }
        else
        {
        	tempName = Item.itemRegistry.getNameForObject(Items.apple);
			Items.apple = new IguanaFood(1, 0.05F, false).setUnlocalizedName("apple").setTextureName("apple");
        	Utils.replace(Items.apple, tempName);

        	tempName = Item.itemRegistry.getNameForObject(Items.bread);
			Items.bread = new IguanaFood(3, 0.2F, false).setUnlocalizedName("bread").setTextureName("bread");
            Utils.replace(Items.bread, tempName);

            tempName = Item.itemRegistry.getNameForObject(Items.porkchop);
			Items.porkchop = new IguanaFood(1, 0.05F, true).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
            Utils.replace(Items.porkchop, tempName);

            tempName = Item.itemRegistry.getNameForObject(Items.cooked_porkchop);
			Items.cooked_porkchop = new IguanaFood(2, 0.15F, true).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
            Utils.replace(Items.cooked_porkchop, tempName);

            tempName = Item.itemRegistry.getNameForObject(Items.fish);
			Items.fish = new IguanaFood(1, 0.05F, false).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
            Utils.replace(Items.fish, tempName);

            tempName = Item.itemRegistry.getNameForObject(Items.cooked_fished);
			Items.cooked_fished = new IguanaFood(2, 0.1F, false).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
			Utils.replace(Items.cooked_fished, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.cookie);
			Items.cookie = new IguanaFood(1, 0.05F, false).setUnlocalizedName("cookie").setTextureName("cookie");
			Utils.replace(Items.cookie, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.melon);
			Items.melon = new IguanaFood(1, 0.05F, false).setUnlocalizedName("melon").setTextureName("melon");
			Utils.replace(Items.melon, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.beef);
			Items.beef = new IguanaFood(1, 0.05F, true).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
			Utils.replace(Items.beef, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.cooked_beef);
			Items.cooked_beef = new IguanaFood(2, 0.15F, true).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
			Utils.replace(Items.cooked_beef, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.chicken);
			Items.chicken = new IguanaFood(1, 0.05F, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.15F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
			Utils.replace(Items.chicken, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.cooked_chicken);
			Items.cooked_chicken = new IguanaFood(2, 0.15F, true).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
			Utils.replace(Items.cooked_chicken, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.rotten_flesh);
			Items.rotten_flesh = new IguanaFood(1, 0.05F, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.4F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
			Utils.replace(Items.rotten_flesh, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.baked_potato);
			Items.baked_potato = new IguanaFood(2, 0.15F, false).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
			Utils.replace(Items.baked_potato, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.poisonous_potato);
			Items.poisonous_potato = new IguanaFood(1, 0.05F, false).setPotionEffect(Potion.poison.id, 5, 0, 0.3F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
			Utils.replace(Items.poisonous_potato, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.pumpkin_pie);
			Items.pumpkin_pie = new IguanaFood(3, 0.15F, false).setUnlocalizedName("pumpkinPie").setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood);
			Utils.replace(Items.pumpkin_pie, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.mushroom_stew);
			Items.mushroom_stew = new IguanaFoodBowl(2, 0.1F, false).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
			Utils.replace(Items.mushroom_stew, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.carrot);
			Items.carrot = new IguanaSeedFood(1, 0.05F, Blocks.carrots, Blocks.farmland).setUnlocalizedName("carrots").setTextureName("carrot");
			Utils.replace(Items.carrot, tempName);
			
			tempName = Item.itemRegistry.getNameForObject(Items.potato);
			Items.potato = new IguanaSeedFood(1, 0.05F, Blocks.potatoes, Blocks.farmland).setUnlocalizedName("potato").setTextureName("potato");
			Utils.replace(Items.potato, tempName);
        }
    }*/
}
