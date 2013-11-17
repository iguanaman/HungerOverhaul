package iguanaman.hungeroverhaul;

import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaCropReed;
import iguanaman.hungeroverhaul.blocks.IguanaCropVegetable;
import iguanaman.hungeroverhaul.blocks.IguanaStem;
import iguanaman.hungeroverhaul.items.IguanaFood;
import iguanaman.hungeroverhaul.items.IguanaFoodBowl;
import iguanaman.hungeroverhaul.items.IguanaFoodPam;
import iguanaman.hungeroverhaul.items.IguanaFoodPamPotion;
import iguanaman.hungeroverhaul.items.IguanaSeedFood;
import iguanaman.hungeroverhaul.items.IguanaReed;
import iguanaman.hungeroverhaul.items.IguanaSeed;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.BiomeDictionary.Type;
import assets.pamharvestcraft.HarvestConfigurationHandler;
import assets.pamharvestcraft.ItemPam;
import assets.pamharvestcraft.ItemPamSeedFood;
import assets.pamharvestcraft.PamHarvestCraft;
import cpw.mods.fml.common.Loader;

public class ModuleVanilla {
    
    public static Block carrotNew;
    public static Block potatoNew;
    public static Block wheatNew;
    public static Block pumpkinStemNew;
    public static Block melonStemNew;
    public static Block reedNew;
    
