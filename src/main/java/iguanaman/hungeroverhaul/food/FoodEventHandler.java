package iguanaman.hungeroverhaul.food;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FoodEventHandler
{
	@SubscribeEvent
	public void onFoodEaten(FoodEvent.FoodEaten event)
	{
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
