package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.blocks.IguanaCropPam;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

import assets.pamharvestcraft.ItemPamSeeds;

public class IguanaSeedPam extends ItemPamSeeds {

	public IguanaSeedPam(int i, int j) {
		super(i, j);
		
    	if (Loader.isModLoaded("Thaumcraft"))
    	{
    	   if (!ThaumcraftApi.exists(itemID, -1))
    	   {
    		   ThaumcraftApi.registerObjectTag(itemID, -1, new AspectList()
    		   .add(Aspect.SEED, 1)
    		   );
    	   }
    	}
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
	    	par3List.add("Crop grows best in:");
	    	String tooltip = "";

	    	Type[] theBiomes = null;
	    	if (Block.blocksList[this.cropID] instanceof IguanaCropPam) {
	    		theBiomes = ((IguanaCropPam)Block.blocksList[this.cropID]).biomes[this.cropID];
	    	}
	    	
	    	if (theBiomes != null) {
		    	for(Type biomeType : theBiomes) {
		    		tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
		    	}
		    	par3List.add(tooltip.substring(0, tooltip.length() - 2));
	    	}
    	} else {
	    	par3List.add("\u00A7o<Hold SHIFT for more>\u00A7r");
    	}
    }

}
