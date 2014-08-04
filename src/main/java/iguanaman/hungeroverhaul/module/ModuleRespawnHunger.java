package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import net.minecraft.world.EnumDifficulty;
import squeek.applecore.api.AppleCoreAPI;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class ModuleRespawnHunger
{
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        int respawnHunger = IguanaConfig.respawnHungerValue;

        if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingRespawnHunger && event.player.worldObj.difficultySetting.getDifficultyId() > EnumDifficulty.EASY.getDifficultyId())
            respawnHunger -= (event.player.worldObj.difficultySetting.getDifficultyId() - 1) * IguanaConfig.respawnHungerDifficultyModifier;

        AppleCoreAPI.mutator.setHunger(event.player, Math.min(Math.max(respawnHunger, 1), 20));
        if (event.player.getFoodStats().getSaturationLevel() > event.player.getFoodStats().getFoodLevel())
            AppleCoreAPI.mutator.setSaturation(event.player, event.player.getFoodStats().getFoodLevel());
    }
}
