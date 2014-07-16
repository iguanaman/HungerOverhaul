package iguanaman.hungeroverhaul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import iguanaman.hungeroverhaul.api.FoodModifierRegistry;
import iguanaman.hungeroverhaul.commands.IguanaCommandHunger;
import iguanaman.hungeroverhaul.food.FoodEventHandler;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import iguanaman.hungeroverhaul.module.ModuleVanilla;

@Mod(modid = "HungerOverhaul", name = "Hunger Overhaul", version = "${version}", dependencies = "required-after:HO-Core;after:TConstruct;after:harvestcraft;after:temperateplants;after:randomplants;after:weeeflowers;after:Natura")
public class HungerOverhaul
{
	public static final Logger Log = LogManager.getLogger("HungerOverhaul");

	// The instance of your mod that Forge uses.
	@Instance("HungerOverhaul")
	public static HungerOverhaul instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		IguanaConfig.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new FoodEventHandler());
        ModuleVanilla.init();
        FoodModifierRegistry.registerFoodValueModifier(new ModuleVanilla());
	}

	/*
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="iguanaman.hungeroverhaul.proxy.ClientProxy", serverSide="iguanaman.hungeroverhaul.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		IguanaConfig.init(event.getSuggestedConfigurationFile());

		potionWellFed = new PotionWellFed();

		if (IguanaConfig.removeHoeRecipes) {
			RecipeRemover.removeAnyRecipe(new ItemStack(Items.wooden_hoe));
			RecipeRemover.removeAnyRecipe(new ItemStack(Items.stone_hoe));
		}

	}

	@SuppressWarnings({ "unchecked" })
	@EventHandler
	public void load(FMLInitializationEvent event) {

		if (IguanaConfig.addCustomVillageField && IguanaConfig.fieldNormalWeight + IguanaConfig.fieldReedWeight + IguanaConfig.fieldStemWeight > 0)
		{
			MapGenStructureIO.func_143031_a(ComponentVillageCustomField.class, "IguanaField");
			VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerCustomField());
		}

		//RECIPES
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.wheat_seeds, Items.wheat));

		ModuleVanilla.init();
		if(Loader.isModLoaded("harvestcraft")) { PamsModsHelper.loadHC(); ModuleHarvestCraftCrops.init(); ModuleHarvestCraftTrees.init(); }
		if(Loader.isModLoaded("temperateplants")) ModuleTemperatePlants.init();
		if(Loader.isModLoaded("randomplants")) ModuleRandomPlants.init();
		if(Loader.isModLoaded("weeeflowers")) { PamsModsHelper.loadWF(); ModuleWeeeFlowers.init(); };
		if(Loader.isModLoaded("TConstruct")) ModuleTConstruct.init();
		if(Loader.isModLoaded("Natura")) ModuleNatura.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		if (IguanaConfig.removeTallGrassSeeds || IguanaConfig.allSeedsEqual) ModuleGrassSeeds.init();
		FMLCommonHandler.instance().bus().register(new IguanaPlayerHandler());
		MinecraftForge.EVENT_BUS.register(new IguanaEventHook());

	}
	*/

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		if (IguanaConfig.addSetHungerCommand)
		{
			event.registerServerCommand(new IguanaCommandHunger());
		}
	}
}