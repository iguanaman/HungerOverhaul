package iguanaman.hungeroverhaul;

import iguanaman.hungeroverhaul.commands.IguanaCommandHunger;
import iguanaman.hungeroverhaul.util.IguanaEventHook;
import iguanaman.hungeroverhaul.util.IguanaPlayerHandler;
import iguanaman.hungeroverhaul.util.VillageHandlerCustomField;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.potion.Potion;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.modstats.ModstatInfo;
import org.modstats.Modstats;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid="HungerOverhaul", name="Hunger Overhaul", version="1.6.X-2l",
dependencies = "after:TConstruct;after:pamharvestcraft;after:pamtemperateplants;after:pamrandomplants;after:pamweeeflowers;after:Natura;after:Thaumcraft")
@ModstatInfo(prefix="hngrovrhl")

public class HungerOverhaul {

	// The instance of your mod that Forge uses.
	@Instance("HungerOverhaul")
	public static HungerOverhaul instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="iguanaman.hungeroverhaul.ClientProxy", serverSide="iguanaman.hungeroverhaul.CommonProxy")
	public static CommonProxy proxy;

	public static IguanaPlayerHandler playerTracker;
	public static Potion potionWellFed;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		IguanaConfig.init(event.getSuggestedConfigurationFile());

		potionWellFed = new Potion(IguanaConfig.wellFedId, false, 0).setIconIndex(7, 0).setPotionName("potion.wellfedPotion");

		if (IguanaConfig.removeHoeRecipes) {
			RecipeRemover.removeAnyRecipe(new ItemStack(Items.wooden_hoe));
			RecipeRemover.removeAnyRecipe(new ItemStack(Items.stone_hoe));
		}

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Modstats.instance().getReporter().registerMod(this);
		proxy.registerLocalization();

		if (IguanaConfig.addCustomVillageField && IguanaConfig.fieldNormalWeight + IguanaConfig.fieldReedWeight + IguanaConfig.fieldStemWeight > 0)
		{
			MapGenStructureIO.func_143031_a(ComponentVillageCustomField.class, "IguanaField");
			VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerCustomField());
		}

		//RECIPES
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.wheat_seeds, Items.wheat));

		ModuleVanilla.init();
		if(Loader.isModLoaded("pamharvestcraft")) { ModuleHarvestCraftCrops.init(); ModuleHarvestCraftTrees.init(); }
		if(Loader.isModLoaded("pamtemperateplants")) ModuleTemperatePlants.init();
		if(Loader.isModLoaded("pamrandomplants")) ModuleRandomPlants.init();
		if(Loader.isModLoaded("pamweeeflowers")) ModuleWeeeFlowers.init();
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
}