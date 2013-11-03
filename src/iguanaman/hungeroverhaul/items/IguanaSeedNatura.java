package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaCropNatura;
import iguanaman.hungeroverhaul.blocks.IguanaStem;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;

import org.lwjgl.input.Keyboard;

import mods.natura.items.NaturaSeeds;

public class IguanaSeedNatura extends NaturaSeeds {

	public IguanaSeedNatura(int id, int cropID, int soilID) {
		super(id, cropID, soilID);
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
	@Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	Type[] theBiomes = null;
    	if (Block.blocksList[this.blockType] instanceof IguanaCropNatura) {
    		theBiomes = ((IguanaCropNatura)Block.blocksList[this.blockType]).biomes;
    	}
    	
    	if (theBiomes != null) {
	    	String tooltip = "";
	    	for(Type biomeType : theBiomes) {
	    		tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
	    	}
	    	par3List.add("Crop grows best in:");
	    	par3List.add(tooltip.substring(0, tooltip.length() - 2));
    	}
    }
}
