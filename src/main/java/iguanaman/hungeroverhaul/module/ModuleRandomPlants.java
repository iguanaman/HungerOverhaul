package iguanaman.hungeroverhaul.module;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.pam.randomplants.randomplants;

import cpw.mods.fml.common.Loader;

public class ModuleRandomPlants {

	public static void init()
	{
		// Add Thaumcraft aspects
		if (Loader.isModLoaded("Thaumcraft"))
			// Flower
			if (!ThaumcraftApi.exists(Item.getItemFromBlock(randomplants.pamrandomPlant), -1))
				ThaumcraftApi.registerObjectTag(new ItemStack(randomplants.pamrandomPlant), new int[] {-1}, new AspectList().add(Aspect.PLANT, 1).add(Aspect.HUNGER, 1));
	}
}
