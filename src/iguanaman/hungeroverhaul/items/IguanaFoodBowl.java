package iguanaman.hungeroverhaul.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IguanaFoodBowl extends IguanaFood {

	public IguanaFoodBowl(int par1, int par2, float par3, boolean par4, boolean integrate) {
		super(par1, par2, par3, par4, integrate);
		// TODO Auto-generated constructor stub
	}
	public IguanaFoodBowl(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4, false);
		// TODO Auto-generated constructor stub
	}
	
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bowlEmpty));
        return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
    }

}
