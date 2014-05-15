package iguanaman.hungeroverhaul.module;

import net.minecraft.block.Block;

import com.pam.harvestcraft.BlockRegistry;

import cpw.mods.fml.common.Loader;

public class HarvestCraftHelper {

	public static Block[] PamCrops;

	public static void load() {
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
}
