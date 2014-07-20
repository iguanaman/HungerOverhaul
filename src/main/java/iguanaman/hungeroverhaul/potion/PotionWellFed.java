package iguanaman.hungeroverhaul.potion;

import iguanaman.hungeroverhaul.IguanaConfig;
import net.minecraft.potion.Potion;

public class PotionWellFed extends Potion
{
    public PotionWellFed()
    {
        super(IguanaConfig.wellFedId, false, 0);
        setIconIndex(7, 0);
        setPotionName("potion.wellfedPotion");
    }
}
