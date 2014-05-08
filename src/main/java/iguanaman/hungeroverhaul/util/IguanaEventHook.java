package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.ModuleGrassSeeds;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaEventHook {

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {

		Random rand = new Random();

		// Slow growth and egg rates
		if (event.entityLiving instanceof EntityAnimal) {
			int rndBreed = rand.nextInt(IguanaConfig.breedingTimeoutMultiplier);
			int rndChild = rand.nextInt(IguanaConfig.childDurationMultiplier);
			EntityAgeable ageable = (EntityAgeable)event.entityLiving;
			int growingAge = ageable.getGrowingAge();
			if (growingAge > 0 && rndBreed != 0)
				ageable.setGrowingAge(++growingAge);
			else if (growingAge < 0 && rndChild != 0)
				ageable.setGrowingAge(--growingAge);

			if (IguanaConfig.eggTimeoutMultiplier > 1 && event.entityLiving instanceof EntityChicken) {
				int rnd = rand.nextInt(IguanaConfig.eggTimeoutMultiplier);
				EntityChicken chicken = (EntityChicken)event.entityLiving;
				if (chicken.timeUntilNextEgg > 0 && rnd != 0) chicken.timeUntilNextEgg += 1;
			}

			// Reduced milked value every second
			if (IguanaConfig.milkedTimeout > 0 && event.entityLiving instanceof EntityCow && event.entityLiving.worldObj.getWorldTime() % 20 == 0)
			{
				NBTTagCompound tags = event.entityLiving.getEntityData();
				if (tags.hasKey("Milked"))
				{
					int milked = tags.getInteger("Milked");
					if (--milked <= 0) tags.removeTag("Milked");
					else tags.setInteger("Milked", milked);
				}
			}
		}

		if (!event.entityLiving.worldObj.isRemote)
		{
			NBTTagCompound tags = event.entityLiving.getEntityData();

			// low stat effects
			if (tags.hasKey("HungerOverhaulCheck"))
			{
				int lastCheck = tags.getInteger("HungerOverhaulCheck");
				if (--lastCheck <= 0) tags.removeTag("HungerOverhaulCheck");
				else tags.setInteger("HungerOverhaulCheck", lastCheck);
			}
			else
			{
				float healthPercent = event.entityLiving.getHealth() / event.entityLiving.getMaxHealth();
				int foodLevel = 20;
				boolean creative = false;
				boolean isPlayer = false;
				if (event.entityLiving instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)event.entityLiving;
					creative = player.capabilities.isCreativeMode;
					foodLevel = player.foodStats.getFoodLevel();
					isPlayer = true;
				} else
					healthPercent /= 2;

				if (event.entityLiving instanceof EntityPlayer && IguanaConfig.constantHungerLoss)
				{
					EntityPlayer player = (EntityPlayer)event.entityLiving;
					if (!player.capabilities.isCreativeMode && !player.isDead) player.addExhaustion(0.01F);
				}

				if (IguanaConfig.addLowStatEffects)
				{
					int difficultyModifierEffects = 2;
					if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingEffects)
					{
						difficultyModifierEffects = event.entityLiving.worldObj.difficultySetting.getDifficultyId();

						if (!(event.entityLiving instanceof EntityPlayer))
							difficultyModifierEffects = difficultyModifierEffects * -1 + 3;
					}


					// low stat effects
					if (!creative && isPlayer && !event.entityLiving.isDead && healthPercent > 0f)
					{

						if (IguanaConfig.addLowStatSlowness)
							if (foodLevel <= 1 || healthPercent <= 0.05F)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, 1 + difficultyModifierEffects, true));
							else if (foodLevel <= 2 || healthPercent <= 0.10F)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, difficultyModifierEffects, true));
							else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 1)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -1 + difficultyModifierEffects, true));
							else if ((foodLevel <= 4 || healthPercent <= 0.20F) && difficultyModifierEffects >= 2)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -2 + difficultyModifierEffects, true));
							else if ((foodLevel <= 5 || healthPercent <= 0.25F) && difficultyModifierEffects >= 3)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -3 + difficultyModifierEffects, true));

						if (IguanaConfig.addLowStatMiningSlowdown)
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

						if (IguanaConfig.addLowStatWeakness)
							//Weakness effect
							if ((foodLevel <= 1 || healthPercent <= 0.05F) && difficultyModifierEffects >= 1)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -1 + difficultyModifierEffects, true));
							else if ((foodLevel <= 2 || healthPercent <= 0.10F) && difficultyModifierEffects >= 2)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -2 + difficultyModifierEffects, true));
							else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 3)
								event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -3 + difficultyModifierEffects, true));

						if (IguanaConfig.addLowStatNausea && isPlayer && (foodLevel <= 1 || healthPercent <= 0.05F))
							event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 19, 0, true));
					}
				}

				tags.setInteger("HungerOverhaulCheck", 9);
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

	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event) {
		if (IguanaConfig.modifyHoeUse) {
			Block block = event.world.getBlock(event.x, event.y, event.z);

			if ((block == Blocks.dirt || block == Blocks.grass) && isWaterNearby(event.world, event.x, event.y, event.z) ) {
				if (IguanaConfig.hoeToolDamageMultiplier > 1)
					event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
			} else if (block == Blocks.grass && ! isWaterNearby(event.world, event.x, event.y, event.z)) {

				Block block1 = Blocks.farmland;
				event.world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, block1.stepSound.soundName, (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
				if (!event.world.isRemote) {
					int seedChance = IguanaConfig.seedChance;
					if (event.world.difficultySetting.getDifficultyId() < 2) seedChance *= 2;
					else if (event.world.difficultySetting.getDifficultyId() == 3) seedChance = Math.max(Math.round(seedChance / 2f), 1);

					if (event.world.rand.nextInt(100) <= seedChance) {
						ItemStack seed = IguanaConfig.removeTallGrassSeeds ? ModuleGrassSeeds.getGrassSeed(event.world) : ForgeHooks.getGrassSeed(event.world);
						if (seed != null) block.dropBlockAsItem(event.world, event.x, event.y, event.z, seed);
					}
					event.world.setBlock(event.x, event.y, event.z, Blocks.dirt);
				}

				if (IguanaConfig.hoeToolDamageMultiplier > 1)
					event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
				event.setResult(Result.ALLOW);
			} else
				event.setCanceled(true);
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
		if (IguanaConfig.addGuiText)
		{
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;

			if (!player.isDead && !player.capabilities.isCreativeMode && !mc.gameSettings.showDebugInfo) {

				float healthPercent = player.getHealth() / player.getMaxHealth();

				if (healthPercent <= 0.15F)
					event.left.add("\u00A7cDying\u00A7r");
				else if (healthPercent <= 0.3F)
					event.left.add("\u00A7eInjured\u00A7r");
				else if (healthPercent < 0.5F)
					event.left.add("\u00A7fHurt\u00A7r");

				if (player.foodStats.getFoodLevel() <= 6)
					event.right.add("\u00A7cStarving\u00A7r");
				else if (player.foodStats.getFoodLevel() <= 10)
					event.right.add("\u00A7eHungry\u00A7r");
				else if (player.foodStats.getFoodLevel() <= 14)
					event.right.add("\u00A7fPeckish\u00A7r");

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

	@SubscribeEvent
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		if (IguanaConfig.milkedTimeout > 0 && event.entityPlayer != null && event.target != null && event.target instanceof EntityCow)
		{
			EntityCow cow = (EntityCow)event.target;
			EntityPlayer player = event.entityPlayer;
			ItemStack equipped = player.getCurrentEquippedItem();
			if (equipped != null && equipped.getItem() != null)
			{
				Item item = equipped.getItem();
				if (item instanceof ItemBucket && ((ItemBucket)item).isFull == Blocks.air || cow instanceof EntityMooshroom && item == Items.bowl)
				{
					NBTTagCompound tags = cow.getEntityData();
					if (tags.hasKey("Milked"))
					{
						event.setCanceled(true);
						if (!player.worldObj.isRemote)
							cow.playSound("mob.cow.hurt", 0.4F, (event.entity.worldObj.rand.nextFloat() - event.entity.worldObj.rand.nextFloat()) * 0.2F + 1.0F);
					} else
						tags.setInteger("Milked", IguanaConfig.milkedTimeout * 60);
				}
			}
		}
	}

	@SubscribeEvent
	public void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event)
	{
		if (IguanaConfig.saplingRegrowthMultiplier > 1)
			if (event.rand.nextInt(IguanaConfig.saplingRegrowthMultiplier) != 0) event.setResult(Result.DENY);
	}

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			player.foodStats.foodTimer = 0;
		}
	}

	/**
	 * returns true if there's water nearby (x-4 to x+4, y to y+1, k-4 to k+4)
	 */
	private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
	{
		for (int l = par2 - 4; l <= par2 + 4; ++l)
			for (int i1 = par3; i1 <= par3 + 1; ++i1)
				for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)
					if (par1World.getBlock(l, i1, j1).getMaterial() == Material.water)
						return true;

		return false;
	}
}
