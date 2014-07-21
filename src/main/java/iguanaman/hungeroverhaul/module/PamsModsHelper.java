package iguanaman.hungeroverhaul.module;

import java.util.HashMap;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.pam.harvestcraft.BlockRegistry;
import com.pam.weeeflowers.weeeflowers;

import cpw.mods.fml.common.Loader;

public class PamsModsHelper {

	public static Block[] PamCrops;
	public static Block[] PamFlowerCrops;
	public static Item[] PamFlowerSeeds;
	
	public static HashMap<Block, Integer> crops = Maps.newHashMap();

	public static void loadHC() {
		if(Loader.isModLoaded("harvestcraft")) {
			PamCrops = new Block[] {
					BlockRegistry.pamblackberryCrop, BlockRegistry.pamblueberryCrop, BlockRegistry.pamcandleberryCrop, BlockRegistry.pamraspberryCrop, BlockRegistry.pamstrawberryCrop,
					BlockRegistry.pamcactusfruitCrop, BlockRegistry.pamasparagusCrop, BlockRegistry.pambarleyCrop, BlockRegistry.pamoatsCrop, BlockRegistry.pamryeCrop,
					BlockRegistry.pamcornCrop, BlockRegistry.pambambooshootCrop, BlockRegistry.pamcantaloupeCrop, BlockRegistry.pamcucumberCrop, BlockRegistry.pamwintersquashCrop,
					BlockRegistry.pamzucchiniCrop, BlockRegistry.pambeetCrop, BlockRegistry.pamonionCrop, BlockRegistry.pamparsnipCrop, BlockRegistry.pampeanutCrop,
					BlockRegistry.pamradishCrop, BlockRegistry.pamrutabagaCrop, BlockRegistry.pamsweetpotatoCrop, BlockRegistry.pamturnipCrop, BlockRegistry.pamrhubarbCrop,
					BlockRegistry.pamceleryCrop, BlockRegistry.pamgarlicCrop, BlockRegistry.pamgingerCrop, BlockRegistry.pamspiceleafCrop, BlockRegistry.pamtealeafCrop,
					BlockRegistry.pamcoffeebeanCrop, BlockRegistry.pammustardseedsCrop, BlockRegistry.pambroccoliCrop, BlockRegistry.pamcauliflowerCrop, BlockRegistry.pamleekCrop,
					BlockRegistry.pamlettuceCrop, BlockRegistry.pamscallionCrop, BlockRegistry.pamartichokeCrop, BlockRegistry.pambrusselsproutCrop, BlockRegistry.pamcabbageCrop,
					BlockRegistry.pamwhitemushroomCrop, BlockRegistry.pambeanCrop, BlockRegistry.pamsoybeanCrop, BlockRegistry.pambellpepperCrop, BlockRegistry.pamchilipepperCrop,
					BlockRegistry.pameggplantCrop, BlockRegistry.pamokraCrop, BlockRegistry.pampeasCrop, BlockRegistry.pamtomatoCrop, BlockRegistry.pamcottonCrop,
					BlockRegistry.pampineappleCrop, BlockRegistry.pamgrapeCrop, BlockRegistry.pamkiwiCrop, BlockRegistry.pamcranberryCrop, BlockRegistry.pamriceCrop, BlockRegistry.pamseaweedCrop
			};
			
			crops.put(BlockRegistry.pamasparagusCrop, 0);
			crops.put(BlockRegistry.pambarleyCrop, 1);
			crops.put(BlockRegistry.pambeanCrop, 2);
			crops.put(BlockRegistry.pambeetCrop, 3);
			crops.put(BlockRegistry.pambroccoliCrop, 4);
			crops.put(BlockRegistry.pamcauliflowerCrop, 5);
			crops.put(BlockRegistry.pamceleryCrop, 6);
			crops.put(BlockRegistry.pamcranberryCrop, 7);
			crops.put(BlockRegistry.pamgarlicCrop, 8);
			crops.put(BlockRegistry.pamgingerCrop, 9);
			crops.put(BlockRegistry.pamleekCrop, 10);
			crops.put(BlockRegistry.pamlettuceCrop, 11);
			crops.put(BlockRegistry.pamoatsCrop, 12);
			crops.put(BlockRegistry.pamonionCrop, 13);
			crops.put(BlockRegistry.pamparsnipCrop, 14);
			crops.put(BlockRegistry.pampeanutCrop, 15);
			crops.put(BlockRegistry.pampineappleCrop, 16);
			crops.put(BlockRegistry.pamradishCrop, 17);
			crops.put(BlockRegistry.pamriceCrop, 18);
			crops.put(BlockRegistry.pamrutabagaCrop, 19);
			crops.put(BlockRegistry.pamryeCrop, 20);
			crops.put(BlockRegistry.pamscallionCrop, 21);
			crops.put(BlockRegistry.pamsoybeanCrop, 22);
			crops.put(BlockRegistry.pamspiceleafCrop, 23);
			crops.put(BlockRegistry.pamsweetpotatoCrop, 24);
			crops.put(BlockRegistry.pamtealeafCrop, 25);
			crops.put(BlockRegistry.pamturnipCrop, 26);
			crops.put(BlockRegistry.pamwhitemushroomCrop, 27);
			crops.put(BlockRegistry.pamartichokeCrop, 28);
			crops.put(BlockRegistry.pambellpepperCrop, 29);
			crops.put(BlockRegistry.pamblackberryCrop, 30);
			crops.put(BlockRegistry.pamblueberryCrop, 31);
			crops.put(BlockRegistry.pambrusselsproutCrop, 32);
			crops.put(BlockRegistry.pamcabbageCrop, 33);
			crops.put(BlockRegistry.pamcactusfruitCrop, 34);
			crops.put(BlockRegistry.pamcandleberryCrop, 35);
			crops.put(BlockRegistry.pamcantaloupeCrop, 36);
			crops.put(BlockRegistry.pamchilipepperCrop, 37);
			crops.put(BlockRegistry.pamcoffeebeanCrop, 38);
			crops.put(BlockRegistry.pamcornCrop, 39);
			crops.put(BlockRegistry.pamcottonCrop, 40);
			crops.put(BlockRegistry.pamcucumberCrop, 41);
			crops.put(BlockRegistry.pameggplantCrop, 42);
			crops.put(BlockRegistry.pamgrapeCrop, 43);
			crops.put(BlockRegistry.pamkiwiCrop, 44);
			crops.put(BlockRegistry.pammustardseedsCrop, 45);
			crops.put(BlockRegistry.pamokraCrop, 46);
			crops.put(BlockRegistry.pampeasCrop, 47);
			crops.put(BlockRegistry.pamraspberryCrop, 48);
			crops.put(BlockRegistry.pamrhubarbCrop, 49);
			crops.put(BlockRegistry.pamseaweedCrop, 50);
			crops.put(BlockRegistry.pamstrawberryCrop, 51);
			crops.put(BlockRegistry.pamtomatoCrop, 52);
			crops.put(BlockRegistry.pamwintersquashCrop, 53);
			crops.put(BlockRegistry.pamzucchiniCrop, 54);
			crops.put(BlockRegistry.pambambooshootCrop, 55);
		}
	}

