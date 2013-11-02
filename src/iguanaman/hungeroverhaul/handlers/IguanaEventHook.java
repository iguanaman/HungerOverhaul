package iguanaman.hungeroverhaul.handlers;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class IguanaEventHook {

	@ForgeSubscribe
    public void onLivingUpdate(LivingUpdateEvent event) {
		Random rand = new Random();

		float healthPercent = event.entityLiving.getHealth() / event.entityLiving.getMaxHealth();
		int foodLevel = 20;
		boolean creative = false;
		boolean isPlayer = false;
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			creative = player.capabilities.isCreativeMode;
			foodLevel = player.foodStats.foodLevel;
			isPlayer = true;
		} else {
			healthPercent /= 2;
		} 
		
		if (!event.entityLiving.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntityPlayer && IguanaConfig.constantHungerLoss) 
			{
				EntityPlayer player = (EntityPlayer)event.entityLiving;
				if (!player.capabilities.isCreativeMode && !player.isDead) player.addExhaustion(0.001F);
			}
			
			if (event.entityLiving instanceof EntityAgeable) {
		    	int rndBreed = rand.nextInt(IguanaConfig.breedingTimeoutMultiplier);
		    	int rndChild = rand.nextInt(IguanaConfig.childDurationMultiplier);
				EntityAgeable ageable = (EntityAgeable)event.entityLiving;
	        	int growingAge = ageable.getGrowingAge();
	        	if (growingAge > 0 && rndBreed != 0) {
	                ageable.setGrowingAge(++growingAge);
	        	} else if (growingAge < 0 && rndChild != 0) {
	                ageable.setGrowingAge(--growingAge);
	        	}
			}
	
			if (event.entityLiving instanceof EntityChicken) {
		    	int rnd = rand.nextInt(IguanaConfig.eggTimeoutMultiplier);
				EntityChicken chicken = (EntityChicken)event.entityLiving;
	        	if (chicken.timeUntilNextEgg > 0 && rnd != 0) {
	        		chicken.timeUntilNextEgg += 1;
	        	} 
			}
			

			if (IguanaConfig.addLowStatEffects) 
			{     
				int difficultyModifierEffects = 2;
				if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingEffects)
				{
					difficultyModifierEffects = event.entityLiving.worldObj.difficultySetting;
					
					if (!(event.entityLiving instanceof EntityPlayer))
						difficultyModifierEffects = (difficultyModifierEffects * -1) + 3;
				}
				
	        	
		  	   // low stat effects
		        if (!creative && isPlayer && !event.entityLiving.isDead && healthPercent > 0f)
		        {

		           if (IguanaConfig.addLowStatMiningSlowdown)
		           {
				       if (foodLevel <= 1 || healthPercent <= 0.05F)
				            event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, 1 + difficultyModifierEffects, true));
				       else if (foodLevel <= 2 || healthPercent <= 0.10F)
				            event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, difficultyModifierEffects, true));
				       else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 1)
				            event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -1 + difficultyModifierEffects, true));
				       else if ((foodLevel <= 4 || healthPercent <= 0.20F) && difficultyModifierEffects >= 2)
				            event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -2 + difficultyModifierEffects, true));
				       else if ((foodLevel <= 5 || healthPercent <= 0.25F) && difficultyModifierEffects >= 3)
				            event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -3 + difficultyModifierEffects, true));
		           }
		           
		            if (IguanaConfig.addLowStatWeakness) 
		            {
		 		       //Weakness effect
		 		       if ((foodLevel <= 1 || healthPercent <= 0.05F) && difficultyModifierEffects >= 1)
		 		    	   event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -1 + difficultyModifierEffects, true));
		 		       else if ((foodLevel <= 2 || healthPercent <= 0.10F) && difficultyModifierEffects >= 2)
		 		    	   event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -2 + difficultyModifierEffects, true));
		 		       else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 3)
		 		    	   event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -3 + difficultyModifierEffects, true));
		            }
		
		            if (IguanaConfig.addLowStatNausea && isPlayer) 
		            {
		 		       //Nausea effect
		 		       if (foodLevel <= 1 || healthPercent <= 0.05F)
		 		    	   event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 19, 0, true));
		            }
		        }
			}
		}
		
		if (IguanaConfig.addLowStatSlowness)
		{
			//slowdown effect
			int healthValue = Math.round(healthPercent * 20f);
	    	if (healthValue <= 4 || foodLevel <= 4)
	    	{
	    		double speedModifier = 1d;
	    		if (healthValue < foodLevel)
	    		{
	    			speedModifier = (double)(healthValue + 5) / 10d;
	    		}
	    		else
	    		{
	    			speedModifier = (double)(foodLevel + 5) / 10d;
	    		}
	    		
    			//Walking block
    			EntityLivingBase entity = event.entityLiving;
    			World world = entity.worldObj;
    			
    			if (!entity.isInWater())
    			{
    				double posmod = 0d;
    				
    				if (world.isRemote)
    					if(entity instanceof EntityClientPlayerMP)
    						posmod = 1.62d;
    				
    				int posX = (int)entity.posX;
    				int posY = (int)(entity.posY - posmod - 1d);
    				int posZ = (int)entity.posZ;
    				if (posX < 0) --posX;
    				if (posY < 0) --posY;
    				if (posZ < 0) --posZ;
    				
    				Material blockOnMaterial = world.getBlockMaterial(posX, posY, posZ);
    		        if (blockOnMaterial == Material.ice) speedModifier = 0.80d + (speedModifier / 5d);
    			}

    			/*
        		if (event.entityLiving instanceof EntityPlayer)
        			FMLLog.warning("sm" + Double.toString(speedModifier));
    			*/
		    	speedModifier = (2d * speedModifier) - 1d;
    			
        		entity.motionX *= speedModifier;
        		entity.motionZ *= speedModifier;
    		}
		}
	}

	/*
	@ForgeSubscribe
    public void onSleep(PlayerSleepInBedEvent event) {

		if (IguanaConfig.addSleepHungerLoss && !event.entityPlayer.capabilities.isCreativeMode) {
			
			World world = event.entityPlayer.worldObj;
	
	        if (!world.isRemote)
	        {
		        if (event.entityPlayer.isPlayerSleeping() || !event.entityPlayer.isEntityAlive())
		        {
		            event.result = EnumStatus.OTHER_PROBLEM;
		            return;
		        }
		
		        if (!world.provider.isSurfaceWorld())
		        {
		        	event.result = EnumStatus.NOT_POSSIBLE_HERE;
		            return;
		        }
		
		        if (world.isDaytime())
		        {
		        	event.result =  EnumStatus.NOT_POSSIBLE_NOW;
		            return;
		        }
		
		        if (Math.abs(event.entityPlayer.posX - (double)event.x) > 3.0D || Math.abs(event.entityPlayer.posY - (double)event.y) > 2.0D || Math.abs(event.entityPlayer.posZ - (double)event.z) > 3.0D)
		        {
		        	event.result =  EnumStatus.TOO_FAR_AWAY;
		            return;
		        }
		
		        double d0 = 8.0D;
		        double d1 = 5.0D;
		        List list = world.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getAABBPool().getAABB((double)event.x - d0, (double)event.y - d1, (double)event.z - d0, (double)event.x + d0, (double)event.y + d1, (double)event.z + d0));
		
		        if (!list.isEmpty())
		        {
		        	event.result =  EnumStatus.NOT_SAFE;
		            return;
		        }
	        }
			
	        // if sleeping is possible
			long sleepTime = 24000L - world.getWorldTime();
			int hungerInterval = 2500;
			if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingSleepHungerLoss) {
				hungerInterval = 1500 + (((world.difficultySetting - 3) * -1) * 500);
			}
			int hungerLoss = Math.round(sleepTime / hungerInterval);
			int foodLevel = event.entityPlayer.foodStats.foodLevel;
			if (foodLevel - hungerLoss <= 6) {
				event.entityPlayer.addChatMessage("You are too hungry to sleep");
				event.result = EnumStatus.OTHER_PROBLEM;
			} else {
				event.entityPlayer.foodStats.foodLevel -= hungerLoss;
			}
		}
	}
	*/
		
	@ForgeSubscribe
    public void onUseHoe(UseHoeEvent event) {
		if (IguanaConfig.modifyHoeUse) {
			int blockID = event.world.getBlockId(event.x, event.y, event.z);
			
			if ((blockID == Block.dirt.blockID || blockID == Block.grass.blockID) && isWaterNearby(event.world, event.x, event.y, event.z) ) {
	            if (IguanaConfig.hoeToolDamageMultiplier > 1) {
		            event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
	            }
			} else if (blockID == Block.grass.blockID && ! isWaterNearby(event.world, event.x, event.y, event.z)) {

	            Block block = Block.tilledField;
	            event.world.playSoundEffect((double)((float)event.x + 0.5F), (double)((float)event.y + 0.5F), (double)((float)event.z + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
	            if (!event.world.isRemote) {
	            	int seedChance = IguanaConfig.seedChance - (event.world.difficultySetting * IguanaConfig.seedChanceDifficultyModifier); 
	                if (event.world.rand.nextInt(100) <= seedChance) {
		    			Block.blocksList[blockID].dropBlockAsItem_do(event.world, event.x, event.y, event.z, ForgeHooks.getGrassSeed(event.world));
	                }
	    			event.world.setBlock(event.x, event.y, event.z, Block.dirt.blockID);
	            }

	            if (IguanaConfig.hoeToolDamageMultiplier > 1) {
		            event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
	            }
				event.setResult(Result.ALLOW);
			} else {
				event.setCanceled(true);
			}
		}
	}
	
	@ForgeSubscribe
	public void onBlockHarvested(HarvestDropsEvent event)
	{
		if (event.block != null)
		{
			if (IguanaConfig.removeTallGrassSeeds && event.block instanceof BlockTallGrass)
			{
				event.drops.clear();
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
		if (IguanaConfig.addGuiText) 
		{
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;
			
			if (!player.isDead && !player.capabilities.isCreativeMode && !mc.gameSettings.showDebugInfo) {

		        float healthPercent = player.getHealth() / player.getMaxHealth();
		        
				if (healthPercent <= 0.15F) {
					event.left.add("\u00A7cDying\u00A7r");
				} else if (healthPercent <= 0.3F) {
					event.left.add("\u00A7eInjured\u00A7r");
				} else if (healthPercent < 0.5F) {
					event.left.add("\u00A7fHurt\u00A7r");
				}  
				
				if (player.foodStats.getFoodLevel() <= 6) {
					event.right.add("\u00A7cStarving\u00A7r");
				} else if (player.foodStats.getFoodLevel() <= 10) {
					event.right.add("\u00A7eHungry\u00A7r");
				} else if (player.foodStats.getFoodLevel() <= 14) {
					event.right.add("\u00A7fPeckish\u00A7r");
				} 
				
				/*
				if (HungerOverhaul.modifyFoodStats == true) {
					event.left.add("Meat: " + player.foodStats.diet[IguanaFoodType.meat.id]);
					event.left.add("Fish: " + player.foodStats.diet[IguanaFoodType.fish.id]);
					event.left.add("Vegetable: " + player.foodStats.diet[IguanaFoodType.vegetable.id]);
					event.left.add("Fruit: " + player.foodStats.diet[IguanaFoodType.fruit.id]);
					event.left.add("Grain: " + player.foodStats.diet[IguanaFoodType.grain.id]);
					event.left.add("Dairy: " + player.foodStats.diet[IguanaFoodType.dairy.id]);
				}
				*/
			}
		}
	}
    


    /**
     * returns true if there's water nearby (x-4 to x+4, y to y+1, k-4 to k+4)
     */
    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 4; l <= par2 + 4; ++l)
        {
            for (int i1 = par3; i1 <= par3 + 1; ++i1)
            {
                for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)
                {
                    if (par1World.getBlockMaterial(l, i1, j1) == Material.water)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
