package iguanaman.hungeroverhaul.module;

public class ModuleCropGrowth
{
    // growth tick modification not implemented in AppleCore yet
    /*
    public static boolean shouldUpdateTick(Block block, World world, int x, int y, int z, Random rand)
    {
        if (block instanceof NetherBerryBush)
            return shouldNetherBerryBushUpdateTick(world, x, y, z, rand);
        else if (block instanceof SaguaroBlock)
            return shouldSaguaroUpdateTick(world, x, y, z, rand);
        else if (block instanceof BlockReed)
            return shouldReedUpdateTick(world, x, y, z, rand);

        int sunlightModifier = world.isDaytime() && world.canBlockSeeTheSky(x, y, z) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0)
            return false;

        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
        try
        {
            BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
            for (BiomeDictionary.Type biomeType : new BiomeDictionary.Type[]{BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS})
                if (BiomeDictionary.isBiomeOfType(biome, biomeType))
                {
                    biomeModifier = 1;
                    break;
                }
        }
        catch (Exception var5)
        {
            biomeModifier = 1;
        }
        if (biomeModifier == 0)
            return false;

        if (rand.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0)
            return false;

        return true;
    }

    public static boolean shouldNetherBerryBushUpdateTick(World world, int x, int y, int z, Random rand)
    {
        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
        try
        {
            BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.NETHER))
                biomeModifier = 1;
        }
        catch (Exception var5)
        {
            biomeModifier = 1;
        }

        if (rand.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0)
            return false;

        return true;
    }

    public static boolean shouldSaguaroUpdateTick(World world, int x, int y, int z, Random rand)
    {
        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
        try
        {
            BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY))
                biomeModifier = 1;
        }
        catch (Exception var5)
        {
            biomeModifier = 1;
        }

        if (rand.nextInt(IguanaConfig.cactusRegrowthMultiplier * biomeModifier) != 0)
            return false;

        return true;
    }

    public static boolean shouldReedUpdateTick(World world, int x, int y, int z, Random rand)
    {
        int sunlightModifier = world.isDaytime() && world.canBlockSeeTheSky(x, y, z) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0)
            return false;

        // biome modifier
        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplierSugarcane;
        try
        {
            BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
            for (BiomeDictionary.Type biomeType : new BiomeDictionary.Type[]{BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.SWAMP})
            {
                if (BiomeDictionary.isBiomeOfType(biome, biomeType))
                {
                    biomeModifier = 1;
                    break;
                }
            }
        }
        catch (Exception var5)
        {
            biomeModifier = 1;
        }
        if (biomeModifier == 0)
            return false;

        if (rand.nextInt(IguanaConfig.sugarcaneRegrowthMultiplier * biomeModifier) != 0)
            return false;

        return true;
    }
    */
}
