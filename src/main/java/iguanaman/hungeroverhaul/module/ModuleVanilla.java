package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.util.BonemealModification;
import iguanaman.hungeroverhaul.util.PlantGrowthModification;
import net.minecraft.block.*;
import net.minecraft.init.Items;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary.Type;
import squeek.applecore.api.food.FoodValues;
import cpw.mods.fml.common.Loader;

public class ModuleVanilla
{
    public static void init()
    {
        /*
         * Food values
         */
        if (Loader.isModLoaded("harvestcraft") || IguanaConfig.modifyFoodValues)
        {
            FoodModifier.setModifiedFoodValues(Items.apple, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.bread, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(Items.porkchop, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_porkchop, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.fish, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_fished, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(Items.cookie, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.melon, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.beef, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_beef, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.chicken, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.cooked_chicken, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.rotten_flesh, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.baked_potato, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.poisonous_potato, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.pumpkin_pie, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(Items.mushroom_stew, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(Items.carrot, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(Items.potato, new FoodValues(1, 0.05F));
        }

        /*
         * Plant growth
         */
        PlantGrowthModification cropGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.FOREST, 1)
                .setBiomeGrowthModifier(Type.PLAINS, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockCrops.class, cropGrowthModification);

        PlantGrowthModification reedGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.sugarcaneRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.JUNGLE, 1)
                .setBiomeGrowthModifier(Type.SWAMP, 1)
                .setWrongBiomeMultiplier(IguanaConfig.wrongBiomeRegrowthMultiplierSugarcane);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockReed.class, reedGrowthModification);

        PlantGrowthModification stemGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.JUNGLE, 1)
                .setBiomeGrowthModifier(Type.SWAMP, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockStem.class, stemGrowthModification);

        PlantGrowthModification cocoaGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.cocoaRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.JUNGLE, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockCocoa.class, cocoaGrowthModification);

        PlantGrowthModification cactusGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.cactusRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.SANDY, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockCactus.class, cactusGrowthModification);

        PlantGrowthModification saplingGrowthModification = new PlantGrowthModification()
                .setGrowthTickProbability(IguanaConfig.saplingRegrowthMultiplier);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockSapling.class, saplingGrowthModification);

        PlantGrowthModification netherWartGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.netherWartRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.NETHER, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockNetherWart.class, netherWartGrowthModification);

        /*
         * Bonemeal
         */
        BonemealModification cropBonemealModification = new BonemealModification()
        {
            @Override
            public int getNewMeta(World world, int x, int y, int z, Block block, int currentMeta)
            {
                int metaIncrease = 1;
                if (world.difficultySetting.getDifficultyId() < EnumDifficulty.EASY.getDifficultyId())
                    metaIncrease = world.rand.nextInt(3);
                return Math.min(currentMeta + metaIncrease, 7);
            }
        };
        ModuleBonemeal.registerBonemealModifier(BlockCrops.class, cropBonemealModification);
    }
}
