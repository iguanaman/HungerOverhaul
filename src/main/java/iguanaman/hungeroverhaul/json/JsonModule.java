package iguanaman.hungeroverhaul.json;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.food.FoodModifier;

import java.io.File;
import java.io.FileReader;
import java.util.List;

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
            for (Food f : h.foods)
            {
                FoodModifier.setModifiedFoodValues(f.toItemStack(), f.toFoodValues());
            }
        }
        HungerOverhaul.Log.info("Loaded all data from JSON");
    }
}
