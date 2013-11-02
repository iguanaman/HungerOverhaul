package iguanaman.hungeroverhaul.items;

import assets.pamharvestcraft.PamHarvestCraft;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class IguanaFoodPamPotion extends IguanaFoodPam {

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4,
			boolean integrate, boolean isJuicy, boolean isSeedy) {
		super(par1, par2, par3, par4, integrate, isJuicy, isSeedy);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4,
			boolean integrate) {
		super(par1, par2, par3, par4, integrate);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPamPotion(int par1, int par2, float par3, boolean par4,
			boolean integrate, boolean isJuicy) {
		super(par1, par2, par3, par4, integrate, isJuicy);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}
	
	 /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public EnumAction getItemUseAction(ItemStack par1ItemStack)
   {
       return EnumAction.drink;
   }

}
