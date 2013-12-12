package iguanaman.hungeroverhaul;

import iguanaman.hungeroverhaul.util.IguanaLog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomItem;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

public class ModuleGrassSeeds {

    static class SeedEntry extends WeightedRandomItem
    {
        public final ItemStack seed;
        public SeedEntry(ItemStack seed, int weight)
        {
            super(weight);
            this.seed = seed;
        }
    }

    public static ItemStack getGrassSeed(World world)
    {
    	IguanaLog.log("get grass seed");
        SeedEntry entry = (SeedEntry)WeightedRandom.getRandomItem(world.rand, seedListNew);
        if (entry == null || entry.seed == null) return null;
        return entry.seed.copy();
    }
    
    public static List<SeedEntry> seedListNew = new ArrayList<SeedEntry>();
	
	public static void init() 
	{

    	IguanaLog.log("Removing tall grass seeds");
    	
        ForgeHooks hooks = new ForgeHooks();
        Field f = null;
        try {
        	f = ForgeHooks.class.getDeclaredField("seedList");
        } catch (NoSuchFieldException e) {
        	throw new RuntimeException("Could not access seedList field, report please");
        }
        
        f.setAccessible(true);
        List<SeedEntry> seedList = null;
        try {
    		seedList = (List<SeedEntry>) f.get(hooks);   
        } catch (IllegalAccessException e) {
        	throw new RuntimeException("Could not access seedList field, report please");
        }
        
        for (Object entry : seedList)
        {
        	ItemStack seed = null;
        	try	{
        		Field seedField = entry.getClass().getDeclaredField("seed");
        		seedField.setAccessible(true);
        		seed = (ItemStack) seedField.get(entry);
            } catch (NoSuchFieldException e) {
            	throw new RuntimeException("Could not access seed field, report please");
            } catch (IllegalAccessException e) {
            	throw new RuntimeException("Could not access seed field, report please");
            }
        	
        	int weight = -1;
        	try	{
        		Field weightField = entry.getClass().getSuperclass().getDeclaredField("itemWeight");
        		weightField.setAccessible(true);
        		weight = (int) weightField.get(entry);
            } catch (NoSuchFieldException e) {
            	throw new RuntimeException("Could not access itemWeight field, report please");
            } catch (IllegalAccessException e) {
            	throw new RuntimeException("Could not access itemWeight field, report please");
            }
        	
        	IguanaLog.log("seed" + seed.getUnlocalizedName() + " weight" + weight);
        	
        	seedListNew.add(new SeedEntry(seed, weight));
        }
        
        seedList.clear();
        MinecraftForge.addGrassSeed(null, 10);
	}
}
