package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.BiomeDictionary;

public class PlantGrowthModification
{
    public boolean needsSunlight = true;
    public final HashMap<BiomeDictionary.Type, Float> biomeGrowthModifiers = new HashMap<BiomeDictionary.Type, Float>();
    public int growthTickProbability = 0;
    public int wrongBiomeMultiplier = IguanaConfig.wrongBiomeRegrowthMultiplier;

    public PlantGrowthModification setNeedsSunlight(boolean needsSunlight)
    {
        this.needsSunlight = needsSunlight;
        return this;
    }

    public float getBiomeGrowthModifier(BiomeDictionary.Type biomeType)
    {
        return biomeGrowthModifiers.get(biomeType);
    }

    public PlantGrowthModification setBiomeGrowthModifier(BiomeDictionary.Type biomeType, float growthModifier)
    {
        this.biomeGrowthModifiers.put(biomeType, growthModifier);
        return this;
    }

    public PlantGrowthModification setBiomeGrowthModifiers(Map<BiomeDictionary.Type, Float> biomeGrowthModifiers)
    {
        this.biomeGrowthModifiers.putAll(biomeGrowthModifiers);
        return this;
    }

    public PlantGrowthModification setGrowthTickProbability(int growthTickProbability)
    {
        this.growthTickProbability = growthTickProbability;
        return this;
    }
    
    public PlantGrowthModification setWrongBiomeMultiplier(int wrongBiomeMultiplier)
    {
        this.wrongBiomeMultiplier = wrongBiomeMultiplier;
        return this;
    }
}
