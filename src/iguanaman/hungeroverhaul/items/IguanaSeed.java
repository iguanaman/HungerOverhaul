package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaStem;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.Loader;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class IguanaSeed extends ItemSeeds implements IPlantable {

    public IguanaSeed(int par1, int par2, int par3)
    {
        super(par1, par2, par3);
    }
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
	@Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if (IguanaConfig.wrongBiomeRegrowthMultiplier > 1)
    	{
	    	Type[] theBiomes = null;
	    	if (Block.blocksList[this.blockType] instanceof IguanaCrop) {
	    		theBiomes = ((IguanaCrop)Block.blocksList[this.blockType]).biomes;
	    	}
	    	else if (Block.blocksList[this.blockType] instanceof IguanaStem) {
	        	theBiomes = ((IguanaStem)Block.blocksList[this.blockType]).biomes;
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
}
