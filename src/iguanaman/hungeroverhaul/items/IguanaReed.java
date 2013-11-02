package iguanaman.hungeroverhaul.items;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaReed extends ItemReed {

	public IguanaReed(int par1, Block par2Block) {
		super(par1, par2Block);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) { 
	    	par3List.add("Plant on: Soil, Sand");
	    	par3List.add(" ");
	    	par3List.add("Crop grows best in:");
	    	par3List.add("Desert, Jungle, Swamp");
    	} else {
	    	par3List.add("\u00A7o<Hold SHIFT for more>\u00A7r");
    	}
    }

}
