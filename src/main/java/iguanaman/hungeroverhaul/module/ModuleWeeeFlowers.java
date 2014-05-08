package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.blocks.IguanaCropPamFlower;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import assets.pamweeeflowers.PamWeeeFlowers;
import cpw.mods.fml.common.Loader;

public class ModuleWeeeFlowers {

	public static void init()
	{

		// Overwrite flower crop block
		Block.blocksList[PamWeeeFlowers.pamflowerCrop.blockID] = null;
		PamWeeeFlowers.pamflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.flowercropID).setUnlocalizedName("flowerCrop");

		// Add Thaumcraft aspects
		if (Loader.isModLoaded("Thaumcraft"))
			// Flower seeds
			for(Item flowerSeed : PamWeeeFlowers.PamFlowerSeeds)
				if (!ThaumcraftApi.exists(flowerSeed.itemID, -1)) ThaumcraftApi.registerObjectTag(flowerSeed.itemID, -1, new AspectList().add(Aspect.SEED, 1));

		// Flower blocks
		Block[] flowers = new Block[]
				{
				PamWeeeFlowers.pamwhiteflowerVine, PamWeeeFlowers.pamorangeflowerVine, PamWeeeFlowers.pammagentaflowerVine,
				PamWeeeFlowers.pamlightblueflowerVine, PamWeeeFlowers.pamyellowflowerVine, PamWeeeFlowers.pamlimeflowerVine,
				PamWeeeFlowers.pampinkflowerVine, PamWeeeFlowers.pamlightgreyflowerVine, PamWeeeFlowers.pamdarkgreyflowerVine,
				PamWeeeFlowers.pamcyanflowerVine, PamWeeeFlowers.pampurpleflowerVine, PamWeeeFlowers.pamblueflowerVine,
				PamWeeeFlowers.pambrownflowerVine, PamWeeeFlowers.pamgreenflowerVine, PamWeeeFlowers.pamredflowerVine,
				PamWeeeFlowers.pamblackflowerVine, PamWeeeFlowers.pamFlower, PamWeeeFlowers.pammoonFlower
				};

		AspectList flowerAspects = new AspectList().add(Aspect.PLANT, 1);

		for(Block flower : flowers)
			if (!ThaumcraftApi.exists(flower.blockID, -1))
				ThaumcraftApi.registerObjectTag(flower.blockID, -1, flowerAspects);

	}

}
