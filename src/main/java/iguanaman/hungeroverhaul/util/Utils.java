package iguanaman.hungeroverhaul.util;

import com.google.common.collect.BiMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;

public class Utils
{

    public static void replace (Block current, String name)
    {
        overwriteEntry(Block.blockRegistry, name, current);
    }

    public static void replace (Item current, String name)
    {
        overwriteEntry(Item.itemRegistry, name, current);

    }

    @Deprecated
    public static void replace (Block current, Block name)
    {
        overwriteEntry(Block.blockRegistry, Block.blockRegistry.getNameForObject(name), current);
    }

    @Deprecated
    public static void replace (Item current, Item name)
    {
        overwriteEntry(Item.itemRegistry, Item.itemRegistry.getNameForObject(name), current);

    }

    /**
     * Used to replace entries in the registry
     * 
     * @param registry The registry the thing to replace is in
     * @param name The name that the thing to replace is registered as
     * @param object The thing that will replace the previous object
     * @author Skyboy & Team CoFH
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void overwriteEntry (RegistryNamespaced registry, String name, Object object)
    {
        boolean bl = object instanceof Block;
        Object oldThing = registry.getObject(name);
        int id = registry.getIDForObject(oldThing);
        IguanaLog.log.info("Replacing " + (bl ? "Block" : "Item") + ": " + name + " @id " + id);

        BiMap map = ((BiMap) registry.registryObjects);
        registry.underlyingIntegerMap.func_148746_a(object, id);
        map.remove(name);
        map.forcePut(name, object);
    }
}
