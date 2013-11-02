package iguanaman.hungeroverhaul;


import iguanaman.hungeroverhaul.RecipeRemover;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.modstats.ModstatInfo;
import org.modstats.Modstats;

import tconstruct.util.PHConstruct;

import assets.pamharvestcraft.HarvestConfigurationHandler;
import assets.pamharvestcraft.ItemPamSeedFood;
import assets.pamharvestcraft.PamHarvestCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CallableMinecraftVersion;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.ComponentVillageWell;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import iguanaman.hungeroverhaul.*;
import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaCropPam;
import iguanaman.hungeroverhaul.blocks.IguanaCropReed;
import iguanaman.hungeroverhaul.blocks.IguanaCropVegetable;
import iguanaman.hungeroverhaul.blocks.IguanaFruit;
import iguanaman.hungeroverhaul.blocks.IguanaStem;
import iguanaman.hungeroverhaul.commands.IguanaCommandConfig;
import iguanaman.hungeroverhaul.commands.IguanaCommandHunger;
import iguanaman.hungeroverhaul.handlers.IguanaEventHook;
import iguanaman.hungeroverhaul.handlers.IguanaPlayerHandler;
import iguanaman.hungeroverhaul.handlers.VillageHandlerCustomField;
import iguanaman.hungeroverhaul.items.IguanaReed;
import iguanaman.hungeroverhaul.items.IguanaSeed;
import iguanaman.hungeroverhaul.items.IguanaSeedPam;

@Mod(modid="HungerOverhaul", name="Hunger Overhaul", version="1.6.X-2i", dependencies = "after:TConstruct@;after:pamharvestcraft@;after:Natura@;after:Thaumcraft;")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
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
        public static Potion slowdownNew;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	
        	IguanaConfig.init(event.getSuggestedConfigurationFile());

    		if(Loader.isModLoaded("TConstruct") && IguanaConfig.modifyFoodStats) {
    			try {
    				if (!PHConstruct.enableHealthRegen)
    				{
    	    			PHConstruct.enableHealthRegen = true;
    	    			IguanaConfig.healthRegenRatePercentage = 0;
    				}
    				if (PHConstruct.alphaRegen)
    				{
    	    			PHConstruct.alphaRegen = false;
    	    			IguanaConfig.foodRegensHealth = true;
    				}
    			} catch (Exception ex) {}
    		}

            potionWellFed = new Potion(IguanaConfig.wellFedId, false, 0).setIconIndex(7, 0).setPotionName("potion.wellfedPotion");
        	slowdownNew = new Potion(IguanaConfig.newSlowdownPotionId, true, 0).setIconIndex(1, 0).setPotionName("potion.newSlowdownPotionHO");

            if (IguanaConfig.removeHoeRecipes) {
                RecipeRemover.removeAnyRecipe(new ItemStack(Item.hoeWood));
                RecipeRemover.removeAnyRecipe(new ItemStack(Item.hoeStone));
            }

        }
     	  
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
            Modstats.instance().getReporter().registerMod(this);
            proxy.registerLocalization();
            
    			
			if (IguanaConfig.addCustomVillageField && IguanaConfig.fieldNormalWeight + IguanaConfig.fieldReedWeight + IguanaConfig.fieldStemWeight > 0)
			{
                if ((new CallableMinecraftVersion(null)).minecraftVersion() != "1.6.2")
                	MapGenStructureIO.func_143031_a(ComponentVillageCustomField.class, "IguanaField");
                VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerCustomField());
			}
           
            //RECIPES
    		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Item.seeds, Item.wheat));
            
            ModuleVanilla.init();
            ModuleHarvestCraftCrops.init();
            ModuleHarvestCraftTrees.init();
            ModuleWeeeFlowers.init();
            ModuleNatura.init();
    		
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
           GameRegistry.registerPlayerTracker(new IguanaPlayerHandler());
           MinecraftForge.EVENT_BUS.register(new IguanaEventHook());
        }

        @EventHandler
		public void serverStarting(FMLServerStartingEvent event)
		{			
			if (IguanaConfig.addSetHungerCommand)
			{
				ICommandManager commandManager = ModLoader.getMinecraftServerInstance().getCommandManager();
				ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager);
				serverCommandManager.registerCommand(new IguanaCommandConfig());
				serverCommandManager.registerCommand(new IguanaCommandHunger());
			}
		}
}