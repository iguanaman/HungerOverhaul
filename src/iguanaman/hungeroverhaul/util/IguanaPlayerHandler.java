package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.IguanaFoodStats;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.FoodStats;

public class IguanaPlayerHandler implements IPlayerTracker {

	@Override
   public void onPlayerLogin(EntityPlayer entityplayer) {
		IguanaFoodStats food = new IguanaFoodStats(entityplayer.foodStats);
		food.initPlayer(entityplayer);
		entityplayer.foodStats = food;
   }
	
	@Override
	public void onPlayerRespawn(EntityPlayer entityplayer) {
	   int respawnHunger = IguanaConfig.respawnHungerValue;
	   if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingRespawnHunger) {
		   if (entityplayer.worldObj.difficultySetting > 1) {
			   respawnHunger -= (entityplayer.worldObj.difficultySetting - 1) * IguanaConfig.respawnHungerDifficultyModifier;
		   }
	   }
	   
		IguanaFoodStats food = new IguanaFoodStats(Math.min(Math.max(respawnHunger, 1), 20));
		food.initPlayer(entityplayer);
		entityplayer.foodStats = food;
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {}
	
	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {}

}
