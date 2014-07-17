package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.IguanaConfig;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

public class ModuleGrassSeeds {

	static class SeedEntry extends WeightedRandom.Item
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
		HungerOverhaul.Log.info("get grass seed");
		SeedEntry entry = (SeedEntry)WeightedRandom.getRandomItem(world.rand, seedListNew);
		if (entry == null || entry.seed == null) return null;
		return entry.seed.copy();
	}

	public static List<SeedEntry> seedListNew = new ArrayList<SeedEntry>();

	@SuppressWarnings("unchecked")
	public static void init()
	{

		if (IguanaConfig.removeTallGrassSeeds) HungerOverhaul.Log.info("Removing tall grass seeds");

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

			int weight = 1;
			if (!IguanaConfig.allSeedsEqual)
				try	{
					Field weightField = entry.getClass().getSuperclass().getDeclaredField("field_76292_a");
					weightField.setAccessible(true);
					weight = (Integer) weightField.get(entry);
				} catch (NoSuchFieldException e) {
					try	{
						Field weightField = entry.getClass().getSuperclass().getDeclaredField("itemWeight");
						weightField.setAccessible(true);
						weight = (Integer) weightField.get(entry);
					} catch (NoSuchFieldException e2) {
                        HungerOverhaul.Log.warn("WARNING Could not access itemWeight field, report please");
					} catch (IllegalAccessException e2) {
						throw new RuntimeException("Could not access itemWeight field, report please");
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException("Could not access itemWeight field, report please");
				}

			//IguanaLog.log("seed" + seed.getUnlocalizedName() + " weight" + weight);

			seedListNew.add(new SeedEntry(seed, weight));
		}

		seedList.clear();

		if (IguanaConfig.removeTallGrassSeeds) MinecraftForge.addGrassSeed(null, 10);
		else for (SeedEntry entry : seedListNew) MinecraftForge.addGrassSeed(entry.seed, 1);

	}
}
