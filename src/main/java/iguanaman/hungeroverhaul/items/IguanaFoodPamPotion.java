package iguanaman.hungeroverhaul.items;

import com.pam.harvestcraft.harvestcraft;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class IguanaFoodPamPotion extends IguanaFoodPam {

	public IguanaFoodPamPotion(int par2, float par3, boolean par4) {
		this(par2, par3, par4, false);
	}

	public IguanaFoodPamPotion(int par2, float par3, boolean par4, boolean integrate) {
		super(par2, par3, par4, integrate);
		setCreativeTab(harvestcraft.tabHarvestCraft);
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}
}
