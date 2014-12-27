package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.food.FoodModifier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.registry.GameData;

public class IMCHandler
{
    public static String BLACKLIST_RIGHT_CLICK = "BlacklistRightClick";
    public static String BLACKLIST_DROPS = "BlacklistDrops";
    public static String BLACKLIST_FOOD = "BlacklistFood";

    public static void processMessages(ImmutableList<IMCMessage> messages)
    {
        for (final FMLInterModComms.IMCMessage message : messages)
        {
            ItemAndBlockList blacklist = null;

            if (message.key.equalsIgnoreCase(BLACKLIST_RIGHT_CLICK))
            {
                blacklist = IguanaEventHook.rightClickHarvestBlacklist;
            }
            else if (message.key.equalsIgnoreCase(BLACKLIST_DROPS))
            {
                blacklist = IguanaEventHook.harvestDropsBlacklist;
            }
            else if (message.key.equalsIgnoreCase(BLACKLIST_FOOD))
            {
                blacklist = FoodModifier.blacklist;
            }

            if (blacklist != null)
            {
                if (message.isItemStackMessage())
                {
                    blacklist.add(message.getItemStackValue());
                }
                else if (message.isStringMessage())
                {
                    String msg = message.getStringValue();
                    if (msg.contains(":"))
                    {
                        Item item = GameData.getItemRegistry().getObject(msg);
                        Block block = GameData.getBlockRegistry().getObject(msg);

                        if (item != null)
                            blacklist.add(item);
                        if (block != null)
                            blacklist.add(block);
                    }
                    else
                    {
                        try
                        {
                            Class<?> clazz = Class.forName(message.getStringValue());
                            blacklist.add(clazz);
                        }
                        catch (ClassNotFoundException e)
                        {
                            HungerOverhaul.Log.error("Class to blacklist not found (sent by mod " + message.getSender() + ")");
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
