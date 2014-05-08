package iguanaman.hungeroverhaul.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IguanaFoodBowl extends IguanaFood {

	public IguanaFoodBowl(int par2, float par3, boolean par4, boolean integrate) {
		super(par2, par3, par4, integrate);
	}
	public IguanaFoodBowl(int par2, float par3, boolean par4) {
		super(par2, par3, par4, false);
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

}
