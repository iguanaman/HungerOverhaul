package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import net.minecraft.world.EnumDifficulty;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class ModuleRespawnHunger
{
    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        int respawnHunger = IguanaConfig.respawnHungerValue;

        if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingRespawnHunger && event.player.worldObj.difficultySetting.getDifficultyId() > EnumDifficulty.EASY.getDifficultyId())
            respawnHunger -= (event.player.worldObj.difficultySetting.getDifficultyId() - 1) * IguanaConfig.respawnHungerDifficultyModifier;

        event.player.getFoodStats().setFoodLevel(Math.min(Math.max(respawnHunger, 1), 20));
        if (event.player.getFoodStats().getSaturationLevel() > event.player.getFoodStats().getFoodLevel())
            event.player.getFoodStats().setFoodSaturationLevel(event.player.getFoodStats().getFoodLevel());
    }
}
