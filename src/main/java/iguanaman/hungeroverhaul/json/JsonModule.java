package iguanaman.hungeroverhaul.json;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.util.IguanaEventHook;
import iguanaman.hungeroverhaul.util.ItemAndBlockList;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import squeek.applecore.api.food.FoodValues;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class JsonModule
{
    private static Gson GSON;
    private static File[] hojsons;
    private static List<HOJsonData> hoData = Lists.newArrayList();

    public static void preinit(File configFolder)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.enableComplexMapKeySerialization();
        builder.setPrettyPrinting();
        GSON = builder.create();
        File hoFolder = new File(configFolder, "HungerOverhaul");
        if (!hoFolder.exists())
            hoFolder.mkdirs();
        hojsons = hoFolder.listFiles();
    }

    public static void init()
    {
        HungerOverhaul.Log.info("Loading JSON Files");
        HOJsonData hod;
        for (File j : hojsons)
        {
            try
            {
                FileReader reader = new FileReader(j);
                hod = GSON.fromJson(reader, HOJsonData.class);
                reader.close();
                hoData.add(hod);
            }
            catch (Exception e)
            {
                HungerOverhaul.Log.warn("Error Loading json files: ", e);
            }
        }
        HungerOverhaul.Log.info("Loading data from json");
        for (HOJsonData h : hoData)
        {
            if (h.foods != null)
            {
                for (Food f : h.foods)
                {
                    ItemStack itemStack = f.toItemStack();
                    FoodValues foodValues = f.toFoodValues();
                    if (itemStack != null && itemStack.getItem() != null && foodValues != null)
                        FoodModifier.setModifiedFoodValues(itemStack, foodValues);
                }
            }
            if (h.foodsBlacklist != null)
            {
                for (GameObject gameObj : h.foodsBlacklist)
                {
                    addGameObjectToList(FoodModifier.blacklist, gameObj);
                }
            }
            if (h.dropsBlacklist != null)
            {
                for (GameObject gameObj : h.dropsBlacklist)
                {
                    addGameObjectToList(IguanaEventHook.harvestDropsBlacklist, gameObj);
                }
            }
            if (h.harvestBlacklist != null)
            {
                for (GameObject gameObj : h.harvestBlacklist)
                {
                    addGameObjectToList(IguanaEventHook.rightClickHarvestBlacklist, gameObj);
                }
            }
        }
        HungerOverhaul.Log.info("Loaded all data from JSON");
    }

    public static void addGameObjectToList(ItemAndBlockList list, GameObject gameObj)
    {
        if (gameObj.meta == OreDictionary.WILDCARD_VALUE)
        {
            if (gameObj.toBlock() != null)
                list.add(gameObj.toBlock());
            if (gameObj.toItem() != null)
                list.add(gameObj.toItem());
        }
        else
        {
            ItemStack itemStack = gameObj.toItemStack();
            if (itemStack != null)
                list.add(itemStack);
        }
    }
}
