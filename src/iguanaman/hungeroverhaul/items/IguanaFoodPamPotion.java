package iguanaman.hungeroverhaul.items;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import assets.pamharvestcraft.PamHarvestCraft;

public class IguanaFoodPamPotion extends IguanaFoodPam {

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4) {
		this(par1, par2, par3, par4, false);
	}

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4,
			boolean integrate) {
		super(par1, par2, par3, par4, integrate);
		setCreativeTab(PamHarvestCraft.tabHarvestCraft);
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
