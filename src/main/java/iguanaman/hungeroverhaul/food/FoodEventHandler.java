package iguanaman.hungeroverhaul.food;

import net.minecraft.potion.PotionEffect;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FoodEventHandler
{
	@SubscribeEvent
	public void onFoodEaten(FoodEvent.FoodEaten event)
	{
        if (!event.player.worldObj.isRemote && event.player.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration") && IguanaConfig.healthRegenRatePercentage > 0) {
            if (IguanaConfig.addWellFedEffect)
            {
                int duration = (int)Math.pow(event.foodValues.hunger * 100, 1.2);

                if (duration >= 30)
                {
                    PotionEffect currentEffect = event.player.getActivePotionEffect(HungerOverhaul.potionWellFed);
                    if (currentEffect != null) duration += currentEffect.getDuration();
                    event.player.addPotionEffect(new PotionEffect(HungerOverhaul.potionWellFed.id, duration, 0, true));
                }
            }
        }

		if (IguanaConfig.foodRegensHealth)
		{
			float toHeal = Math.round((float) event.foodValues.hunger / (float) IguanaConfig.foodHealDivider);
			float canHeal = event.player.getMaxHealth() - event.player.getHealth();
			if (toHeal > canHeal)
				toHeal = canHeal;
			if (toHeal > 0f)
				event.player.heal(toHeal);
		}
	}
}
