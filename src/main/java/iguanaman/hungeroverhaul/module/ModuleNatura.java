package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.util.PlantGrowthModification;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.util.RecipeRemover;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.blocks.trees.SaguaroBlock;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import squeek.applecore.api.food.FoodValues;

public class ModuleNatura
{
    public static void init()
    {
        RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 1));
        RecipeRemover.removeAnyRecipe(new ItemStack(NContent.plantItem, 1, 2));
        RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 1);
        RecipeRemover.removeFurnaceRecipe(NContent.plantItem, 2);

        //TODO Figure out how iguana_man calculated the FoodValues
        if (IguanaConfig.modifyFoodValues)
        {
            for(int i = 0; i < 4; i++)
                FoodModifier.setModifiedFoodValues(new ItemStack(NContent.berryItem, 1, i), new FoodValues(0, 0F));
            FoodModifier.setModifiedFoodValues(NContent.berryMedley, new FoodValues(0, 0F));
        }

        // plant growth
        PlantGrowthModification cropGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.FOREST, 1)
                .setBiomeGrowthModifier(Type.PLAINS, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(CropBlock.class, cropGrowthModification);

        PlantGrowthModification saguaroGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.cactusRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.SANDY, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(SaguaroBlock.class, saguaroGrowthModification);

        PlantGrowthModification berryBushGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.FOREST, 1)
                .setBiomeGrowthModifier(Type.PLAINS, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BerryBush.class, berryBushGrowthModification);

        PlantGrowthModification netherBushGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.NETHER, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(NetherBerryBush.class, netherBushGrowthModification);
    }

}
