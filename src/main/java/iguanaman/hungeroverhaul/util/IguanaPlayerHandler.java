package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.IguanaFoodStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class IguanaPlayerHandler {

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) {
		IguanaFoodStats food = new IguanaFoodStats(event.player.foodStats);
		food.initPlayer(event.player);
		event.player.foodStats = food;
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		int respawnHunger = IguanaConfig.respawnHungerValue;
		if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingRespawnHunger)
			if (event.player.worldObj.difficultySetting.getDifficultyId() > 1)
				respawnHunger -= (event.player.worldObj.difficultySetting.getDifficultyId() - 1) * IguanaConfig.respawnHungerDifficultyModifier;

		IguanaFoodStats food = new IguanaFoodStats(Math.min(Math.max(respawnHunger, 1), 20));
		food.initPlayer(event.player);
		event.player.foodStats = food;
	}
}
