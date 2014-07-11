package iguanaman.hungeroverhaul;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;

@Mod(modid="HungerOverhaul", name="Hunger Overhaul", version="${version}", dependencies = "after:TConstruct;after:pamharvestcraft;after:temperateplants;after:randomplants;after:weeeflowers;after:Natura")
public class HungerOverhaul {

	// The instance of your mod that Forge uses.
	@Instance("HungerOverhaul")
	public static HungerOverhaul instance;
	
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

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		if (IguanaConfig.addSetHungerCommand)
		{
			ICommandManager commandManager = FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager();
			ServerCommandManager serverCommandManager = (ServerCommandManager) commandManager;
			serverCommandManager.registerCommand(new IguanaCommandHunger());
		}
	}
	*/
}