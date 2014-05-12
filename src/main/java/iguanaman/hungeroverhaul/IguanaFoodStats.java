package iguanaman.hungeroverhaul;

import java.lang.ref.WeakReference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import cpw.mods.fml.common.Loader;

public class IguanaFoodStats extends FoodStats {

	public int starveTimer = 0;

	public IguanaFoodStats(int hungerLevel) {
		if (hungerLevel < 20)
			super.setFoodLevel(hungerLevel);
	}

	public IguanaFoodStats(FoodStats stats) {
		super.setFoodLevel(stats.getFoodLevel());
		super.setFoodSaturationLevel(stats.getSaturationLevel());
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
			setFoodLevel(Math.min(par1 + getFoodLevel(), 20));
			setFoodSaturationLevel(Math.min(getSaturationLevel() + par1 * par2 * 2.0F, getFoodLevel()));
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
	public void func_151686_a(ItemFood par1ItemFood, ItemStack par2ItemStack)
	{
		if (Loader.isModLoaded("pamharvestcraft") && IguanaConfig.modifyFoodValues) {
			int foodValue = Math.max(Math.round((float)par1ItemFood.func_150905_g(par2ItemStack) / (float)IguanaConfig.modFoodValueDivider), 1);
			float saturationValue = Math.max(Math.round(foodValue / 20F), 0F);
			super.addStats(foodValue, saturationValue);
		} else
			super.addStats(par1ItemFood.func_150905_g(par2ItemStack), par1ItemFood.func_150906_h(par2ItemStack));
	}

	/**
	 * Handles the food game logic.
	 */
	@Override
	public void onUpdate(EntityPlayer par1EntityPlayer)
	{
		int i = par1EntityPlayer.worldObj.difficultySetting.getDifficultyId();
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

		super.prevFoodLevel = super.getFoodLevel();

		if (IguanaConfig.hungerLossRatePercentage == 0)
		{
			super.foodExhaustionLevel = 0.0F;
			super.setFoodSaturationLevel(0.0F);
			super.setFoodLevel(19);
		}
		else if (super.foodExhaustionLevel > hungerLossRate / (IguanaConfig.hungerLossRatePercentage / 100F))
		{
			super.foodExhaustionLevel = 0.0F;

			if (super.getSaturationLevel() > 0.0F)
				super.setFoodSaturationLevel(Math.max(super.getSaturationLevel() - 1.0F, 0.0F));
			else
				super.setFoodLevel(Math.max(super.getFoodLevel() - 1, 0));
		}

		if (super.getFoodLevel() >= IguanaConfig.minHungerToHeal && par1EntityPlayer.shouldHeal()
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

		if (super.getFoodLevel() <= 0 && ++starveTimer >= 80)
		{
			par1EntityPlayer.attackEntityFrom(DamageSource.starve, IguanaConfig.damageOnStarve);
			starveTimer = 0;
		} else {
			starveTimer = 0;
		}
	}
}
