package iguanaman.hungeroverhaul;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import assets.pamtemperateplants.PamTemperatePlants;
import cpw.mods.fml.common.Loader;

public class ModuleTemperatePlants {
	public static void init()
	{

		// Add Thaumcraft aspects
		if (Loader.isModLoaded("Thaumcraft"))
			if (!ThaumcraftApi.exists(PamTemperatePlants.pamtemperatePlant.blockID, -1))
			{
				AspectList flowerAspects = new AspectList().add(Aspect.PLANT, 1);
				ThaumcraftApi.registerObjectTag(PamTemperatePlants.pamtemperatePlant.blockID, -1, flowerAspects);
			}

	}

}
