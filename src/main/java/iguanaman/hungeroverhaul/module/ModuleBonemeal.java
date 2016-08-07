package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.config.IguanaConfig;
import iguanaman.hungeroverhaul.util.BonemealModification;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ModuleBonemeal
{
    private static HashMap<Class<? extends Block>, BonemealModification> bonemealModificationsByBlockClass = new HashMap<Class<? extends Block>, BonemealModification>();
    private static HashMap<Block, BonemealModification> bonemealModificationsByBlock = new HashMap<Block, BonemealModification>();

    public static void registerBonemealModifier(Class<? extends Block> blockClass, BonemealModification bonemealModification)
    {
        bonemealModificationsByBlockClass.put(blockClass, bonemealModification);
    }

    public static void registerBonemealModifier(Block block, BonemealModification bonemealModification)
    {
        bonemealModificationsByBlock.put(block, bonemealModification);
    }

    public static BonemealModification getBonemealModification(Block block)
    {
        BonemealModification bonemealModification = bonemealModificationsByBlock.get(block);
        if (bonemealModification != null)
            return bonemealModification;
        else
            return getBonemealModification(block.getClass());
    }

    public static BonemealModification getBonemealModification(Class<? extends Block> blockClass)
    {
        // get exact matches first
        BonemealModification bonemealModification = bonemealModificationsByBlockClass.get(blockClass);
        // as a backup, check instanceof
        if (bonemealModification == null)
        {
            for (Map.Entry<Class<? extends Block>, BonemealModification> entry : bonemealModificationsByBlockClass.entrySet())
            {
                if (entry.getKey().isInstance(blockClass))
                    return entry.getValue();
            }
        }
        return bonemealModification;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onBonemealUsed(BonemealEvent event)
    {
        // only the server matters
        // can't simulate this on the client because the client
        // generates different random numbers, causing visual desyncing
        if (event.world.isRemote)
            return;

        // do nothing if effectiveness is normal
        if (event.getResult() != Result.DEFAULT || event.isCanceled() || IguanaConfig.bonemealEffectiveness == 1.0f)
            return;

        BonemealModification bonemealModification = getBonemealModification(event.block);
        if (bonemealModification == null)
            return;

        // bonemeal doesn't do anything to the registered plants when
        // effectiveness is 0
        if (IguanaConfig.bonemealEffectiveness == 0.0f)
        {
            event.setCanceled(true);
            event.setResult(Result.DENY);
            return;
        }

        if (event.world.rand.nextFloat() < IguanaConfig.bonemealEffectiveness)
        {
            if (IguanaConfig.modifyBonemealGrowth)
            {
                int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
                int resultingMeta = bonemealModification.getNewMeta(event.world, event.x, event.y, event.z, event.block, meta);
                if (meta != resultingMeta)
                {
                    event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, resultingMeta, 3);
                }
                bonemealModification.onBonemeal(event.world, event.x, event.y, event.z, event.block, resultingMeta);
                event.setResult(Result.ALLOW);
            }
            // otherwise fall through to default implementation (Result.DEFAULT)
        }
        else
        {
            // set as handled
            event.setResult(Result.ALLOW);
        }
    }
}
