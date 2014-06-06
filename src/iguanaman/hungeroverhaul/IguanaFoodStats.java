package iguanaman.hungeroverhaul;

import java.lang.ref.WeakReference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import cpw.mods.fml.common.Loader;

public class IguanaFoodStats extends FoodStats {

	public int starveTimer = 0;

	public IguanaFoodStats(int hungerLevel) {
		if (hungerLevel < 20) super.foodLevel = hungerLevel;
	}

	public IguanaFoodStats(FoodStats stats) {
		super.foodLevel = stats.foodLevel;
		super.foodSaturationLevel = stats.foodSaturationLevel;
		super.foodExhaustionLevel = stats.foodExhaustionLevel;
		super.foodTimer = stats.foodTimer;
		super.prevFoodLevel = stats.prevFoodLevel;
	}

	public WeakReference<EntityPlayer> entityplayer;

	public void initPlayer (EntityPlayer entityplayer)
	{
		this.entityplayer = new WeakReference<EntityPlayer>(entityplayer);
	}

	/**
	 * Args: int foodLevel, float foodSaturationModifier
	 */
	@Override
	public void addStats(int par1, float par2)
	{
		if (IguanaConfig.hungerLossRatePercentage > 0)
		{
			foodLevel = Math.min(par1 + foodLevel, 20);
			foodSaturationLevel = Math.min(foodSaturationLevel + par1 * par2 * 2.0F, foodLevel);
		}

		if (IguanaConfig.foodRegensHealth)
		{
			EntityPlayer player = entityplayer.get();
			float toHeal = Math.round((float)par1 / (float)IguanaConfig.foodHealDivider);
			float canHeal = player.getMaxHealth() - player.getHealth();
			if (toHeal > canHeal) toHeal = canHeal;
			if (toHeal > 0f) player.heal(toHeal);
		}
	}

	@Override
	public void addStats(ItemFood par1ItemFood)
	{
		if (Loader.isModLoaded("pamharvestcraft") && IguanaConfig.modifyFoodValues) {
			int foodValue = Math.max(Math.round((float)par1ItemFood.getHealAmount() / (float)IguanaConfig.modFoodValueDivider), 1);
			float saturationValue = Math.max(foodValue / 20F, 0F);
			super.addStats(foodValue, saturationValue);
		} else
			super.addStats(par1ItemFood.getHealAmount(), par1ItemFood.getSaturationModifier());
	}

	/**
	 * Handles the food game logic.
	 */
	@Override
	public void onUpdate(EntityPlayer par1EntityPlayer)
	{
		int i = par1EntityPlayer.worldObj.difficultySetting;
		float hungerLossRate = 3f;
		float difficultyModifierHealing = 1.0F;
		if (IguanaConfig.difficultyScaling == true)
		{
			if (IguanaConfig.difficultyScalingHealing)
				if (i <= 1) difficultyModifierHealing = 0.75F;
				else if (i == 3) difficultyModifierHealing = 1.5F;
			if (IguanaConfig.difficultyScalingHunger)
				if (i == 0) hungerLossRate = 5F;
				else if (i == 1) hungerLossRate = 4F;
		}

		super.prevFoodLevel = super.foodLevel;

		if (IguanaConfig.hungerLossRatePercentage == 0)
		{
			super.foodExhaustionLevel = 0.0F;
			super.foodSaturationLevel = 0.0F;
			super.foodLevel = 19;
		}
		else if (super.foodExhaustionLevel > hungerLossRate / (IguanaConfig.hungerLossRatePercentage / 100F))
		{
			super.foodExhaustionLevel = 0.0F;

			if (super.foodSaturationLevel > 0.0F)
				super.foodSaturationLevel = Math.max(super.foodSaturationLevel - 1.0F, 0.0F);
			else
				super.foodLevel = Math.max(super.foodLevel - 1, 0);
		}

		if (super.foodLevel >= IguanaConfig.minHungerToHeal && par1EntityPlayer.shouldHeal()
				&& par1EntityPlayer.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration")
				&& IguanaConfig.healthRegenRatePercentage > 0)
		{
			++super.foodTimer;

			float wellfedModifier = 1.0F;
			if (par1EntityPlayer.isPotionActive(HungerOverhaul.potionWellFed)) wellfedModifier = 0.75F;

			float lowHealthModifier = par1EntityPlayer.getMaxHealth() - par1EntityPlayer.getHealth();
			lowHealthModifier *= IguanaConfig.lowHealthRegenRateModifier / 100F;
			lowHealthModifier *= difficultyModifierHealing;
			lowHealthModifier = (float)Math.pow(lowHealthModifier + 1F, 1.5F);

			float result = 80.0F * difficultyModifierHealing * wellfedModifier * lowHealthModifier
					/ (IguanaConfig.healthRegenRatePercentage / 100F);

			if (super.foodTimer >= result)
			{
				par1EntityPlayer.heal(1.0F);
				if (!IguanaConfig.disableHealingHungerDrain) addExhaustion(3.0F);
				super.foodTimer = 0;
			}
		} else
			super.foodTimer = 0;

		if (super.foodLevel <= 0 && ++starveTimer >= 80)
		{
			par1EntityPlayer.attackEntityFrom(DamageSource.starve, IguanaConfig.damageOnStarve);
			starveTimer = 0;
		} else
			starveTimer = 0;

	}

}
