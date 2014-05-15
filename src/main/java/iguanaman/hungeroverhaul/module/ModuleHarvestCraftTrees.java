package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.blocks.IguanaFruit;
import iguanaman.hungeroverhaul.util.Utils;

import com.pam.harvestcraft.BlockRegistry;

public class ModuleHarvestCraftTrees {

	public static void init()
	{
		Utils.replace(BlockRegistry.pamApple, new IguanaFruit("apple"));
		Utils.replace(BlockRegistry.pamAvocado, new IguanaFruit("avocado"));
		Utils.replace(BlockRegistry.pamBanana, new IguanaFruit("banana"));
		Utils.replace(BlockRegistry.pamCherry, new IguanaFruit("cherry"));
		Utils.replace(BlockRegistry.pamCinnamon, new IguanaFruit("cinnamon"));
		Utils.replace(BlockRegistry.pamCoconut, new IguanaFruit("coconut"));
		Utils.replace(BlockRegistry.pamDragonfruit, new IguanaFruit("dragonfruit"));
		Utils.replace(BlockRegistry.pamLemon, new IguanaFruit("lemon"));
		Utils.replace(BlockRegistry.pamLime, new IguanaFruit("lime"));
		Utils.replace(BlockRegistry.pamMango, new IguanaFruit("mango"));
		Utils.replace(BlockRegistry.pamNutmeg, new IguanaFruit("nutmeg"));
		Utils.replace(BlockRegistry.pamOlive, new IguanaFruit("olive"));
		Utils.replace(BlockRegistry.pamOrange, new IguanaFruit("orange"));
		Utils.replace(BlockRegistry.pamPapaya, new IguanaFruit("papaya"));
		Utils.replace(BlockRegistry.pamPeach, new IguanaFruit("peach"));
		Utils.replace(BlockRegistry.pamPear, new IguanaFruit("pear"));
		Utils.replace(BlockRegistry.pamPeppercorn, new IguanaFruit("peppercorn"));
		Utils.replace(BlockRegistry.pamPlum, new IguanaFruit("plum"));
		Utils.replace(BlockRegistry.pamPomegranate, new IguanaFruit("pomegranate"));
		Utils.replace(BlockRegistry.pamStarfruit, new IguanaFruit("starfruit"));
		Utils.replace(BlockRegistry.pamVanillabean, new IguanaFruit("vanillabean"));
		Utils.replace(BlockRegistry.pamWalnut, new IguanaFruit("walnut"));
	}
}
