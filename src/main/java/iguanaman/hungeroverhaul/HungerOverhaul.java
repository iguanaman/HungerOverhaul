package iguanaman.hungeroverhaul;

import cpw.mods.fml.common.registry.VillagerRegistry;
import iguanaman.hungeroverhaul.module.*;
import iguanaman.hungeroverhaul.util.VillageHandlerCustomField;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
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
import iguanaman.hungeroverhaul.potion.PotionWellFed;
import iguanaman.hungeroverhaul.util.IguanaEventHook;
import iguanaman.hungeroverhaul.util.RecipeRemover;
import iguanaman.hungeroverhaul.util.StackSizeTweaks;

@Mod(modid = "HungerOverhaul", name = "Hunger Overhaul", version = "${version}", dependencies = "required-after:HO-Core;required-after:AppleCore;after:TConstruct;after:harvestcraft;after:temperateplants;after:randomplants;after:weeeflowers;after:Natura")
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

        if (IguanaConfig.removeHoeRecipes)
        {
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
        MinecraftForge.EVENT_BUS.register(new FoodModifier());
        MinecraftForge.EVENT_BUS.register(new ModulePlantGrowth());
        MinecraftForge.EVENT_BUS.register(new ModuleBonemeal());
        ModuleVanilla.init();
        if(Loader.isModLoaded("harvestcraft"))
        {
            PamsModsHelper.loadHC();
            ModuleHarvestCraft.init();
        }
        if(Loader.isModLoaded("temperateplants"))
            ModuleTemperatePlants.init();
        if(Loader.isModLoaded("randomplants"))
            ModuleRandomPlants.init();
        if(Loader.isModLoaded("weeeflowers"))
        {
            PamsModsHelper.loadWF();
            ModuleWeeeFlowers.init();
        }
        if (Loader.isModLoaded("TConstruct"))
            ModuleTConstruct.init();
        if (Loader.isModLoaded("Natura"))
            ModuleNatura.init();
        if (Loader.isModLoaded("BiomesOPlenty"))
            ModuleBOP.init();

        if (IguanaConfig.addCustomVillageField && IguanaConfig.fieldNormalWeight + IguanaConfig.fieldReedWeight + IguanaConfig.fieldStemWeight > 0)
        {
            MapGenStructureIO.func_143031_a(ComponentVillageCustomField.class, "IguanaField");
            VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerCustomField());
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        if (IguanaConfig.removeTallGrassSeeds || IguanaConfig.allSeedsEqual)
            ModuleGrassSeeds.init();
        StackSizeTweaks.init();
        MinecraftForge.EVENT_BUS.register(new IguanaEventHook());
        FMLCommonHandler.instance().bus().register(new ModuleRespawnHunger());
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        if (IguanaConfig.addSetHungerCommand)
        {
            event.registerServerCommand(new IguanaCommandHunger());
        }
    }
}