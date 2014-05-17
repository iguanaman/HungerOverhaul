package iguanaman.hungeroverhaul.module;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.pam.harvestcraft.BlockRegistry;
import com.pam.weeeflowers.weeeflowers;

import cpw.mods.fml.common.Loader;

public class PamsModsHelper {

	public static Block[] PamCrops;
	public static Block[] PamFlowerCrops;
	public static Item[] PamFlowerSeeds;

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
