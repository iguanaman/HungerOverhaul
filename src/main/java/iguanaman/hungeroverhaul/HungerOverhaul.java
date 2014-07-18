package iguanaman.hungeroverhaul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import iguanaman.hungeroverhaul.api.FoodModifierRegistry;
import iguanaman.hungeroverhaul.commands.IguanaCommandHunger;
import iguanaman.hungeroverhaul.food.FoodEventHandler;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.module.ModuleGrassSeeds;
import iguanaman.hungeroverhaul.module.ModuleTConstruct;
import iguanaman.hungeroverhaul.module.ModuleVanilla;
import iguanaman.hungeroverhaul.potion.PotionWellFed;
import iguanaman.hungeroverhaul.util.IguanaEventHook;
import iguanaman.hungeroverhaul.util.RecipeRemover;
import iguanaman.hungeroverhaul.util.StackSizeTweaks;

@Mod(modid = "HungerOverhaul", name = "Hunger Overhaul", version = "${version}", dependencies = "required-after:HO-Core;after:TConstruct;after:harvestcraft;after:temperateplants;after:randomplants;after:weeeflowers;after:Natura")
public class HungerOverhaul
{
	public static final Logger Log = LogManager.getLogger("HungerOverhaul");

	// The instance of your mod that Forge uses.
	@Instance("HungerOverhaul")
	public static HungerOverhaul instance;

    public static Potion potionWellFed;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		IguanaConfig.init(event.getSuggestedConfigurationFile());

        potionWellFed = new PotionWellFed();

        if (IguanaConfig.removeHoeRecipes) {
            RecipeRemover.removeAnyRecipe(new ItemStack(Items.wooden_hoe));
            RecipeRemover.removeAnyRecipe(new ItemStack(Items.stone_hoe));
        }
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
        //RECIPES
        GameRegistry.addRecipe(new ShapelessOreRecipe(Items.wheat_seeds, Items.wheat));

		MinecraftForge.EVENT_BUS.register(new FoodEventHandler());
        ModuleVanilla.init();
        ModuleTConstruct.init();
        FoodModifierRegistry.registerFoodValueModifier(new FoodModifier());
	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        if (IguanaConfig.removeTallGrassSeeds || IguanaConfig.allSeedsEqual) ModuleGrassSeeds.init();
        StackSizeTweaks.init();
        MinecraftForge.EVENT_BUS.register(new IguanaEventHook());
    }

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		if (IguanaConfig.addSetHungerCommand)
		{
			event.registerServerCommand(new IguanaCommandHunger());
		}
	}

    //Yet to be re-implemented
    /*
	@SuppressWarnings({ "unchecked" })
	@EventHandler
	public void load(FMLInitializationEvent event) {

		if (IguanaConfig.addCustomVillageField && IguanaConfig.fieldNormalWeight + IguanaConfig.fieldReedWeight + IguanaConfig.fieldStemWeight > 0)
		{
			MapGenStructureIO.func_143031_a(ComponentVillageCustomField.class, "IguanaField");
			VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerCustomField());
		}

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
		FMLCommonHandler.instance().bus().register(new IguanaPlayerHandler());
	}
	*/
}