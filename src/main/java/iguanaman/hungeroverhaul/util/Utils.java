package iguanaman.hungeroverhaul.util;

import com.google.common.collect.BiMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;

public class Utils
{

    public static void replace (Block current, Block newBlock)
    {
        overwriteEntry(Block.blockRegistry, Block.blockRegistry.getNameForObject(current), newBlock);
    }

    public static void replace (Item current, Item newItem)
    {
        overwriteEntry(Item.itemRegistry, Item.itemRegistry.getNameForObject(current), newItem);
    }

    /*
        @Author Skyboy & Team CoFH
        used to replace entries in the registry
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void overwriteEntry(RegistryNamespaced registry, String name, Object object)
    {
		Object oldThing = registry.getObject(name);
		int id = registry.getIDForObject(oldThing);
		BiMap map = ((BiMap)registry.registryObjects);
		registry.underlyingIntegerMap.func_148746_a(object, id);
		map.remove(name);
		map.forcePut(name, object);
	}
}
