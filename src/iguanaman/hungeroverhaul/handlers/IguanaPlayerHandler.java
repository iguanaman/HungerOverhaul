package iguanaman.hungeroverhaul.handlers;

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
		if (IguanaConfig.modifyFoodStats) {
			IguanaFoodStats food = new IguanaFoodStats(entityplayer.foodStats);
			food.initPlayer(entityplayer);
			entityplayer.foodStats = food;

		      /*
		      NBTTagCompound tags = entityplayer.getEntityData();
		      entityplayer.foodStats.readNBT(tags);
		      if(!tags.hasKey("HungerOverhaul")) {
		         tags.setCompoundTag("HungerOverhaul", new NBTTagCompound());
		      }
		      */
		}

   }

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPlayerRespawn(EntityPlayer entityplayer) {
		if (IguanaConfig.modifyFoodStats) {

		   int respawnHunger = IguanaConfig.respawnHungerValue;
		   if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingRespawnHunger) {
			   if (entityplayer.worldObj.difficultySetting > 1) {
				   respawnHunger -= (entityplayer.worldObj.difficultySetting - 1) * IguanaConfig.respawnHungerDifficultyModifier;
			   }
		   }
		   if (respawnHunger > 20) {
			   respawnHunger = 20;
		   } else if (respawnHunger < 1) {
			   respawnHunger = 1;
		   }
		   
			IguanaFoodStats food = new IguanaFoodStats(respawnHunger);
			food.initPlayer(entityplayer);
			entityplayer.foodStats = food;
		}


	}

}
