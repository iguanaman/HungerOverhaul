package iguanaman.hungeroverhaul;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import assets.pamrandomplants.PamRandomPlants;
import cpw.mods.fml.common.Loader;

public class ModuleRandomPlants {

	public static void init()
	{

		// Add Thaumcraft aspects
		if (Loader.isModLoaded("Thaumcraft"))
			// Flower
			if (!ThaumcraftApi.exists(PamRandomPlants.pamrandomPlant.blockID, -1))
				ThaumcraftApi.registerObjectTag(PamRandomPlants.pamrandomPlant.blockID, -1,
						new AspectList().add(Aspect.PLANT, 1).add(Aspect.HUNGER, 1)
						);

	}

}