	public static void init() {

    	//Base
    	Block.blocksList[Block.reed.blockID] = null;
    	reedNew = new IguanaCropReed(83).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("reeds").setTextureName("reeds");
        ModLoader.registerBlock(reedNew);
        Item.itemsList[Item.reed.itemID] = null;
        Item.reed = new IguanaReed(82, reedNew).setUnlocalizedName("reeds").setTextureName("reeds").setCreativeTab(CreativeTabs.tabMaterials);
        
    	Block.blocksList[Block.carrot.blockID] = null;
    	carrotNew = new IguanaCropVegetable(141, "carrots").setCropItem(Item.carrot.itemID).setSeedItem(Item.carrot.itemID).setUnlocalizedName("carrots").setTextureName("carrots");
        ModLoader.registerBlock(carrotNew);
        
    	Block.blocksList[Block.potato.blockID] = null;
    	potatoNew = new IguanaCropVegetable(142, "potatoes").setCropItem(Item.potato.itemID).setSeedItem(Item.potato.itemID).setUnlocalizedName("potatoes").setTextureName("potatoes");
        ModLoader.registerBlock(potatoNew);
        
    	Block.blocksList[Block.crops.blockID] = null;
    	wheatNew = new IguanaCrop(59, "crops").setCropItem(Item.wheat.itemID).setSeedItem(Item.seeds.itemID).setUnlocalizedName("crops").setTextureName("wheat");
        ModLoader.registerBlock(wheatNew);
        Item.itemsList[Item.seeds.itemID] = null;
        Item.seeds = (new IguanaSeed(39, Block.crops.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds").setTextureName("seeds_wheat");

    	Block.blocksList[Block.pumpkinStem.blockID] = null;
    	Block.blocksList[Block.melonStem.blockID] = null;
        pumpkinStemNew = (new IguanaStem(104, Block.pumpkin)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pumpkinStem").setTextureName("pumpkin_stem");
        melonStemNew = (new IguanaStem(105, Block.melon)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pumpkinStem").setTextureName("melon_stem");
        ModLoader.registerBlock(pumpkinStemNew);
        ModLoader.registerBlock(melonStemNew);
        Item.itemsList[Item.pumpkinSeeds.itemID] = null;
        Item.itemsList[Item.melonSeeds.itemID] = null;
        Item.pumpkinSeeds = (new IguanaSeed(105, Block.pumpkinStem.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds_pumpkin").setTextureName("seeds_pumpkin");
        Item.melonSeeds = (new IguanaSeed(106, Block.melonStem.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds_melon").setTextureName("seeds_melon");
		
        Item.itemsList[Item.appleRed.itemID] = null;
        Item.itemsList[Item.bread.itemID] = null;
        Item.itemsList[Item.porkRaw.itemID] = null;
        Item.itemsList[Item.porkCooked.itemID] = null;
        Item.itemsList[Item.fishRaw.itemID] = null;
        Item.itemsList[Item.fishCooked.itemID] = null;
        Item.itemsList[Item.cookie.itemID] = null;
        Item.itemsList[Item.melon.itemID] = null;
        Item.itemsList[Item.beefRaw.itemID] = null;
        Item.itemsList[Item.beefCooked.itemID] = null;
        Item.itemsList[Item.chickenRaw.itemID] = null;
        Item.itemsList[Item.chickenCooked.itemID] = null;
        Item.itemsList[Item.rottenFlesh.itemID] = null;
        Item.itemsList[Item.bakedPotato.itemID] = null;
        Item.itemsList[Item.poisonousPotato.itemID] = null;
        Item.itemsList[Item.pumpkinPie.itemID] = null;
        Item.itemsList[Item.bowlSoup.itemID] = null;
        Item.itemsList[Item.carrot.itemID] = null;
        Item.itemsList[Item.potato.itemID] = null;

		if(!Loader.isModLoaded("pamharvestcraft") || !IguanaConfig.modifyFoodValues)
		{
            Item.appleRed = (new IguanaFood(4, ((ItemFood)Item.appleRed).getHealAmount(), ((ItemFood)Item.appleRed).getSaturationModifier(), false)).setUnlocalizedName("apple").setTextureName("apple");
            Item.bread = (new IguanaFood(41, ((ItemFood)Item.bread).getHealAmount(), ((ItemFood)Item.bread).getSaturationModifier(), false)).setUnlocalizedName("bread").setTextureName("bread");
            Item.porkRaw = (new IguanaFood(63, ((ItemFood)Item.porkRaw).getHealAmount(), ((ItemFood)Item.porkRaw).getSaturationModifier(), true)).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
            Item.porkCooked = (new IguanaFood(64, ((ItemFood)Item.porkCooked).getHealAmount(), ((ItemFood)Item.porkCooked).getSaturationModifier(), true)).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
            Item.fishRaw = (new IguanaFood(93, ((ItemFood)Item.fishRaw).getHealAmount(), ((ItemFood)Item.fishRaw).getSaturationModifier(), false)).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
            Item.fishCooked = (new IguanaFood(94, ((ItemFood)Item.fishCooked).getHealAmount(), ((ItemFood)Item.fishCooked).getSaturationModifier(), false)).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
            Item.cookie = (new IguanaFood(101, ((ItemFood)Item.cookie).getHealAmount(), ((ItemFood)Item.cookie).getSaturationModifier(), false)).setUnlocalizedName("cookie").setTextureName("cookie");
            Item.melon = (new IguanaFood(104, ((ItemFood)Item.melon).getHealAmount(), ((ItemFood)Item.melon).getSaturationModifier(), false)).setUnlocalizedName("melon").setTextureName("melon");
            Item.beefRaw = (new IguanaFood(107, ((ItemFood)Item.beefRaw).getHealAmount(), ((ItemFood)Item.beefRaw).getSaturationModifier(), true)).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
            Item.beefCooked = (new IguanaFood(108, ((ItemFood)Item.beefCooked).getHealAmount(), ((ItemFood)Item.beefCooked).getSaturationModifier(), true)).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
            Item.chickenRaw = (new IguanaFood(109, ((ItemFood)Item.chickenRaw).getHealAmount(), ((ItemFood)Item.chickenRaw).getSaturationModifier(), true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
            Item.chickenCooked = (new IguanaFood(110, ((ItemFood)Item.chickenCooked).getHealAmount(), ((ItemFood)Item.chickenCooked).getSaturationModifier(), true)).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
            Item.rottenFlesh = (new IguanaFood(111, ((ItemFood)Item.rottenFlesh).getHealAmount(), ((ItemFood)Item.rottenFlesh).getSaturationModifier(), true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
            Item.bakedPotato = (new IguanaFood(137, ((ItemFood)Item.bakedPotato).getHealAmount(), ((ItemFood)Item.bakedPotato).getSaturationModifier(), false)).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
            Item.poisonousPotato = (new IguanaFood(138, ((ItemFood)Item.poisonousPotato).getHealAmount(), ((ItemFood)Item.poisonousPotato).getSaturationModifier(), false)).setPotionEffect(Potion.poison.id, 5, 0, 0.6F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
            Item.pumpkinPie = (new IguanaFood(144, ((ItemFood)Item.pumpkinPie).getHealAmount(), ((ItemFood)Item.pumpkinPie).getSaturationModifier(), false)).setUnlocalizedName("pumpkinPie").setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood);
            Item.bowlSoup = (new IguanaFoodBowl(26, ((ItemFood)Item.bowlSoup).getHealAmount(), ((ItemFood)Item.bowlSoup).getSaturationModifier(), false)).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
            Item.carrot = (new IguanaSeedFood(135, ((ItemFood)Item.carrot).getHealAmount(), ((ItemFood)Item.carrot).getSaturationModifier(), Block.carrot.blockID, Block.tilledField.blockID)).setUnlocalizedName("carrots").setTextureName("carrot");
            Item.potato = (new IguanaSeedFood(136, ((ItemFood)Item.potato).getHealAmount(), ((ItemFood)Item.potato).getSaturationModifier(), Block.potato.blockID, Block.tilledField.blockID)).setUnlocalizedName("potato").setTextureName("potato");
		}
		else
		{
            Item.appleRed = (new IguanaFood(4, 1, 0.05F, false)).setUnlocalizedName("apple").setTextureName("apple");
            Item.bread = (new IguanaFood(41, 3, 0.2F, false)).setUnlocalizedName("bread").setTextureName("bread");
            Item.porkRaw = (new IguanaFood(63, 1, 0.05F, true)).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
            Item.porkCooked = (new IguanaFood(64, 2, 0.15F, true)).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
            Item.fishRaw = (new IguanaFood(93, 1, 0.05F, false)).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
            Item.fishCooked = (new IguanaFood(94, 2, 0.1F, false)).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
            Item.cookie = (new IguanaFood(101, 1, 0.05F, false)).setUnlocalizedName("cookie").setTextureName("cookie");
            Item.melon = (new IguanaFood(104, 1, 0.05F, false)).setUnlocalizedName("melon").setTextureName("melon");
            Item.beefRaw = (new IguanaFood(107, 1, 0.05F, true)).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
            Item.beefCooked = (new IguanaFood(108, 2, 0.15F, true)).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
            Item.chickenRaw = (new IguanaFood(109, 1, 0.05F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.15F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
            Item.chickenCooked = (new IguanaFood(110, 2, 0.15F, true)).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
            Item.rottenFlesh = (new IguanaFood(111, 1, 0.05F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.4F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
            Item.bakedPotato = (new IguanaFood(137, 2, 0.15F, false)).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
            Item.poisonousPotato = (new IguanaFood(138, 1, 0.05F, false)).setPotionEffect(Potion.poison.id, 5, 0, 0.3F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
            Item.pumpkinPie = (new IguanaFood(144, 3, 0.15F, false)).setUnlocalizedName("pumpkinPie").setTextureName("pumpkin_pie").setCreativeTab(CreativeTabs.tabFood);
            Item.bowlSoup = (new IguanaFoodBowl(26, 2, 0.1F, false)).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
            Item.carrot = (new IguanaSeedFood(135, 1, 0.05F, Block.carrot.blockID, Block.tilledField.blockID)).setUnlocalizedName("carrots").setTextureName("carrot");
            Item.potato = (new IguanaSeedFood(136, 1, 0.05F, Block.potato.blockID, Block.tilledField.blockID)).setUnlocalizedName("potato").setTextureName("potato");
		}

	}

}