	public static void loadWF() {
		if(Loader.isModLoaded("weeeflowers")) {
			PamFlowerCrops = new Block[] {
					weeeflowers.pamwhiteflowerCrop, weeeflowers.pamorangeflowerCrop, weeeflowers.pammagentaflowerCrop, weeeflowers.pamlightblueflowerCrop, weeeflowers.pamyellowflowerCrop,
					weeeflowers.pamlimeflowerCrop, weeeflowers.pampinkflowerCrop, weeeflowers.pamlightgreyflowerCrop, weeeflowers.pamdarkgreyflowerCrop, weeeflowers.pamcyanflowerCrop,
					weeeflowers.pampurpleflowerCrop, weeeflowers.pamblueflowerCrop, weeeflowers.pambrownflowerCrop, weeeflowers.pamgreenflowerCrop, weeeflowers.pamredflowerCrop, weeeflowers.pamblackflowerCrop
			};

			PamFlowerSeeds = new Item[] {
					weeeflowers.whiteflowerseedItem, weeeflowers.orangeflowerseedItem, weeeflowers.magentaflowerseedItem, weeeflowers.lightblueflowerseedItem, weeeflowers.yellowflowerseedItem,
					weeeflowers.limeflowerseedItem, weeeflowers.pinkflowerseedItem, weeeflowers.lightgreyflowerseedItem, weeeflowers.darkgreyflowerseedItem, weeeflowers.cyanflowerseedItem,
					weeeflowers.purpleflowerseedItem, weeeflowers.blueflowerseedItem, weeeflowers.brownflowerseedItem, weeeflowers.greenflowerseedItem, weeeflowers.redflowerseedItem, weeeflowers.blackflowerseedItem	
			};
		}
	}
}
